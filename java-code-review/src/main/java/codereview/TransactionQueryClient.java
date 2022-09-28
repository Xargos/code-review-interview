package codereview;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;


public class TransactionQueryClient {

    public NioAsyncHttpClient<Transaction> nioAsyncHttpClient;

    public List<Pair<String, Optional<Transaction>>> responses = new ArrayList<>();

    public CompletableFuture<Transaction> getTransaction(int transactionId) {
        return nioAsyncHttpClient.get(transactionId);
    }

    public Transaction CreateTransaction(
            String fromAccount,
            String toAccount, Double amount,
            String currency,
            String billingAddress
    ) {
        String messageId = UUID.randomUUID().toString();

        nioAsyncHttpClient.post(
                new Message<>(messageId,new Transaction(null, fromAccount, toAccount,
                        amount, currency, billingAddress))
                ,
                (transaction, exception) -> {
                    if(transaction == null) {
                        System.out.println("something went wrong");
                        responses.add(new Pair<>(messageId, Optional.empty()));
                    } else {
                        // Return result
                        responses.add(new Pair<>(messageId, Optional.of(transaction)));
                    }
                }
        );

        while(responses.stream().filter(pair -> pair.a() == messageId).findFirst().filter(r -> r.b().isPresent()).isEmpty()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return responses.stream().filter(pair -> pair.a() == messageId).findFirst().get().b().get();
    }
}

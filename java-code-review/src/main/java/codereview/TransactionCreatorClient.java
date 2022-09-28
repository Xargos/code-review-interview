package codereview;

import java.util.concurrent.CompletableFuture;


public class TransactionCreatorClient {

    public NioAsyncHttpClient<Transaction> nioAsyncHttpClient;

    public CompletableFuture<Transaction> getTransaction(int transactionId) {
        return nioAsyncHttpClient.get(transactionId);
    }

    public void CreateTransaction(
            String fromAccount,
            String toAccount, Double amount,
            String currency,
            String billingAddress,
    ) {

    }
}

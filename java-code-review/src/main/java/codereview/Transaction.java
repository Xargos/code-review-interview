package codereview;

public record Transaction(Integer id, String fromAccount, String toAccount, Double amount,
                          String currency, String billingAddress) {
}

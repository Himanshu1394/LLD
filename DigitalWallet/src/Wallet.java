import java.util.UUID;

public class Wallet {
    private final UUID accountId;
    private final User user;
    private Balance balance;

    public Wallet(UUID accountId, User user, Balance balance) {
        this.accountId = accountId;
        this.user = user;
        this.balance = balance;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public User getUser() {
        return user;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
}

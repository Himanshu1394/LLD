import java.math.BigDecimal;
import java.util.UUID;

public interface PaymentProcessingPort {
    public void processPayment(Transaction transaction);
    public void addMoneyToWallet(UUID walletId, BigDecimal amount);
    public void getBalance(UUID walletID);
    public void createWallet(User user);
    public void fetchLedger(UUID userId);
    public void fetchTransactionHistory(UUID userId);
}

import java.math.BigDecimal;
import java.util.UUID;

public class DigitalWalletService {
    private final PaymentProcessingPort paymentProcessingPort;

    public DigitalWalletService(PaymentProcessingPort paymentProcessingPort) {
        this.paymentProcessingPort = paymentProcessingPort;
    }
//    DigitalWalletServicePort digitalWalletServicePort;

    public void addMoneyToWallet(UUID userId, BigDecimal amount,  PaymentModeStrategy paymentModeStrategy) {
        paymentModeStrategy.addMoney(userId, amount);
        paymentProcessingPort.addMoneyToWallet(userId, amount);
    }

    public void sendPayment(UUID senderId, UUID receiverId, BigDecimal amount) {
        paymentProcessingPort.processPayment(new Transaction(UUID.randomUUID(), amount, receiverId, senderId, TransactionStatus.IN_PROGRESS, TransactionType.DEBIT));
    }

    public void getBalance(UUID walletId) {
        paymentProcessingPort.getBalance(walletId);
    }

    public void createWallet(User user) {
        paymentProcessingPort.createWallet(user);
    }

    public void getLedgerHistory(User user) {
        paymentProcessingPort.fetchLedger(user.getUserId());
    }

    public void getTransactionHistory(User user) {
        paymentProcessingPort.fetchTransactionHistory(user.getUserId());
    }

}

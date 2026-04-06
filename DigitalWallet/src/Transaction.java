import java.math.BigDecimal;
import java.util.UUID;

public class Transaction {
    private final UUID transactionId;
    private final BigDecimal amount;
    private final UUID senderId;
    private final UUID receiverId;
    private TransactionStatus transactionStatus;
    private final TransactionType transactionType;

    public Transaction(UUID transactionId, BigDecimal amount, UUID receiverId, UUID senderId, TransactionStatus transactionStatus, TransactionType transactionType) {

        this.receiverId = receiverId;
        this.senderId = senderId;
        this.amount = amount;
        this.transactionId = transactionId;
        this.transactionStatus = transactionStatus;
        this.transactionType = transactionType;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public UUID getSenderId() {
        return senderId;
    }

    public UUID getReceiverId() {
        return receiverId;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", amount=" + amount +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", transactionStatus=" + transactionStatus +
                ", transactionType=" + transactionType +
                '}';
    }
}

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class LedgerEntry {
    private final UUID ledgerEntryId;
    private final BigDecimal amount;
    private final UUID transactionId;
    private final TransactionType transactionType;
    private final Instant timeStamp;

    public LedgerEntry(UUID ledgerEntryId, BigDecimal amount, UUID transactionId, TransactionType transactionType, Instant timeStamp) {
        this.ledgerEntryId = ledgerEntryId;
        this.amount = amount;
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.timeStamp = timeStamp;
    }

    public UUID getLedgerEntryId() {
        return ledgerEntryId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return "LedgerEntry{" +
                "ledgerEntryId=" + ledgerEntryId +
                ", amount=" + amount +
                ", transactionId=" + transactionId +
                ", transactionType=" + transactionType +
                ", timeStamp=" + timeStamp +
                '}';
    }
}

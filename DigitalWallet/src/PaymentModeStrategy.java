import java.math.BigDecimal;
import java.util.UUID;

public interface PaymentModeStrategy {
    public void addMoney(UUID walletId, BigDecimal amount);
}

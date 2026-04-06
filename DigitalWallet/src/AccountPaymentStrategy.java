import java.math.BigDecimal;
import java.util.UUID;

public class AccountPaymentStrategy implements PaymentModeStrategy {
    @Override
    public void addMoney(UUID walletId, BigDecimal amount) {
        System.out.println("Adding money from account");
    }
}

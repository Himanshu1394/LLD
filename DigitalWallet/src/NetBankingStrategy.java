import java.math.BigDecimal;
import java.util.UUID;

public class NetBankingStrategy implements PaymentModeStrategy {

    @Override
    public void addMoney(UUID walletId, BigDecimal amount) {
        System.out.println("Adding money via netBanking");
    }
}

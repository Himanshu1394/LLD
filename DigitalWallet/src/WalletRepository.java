import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class WalletRepository {
    Map<UUID, List<Transaction>> transactionMap = new ConcurrentHashMap<>();
//    Map<UUID, Balance> balanceMap = new ConcurrentHashMap<>();
    Map<UUID, Wallet> walletMap = new ConcurrentHashMap<>();

    public void saveTransaction(UUID walletId, Transaction transaction) {
        transactionMap.computeIfAbsent(walletId, k -> new ArrayList<>()).add(transaction);
    }

    public Optional<List<Transaction>> getTransactions(UUID walletId) {
        return Optional.of(transactionMap.get(walletId));
    }

    public Balance getBalance(UUID walletId) {
        return walletMap.get(walletId).getBalance();
    }

    public boolean saveBalance(UUID userId, Balance balance) {
        Wallet wallet = walletMap.get(userId);
        wallet.setBalance(balance);
        walletMap.put(userId, wallet);
        return true;
    }

    public boolean saveWallet(UUID userId, Wallet wallet) {
        walletMap.put(userId, wallet);
        return true;
    }

    public Wallet getWallet(UUID userId) {
        return walletMap.get(userId);
    }
}

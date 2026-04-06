import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PaymentProcessingLogic implements PaymentProcessingPort {
    private final WalletRepository walletRepository;
    private final LedgerRepository ledgerRepository;

    public PaymentProcessingLogic(WalletRepository walletRepository, LedgerRepository ledgerRepository) {
        this.walletRepository = walletRepository;
        this.ledgerRepository = ledgerRepository;
    }

    @Override
    public void processPayment(Transaction transaction) {
        UUID senderWalletId = walletRepository.getWallet(transaction.getSenderId()).getAccountId();
        UUID receiverWalletId = walletRepository.getWallet(transaction.getReceiverId()).getAccountId();
        //checkAvailableBalance
        Balance availableBalance = walletRepository.getBalance(transaction.getSenderId());
        if (availableBalance.getAmount().compareTo(transaction.getAmount()) < 0 ) {
            walletRepository.saveTransaction(senderWalletId, new Transaction(transaction.getTransactionId(), transaction.getAmount(), transaction.getReceiverId(), transaction.getSenderId(), TransactionStatus.FAILED, transaction.getTransactionType()));
            System.out.println("Transaction Declined Insufficient Balance available balance: " + availableBalance.getAmount());
            return;
        }



        boolean debitResult = walletRepository.saveBalance(transaction.getSenderId(), new Balance(availableBalance.getAmount().subtract(transaction.getAmount())));
        Balance receiverBalance = walletRepository.getBalance(transaction.getReceiverId());
        boolean creditResult = walletRepository.saveBalance(transaction.getReceiverId(), new Balance(receiverBalance.getAmount().add(transaction.getAmount())));

        if (debitResult && creditResult) {
            Transaction senderTransaction = new Transaction(transaction.getTransactionId(), transaction.getAmount(), transaction.getReceiverId(), transaction.getSenderId(), TransactionStatus.COMPLETED, TransactionType.DEBIT);
            walletRepository.saveTransaction(senderWalletId, senderTransaction);
            Transaction recieverTransaction = new Transaction(transaction.getTransactionId(), transaction.getAmount(), transaction.getReceiverId(), transaction.getSenderId(), TransactionStatus.COMPLETED, TransactionType.CREDIT);
            walletRepository.saveTransaction(receiverWalletId, recieverTransaction);
            ledgerRepository.saveLedger(senderWalletId , new LedgerEntry(UUID.randomUUID(), senderTransaction.getAmount(), transaction.getTransactionId(), senderTransaction.getTransactionType(), Instant.now()));
            ledgerRepository.saveLedger(receiverWalletId , new LedgerEntry(UUID.randomUUID(), senderTransaction.getAmount(), transaction.getTransactionId(), senderTransaction.getTransactionType(), Instant.now()));
        }

        else {
            //rollback
            return;
        }

        System.out.println("Transaction Successful of amount: " + transaction.getAmount() + " from user: " + transaction.getSenderId() + "Balance: " + walletRepository.getBalance(transaction.getSenderId()).getAmount() + " to user: " + transaction.getReceiverId() + "Balance: " + walletRepository.getBalance(transaction.getReceiverId()).getAmount());

    }

    @Override
    public void addMoneyToWallet(UUID userId, BigDecimal amount) {
        UUID senderWalletId = walletRepository.getWallet(userId).getAccountId();
        Transaction transaction = new Transaction(UUID.randomUUID(), amount, null, null, TransactionStatus.IN_PROGRESS, TransactionType.CREDIT);
        Balance availableBalance = walletRepository.getBalance(userId);
        Balance updateBalance = new Balance(availableBalance.getAmount().add(amount));
        boolean result = walletRepository.saveBalance(userId, updateBalance);
        if (result) {
            transaction.setTransactionStatus(TransactionStatus.COMPLETED);
            ledgerRepository.saveLedger(senderWalletId, new LedgerEntry(UUID.randomUUID(), amount, transaction.getTransactionId(), transaction.getTransactionType(), Instant.now()));
            walletRepository.saveTransaction(senderWalletId, transaction);
        }

        System.out.println("Amount: " + amount + " Successfully added to wallet " + senderWalletId + "Update balance: " + updateBalance.getAmount());

    }

    @Override
    public void getBalance(UUID walletId) {
        Balance balance = walletRepository.getBalance(walletId);
        System.out.println(balance.getAmount());
    }

    @Override
    public void createWallet(User user) {
        Wallet wallet = new Wallet(UUID.randomUUID(), user, new Balance(BigDecimal.ZERO));
        walletRepository.saveWallet(user.getUserId(), wallet);
        System.out.println("Wallet created with Id" + wallet.getAccountId());
    }

    public void fetchLedger(UUID userId) {
        Wallet wallet = walletRepository.getWallet(userId);
        Optional<List<LedgerEntry>> result = ledgerRepository.getLedger(wallet.getAccountId());

        if (result.isPresent()) {
            System.out.println("Ledger entries");
            for (LedgerEntry ledgerEntry : result.get()) {
                System.out.println(ledgerEntry.toString() + "  ");
            }
            return;
        }

        System.out.println("No ledger Entry");
    }

    public void fetchTransactionHistory(UUID userId) {
        Wallet wallet = walletRepository.getWallet(userId);
        Optional<List<Transaction>> transactions = walletRepository.getTransactions(wallet.getAccountId());
        if (transactions.isPresent()) {
            System.out.println("Transaction History");
            for (Transaction transaction : transactions.get()) {
                System.out.println(transaction.toString());
            }
            return;
        }


        System.out.println("No transaction History");
    }
}

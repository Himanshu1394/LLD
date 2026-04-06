import jdk.jshell.execution.JdiDefaultExecutionControl;

import java.math.BigDecimal;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PaymentProcessingPort paymentProcessingPort = new PaymentProcessingLogic(new WalletRepository(), new LedgerRepository());
        DigitalWalletService digitalWalletService = new DigitalWalletService(paymentProcessingPort);

        User user1 = new User(UUID.randomUUID(), "Himanshu");
        User user2 = new User(UUID.randomUUID(), "Singh");



        digitalWalletService.createWallet(user1);
        digitalWalletService.createWallet(user2);

        PaymentModeStrategy accountStrategy = new AccountPaymentStrategy();
//
//
//
//
        digitalWalletService.addMoneyToWallet(user1.getUserId(), BigDecimal.valueOf(1000L), accountStrategy);
        digitalWalletService.addMoneyToWallet(user2.getUserId(), BigDecimal.valueOf(2000L), new NetBankingStrategy());
//
        digitalWalletService.getBalance(user1.getUserId());
        digitalWalletService.getBalance(user2.getUserId());

        digitalWalletService.addMoneyToWallet(user1.getUserId(), BigDecimal.valueOf(5000L), new NetBankingStrategy());

        digitalWalletService.sendPayment(user1.getUserId(), user2.getUserId(), BigDecimal.valueOf(500L));
        digitalWalletService.sendPayment(user2.getUserId(), user1.getUserId(), BigDecimal.valueOf(3000L));

        digitalWalletService.getTransactionHistory(user2);
        digitalWalletService.getLedgerHistory(user2);
        digitalWalletService.getTransactionHistory(user1);
        digitalWalletService.getLedgerHistory(user1);
    }
}
package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee;

    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount can't be negative");
        }
        balance = balance + amount;
    }

    double getBalance() {
        return this.balance;
    }

    boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount can't be negative");
        }

        double totalAmount = amount + transactionFee;

        if (balance >= totalAmount) {
            balance = balance - totalAmount;
            return true;
        } else {
            return false;
        }
    }

    boolean transfer(BankAccount receiver, double amount) {
        if (amount <= 0) {
            return false;
        }

        if (receiver == null) {
            return false;
        }

        double totalAmount = amount + transactionFee;

        if (balance >= totalAmount) {
            balance = balance - totalAmount;

            receiver.balance = receiver.balance + amount;

            return true;
        } else {
            return false;
        }
    }

    void setTransactionFee(double fee) {
        if (fee >= 0) {
            this.transactionFee = fee;
        }
    }
}

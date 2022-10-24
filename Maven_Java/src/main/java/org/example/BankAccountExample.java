package org.example;

public class BankAccountExample {
    public static void main(String[] args) {
    }

}
class Bank {
    private static long bankBalance = 0;

    public static long getBankBalance() {
        return bankBalance;
    }

    public static void setBankBalance(long bankBalance) {
        Bank.bankBalance = bankBalance;
    }
}
class Account {
    private String name;
    private int id;
    private long localBalance = 0;

    private Account(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public static class AccountBuilder {
        private static int num;
        private String name;
        private int id;

        public AccountBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Account build() {
            return new Account(name,generateId());
        }

        private int generateId() {
            int min = 0;
            int max = 9;
            int temp = 0;
            for (int i = 0; i < 8; i++) {
                temp += (int) ((Math.random() * (max - min)) + min);
                temp *= 10;
            }
            return temp / 10;
        }
    }
}

package org.example;

import java.util.Random;

public class BankAccount {
    private final String userName;
    private final String id;
    private long balance = 0;

    private BankAccount(String userName, String id) {
        this.userName = userName;
        this.id = id;
    }

    public class BankAccountBuilder {
        private String userName;
        private String id;

        public BankAccountBuilder setUserName (String name) {
            this.userName = name;
            return this;
        }
        private String generateID() {
            StringBuilder s = new StringBuilder("");
            for (int i = 0; i < 16; i++) {
                int j = randomInteger();
                switch (j) {
                    case 0:
                        int min = 48;
                        int max = 57;
                        s.append((char) Math.floor(Math.random() * (max - min + 1) + min));
                        break;
                    case 1:
                        min = 65;
                        max = 90;
                        s.append((char) Math.floor(Math.random() * (max - min + 1) + min));
                        break;
                    case 2:
                        min = 97;
                        max = 122;
                        s.append((char) Math.floor(Math.random() * (max - min + 1) + min));
                        break;
                }
            }
            return String.valueOf(s);
        }
        private Integer randomInteger() {
            return new Random().nextInt(3);
        }

        public BankAccount build() {
            return new BankAccount(userName,generateID());
        }
    }
}

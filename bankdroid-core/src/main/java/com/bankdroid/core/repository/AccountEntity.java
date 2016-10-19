package com.bankdroid.core.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class AccountEntity {

    private final String id;
    private final BigDecimal balance;
    private final String currency;
    private final String name;
    private final boolean hidden;
    private final boolean notifications;
    private final Collection<TransactionEntity> transactions;

    private AccountEntity(String id,
                          BigDecimal balance,
                          String currency,
                          String name,
                          boolean hidden,
                          boolean notifications,
                          Collection<TransactionEntity> transactions) {
        this.id = id;
        this.balance = balance;
        this.currency = currency;
        this.name = name;
        this.hidden = hidden;
        this.notifications = notifications;
        this.transactions = transactions;
    }

    public String id() {
        return id;
    }

    public BigDecimal balance() {
        return balance;
    }

    public String currency() {
        return currency;
    }

    public String name() {
        return name;
    }

    public boolean notifications() {
        return notifications;
    }

    public boolean hidden() {
        return hidden;
    }

    public Collection<TransactionEntity> transactions() {
        return Collections.unmodifiableCollection(transactions);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private BigDecimal balance;
        private String currency;
        private String name;
        private boolean hidden;
        private boolean notifications;
        private Collection<TransactionEntity> transactions = new ArrayList<>();

        private Builder() {}

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder hidden(boolean hidden) {
            this.hidden = hidden;
            return this;
        }

        public Builder notifications(boolean notifications) {
            this.notifications = notifications;
            return this;
        }

        public Builder transactions(Collection<TransactionEntity> transactions) {
            this.transactions.addAll(transactions);
            return this;
        }

        public AccountEntity build() {
            return new AccountEntity(
                    id,
                    balance,
                    currency,
                    name,
                    hidden,
                    notifications,
                    transactions);
        }
    }
}
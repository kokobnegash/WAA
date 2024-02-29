package Account.web;

import Account.domain.Account;
import Account.domain.Transaction;

import java.util.Collection;

public class Transactions {
    private Collection<Transaction> transactions;

    public Collection<Transaction> getTransactions() {
        return transactions;
    }

    public Transactions() {
    }

    public Transactions(Collection<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setTransactions(Collection<Transaction> transactions) {
        this.transactions = transactions;
    }
}

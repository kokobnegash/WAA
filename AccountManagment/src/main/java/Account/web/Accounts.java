package Account.web;

import Account.domain.Account;

import java.util.Collection;

public class Accounts {

    private Collection<Account> accounts;

    public Accounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }
}

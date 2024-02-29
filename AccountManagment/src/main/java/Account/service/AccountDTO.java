package Account.service;

import Account.domain.Account;
import org.springframework.data.annotation.Id;

import java.util.Objects;

public class AccountDTO {


    private String accountNumber;
    private String accountHolder;

    private float balance;


    public AccountDTO() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                '}';
    }

    public AccountDTO(String accountNumber, String accountHolder, float balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0;

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountDTO account)) return false;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }


}

package Account.service;

import Account.domain.Account;
import org.springframework.data.annotation.Id;

public class TransactionDTO {

    private Account account ;
    private TRANSTYPE type ;
    private  float amount ;

    public TransactionDTO(Account account, TRANSTYPE type , float amount) {
        this.account = account;
        this.type = type;
        this.amount=amount;

    }

    public Account getAccount() {
        return account;
    }



    public TRANSTYPE getType() {
        return type;
    }

    public void setType(TRANSTYPE type) {
        this.type = type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public TransactionDTO() {
    }

    public  void removeAccount(){

        account=null;
    }
    public Account deposit(){
        float currentBalance=account.getBalance();
        account.setBalance(currentBalance+amount);
        return account;
    }
    public Account withDraw( ){
        float currentBalance=account.getBalance();
        if(currentBalance >=amount)
            account.setBalance(currentBalance-amount);
        return account;
    }


}

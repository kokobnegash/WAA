package Account.domain;

import Account.service.TRANSTYPE;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Transaction {


    private Account account ;

    public Account getAccount() {
        return account;
    }



    private TRANSTYPE type ;
    private  float amount ;

    public Transaction(Account account, TRANSTYPE type , float amount) {
        this.account = account;
        this.type = type;
        this.amount=amount;

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

    public Transaction() {
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

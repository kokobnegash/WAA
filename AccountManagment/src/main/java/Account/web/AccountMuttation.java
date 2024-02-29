package Account.web;


import Account.data.AccountRepository;
import Account.domain.Account;
import Account.service.AccountDTO;
import Account.service.AccountService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AccountMuttation {


    @Autowired
   AccountService2 accountService2;

    public AccountDTO createAccount(String accountNumber, String accountHolder, Float baance){

        return accountService2.createAccount(accountNumber,accountHolder,baance) ;


    }
}

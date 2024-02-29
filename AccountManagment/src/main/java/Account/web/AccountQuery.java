package Account.web;


import Account.domain.Account;
import Account.service.AccountDTO;
import Account.service.AccountService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountQuery {



    @Autowired
    AccountService2 accountService2;


  @QueryMapping
    public AccountDTO getAccount(String accountNumber){

        return  accountService2.getAccount(accountNumber) ;

    }

    @QueryMapping
    public List<AccountDTO> getAccounts(int count){

        return  accountService2.getallaccount(count) ;

    }




}

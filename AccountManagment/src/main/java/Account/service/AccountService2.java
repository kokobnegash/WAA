package Account.service;


import Account.data.AccountRepository;
import Account.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService2 {



    @Autowired
    AccountRepository   accountRepository ;

    public AccountDTO createAccount(String accountNumber , String accountHolder, float balance){
        AccountDTO account=new AccountDTO(accountNumber, accountHolder, balance);
        accountRepository.save( AccountAdaptor.getAccount(account)  );

        return account ;

    }


    public AccountDTO getAccount(String accountNumebr ){

        return   AccountAdaptor.getAccountDTO(accountRepository.findAllByAccountNumber(accountNumebr))
    ;}

    public List<AccountDTO> getallaccount(int count){

   return  AccountAdaptor.getAccountDTOList(accountRepository.findAllBy())  ;
        }

        }

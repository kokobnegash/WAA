package Account.service;

import Account.data.AccountRepository;
import Account.data.TransactionRepository;
import Account.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;


     public AccountDTO createAccount(AccountDTO accountDTO){


         return  AccountAdaptor.getAccountDTO((accountRepository.save(AccountAdaptor.getAccount(accountDTO))) );
     }
    public TransactionDTO createTransaction(String accountNumber  , float amount,String type){
        TransactionDTO transaction=new TransactionDTO(accountRepository.findAllByAccountNumber(accountNumber),TRANSTYPE.DEPOSIT, amount);

        return  TransactionAdaptor.getAccountDTO(transactionRepository.save(TransactionAdaptor.getAccountTransaction(transaction))) ;
    }
     public AccountDTO deposit(String accountNumber, float amount){
         TransactionDTO transaction=new TransactionDTO(accountRepository.findAllByAccountNumber(accountNumber),TRANSTYPE.DEPOSIT, amount);
         transactionRepository.save(TransactionAdaptor.getAccountTransaction(transaction) );


         return  AccountAdaptor.getAccountDTO(accountRepository.save(TransactionAdaptor.getAccountTransaction(transaction).deposit())    ) ;
     }
    public AccountDTO withDraw(String accountNumber, float amount){
        TransactionDTO transaction=new TransactionDTO(accountRepository.findAllByAccountNumber(accountNumber),TRANSTYPE.WITHDRAW, amount);
        transactionRepository.save(TransactionAdaptor.getAccountTransaction(transaction) );
        return  AccountAdaptor.getAccountDTO(accountRepository.save(TransactionAdaptor.getAccountTransaction(transaction).withDraw())    ) ;
    }

   public AccountDTO getAccount(String accountNumber){
         return  AccountAdaptor.getAccountDTO( accountRepository.findAllByAccountNumber(accountNumber));



   }
    public  List<AccountDTO> getAccounts(){
        return  AccountAdaptor.getAccountDTOList( accountRepository.findAllBy());



    }
public  AccountDTO removeAccount(String accountNumber){
         return AccountAdaptor.getAccountDTO(  accountRepository.deleteAccountByAccountNumber(accountNumber));
}
    public List<TransactionDTO> getATransaction(String accountNumber){
        return TransactionAdaptor.getAccountDTOList(transactionRepository.findByAccount_AccountNumber(accountNumber)) ;
    }


    public List<TransactionDTO> getAllTransaction() {
        return TransactionAdaptor.getAccountDTOList(transactionRepository.findAllBy());
    }
}
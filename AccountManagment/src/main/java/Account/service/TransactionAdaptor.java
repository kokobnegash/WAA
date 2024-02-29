package Account.service;

import Account.domain.Transaction;
import Account.service.TransactionDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TransactionAdaptor {


    public static Transaction getAccountTransaction(TransactionDTO accountDTO){
        Transaction account= new Transaction();
        if (accountDTO != null) {
            account = new Transaction(accountDTO.getAccount(),accountDTO.getType()
                   , accountDTO.getAmount()
                    );

        }
        return account;
    }

    public static TransactionDTO getAccountDTO(Transaction account){
        TransactionDTO accountDTO = new TransactionDTO();
        if (account != null) {
            accountDTO = new TransactionDTO(account.getAccount(),
                    account.getType(),
                    account.getAmount()
                    );
        }
        return accountDTO;
    }



    public static Collection<Transaction> getAccountList(Collection<TransactionDTO> accountDTOList){
        Collection<Transaction> accountList =new ArrayList<>();
        for (TransactionDTO accountDTO:accountDTOList              ) {

            if (accountDTO != null) {
                Transaction         account = new Transaction(accountDTO.getAccount(),
                        accountDTO.getType(),
                        accountDTO.getAmount());
                accountList.add(account);
            }   }
        return accountList;
    }

    public static List<TransactionDTO>  getAccountDTOList(List<Transaction> accountList){
       List<TransactionDTO> accountDTOList =new ArrayList<>();
        for (Transaction account:accountList              ) {

            if (account != null) {
                TransactionDTO           bookdto = new TransactionDTO(account.getAccount(),
                        account.getType(),
                        account.getAmount()
                     );
                accountDTOList.add(bookdto);
            }   }
        return accountDTOList;
    }




}

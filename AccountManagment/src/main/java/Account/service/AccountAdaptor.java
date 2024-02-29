package Account.service;

import Account.domain.Account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountAdaptor {


    public static Account getAccount(AccountDTO accountDTO){
        Account account= new Account();
        if (accountDTO != null) {
            account.setAccountNumber(accountDTO.getAccountNumber());
            account.setAccountHolder(accountDTO.getAccountHolder());
            account.setBalance( accountDTO.getBalance());

        }
        return account;
    }

    public static AccountDTO getAccountDTO(Account account){
        AccountDTO accountDTO = new AccountDTO();
        if (account != null) {

            accountDTO.setAccountNumber(account.getAccountNumber());
            accountDTO.setAccountHolder(account.getAccountHolder());
            accountDTO.setBalance( account.getBalance());

        }
        return accountDTO;
    }



    public static List<Account> getAccountList(Collection<AccountDTO> accountDTOList){
        List<Account> accountList =new ArrayList<>();
        for (AccountDTO accountDTO:accountDTOList              ) {

            if (accountDTO != null) {
                Account         account = new Account(accountDTO.getAccountNumber(),
                        accountDTO.getAccountHolder(),
                        accountDTO.getBalance());
                accountList.add(account);
            }   }
        return accountList;
    }

    public static List<AccountDTO> getAccountDTOList(Collection<Account> accountList){
        List<AccountDTO> accountDTOList =new ArrayList<>();
        for (Account account:accountList              ) {

            if (account != null) {
                AccountDTO           bookdto = new AccountDTO(account.getAccountNumber(),
                        account.getAccountHolder(),
                        account.getBalance()
                     );
                accountDTOList.add(bookdto);
            }   }
        return accountDTOList;
    }




}

package Account.data;

import Account.domain.Account;
import Account.web.Accounts;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountRepository  extends MongoRepository<Account , Integer> {


    public List<Account> findAllBy();

    public Account findAllByAccountNumber(String accountNumber);
    public Account findAllByAccountHolder(String accountHolder);

public   Account   deleteAccountByAccountNumber(String accountNumber);




}

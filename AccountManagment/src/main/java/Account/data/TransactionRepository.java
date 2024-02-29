package Account.data;

import Account.domain.Account;
import Account.domain.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, Integer> {


public  List<Transaction>  findAllBy();

public List<Transaction>   findByAccount_AccountNumber(String accountNumber);

public List<Transaction> findAllByType(String type);




}

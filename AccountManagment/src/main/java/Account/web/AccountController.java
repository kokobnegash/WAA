package Account.web;


import Account.domain.Account;
import Account.domain.Transaction;
import Account.service.AccountDTO;
import Account.service.AccountService;
import Account.service.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*")
public class AccountController {




@Autowired
    AccountService accountService;
@PostMapping("/account")
public ResponseEntity<?>  createAccount(@RequestBody AccountDTO accountDTO){

    AccountDTO account=accountService.createAccount(accountDTO);

    return new ResponseEntity<AccountDTO>(account, HttpStatus.OK);


}




@PostMapping("/account/{accountNumber}/deposit/{amount}")
  public ResponseEntity<?> deposit( @PathVariable String accountNumber,@PathVariable float amount ){

     AccountDTO account=accountService.deposit(accountNumber,amount);

        return new ResponseEntity<AccountDTO>(account , HttpStatus.OK);


  }


    @PostMapping("/account/{accountNumber}/withdraw/{amount}")
    public ResponseEntity<?> withDraw(@PathVariable float amount , @PathVariable String accountNumber){
        AccountDTO account=accountService.withDraw(accountNumber,amount);
        return new ResponseEntity<AccountDTO>(account , HttpStatus.OK);

    }

    @GetMapping("/account/{accountNumber}")
public  ResponseEntity<?> getBalance(@Validated @PathVariable String accountNumber){
        AccountDTO account=accountService.getAccount(accountNumber);
        return new ResponseEntity<AccountDTO>(account , HttpStatus.OK);
}

    @GetMapping("/account")
    public  ResponseEntity<?> getaccounts(){
        List<AccountDTO> account=accountService.getAccounts();
        return new ResponseEntity<List<AccountDTO>>(account , HttpStatus.OK);
    }


    @GetMapping("/account/{accountNumber}/transaction/")
    public  ResponseEntity<?> transaction(@Validated @PathVariable String accountNumber){

       List<TransactionDTO>  transaction=accountService.getATransaction(accountNumber);

        return new ResponseEntity<List<TransactionDTO>>(transaction, HttpStatus.OK);
    }
    @GetMapping("/account/transactions")
    public  ResponseEntity<?> transactionAll(){
      List<TransactionDTO>   transactions=accountService.getAllTransaction();
            return new ResponseEntity<List<TransactionDTO> >(transactions, HttpStatus.OK);

    }


    @DeleteMapping("/account/{accountNumber}")
    public  ResponseEntity<?> removeAccount(@Validated @PathVariable String accountNumber){

        AccountDTO account=accountService.removeAccount(accountNumber);
        return new ResponseEntity<AccountDTO>(account , HttpStatus.OK);


    }

    @PostMapping("/account/{accountNumber}/transaction/{amount}/{type}")
    public  ResponseEntity<?> createTransaction(@Validated @PathVariable String accountNumber , @PathVariable float amount, @PathVariable String type){

        TransactionDTO transaction=accountService.createTransaction(accountNumber,amount,type);
        return new ResponseEntity<TransactionDTO>(transaction , HttpStatus.OK);


    }




    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccess", false);
        map.put("error", exception.getMessage());
        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<Object>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}

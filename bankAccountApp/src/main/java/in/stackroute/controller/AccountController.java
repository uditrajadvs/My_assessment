package in.stackroute.controller;

import in.stackroute.model.Account;
import in.stackroute.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

//    @Autowired
//    public AccountController(AccountService accountService) {
//        this.accountService = accountService;
//    }

    // Create a new account
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        // Check if the account already exists
//        Account existingAccount = accountService.findById(account.getId());
//        if (existingAccount != null) {
//            return new ResponseEntity<>(HttpStatus.CONFLICT); // 409 Conflict
//        }

        var savedAccount = accountService.save(account);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(savedAccount);
    }

    // Get all accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        var accounts = accountService.findAll();
        if (accounts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accounts); // 200OK
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int id) {
        // Check if the account exists
//        Account existingAccount = accountService.findById(id);
//        if (existingAccount == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
//        }
//
//        accountService.deleteAccountById(id);
//        return new ResponseEntity<>(HttpStatus.OK); // 200 OK
        if (!accountService.exitsById(id)) {
            return ResponseEntity.notFound().build();
        }
        accountService.deleteAccountById(id);
        return ResponseEntity.noContent().build();
    }
}

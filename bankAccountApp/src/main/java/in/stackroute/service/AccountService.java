package in.stackroute.service;

import in.stackroute.model.Account;

import java.util.List;

public interface AccountService {
    Account save(Account account);
    void deleteAccountById(int id);
    boolean exitsById(int id);
    List<Account> findAll();

}

package in.stackroute.service;
import in.stackroute.repository.AccountRepository;
import in.stackroute.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account save(Account account) {
        return repository.save(account);
    }

//    @Override
//    public List<Account> viewAllAccounts() {
//        return accountRepository.findAll();
//    }

    @Override
    public void deleteAccountById(int accountId) {
        repository.deleteById(accountId);
    }

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean exitsById(int id){
        if(!repository.existsById(id)){
            return false;
        }

        return  true;
    }
}


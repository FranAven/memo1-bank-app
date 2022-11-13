package com.aninfo.service;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.exceptions.InsufficientFundsException;
import com.aninfo.model.Account;
import com.aninfo.model.Deposit;
import com.aninfo.model.Extraction;
import com.aninfo.model.Transaction;
import com.aninfo.repository.AccountRepository;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Collection<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> findAccountById(Long cbu) {
        return accountRepository.findById(cbu);
    }

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    public void deleteAccountById(Long cbu) {
        accountRepository.deleteById(cbu);
    }

    public Transaction createDeposit(Deposit deposit){
        if(deposit.getAmount() <= 0){
            throw new DepositNegativeSumException("Cannot deposit negative sums");
        }
        return transactionRepository.save(deposit);
    }

    public Transaction createExtraction(Extraction extraction){
        return transactionRepository.save(extraction);
    }

    public Optional<Transaction> findTransactionById(Long id){
        return transactionRepository.findById(id);
    }

    public List<Transaction> getByAccountCbu(Long cbu){
        return transactionRepository.findTransactionsByAccountCbu(cbu);
    }

    public void deleteTransactionById(Long id){
        transactionRepository.deleteById(id);
    }

    @Transactional
    public Account withdraw(Long cbu, Double sum) {
        Account account = accountRepository.findAccountByCbu(cbu);

        if (account.getBalance() < sum) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        account.setBalance(account.getBalance() - sum);
        accountRepository.save(account);

        return account;
    }

    @Transactional
    public Account deposit(Long cbu, Double sum) {

        if (sum <= 0) {
            throw new DepositNegativeSumException("Cannot deposit negative sums");
        }



        Account account = accountRepository.findAccountByCbu(cbu);
        account.setBalance(account.getBalance() + sum);
        accountRepository.save(account);

        return account;
    }

}

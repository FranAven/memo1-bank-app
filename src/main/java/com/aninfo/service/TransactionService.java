package com.aninfo.service;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.model.Deposit;
import com.aninfo.model.Extraction;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createDeposit(Deposit deposit){
        if(deposit.getAmount() <= 0){
            throw new DepositNegativeSumException("Cannot deposit negative sums");
        }
        return transactionRepository.save(deposit);
    }

    public Transaction createExtraction(Extraction extraction){
        return transactionRepository.save(extraction);
    }

    public Optional<Transaction> findById(Long id){
        return transactionRepository.findById(id);
    }

    public List<Transaction> getByAccountCbu(Long cbu){
        return transactionRepository.findTransactionsByAccountCbu(cbu);
    }

    public void deleteById(Long id){
        transactionRepository.deleteById(id);
    }
}

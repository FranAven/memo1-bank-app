package com.aninfo.service;

import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createDeposit(Long cbu, Double sum){
        if (sum >= 2000){
            if (sum*0.1 <= 500)
                sum = sum*1.1;
            else
                sum = sum+500;
        }
        Transaction transaction = new Transaction(cbu, sum, "Deposit");
        return transactionRepository.save(transaction);
    }

    public Transaction createExtraction(Long cbu, Double sum){
        Transaction transaction = new Transaction(cbu, sum, "Extraction");
        return transactionRepository.save(transaction);
    }

    public Optional<Transaction> findTransactionById(Long id){
        return transactionRepository.findById(id);
    }

    public Collection<Transaction> getTransactionsByAccountCbu(Long cbu){
        return transactionRepository.findTransactionsByAccountCbu(cbu);
    }

    public void deleteTransactionById(Long id){
        transactionRepository.deleteById(id);
    }
}
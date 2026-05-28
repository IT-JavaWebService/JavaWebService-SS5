package com.rikkei.bai5.service;

import com.rikkei.bai5.dto.TransactionRequest;
import com.rikkei.bai5.entity.Transaction;
import com.rikkei.bai5.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public Transaction performTransaction(TransactionRequest request) {
        Transaction transaction = new Transaction(
                request.getWalletAddress(),
                request.getAmount(),
                request.getAmountInUsd(),
                "SUCCESS"
        );

        return transactionRepository.save(transaction);
    }
}
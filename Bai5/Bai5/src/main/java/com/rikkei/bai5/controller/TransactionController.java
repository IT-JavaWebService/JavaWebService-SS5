package com.rikkei.bai5.controller;

import com.rikkei.bai5.dto.TransactionRequest;
import com.rikkei.bai5.entity.Transaction;
import com.rikkei.bai5.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/execute")
    public ResponseEntity<Transaction> executeTransaction(@RequestBody TransactionRequest request) {
        Transaction result = transactionService.performTransaction(request);
        return ResponseEntity.ok(result);
    }
}
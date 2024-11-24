package com.project.PSP_backend.models;

import com.project.PSP_backend.enums.TransactionStatus;

public class TransactionResult {
    private TransactionStatus transactionResult;
    private String acquirerOrderId;
    private String acquirerTimestamp;
    private String issuerOrderId;
    private String issuerTimestamp;
}

package com.project.PSP_backend.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentRequest {
    private long customerId;
    private String merchantId;
    private String merchantPassword;
    private double amount;
    private String merchantOrderId;
    private String successUrl;
    private String failedUrl;
    private String errorUrl;
    private String timestamp;
    private LocalDateTime sendingTime;

    public PaymentRequest(long customerId, double amount) {
        this.customerId = customerId;
        this.merchantId = UUID.randomUUID().toString();
        this.merchantPassword = UUID.randomUUID().toString();
        this.amount = amount;
        this.merchantOrderId = UUID.randomUUID().toString();
        this.successUrl = ""; //postaviti naknadno sva tri URL-a
        this.failedUrl = "";
        this.errorUrl = "";
        this.sendingTime = LocalDateTime.now();
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(LocalDateTime sendingTime) {
        this.sendingTime = sendingTime;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantPassword() {
        return merchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getFailedUrl() {
        return failedUrl;
    }

    public void setFailedUrl(String failedUrl) {
        this.failedUrl = failedUrl;
    }

    public String getErrorUrl() {
        return errorUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

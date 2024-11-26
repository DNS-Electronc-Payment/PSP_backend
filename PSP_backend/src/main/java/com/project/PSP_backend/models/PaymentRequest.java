package com.project.PSP_backend.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentRequest {

    private long id;
    private long customerId;
    private long merchantId;
    private String merchantPassword;
    private double amount;
    private String merchantOrderId;
    private String successUrl;
    private String failedUrl;
    private String errorUrl;
    private String timestamp;
    private long paymentId;
    private String paymentUrl;

    public PaymentRequest(long customerId, double amount) {
        this.customerId = customerId;
        this.merchantId = getMerchantId(customerId); //ID prodavca
        this.merchantPassword = UUID.randomUUID().toString();
        this.amount = amount;
        this.merchantOrderId = UUID.randomUUID().toString();
        this.timestamp = UUID.randomUUID().toString();
        this.successUrl = "http://localhost:4200/success"; //postaviti naknadno sva tri URL-a
        this.failedUrl = "http://localhost:4200/failed";
        this.errorUrl = "http://localhost:4200/error";
        this.paymentId = -1L;
        this.paymentUrl = "";
    }

    private long getMerchantId(long userId) {
        int rest = (int) (userId % 2);
        return rest == 0 ? 1000 : 2000;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
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

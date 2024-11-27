package com.project.PSP_backend.clients;

import com.project.PSP_backend.models.BankResponse;
import com.project.PSP_backend.models.PaymentRequest;
import com.project.PSP_backend.models.TransactionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class APIClient {

    @Autowired
    private RestTemplate restTemplate;
    public void sendPaymentRequest(PaymentRequest paymentRequest) {

        //REST poziv prema Bank Acquirer-u: kreiranje zahtjeva za PaymentUrl i PaymentId
        System.out.println(paymentRequest.getAmount());
        System.out.println(paymentRequest.getCustomerId());
        System.out.println(paymentRequest.getMerchantId());
        String url = "https://localhost:8082/api/bankAccount/send-payment-request" ;

        restTemplate.postForEntity(url, paymentRequest, Void.class);




    }

    public void sendPaymentResponse(BankResponse bankResponse) {
        //REST poziv prema Web Shop-u: vraca se odgovor o uspjesnom/neuspjesnom placanju

        String url = "https://localhost:8080/api/response/bankResponse" ;

        restTemplate.postForEntity(url, bankResponse, Void.class);
    }

    public void sendTransactionResult(TransactionResult transactionResult){
        //zahtjev ka webshopu

        String url = "https://localhost:8080/api/response/transactionResult" ;
        System.out.println("TRANSAKCIJAA");
        restTemplate.postForEntity(url, transactionResult, Void.class);
    }
}


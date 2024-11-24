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
        String url = "https://localhost:8082/api/bankAccount/send-payment-request" ;

        restTemplate.postForEntity(url, paymentRequest, Void.class);


    }

    public void sendPaymentResponse(BankResponse bankResponse) {
        //REST poziv prema Web Shop-u: vraca se odgovor o uspjesnom/neuspjesnom placanju
    }

    public void sendTransactionResult(TransactionResult transactionResult){
        //zahtjev ka webshopu
    }
}


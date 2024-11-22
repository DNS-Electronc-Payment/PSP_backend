package com.project.PSP_backend.clients;

import com.project.PSP_backend.models.BankResponse;
import com.project.PSP_backend.models.PaymentRequest;
import org.springframework.stereotype.Component;

@Component
public class APIClient {

    public void sendPaymentRequest(PaymentRequest paymentRequest) {
        //REST poziv prema Bank Acquirer-u: kreiranje zahtjeva za PaymentUrl i PaymentId
    }

    public void sendPaymentResponse(BankResponse bankResponse) {
        //REST poziv prema Web Shop-u: vraca se odgovor o uspjesnom/neuspjesnom placanju
    }
}


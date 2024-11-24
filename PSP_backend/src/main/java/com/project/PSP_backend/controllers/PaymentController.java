package com.project.PSP_backend.controllers;

import com.project.PSP_backend.clients.APIClient;
import com.project.PSP_backend.models.BankResponse;
import com.project.PSP_backend.models.PaymentRequest;
import com.project.PSP_backend.models.TransactionResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final APIClient apiClient;

    public PaymentController(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    //Ovu metodu poziva Web Shop aplikacija, i to na sledeci nacin:
    //Na frontu Web Shop aplikacije se bira nacin placanja
    //Nacin placanja se bira iz nekog combo box-a npr.
    //Ako je selektovana opcija "credit card payment", Web Shop Front gadja Web Shop Back
    //Tom prilikom, Web Shop Back od Web Shop Fronta dobija podatak amount
    //Metoda u kontroleru Web Shop Backa koja je tada pogodjena od strane Web Shop Fronta, odmah
    //poziva Web Shop API CLienta kome prosljedjuje parametar amount
    //Web Shop API Client gadja ovu metodu u PSP aplikaciji
    //PSP nema ni front, ni bazu podataka
    @PostMapping("/credit-card-payment/{amount}/{customerId}")
    public void processCreditCardPayment(@PathVariable double amount, @PathVariable long customerId) {
        PaymentRequest paymentRequest = new PaymentRequest(customerId, amount);
        //Pozivamo APIClient za kontakt sa bankom
        apiClient.sendPaymentRequest(paymentRequest);
    }

    //Ovu metodu gadja Bank Acquirer (specifikacija, tacka 1.1: Placanje karticom - tacka 6)
    //Ova metoda automatski zove API Clienta koji ce odgovor proslijediti Web Shop-u
    @PostMapping("/response-to-credit-card-payment")
    public void response(@RequestBody BankResponse bankResponse) {
        apiClient.sendPaymentResponse(bankResponse);
    }

    @PostMapping("/transactionResult")
    public void transactionResult(@RequestBody TransactionResult transactionResult){
    apiClient.sendTransactionResult(transactionResult);

    }
}


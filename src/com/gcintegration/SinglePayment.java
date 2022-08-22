package com.gcintegration;

import com.gocardless.GoCardlessClient;
import com.gocardless.resources.Payment;

public class SinglePayment {
    public static void main(String[] args) {
    	
    
        GoCardlessClient client = GoCardlessClient.create(
        		"sandbox_htkvz3FWHW_4-Xo7drptQVs3Xj_tKRbAT2G0a7JK",
            GoCardlessClient.Environment.SANDBOX
        );
        Payment payment = client.payments().create()
            .withAmount(150) // 10 GBP in pence
            .withCurrency("GBP")
            .withLinksMandate("MD000131ZW66XS")
            .withMetadata("invoice_number", "001")
            .withIdempotencyKey("random_payment_specific_string")
            .execute();
        // Keep hold of this payment ID - we'll use it in a minute
        // It should look like "PM000260X9VKF4"  
        System.out.println(payment.getId());
    }
}
package com.gcintegration;

import com.gocardless.GoCardlessClient;
import com.gocardless.resources.RedirectFlow;

public class CompleteRedirectFlow {
    public static void main(String[] args) {
        GoCardlessClient client = GoCardlessClient.create(
        // We recommend storing your access token in an
        // environment variable for security, but you could
        // include it as a string directly in your code
        		"sandbox_htkvz3FWHW_4-Xo7drptQVs3Xj_tKRbAT2G0a7JK",
          	// Change me to LIVE when you're ready to go live
            GoCardlessClient.Environment.SANDBOX
        );

        RedirectFlow redirectFlow = client.redirectFlows()
                .complete("RE000084MQ9PCQGAD4Q79FQYBEAME9ES")
                          //The redirect flow ID from above.  
                .withSessionToken("changeit")
                .execute();

        System.out.println(redirectFlow.getLinks().getMandate());
        // Save this mandate ID for the next section.
        System.out.println(redirectFlow.getLinks().getCustomer());
    }
}
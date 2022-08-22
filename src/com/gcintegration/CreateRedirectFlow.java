package com.gcintegration;

import java.util.Arrays;
import java.util.List;

import com.gocardless.GoCardlessClient;
import com.gocardless.resources.Customer;
import com.gocardless.resources.RedirectFlow;

public class CreateRedirectFlow {
	public static void main(String[] args) {
		GoCardlessClient client = GoCardlessClient.create(
				// We recommend storing your access token in an
				// environment variable for security, but you could
				// include it as a string directly in your code
				"sandbox_oKP5fhEvknIvsOzV4AjhxBLOjuwrX8mEe1dgovb9",
				// Change me to LIVE when you're ready to go live
				GoCardlessClient.Environment.SANDBOX);

		RedirectFlow redirectFlow = client.redirectFlows().create().withDescription("changeit")
				.withSessionToken("changeit") // Not the access token
				.withSuccessRedirectUrl("https://developer.gocardless.com/example-redirect-uri").execute();
		// Hold on to this ID - you'll need it when you
		// "confirm" the redirect flow later
		System.out.println(redirectFlow.getId());
		System.out.println(redirectFlow.getRedirectUrl());
		
		List<Customer> customers = client.customers().list().execute().getItems();
		System.out.println(Arrays.toString(customers.toArray()));
	}
}
package com.olxListing.olxproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olxListing.olxproject.entity.AdminMessages;
import com.olxListing.olxproject.entity.CustomerMessages;
import com.olxListing.olxproject.repository.CustomerMessagesRepo;
import com.olxListing.olxproject.services.MessagesService;

@RestController
@RequestMapping("/message")
public class MessagesController {
	
	@Autowired
	MessagesService messagesService;
	
	// SEE ALL THE MESSAGES FROM OR TO THE CUSTOMERS-----------------
	
	@GetMapping("/seeAllCustomerMessages/{email}")
	public ResponseEntity<?> getCustomerMessages(@PathVariable("email") String email){
		return messagesService.getCustomerMessages(email);
	}
	
	// SEE ALL THE MESSAGES FROM OR TO THE ADMINS-----------------
	
	@GetMapping("/seeAllAdminMessages/{email}")
	public ResponseEntity<?> getAdminMessages(@PathVariable("email") String email){
		return messagesService.getAdminMessages(email);
	}
	
	// SEND MESSAGES FROM CUSTOMER TO CUSTOMER----------------
	
	@PostMapping("/customerToCustomerMessages")
	public String addMessages(@RequestBody CustomerMessages cm) {
		return messagesService.addMessages(cm);
	}
	
	// SEND MESSAGES FROM ADMIN TO CUSTOMER----------------
	
	@PostMapping("/adminTOCustomerMessages")
	public String addAdminMessages(@RequestBody AdminMessages am) {
		return messagesService.addAdminMessages(am);
	}

}

package com.olxListing.olxproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olxListing.olxproject.entity.Listing;
import com.olxListing.olxproject.entity.User_Entity;
import com.olxListing.olxproject.services.ListingService;

@RestController
@RequestMapping("/listing")
public class ListingController {
	
	@Autowired
	ListingService listingService;
	
	// ADD A NEW PRODUCT--------------------------
	
	@PostMapping("/add")
		public ResponseEntity<String> addListing(@RequestBody Listing listing){
			
			return listingService.addListing(listing);
		}
	
	// DISPLAY ALL THE LISTINGS-----------------
	
	@GetMapping("/display")
		public ResponseEntity<?> displayListings(){
			
			return listingService.displayListings();
		}
	
	// GET CONTACT DETAILS OF THE PARTICULAR PRODUCT-------------
	
	@GetMapping("/contactDetails/{id}")
	public ResponseEntity<?> displayContactDetails(@PathVariable("id") int id) {
		return listingService.displayContactDetails(id);
	}
	
	// UPDATE LISTINGS DETAILS------------------
	
	@PutMapping("/update")
	public Listing updateListing(@RequestBody Listing listing) {
		
		return listingService.updateListing(listing);
	}
	
	
	
	// SEARCH PRODUCTS ACCORDING TO CATEGORY--------------
	
	@GetMapping("/searchUsingCategory/{category}")
		public ResponseEntity<?> searchUsingName(@PathVariable("category") String category){
			return listingService.searchUsingCategory(category) ;
		}
	
	// SEARCH PRODUCTS ACCORDING TO CITY--------------------
	
	@GetMapping("/searchUsingLocation/{city}")
	public ResponseEntity<?> searchUsingLocation(@PathVariable("city") String city) {
		return listingService.searchUsingLocation(city);
	}
	
	// SEARCH PRODUCTS LESS THAN THE ENTERED PRICE----------------
	
	@GetMapping("/searchUsingPrice/{price}")
	public ResponseEntity<?> searchUsingPrice(@PathVariable("price") int price){
		return listingService.searchUsingPrice(price);
	}
	
	// SORT THE PRODUCTS IN ASCENDING ORDER BASED ON THE PRICE-------------
	
	@GetMapping("/sortListings")
	public ResponseEntity<?> sortListings(){
		return listingService.sortListings();
	}
	
	

}

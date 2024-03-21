package com.exmaple.miltipledatabase.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/paymentdb")
public class PaymentController {

	@Autowired
	private com.exmaple.miltipledatabase.serviceImpl.PaymentServiceImpl paymentServiceImpl;
	
	@PostMapping(value = "/create")
	public com.exmaple.miltipledatabase.model.Payment_Service savePayment_Service(@RequestBody com.exmaple.miltipledatabase.model.Payment_Service payment_Service) {
		return paymentServiceImpl.createPayment_Service(payment_Service);
		
	}
	

}

package com.exmaple.miltipledatabase.serviceImpl;

import java.util.Random;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exmaple.miltipledatabase.mySql.repository.PaymentServiceRepository;

@Service
public class PaymentServiceImpl {

	@Autowired
	private PaymentServiceRepository paymentrepository;
	
	public com.exmaple.miltipledatabase.model.Payment_Service createPayment_Service(com.exmaple.miltipledatabase.model.Payment_Service payment_Service) {
		payment_Service.setPaymentStatus(paymentsuccess());
		payment_Service.setTransactionId(UUID.randomUUID().toString());
		return paymentrepository.save(payment_Service);
	}
	
	public String paymentsuccess() {
		return new Random().nextBoolean()?"Suceess":"false";
	}
}

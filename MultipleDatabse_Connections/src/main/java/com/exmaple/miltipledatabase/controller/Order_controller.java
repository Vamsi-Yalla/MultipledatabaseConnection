package com.exmaple.miltipledatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderdb")
public class Order_controller {
	
	@Autowired
	private com.exmaple.miltipledatabase.serviceImpl.Order_serviceImpl order_serviceImpl;

	public Order_controller(com.exmaple.miltipledatabase.serviceImpl.Order_serviceImpl order_serviceImpl) {
		super();
		this.order_serviceImpl = order_serviceImpl;
	}

	@PostMapping(value = "/create")
	public com.exmaple.miltipledatabase.model.Order_Service createOrder_Service(@RequestBody com.exmaple.miltipledatabase.model.Order_Service transactionresponce) {
	return order_serviceImpl.saveOrder_Service(transactionresponce);
	}
}

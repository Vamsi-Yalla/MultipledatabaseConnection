package com.exmaple.miltipledatabase.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exmaple.miltipledatabase.model.Order_Service;
import com.exmaple.miltipledatabase.postgres.repository.OrderServiceRepository;

import jakarta.transaction.Transactional;


@Service
public class Order_serviceImpl {

	@Autowired
	private OrderServiceRepository order_repository;
		

	@org.springframework.transaction.annotation.Transactional("orderTransaction")
	public Order_Service saveOrder_Service(Order_Service transactionresponce) {
		return order_repository.saveAndFlush(transactionresponce);
	}
}

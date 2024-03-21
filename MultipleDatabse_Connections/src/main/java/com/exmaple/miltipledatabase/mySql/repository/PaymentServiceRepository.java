package com.exmaple.miltipledatabase.mySql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exmaple.miltipledatabase.model.Payment_Service;

public interface PaymentServiceRepository extends JpaRepository<Payment_Service, Integer> {

}

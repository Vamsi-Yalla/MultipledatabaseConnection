package com.exmaple.miltipledatabase.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exmaple.miltipledatabase.model.Order_Service;

@Repository
public interface OrderServiceRepository extends JpaRepository<Order_Service, Integer> {

}

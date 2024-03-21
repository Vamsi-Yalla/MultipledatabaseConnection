package com.exmaple.miltipledatabase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Table(name = "payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment_Service { 
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	private Double amount;
	@Column(name = "payment_status")
	private String paymentStatus;
	@Column(name = "transaction_id")
	private String transactionId;
	
	
	
	public String setTransactionId(String string) {
	return	this.transactionId=string;
	}
}

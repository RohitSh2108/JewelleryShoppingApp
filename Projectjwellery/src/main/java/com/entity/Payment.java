package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {
	
	@Id
	private int paymentId;
	private String status;
	private String medium;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", status=" + status + ", medium=" + medium + "]";
	}
	
	
	
	

}


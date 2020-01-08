package com.Model;

public class Transaction
{
	private long transactionId;
	private long customerId;
	private long amount;
	private String dateOftransaction;
	private String status;
	private String discription;
	
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getDateOftransaction() {
		return dateOftransaction;
	}
	public void setDateOftransaction(String dateOftransaction) {
		this.dateOftransaction = dateOftransaction;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
}

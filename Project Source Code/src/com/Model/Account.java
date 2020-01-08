package com.Model;

public class Account 
{
	private long customerId;
	private String accType;
	private long accountBal;
	private String branchName;
	
	public Account()
	{
		
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public long getAccountBal() {
		return accountBal;
	}

	public void setAccountBal(long accountBal) {
		this.accountBal = accountBal;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	

	
}

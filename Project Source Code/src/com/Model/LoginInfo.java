package com.Model;

public class LoginInfo
{
	private long customerId;
	private String password;
	private long accountNo;
	private String emailId;
	private String accountCreateDate;
	
	public LoginInfo()
	{
		
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAccountCreateDate() {
		return accountCreateDate;
	}

	public void setAccountCreateDate(String accountCreateDate) {
		this.accountCreateDate = accountCreateDate;
	}

	
}

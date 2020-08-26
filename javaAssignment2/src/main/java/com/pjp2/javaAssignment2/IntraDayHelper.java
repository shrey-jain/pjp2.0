package com.pjp2.javaAssignment2;

public class IntraDayHelper {
	private String Client_Id;
	private String Security_Id;
	private String Transaction_Date;

	public String getClient_Id() {
		return Client_Id;
	}

	public void setClient_Id(String client_Id) {
		Client_Id = client_Id;
	}

	public String getSecurity_Id() {
		return Security_Id;
	}

	public void setSecurity_Id(String security_Id) {
		Security_Id = security_Id;
	}

	public String getTransaction_Date() {
		return Transaction_Date;
	}

	public void setTransaction_Date(String transaction_Date) {
		Transaction_Date = transaction_Date;
	}

	public IntraDayHelper(String client_Id, String security_Id, String transaction_Date) {
		super();
		Client_Id = client_Id;
		Security_Id = security_Id;
		Transaction_Date = transaction_Date;
	}

}

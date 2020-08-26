package com.pjp2.javaAssignment2;

public class Transaction {
	private String External_Transaction_Id;
	private String Client_Id;
	private String Security_Id;
	private String Transaction_Type;
	private String Transaction_Date;
	private Double Market_Value;
	private String Priority_Flag;

	public String getExternal_Transaction_Id() {
		return External_Transaction_Id;
	}

	public void setExternal_Transaction_Id(String external_Transaction_Id) {
		External_Transaction_Id = external_Transaction_Id;
	}

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

	public String getTransaction_Type() {
		return Transaction_Type;
	}

	public void setTransaction_Type(String transaction_Type) {
		Transaction_Type = transaction_Type;
	}

	public String getTransaction_Date() {
		return Transaction_Date;
	}

	public void setTransaction_Date(String transaction_Date) {
		Transaction_Date = transaction_Date;
	}

	public Double getMarket_Value() {
		return Market_Value;
	}

	public void setMarket_Value(Double market_Value) {
		Market_Value = market_Value;
	}

	public String getPriority_Flag() {
		return Priority_Flag;
	}

	public void setPriority_Flag(String priority_Flag) {
		Priority_Flag = priority_Flag;
	}

}

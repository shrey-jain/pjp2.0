package com.pjp2.javaAssignment2;

public class SummaryReport {
	private String Client_Id;
	private String Transaction_Type;
	private String Transaction_Date;

	private String Priority;
	private Double Processing_Fee;

	public SummaryReport(String client_Id, String transaction_Type, String transaction_Date, String priority) {
		super();
		Client_Id = client_Id;
		Transaction_Type = transaction_Type;
		Transaction_Date = transaction_Date;
		Priority = priority;
		Processing_Fee = 0.0;
	}

	public String getClient_Id() {
		return Client_Id;
	}

	public void setClient_Id(String client_Id) {
		Client_Id = client_Id;
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

	public String getPriority() {
		return Priority;
	}

	public void setPriority(String priority) {
		Priority = priority;
	}

	public Double getProcessing_Fee() {
		return Processing_Fee;
	}

	public void setProcessing_Fee(Double processing_Fee) {
		Processing_Fee = processing_Fee;
	}

}

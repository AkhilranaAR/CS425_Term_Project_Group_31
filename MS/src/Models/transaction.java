package Models;

import java.sql.Date;

public class transaction {
	
	private Integer transaction_id;
	private Integer doc_id;
	private String docTitle;
	private String transactionType;
	private Date borrowDate;
	private Date returnDate;
	
	public transaction(Integer transaction_id, Integer doc_id, String docTitle, String transactionType, Date borrowDate, Date returnDate){
		super();
		this.transaction_id = transaction_id;
		this.doc_id = doc_id;
		this.docTitle = docTitle;
		this.transactionType = transactionType;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}
	
	public Integer getDoc_id() {
		return doc_id;
	}
	public Integer getTransaction_id() {
		return transaction_id;
	}
	public String getDocTitle() {
		return docTitle;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
}

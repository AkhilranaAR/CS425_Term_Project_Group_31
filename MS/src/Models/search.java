package Models;


public class search {
	private int doc_id;
	private String docTitle;
	private String docType;
	
	public search(int doc_id, String docTitle, String docType) {
		super();
		this.doc_id = doc_id;
		this.docTitle = docTitle;
		this.docType = docType;
	}

	public Integer getDoc_id() {
		return doc_id;
	}
	
	public String getDocType() {
		return docType;
	}
	
	public String getDocTitle() {
		return docTitle;
	}
}

package Models;

public class borrowBook {
	
	private Integer docId;
	private String title;
	
	public borrowBook(Integer docId, String title) {
		this.docId = docId;
		this.title = title;
	}
	
	
	public Integer getDocId() {
		return docId;
	}
	
	public String getTitle() {
		return title;
	}

}

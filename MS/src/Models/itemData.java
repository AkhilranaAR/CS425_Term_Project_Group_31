package Models;

import java.sql.Date;

public class itemData {

	private Integer id;
	private String title;
	private String category;
	private String image;
	private String price;
	private Date date;
	private String current;
	
	public itemData(Integer id, String title, String category, String image, String price, Date date, String current) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.image = image;
		this.price = price;
		this.date = date;
		this.current = current;
	}
	
	
	public String getCurrent() {
		return current;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getImage() {
		return image;
	}
	
	public String getPrice() {
		return price;
	}
	
	public Date getDate() {
		return date;
	}
	
	
}

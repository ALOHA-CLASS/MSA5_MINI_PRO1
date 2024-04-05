package posts.model;

import java.util.Date;

import lombok.Data;

@Data
public class Category {

	private String id;
	private String strId;
	private String categoryId;
	private String name;
	private int postNo;
	private String type;
	private Date regDate;
	private Date updDate;
	
	public Category() {
		
	}
	public Category(String categoryId, String name, String type) {
		this.categoryId = categoryId;
		this.name = name;
		this.type = type;
		this.postNo = 1;
	}
	
}

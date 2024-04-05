package posts.model;

import lombok.Data;

@Data
public class CategoryType {
	
	private String typeCode;
	private String typeName;
	
	public CategoryType() {
		
	}

	public CategoryType(String typeCode, String typeName) {
		super();
		this.typeCode = typeCode;
		this.typeName = typeName;
	}
	
	

}

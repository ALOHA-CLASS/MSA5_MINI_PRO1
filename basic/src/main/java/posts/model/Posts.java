package posts.model;

import java.util.Date;
import java.util.List;

import files.dto.Files;
import lombok.Data;


@Data
public class Posts {
	
	private String id;
	private String usersId;
	private String cateId;
	private int postNo;
	private String title;
	private String username;
	private String name;
	private String password;
	private String content;
	private Date regDate;
	private Date updDate;
	
	// 파일
	// org.apache.commons.fileupload
	List<Files> fileList;
	
	// 썸네일
	private String thumbnailFileId;

	public Posts() {
		
	}
	
	public Posts(String title, String username, String content) {
		this.title = title;
		this.username = username;
		this.content = content;
	}

}

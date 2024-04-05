package files.dto;

import java.io.File;
import java.util.Date;

import org.apache.commons.fileupload.FileItem;

import lombok.Data;

@Data
public class Files {

	private String id;
	private String parentName;
	private String parentId;
	private String type;
	private String fileName;
	private String filePath;
	private long fileSize;
	private Date regDate;
	private Date updDate;
	
	// 파일 데이터
	private byte[] fileData;
	private File file;
	private FileItem fileItem;
	
	
	public FileItem getFileItem() {
		return this.fileItem;
	}
	
	public void setFileItem(FileItem fileItem) {
		this.fileItem = fileItem;
	}
	
	
}

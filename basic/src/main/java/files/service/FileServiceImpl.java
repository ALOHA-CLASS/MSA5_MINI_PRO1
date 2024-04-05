package files.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import files.data.FileDAO;
import files.dto.Files;

/**
 * 파일 기능 - 비즈니스 로직 클래스
 */
public class FileServiceImpl implements FileService {
	
	private FileDAO fileDAO = new FileDAO();

	@Override
	public List<Files> list() {
		List<Files> fileList = fileDAO.list();
		return fileList;
	}

	@Override
	public Files select(String id) {
		Files file = fileDAO.select(id);
		return file;
	}

	/**
	 * 파일 등록
	 * 1. 파일 경로 등록
	 * 2. 파일 저장
	 */
	@Override
	public int insert(Files file) {
		
		// 1. 파일 경로 등록
		int result = fileDAO.insert(file);
		
		// 2. 파일 저장
		if( result > 0 ) {
			// FileItem fileItem = file.getFileItem();
			File fileObj = file.getFile();
			try {
				FileOutputStream fos = new FileOutputStream(fileObj);
				System.out.println(file.getFileData());
				fos.write(file.getFileData());
				fos.close();
			} catch (Exception e) {
				System.err.println("파일 저장 중 에러 발생!");
				e.printStackTrace();
			}
			
		}
		else {
			System.err.println("파일 등록 실패...");
		}
		
		
		return result;
	}

	@Override
	public int update(Files file) {
		int result = fileDAO.update(file);
		return result;
	}

	@Override
	public int delete(String id) {
		int result = fileDAO.delete(id);
		return result;
	}

	@Override
	public List<Files> listByParent(Files file) {
		List<Files> fileList = fileDAO.listByParent(file);
		return fileList;
	}

}

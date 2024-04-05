package posts.service;

import java.util.List;

import posts.data.CateDAO;
import posts.model.Category;

/**
 * 카테고리 기능 - 비즈니스 로직 클래스
 */
public class CateServiceImpl implements CateService {
	
	private CateDAO cateDAO = new CateDAO();

	@Override
	public List<Category> list() {
		List<Category> categoryList = cateDAO.list();
		return categoryList;
	}

	@Override
	public Category select(String id) {
		Category category = cateDAO.select(id);
		return category;
	}

	@Override
	public int insert(Category category) {
		int result = cateDAO.insert(category);
		return result;
	}

	@Override
	public int update(Category category) {
		int result = cateDAO.update(category);
		return result;
	}

	@Override
	public int delete(String id) {
		int result = cateDAO.delete(id);
		return result;
	}

	@Override
	public Category selectByCategoryId(String id) {
		Category category = cateDAO.selectByCategoryId(id);
		return category;
	}


}

package common.sample.service;

import java.util.List;

import common.sample.data.BaseDAO;
import common.sample.dto.Base;

/**
 * 카테고리 기능 - 비즈니스 로직 클래스
 */
public class BaseServiceImpl implements BaseService {
	
	private BaseDAO baseDAO = new BaseDAO();

	@Override
	public List<Base> list() {
		List<Base> baseList = baseDAO.list();
		return baseList;
	}

	@Override
	public Base select(String id) {
		Base base = baseDAO.select(id);
		return base;
	}

	@Override
	public int insert(Base base) {
		int result = baseDAO.insert(base);
		return result;
	}

	@Override
	public int update(Base base) {
		int result = baseDAO.update(base);
		return result;
	}

	@Override
	public int delete(String id) {
		int result = baseDAO.delete(id);
		return result;
	}

}

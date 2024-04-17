package education.book.model.service;

import static common.SemiTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import education.book.model.dao.EduBookDao;
import education.book.model.dto.EduBookDto;
import education.book.model.dto.EduBookListDto;
import education.model.dao.EduDao;
import education.model.dto.EduOneDto;
import education.model.dto.EduDto;
import education.model.dto.EduListDto;
import education.model.dto.EduRecentDto;

public class EduBookService {
	private EduBookDao dao = new EduBookDao();

	// selectList
	public List<EduBookListDto> selectList() {
		List<EduBookListDto> result = null;
		Connection con = getConnection(true);
		result = dao.selectList(con);
		close(con);
		return result;
	}

	// insert
	public int insert(EduBookDto dto) {
		int result = 0;
		Connection con = getConnection(true);
		result = dao.insert(con, dto);
		close(con);
		return result;
	}


	// delete
	public int delete(String mem_id) {
		int result = 0;
		Connection con = getConnection(true);
		result = dao.delete(con, mem_id);
		close(con);
		return result;
	}
	
//	// update
//	public int update(EduOneDto dto) {
//		int result = 0;
//		Connection con = getConnection(true);
//		result = dao.update(con, dto);
//		close(con);
//		return result;
//	}

}
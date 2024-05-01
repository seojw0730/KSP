package education.model.service;

import static common.SemiTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import common.MybatisTemplate;
import education.model.dao.EduDao;
import education.model.dto.EduOneDto;
import education.model.dto.EduFileDto;
import education.model.dto.EduListDto;
import education.model.dto.EduRecentDto;

public class EduService {
	
	private EduDao dao = new EduDao();

	// selectAllList
	public List<EduListDto> selectAllList(){
		List<EduListDto> result = null;
		SqlSession session = MybatisTemplate.getSqlSession(true);
		result = dao.selectAllList(session);
		return result;
	}
	
	// selectPageList
	public Map<String, Object> selectPageList(String searchSubject, int pageSize, int pageBlockSize, int currentPageNum) {
		Map<String, Object> result = null;
		Connection con = getConnection(true);
		
		int start = pageSize * (currentPageNum - 1) + 1;
		int end = pageSize * currentPageNum;
			
		// 총글수 289
		int totalCount = dao.selectTotalCount(con, searchSubject);
		
		int totalPageCount = (totalCount % pageSize == 0) ? totalCount / pageSize : totalCount / pageSize + 1;
		
		int startPageNum = (currentPageNum % pageBlockSize == 0) ? ((currentPageNum / pageBlockSize) - 1) * pageBlockSize + 1 : (currentPageNum / pageBlockSize) * pageBlockSize + 1;
		int endPageNum = (startPageNum + pageBlockSize > totalPageCount) ? totalPageCount : startPageNum + pageBlockSize - 1;
		
		List<EduListDto> dtolist = dao.selectPageList(con, searchSubject, start, end);
		close(con);
		
		result = new HashMap<String, Object>();
		result.put("dtolist", dtolist);
		result.put("totalPageCount", totalPageCount);
		result.put("startPageNum", startPageNum);
		result.put("endPageNum", endPageNum);
		result.put("currentPageNum", currentPageNum);
		
		return result;
	}
		
	// selectRecent
	public EduRecentDto selectRecent() {
		EduRecentDto result = null;
		Connection con = getConnection(true);
		result = dao.selectRecent(con);
		close(con);
		return result;
	}
		
	// 교육 정보 및 파일 읽기
	public EduOneDto selectOne(Integer eduId) {
		EduOneDto result = null;
		SqlSession session = MybatisTemplate.getSqlSession(true);
		result = dao.selectOne(session, eduId);
		List<EduFileDto> eduFileDtoList = dao.selectFileList(session, eduId);
		result.setEduFileDtoList(eduFileDtoList);
		return result;
	}
	
	// 교육 등록하기
	public int insert(EduOneDto dto, List<EduFileDto> eduFileDtoList) {
		int result = 0;
		SqlSession session = MybatisTemplate.getSqlSession(true);
		result = dao.insert(session, dto, eduFileDtoList);
		session.close();
		return result;
	}
	
	// 교육 수정
	public int update(EduOneDto dto) {
		int result = 0;
		SqlSession session = MybatisTemplate.getSqlSession(true);
		result = dao.update(session, dto);
		session.close();
		return result;
	}
	
	// 교육 삭제
	public int delete(Integer eduId) {
		int result = 0;
		SqlSession session = MybatisTemplate.getSqlSession(true);
		result = dao.delete(session, eduId);
		session.close();
		return result;
	}
}

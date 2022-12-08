package com.esg.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.esg.domain.BGboardVO;
import com.esg.domain.Criteria;

@Repository
public class BGboardDAOImpl implements BGboardDAO{
	
private static final Logger log = LoggerFactory.getLogger(BGboardDAOImpl.class);
	
	private static final String NAMESPACE ="com.esg.mapper.BGMapper";
	
	@Inject
	private SqlSession sqlSession;


	@Override
	public void BGboardwrite(BGboardVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+".createBoard",vo);
	}

	@Override
	public List<BGboardVO> BGboardlist(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".BGlist",cri);
	}

	@Override
	public List<BGboardVO> BGSearchList(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".BGSearchList",cri);
	}

	@Override
	public void getBGmodify(BGboardVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".BGmodify",vo);
	}

	@Override
	public BGboardVO getBGContent(int num) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".BGContent",num);
	}

	@Override
	public void getBGdelete(int num) {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+".BGdelete",num);
	}

	@Override
	public int totalCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".totalCnt");
	}

	@Override
	public void updateBGBoardCount(int num) {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+".BGCount",num);
	}

	@Override
	public void insertFile(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+".insertFile", map);
	}

	@Override
	public int getBoardNum() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".getBoardNum");
	}

	@Override
	public List<Map<String, Object>> selectFileList(int num) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".getBoardFile",num);
	}

}

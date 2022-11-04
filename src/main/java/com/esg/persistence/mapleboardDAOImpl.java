package com.esg.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.esg.domain.mapleboardVO;


@Repository
public class mapleboardDAOImpl implements mapleboardDAO{
	
private static final Logger log = LoggerFactory.getLogger(mapleboardDAOImpl.class);
	
	//mapper 위치값(주소) 이름 (sql를 호출하기 위한 인터페이스)
	private static final String NAMESPACE ="com.esg.mapper.MapleMapper";
	
	//DB연결, 자원해제, SQL실행
	@Inject
	private SqlSession sqlSession;


	@Override
	public void mapleboardwrite(mapleboardVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+".createBoard",vo);
		
	}


	@Override
	public List<mapleboardVO> mapleboardlist() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".maplelist");
	}

}

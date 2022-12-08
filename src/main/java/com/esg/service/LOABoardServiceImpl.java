package com.esg.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.esg.domain.LOABoardVO;
import com.esg.domain.LOASearchCriteria;
import com.esg.persistence.LOABoardDAO;
import com.esg.utils.LOAFileUtils;

@Service
public class LOABoardServiceImpl implements LOABoardService{

	@Inject //dao객체 주입
	LOABoardDAO dao;

	@Resource(name="LOAfileUtils")
	private LOAFileUtils fileUtils;
	
	private static final Logger log = LoggerFactory.getLogger(LOABoardServiceImpl.class);

	@Override
	public List<LOABoardVO> getBoardList(LOASearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.getBoardList(cri);
	}

	@Override
	public void insertBoard(LOABoardVO vo,MultipartFile[] file)throws Exception{
		// TODO Auto-generated method stub
		dao.insertBoard(vo);
	    List<Map<String, Object>>fileList = fileUtils.parseFileInfo(vo, file);
		for(int i=0; i<fileList.size(); i++) {
	        dao.insertFile(fileList.get(i));
	    }
	}

	@Override
	public void updateBoardCount(int num) {
		// TODO Auto-generated method stub
		dao.updateBoardCnt(num);
	}

	@Override
	public LOABoardVO readBoard(int num) {
		// TODO Auto-generated method stub
		LOABoardVO vo = dao.getBoardContent(num);
		return vo;
	}

	@Override
	public void update(LOABoardVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
		
	}
	//파일 정보 불러오기
	@Override
	public List<Map<String, Object>> selectFileList(int num) {
		// TODO Auto-generated method stub
		return dao.selectFileList(num);	
	}

	@Override
	public int countBoardListTotal(LOASearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.countBoardList(cri);
	}

	@Override
	public void insertBoard(LOABoardVO vo) {
		// TODO Auto-generated method stub
		dao.insertBoard(vo);
	}

	@Override
	public void recommend(int num) {
		// TODO Auto-generated method stub
		dao.recommend(num);
	}
}

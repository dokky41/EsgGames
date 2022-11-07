package com.esg.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.esg.persistence.LOLBoardDAO;
import com.esg.utils.LOLFileUtils;
import com.mchange.io.FileUtils;
import com.esg.domain.LOLBoardVO;

@Service
public class LOLBoardServiceImpl implements LOLBoardService {

	@Inject //dao∞¥√º ¡÷¿‘
	LOLBoardDAO dao;

	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	private static final Logger log = LoggerFactory.getLogger(LOLBoardServiceImpl.class);

	@Override
	public List<LOLBoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return dao.getBoardList();
	}

	@Override
	public void insertBoard(LOLBoardVO vo,MultipartHttpServletRequest mpRequest) {
		// TODO Auto-generated method stub
		dao.insertBoard(vo);
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(vo, mpRequest); 
		int size = list.size();
		for(int i=0; i<size; i++){ 
			dao.insertFile(list.get(i)); 
		}
		
	}

	@Override
	public void updateBoardCount(int num) {
		// TODO Auto-generated method stub
		dao.updateBoardCnt(num);
	}

	@Override
	public LOLBoardVO readBoard(int num) {
		// TODO Auto-generated method stub
		LOLBoardVO vo = dao.getBoardContent(num);
		return vo;
	}

	@Override
	public void update(LOLBoardVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
		
	}
	
	
}
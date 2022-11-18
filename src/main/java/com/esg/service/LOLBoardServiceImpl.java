package com.esg.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.esg.persistence.LOLBoardDAO;
import com.esg.utils.FileUtils;
import com.esg.domain.LOLBoardVO;
import com.esg.domain.LOLCriteria;
import com.esg.domain.LOLReplyVO;

@Service
public class LOLBoardServiceImpl implements LOLBoardService {

	@Inject //daoÍ∞ùÏ≤¥ Ï£ºÏûÖ
	LOLBoardDAO dao;

	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	private static final Logger log = LoggerFactory.getLogger(LOLBoardServiceImpl.class);

	@Override
	public List<LOLBoardVO> getBoardList(LOLCriteria cri) {
		// TODO Auto-generated method stub
		return dao.getBoardList(cri);
	}

	@Override
	public void insertBoard(LOLBoardVO vo,MultipartFile[] file)throws Exception{
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
	//∆ƒ¿œ ¡§∫∏ ∫“∑Øø¿±‚
	@Override
	public List<Map<String, Object>> selectFileList(int num) {
		// TODO Auto-generated method stub
		return dao.selectFileList(num);	
	}

	@Override
	public int countBoardListTotal() {
		// TODO Auto-generated method stub
		return dao.countBoardList();
	}

	@Override
	public void insertBoard(LOLBoardVO vo) {
		// TODO Auto-generated method stub
		dao.insertBoard(vo);
	}
}
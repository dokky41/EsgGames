package com.esg.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.esg.domain.BGFileVO;
import com.esg.domain.BGboardVO;
import com.esg.domain.Criteria;
import com.esg.persistence.BGboardDAO;
import com.esg.utils.BGFileUtils;

@Service
public class BGboardServiceImpl implements BGboardService {
	
	private static final Logger log = LoggerFactory.getLogger(BGboardServiceImpl.class);
	
	@Inject
	BGboardDAO dao;
	
	@Resource(name="BGfileUtils")
	private BGFileUtils BGfileUtils;

	@Override
	public void BGboardwrite(BGboardVO vo) {
		// TODO Auto-generated method stub
		dao.BGboardwrite(vo);
		
	}

	@Override
	public List<BGboardVO> BGboardlist(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.BGboardlist(cri);
	}

	@Override
	public List<BGboardVO> BGSearchList(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.BGSearchList(cri);
	}

	@Override
	public void getBGmodify(BGboardVO vo) {
		// TODO Auto-generated method stub
		dao.getBGmodify(vo);
		
	}

	@Override
	public BGboardVO getBGContent(int num) {
		// TODO Auto-generated method stub
		return dao.getBGContent(num);
	}

	@Override
	public void getBGdelete(int num) {
		// TODO Auto-generated method stub
		dao.getBGdelete(num);
	}

	@Override
	public int totalCnt() {
		// TODO Auto-generated method stub
		return dao.totalCnt();
	}

	@Override
	public void updateBGBoardCount(int num) {
		// TODO Auto-generated method stub
		dao.updateBGBoardCount(num);
	}

	@Override
	public void insertFile(BGFileVO vo1, MultipartFile[] file) throws Exception {
		// TODO Auto-generated method stub
		List<Map<String, Object>>fileList = BGFileUtils.parseFileInfo(vo1, file);
		for(int i=0; i<fileList.size(); i++) {
	        dao.insertFile(fileList.get(i));
	    }
	}

	@Override
	public int getBoardNum() {
		// TODO Auto-generated method stub
		return dao.getBoardNum()+1;
	}

	@Override
	public List<Map<String, Object>> selectFileList(int num) {
		// TODO Auto-generated method stub
		return dao.selectFileList(num);
	}

}

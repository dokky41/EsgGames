package com.esg.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.esg.domain.LOLReplyVO;
import com.esg.persistence.LOLReplyDAO;

@Service
public class LOLReplyServiceImpl implements LOLReplyService{
	@Inject
	private LOLReplyDAO dao;

	// ´ñ±Û Á¶È¸
	@Override
	public List<LOLReplyVO> list(int num) throws Exception {
	    return dao.list(num);
	}

	@Override
	public void write(LOLReplyVO vo) throws Exception {
	    dao.write(vo);
	}

	@Override
	public void modify(LOLReplyVO vo) throws Exception {
	    dao.modify(vo);
	}

	@Override
	public void delete(LOLReplyVO vo) throws Exception{
	    dao.delete(vo);
	}
}

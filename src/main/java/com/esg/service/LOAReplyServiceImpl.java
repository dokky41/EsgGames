package com.esg.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.esg.domain.LOAReplyVO;
import com.esg.persistence.LOAReplyDAO;

@Service
public class LOAReplyServiceImpl implements LOAReplyService {
	@Inject
	private LOAReplyDAO dao;

	// ´ñ±Û Á¶È¸
	@Override
	public List<LOAReplyVO> list(int num) throws Exception {
	    return dao.list(num);
	}

	@Override
	public void write(LOAReplyVO vo) throws Exception {
		dao.write(vo);
	}

	@Override
	public void update(LOAReplyVO vo) throws Exception {
	    dao.update(vo);
	}

	@Override
	public void delete(LOAReplyVO vo) throws Exception{
	    dao.delete(vo);
	}

	@Override
	public LOAReplyVO replySelect(LOAReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.replySelect(vo);
	}

	@Override
	public void recommend(int num) {
		// TODO Auto-generated method stub
		dao.recommend(num);
	}

	@Override
	public void Rwrite(LOAReplyVO vo) {
		// TODO Auto-generated method stub
		dao.Rwrite(vo);
	}
}

package com.esg.service;

import java.util.List;

import com.esg.domain.LOLReplyVO;

public interface LOLReplyService {
	// ��� ��ȸ
	public List<LOLReplyVO> list(int num) throws Exception ;

	// ��� ��ȸ
	public void write(LOLReplyVO vo) throws Exception ;

	// ��� ����
	public void update(LOLReplyVO vo) throws Exception ;

	// ��� ����
	public void delete(LOLReplyVO vo) throws Exception ;

}

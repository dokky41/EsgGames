package com.esg.persistence;

import java.util.List;

import com.esg.domain.LOLReplyVO;

public interface LOLReplyDAO {
	// ��� ��ȸ
	public List<LOLReplyVO> list(int num) throws Exception ;

	// ��� ����
	public void write(LOLReplyVO vo) throws Exception ;

	// ��� ����
	public void update(LOLReplyVO vo) throws Exception ;

	// ��� ����
	public void delete(LOLReplyVO vo) throws Exception ;
}

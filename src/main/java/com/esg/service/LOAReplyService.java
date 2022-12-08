package com.esg.service;

import java.util.List;

import com.esg.domain.LOAReplyVO;

public interface LOAReplyService {
	// ��� ��ȸ
	public List<LOAReplyVO> list(int num) throws Exception ;

	// ��� ��ȸ
	public void write(LOAReplyVO vo) throws Exception ;

	// ��� ����
	public void update(LOAReplyVO vo) throws Exception ;

	// ��� ����
	public void delete(LOAReplyVO vo) throws Exception ;
	// ���� ��� ��ȸ
	public LOAReplyVO replySelect(LOAReplyVO vo) throws Exception;

	public void recommend(int num);

	public void Rwrite(LOAReplyVO vo);
}

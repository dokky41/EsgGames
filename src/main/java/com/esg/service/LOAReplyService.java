package com.esg.service;

import java.util.List;

import com.esg.domain.LOAReplyVO;

public interface LOAReplyService {
	// ´ñ±Û Á¶È¸
	public List<LOAReplyVO> list(int num) throws Exception ;

	// ´ñ±Û Á¶È¸
	public void write(LOAReplyVO vo) throws Exception ;

	// ´ñ±Û ¼öÁ¤
	public void update(LOAReplyVO vo) throws Exception ;

	// ´ñ±Û »èÁ¦
	public void delete(LOAReplyVO vo) throws Exception ;
	// ´ÜÀÏ ´ñ±Û Á¶È¸
	public LOAReplyVO replySelect(LOAReplyVO vo) throws Exception;

	public void recommend(int num);

	public void Rwrite(LOAReplyVO vo);
}

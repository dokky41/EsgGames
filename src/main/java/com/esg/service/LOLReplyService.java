package com.esg.service;

import java.util.List;

import com.esg.domain.LOLReplyVO;

public interface LOLReplyService {
	// ´ñ±Û Á¶È¸
	public List<LOLReplyVO> list(int num) throws Exception ;

	// ´ñ±Û Á¶È¸
	public void write(LOLReplyVO vo) throws Exception ;

	// ´ñ±Û ¼öÁ¤
	public void update(LOLReplyVO vo) throws Exception ;

	// ´ñ±Û »èÁ¦
	public void delete(LOLReplyVO vo) throws Exception ;
	// ´ÜÀÏ ´ñ±Û Á¶È¸
	public LOLReplyVO replySelect(LOLReplyVO vo) throws Exception;

	public void recommend(int num);
}

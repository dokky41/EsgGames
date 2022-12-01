package com.esg.persistence;

import java.util.List;

import com.esg.domain.LOLReplyVO;

public interface LOLReplyDAO {
	// ´ñ±Û Á¶È¸
	public List<LOLReplyVO> list(int num) throws Exception ;

	// ´ñ±Û ¾²±â
	public void write(LOLReplyVO vo) throws Exception ;

	// ´ñ±Û ¼öÁ¤
	public void update(LOLReplyVO vo) throws Exception ;

	// ´ñ±Û »èÁ¦
	public void delete(LOLReplyVO vo) throws Exception ;

	LOLReplyVO replySelect(LOLReplyVO vo) throws Exception;

	public void recommend(int num);

	public void Rwrite(LOLReplyVO vo);

}

package com.esg.persistence;

import java.util.List;

import com.esg.domain.LOAReplyVO;

public interface LOAReplyDAO {
	// ´ñ±Û Á¶È¸
		public List<LOAReplyVO> list(int num) throws Exception ;

		// ´ñ±Û ¾²±â
		public void write(LOAReplyVO vo) throws Exception ;

		// ´ñ±Û ¼öÁ¤
		public void update(LOAReplyVO vo) throws Exception ;

		// ´ñ±Û »èÁ¦
		public void delete(LOAReplyVO vo) throws Exception ;

		LOAReplyVO replySelect(LOAReplyVO vo) throws Exception;

		public void recommend(int num);

		public void Rwrite(LOAReplyVO vo);
}

package com.esg.persistence;

import java.util.List;

import com.esg.domain.LOAReplyVO;

public interface LOAReplyDAO {
	// ��� ��ȸ
		public List<LOAReplyVO> list(int num) throws Exception ;

		// ��� ����
		public void write(LOAReplyVO vo) throws Exception ;

		// ��� ����
		public void update(LOAReplyVO vo) throws Exception ;

		// ��� ����
		public void delete(LOAReplyVO vo) throws Exception ;

		LOAReplyVO replySelect(LOAReplyVO vo) throws Exception;

		public void recommend(int num);

		public void Rwrite(LOAReplyVO vo);
}

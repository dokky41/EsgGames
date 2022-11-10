package com.esg.persistence;

import java.util.List;


import com.esg.domain.trMapleVO;

import com.esg.domain.Criteria;

public interface TrMapleDAO {

	    //글 업로드
		void trMapleboardCreate(trMapleVO vo);

		//글목록
		List<trMapleVO> trMapleBoardList(Criteria cri);
		

		//글전체갯수
		int getTotalCnt();

		

		//글수정
		void getTrMapleModify(trMapleVO vo);

		//글삭제
		void getTrMapleDelete(int num);

		//목록검색
		List<trMapleVO> trMapleSearchList(Criteria cri);

		
}

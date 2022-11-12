package com.esg.persistence;

import java.util.List;

import com.esg.domain.Criteria;
import com.esg.domain.mapleboardVO;

public interface mapleboardDAO {

	void mapleboardwrite(mapleboardVO vo);

	List<mapleboardVO> mapleboardlist();

	List<mapleboardVO> mapleSearchList(Criteria cri);

	void getmaplemodify(mapleboardVO vo);


	mapleboardVO getmapleContent(int num);

	void getmapledelete(int num);

}

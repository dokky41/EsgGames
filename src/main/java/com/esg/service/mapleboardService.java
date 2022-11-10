package com.esg.service;

import java.util.List;

import com.esg.domain.Criteria;
import com.esg.domain.mapleboardVO;

public interface mapleboardService {

	void mapleboardwrite(mapleboardVO vo);

	List<mapleboardVO> mapleboardlist();

	List<mapleboardVO> mapleSearchList(Criteria cri);

}

package com.esg.persistence;

import java.util.List;
import java.util.Map;

import com.esg.domain.BGboardVO;
import com.esg.domain.Criteria;

public interface BGboardDAO {

	void BGboardwrite(BGboardVO vo);

	List<BGboardVO> BGboardlist(Criteria cri);

	List<BGboardVO> BGSearchList(Criteria cri);

	void getBGmodify(BGboardVO vo);

	BGboardVO getBGContent(int num);

	void getBGdelete(int num);

	int totalCnt();

	void updateBGBoardCount(int num);

	void insertFile(Map<String, Object> map);

	int getBoardNum();

	List<Map<String, Object>> selectFileList(int num);


}

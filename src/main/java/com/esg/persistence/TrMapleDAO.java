package com.esg.persistence;

import java.util.List;



import com.esg.domain.trMapleVO;

public interface TrMapleDAO {

	
      void trMapleboardCreate(trMapleVO vo);
      
      List<trMapleVO> trMapleboardList();
}

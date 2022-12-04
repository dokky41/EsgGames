package com.esg.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.esg.domain.mapleFileVO;
import com.esg.domain.mapleboardVO;

@Component("maplefileUtils")
public class mapleFileUtils {
	
	private static final org.slf4j.Logger log =  LoggerFactory.getLogger(mapleFileUtils.class);
    
	private static final String uploadPath = "C:\\test\\file\\";
 
    public static List<Map<String, Object>> parseFileInfo(mapleFileVO vo1, MultipartFile[] file) throws Exception {
        
        String boardIDX = String.valueOf(vo1.getBOARD_IDX());
        String creaID = (String) vo1.getCREA_ID();
        
        List<Map<String, Object>> fileList = new ArrayList<Map<String, Object>>();
 
        File target = new File(uploadPath);
        if(!target.exists()) target.mkdirs();
        
        for(int i=0; i<file.length; i++) {
 
            String orgFileName = file[i].getOriginalFilename();
            String orgFileExtension = orgFileName.substring(orgFileName.lastIndexOf("."));
            String saveFileName = UUID.randomUUID().toString().replaceAll("-", "") + orgFileExtension;
            Long saveFileSize = file[i].getSize();
            
            log.info("================== file start ==================");
            log.info("파일 실제 이름: "+orgFileName);
            log.info("파일 저장 이름: "+saveFileName);
            log.info("파일 크기: "+saveFileSize);
            log.info("content type: "+file[i].getContentType());
            log.info("================== file   END ==================");
 
            target = new File(uploadPath, saveFileName);
            file[i].transferTo(target);
            
            Map<String, Object> fileInfo = new HashMap<String, Object>();
 
            fileInfo.put("BOARD_IDX", boardIDX);
            fileInfo.put("ORG_FILE_NAME", orgFileName);
            fileInfo.put("SAVE_FILE_NAME", saveFileName);
            fileInfo.put("FILE_SIZE", saveFileSize);
            fileInfo.put("CREA_ID", creaID);
            fileList.add(fileInfo);
            
        }
        return fileList;
    }

}

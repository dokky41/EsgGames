package com.esg.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.esg.domain.*;

@Component("fileUtils")
public class FileUtils {
	private static final Logger log = LoggerFactory.getLogger(FileUtils.class);
	
	@Resource(name="uploadPath")
    String uploadPath;
 
    public List<LOLBoardVO> parseFileInfo(LOLBoardVO map, MultipartFile[] file) throws Exception {
        
        String boardIDX = String.valueOf(map.getIDX());
        String creaID = (String) map.getCREA_ID();
        
        List<LOLBoardVO> fileList = new ArrayList<LOLBoardVO>();
 
        File target = new File(uploadPath);
        if(!target.exists()) target.mkdirs();
        
        for(int i=0; i<file.length; i++) {
 
            String orgFileName = file[i].getOriginalFilename();
            String orgFileExtension = orgFileName.substring(orgFileName.lastIndexOf("."));
            String saveFileName = UUID.randomUUID().toString().replaceAll("-", "") + orgFileExtension;
            Long saveFileSize = file[i].getSize();
            
            log.debug("================== file start ==================");
            log.debug("파일 실제 이름: "+orgFileName);
            log.debug("파일 저장 이름: "+saveFileName);
            log.debug("파일 크기: "+saveFileSize);
            log.debug("content type: "+file[i].getContentType());
            log.debug("================== file   END ==================");
 
            target = new File(uploadPath, saveFileName);
            file[i].transferTo(target);
            
            Map<String, Object> fileInfo = new HashMap<String, Object>();
 
            fileInfo.put("BOARD_IDX", boardIDX);
            fileInfo.put("ORG_FILE_NAME", orgFileName);
            fileInfo.put("SAVE_FILE_NAME", saveFileName);
            fileInfo.put("FILE_SIZE", saveFileSize);
            fileInfo.put("CREA_ID", creaID);
            fileList.add((LOLBoardVO) fileInfo);
            
        }
        return fileList;
    }
}

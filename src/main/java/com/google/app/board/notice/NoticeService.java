package com.google.app.board.notice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.google.app.pages.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Value("${app.upload.base}")
	private String filePath;
	
	@Value("${app.board.notice}")
	private String notice;
	
	public List<NoticeDTO> list(Pager pager)throws Exception{
		
		pager.makePageNumber(noticeMapper.getCount(pager));
		
		
		
		return noticeMapper.list(pager);
	}
	
	public int create(NoticeDTO noticeDTO, MultipartFile [] attach)throws Exception{
		int result = noticeMapper.create(noticeDTO);
		
		//1. 어디에 저장?
		log.info(filePath);
		String filePath = this.filePath+this.notice;
		
		//attach 자체가 null인 경우
		if(attach == null) {
			return result;			
		}
		
		for(MultipartFile m:attach) {
			
			//파일이 없는 경우 for 반복문을 지속하기 위해
			if(m.isEmpty()) {
				continue;
			}
			
			//2. 어떤이름으로 저장할 것인가?
			String fileName = UUID.randomUUID().toString();
	//		log.warn(fileName);
	//		
	//		//3. 확장자는 어떻게 할것인가?
	//		String f = attach.getOriginalFilename();
	//		f= f.substring(f.lastIndexOf("."));
	//		log.info(f);
			
			fileName = fileName+"_"+m.getOriginalFilename();
			
			//4. 저장
			File file = new File(filePath);
			
			if(!file.exists()) {
				file.mkdirs();
			}
			
			file = new File(file, fileName);
			
			// 파일 저장 1 : multipartfile 의 메서드 사용
			m.transferTo(file);
			
			// 파일 저장 2 : Spring에서 제공하는 클래스 사용
			//FileCopyUtils.copy(attach.getBytes(), file);
			
			// 4. DB에 저장
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setFileName(fileName);
			noticeFileDTO.setOriName(m.getOriginalFilename());
			noticeFileDTO.setBoardNum(noticeDTO.getBoardNum());
			
			result = noticeMapper.createFile(noticeFileDTO);
		}
		return result;
	}
	
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception {
		return noticeMapper.detail(noticeDTO);
	}
}
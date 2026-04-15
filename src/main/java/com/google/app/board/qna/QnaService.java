package com.google.app.board.qna;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.app.pages.Pager;

@Service
public class QnaService {
	
	@Value("${app.upload.base}")
	private String filePath;
	
	@Value("${app.board.qna}")
	private String qna;
	
	@Autowired
	private QnaMapper qnaMapper;
	
	public List<QnaDTO> list(Pager pager) throws Exception {
		pager.makePageNumber(qnaMapper.getCount(pager));
		return qnaMapper.list(pager); 
	}
	
	public int create(QnaDTO qnaDTO, MultipartFile [] attach) throws Exception{
				
		int result = qnaMapper.create(qnaDTO);
		String filepath = this.filePath+this.qna;
		
		if(attach == null) {
			return result;
		}
		
		for(MultipartFile m:attach) {
			if(m.isEmpty()) {
				continue;
			}
			
			String fileName = UUID.randomUUID().toString();
			fileName = fileName + "_"+ m.getOriginalFilename();
			
			File file = new File(filepath);
			
			if(!file.exists()) {
				file.mkdirs();
			}
			
			m.transferTo(file);
			
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriName(m.getOriginalFilename());
			qnaFileDTO.setBoardNum(qnaDTO.getBoardNum());
			
			result = qnaMapper.createFile(qnaFileDTO);
		}
		
		return result;
	}
	
	public QnaDTO detail(QnaDTO qnaDTO) throws Exception{
		return qnaMapper.detail(qnaDTO);
	}
	
	// 답글
	public int replyCreate(QnaDTO qnaDTO) throws Exception{
		QnaDTO parent = qnaMapper.detail(qnaDTO);
		
		//답글의 REF
		qnaDTO.setBoardRef(parent.getBoardRef());
		//답글의 STEP
		qnaDTO.setBoardStep(parent.getBoardStep()+1);
		//답글의 DEPTH
		qnaDTO.setBoardDepth(parent.getBoardDepth() + 1);
		
		int result = qnaMapper.replyUpdate(parent);
		
		result = qnaMapper.create(qnaDTO);
		return result;
	}
}

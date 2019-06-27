package com.iu.s4;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.board.notice.NoticeDTO;
import com.iu.board.notice.NoticeService;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	@RequestMapping(value = "noticeWrite")
	public String setData(NoticeDTO noticeDTO)throws Exception{
		System.out.println("notice Controller");
		noticeDTO.setTitle("title");
		noticeDTO.setContents("contents");
		noticeDTO.setWriter("writer");
		int result=noticeService.setData(noticeDTO);
		
		return "redirect:../";
	}

}

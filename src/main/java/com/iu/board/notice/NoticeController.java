package com.iu.board.notice;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	@RequestMapping(value="noticeWrite", method = RequestMethod.GET)
	public String noticeWrite(NoticeDTO noticeDTO) {
		
		try {
			System.out.println(noticeService.setData(noticeDTO));
			System.out.println(noticeDTO.getTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:../";
	}

}

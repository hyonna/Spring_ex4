package com.iu.board.notice;

import javax.inject.Inject;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;

public class NoticeService implements BoardService{
	
	@Inject
	private NoticeDAO noticeDAO;
	
	
	public NoticeService(NoticeDAO noticeDAO) {

		this.noticeDAO = noticeDAO;
	}

	@Override
	public int setData(BoardDTO boardDTO) throws Exception {
		System.out.println("notice Service");
		return noticeDAO.setdata(boardDTO);
		
	}
	
	

}

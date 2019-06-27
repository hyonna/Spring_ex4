package com.iu.board.qna;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;

@Service
public class QnaService implements BoardService {
	
	@Inject
	private QnaDAO qnaDAO;

	@Override
	public int setData(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setdata(boardDTO);
	}

}
package com.iu.board.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.inject.Inject;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.DBConnector;

public class NoticeDAO implements BoardDAO{
	
	@Inject
	private DBConnector dbConnector;
	
	@Inject
	private NoticeDTO noticeDTO;
	
	public NoticeDAO(DBConnector dbConnector, NoticeDTO noticeDTO) {
		
		this.dbConnector = dbConnector;
		this.noticeDTO = noticeDTO;
	}

	@Override
	public int setdata(BoardDTO boardDTO) throws Exception {
		
		Connection con = dbConnector.getConnect();
		
		String sql = "insert into notice values(notice_seq.nextval, ?, ?, null, sysdate, 0)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, noticeDTO.getTitle());
		st.setString(2, noticeDTO.getWriter());
		
		int result = st.executeUpdate();
		
		return result;
		
		
	}
	
	

}

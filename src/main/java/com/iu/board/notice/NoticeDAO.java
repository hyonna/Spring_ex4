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
	
	
	public NoticeDAO(DBConnector dbConnector) {
		
		this.dbConnector = dbConnector;
	}


	@Override
	public int setdata(BoardDTO boardDTO) throws Exception {
		
		System.out.println("notice DAO");
		Connection con = dbConnector.getConnect();
		String sql ="insert into notice values(notice_seq.nextval, ?,?,null,sysdate,0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getWriter());
		int result = st.executeUpdate();
		st.close();
		con.close();
		return result;
	}

	
	

}

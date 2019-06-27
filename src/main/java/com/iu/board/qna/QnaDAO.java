package com.iu.board.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.DBConnector;

@Repository //new QnaDAO();
public class QnaDAO implements BoardDAO {
	
	@Inject
	private DBConnector dbConnector;
	
	
	@Required
	public void QnaDAO(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}



	@Override
	public int setdata(BoardDTO boardDTO) throws Exception {
		Connection con = dbConnector.getConnect();
		String sql ="insert into qna values(qna_seq.nextval, ?, ?, null, sysdate, 0, qna_seq.currval, 0, 0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getWriter());
		int result = st.executeUpdate();
		st.close();
		con.close();
		return result;
	}


}

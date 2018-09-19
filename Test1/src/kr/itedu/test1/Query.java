package kr.itedu.test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class Query {
	public static ArrayList<BoardVO> getAllBoardList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			Connection conn = DBConnector.getConn();
			String query = " select " + 
					" bid, btitle, bregdate, " +
					" to_char(bregdate, 'YYYY-MM-DD hh24:mi') as bregdate "+
					" from t_board ORDER BY bid desc ";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO vo=new BoardVO();
				vo.setBid(rs.getInt("bid"));
				vo.setBtitle(rs.getString("btitle"));
				vo.setBregdate(rs.getString("bregdate"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static BoardVO getBoardList(int bid) {
		BoardVO vo = new BoardVO();
		try {
			Connection conn = DBConnector.getConn();
			String query = " select " + 
					" btitle, bcontent ,bregdate, editdate, " +
					" to_char(bregdate, 'YYYY-MM-DD hh24:mi') as bregdate "+
					" from t_board where bid = " +bid;
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				vo.setBcontent(rs.getString("bcontent"));
				vo.setBtitle(rs.getString("btitle"));
				vo.setBregdate(rs.getString("bregdate"));
				vo.setEditdate(rs.getString("editdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	public static void insert(String box1, String box2) {
				try {
			Connection conn = DBConnector.getConn();
			String query = " insert into t_board " + 
					" (bid, btitle, bcontent) " +
					" values ((select nvl(Max(bid),0)+1 from t_board), ?, ?) ";
					
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, box1);
			ps.setString(2, box2);
			ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
}
	public static void update(String box1, String box2, int bid) {
		try {
	Connection conn = DBConnector.getConn();
	String query = " update t_board " + 
			" set btitle=?, bcontent=?, editdate=sysdate where bid=? ";
			
	PreparedStatement ps = conn.prepareStatement(query);
	ps.setString(1, box1);
	ps.setString(2, box2);
	ps.setInt(3, bid);
	ps.executeQuery();
} catch (Exception e) {
	e.printStackTrace();
}

}
}
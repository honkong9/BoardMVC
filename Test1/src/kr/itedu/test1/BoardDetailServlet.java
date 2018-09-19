package kr.itedu.test1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.test1.BoardVO;

@WebServlet("/boardDetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
			int bid = Integer.parseInt(request.getParameter("bid"));
			BoardVO vo = Query.getBoardList(bid);
			request.setAttribute("boardDetail", vo);
			
			RequestDispatcher rd = request.getRequestDispatcher("boardDetail.jsp");
			rd.forward(request, response);
			
	}
}

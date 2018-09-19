package kr.itedu.test1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.test1.BoardVO;

/**
 * Servlet implementation class boardRegModServlet
 */
@WebServlet("/boardRegMod")
public class boardRegModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public boardRegModServlet() {
		super();

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardVO vo = Query.getBoardList(bid);
		request.setAttribute("boardRegMod", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("boardRegMod.jsp");
		rd.forward(request,  response);
		}
	
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int bid = Integer.parseInt(request.getParameter("hidden"));
		if(bid!=0) {
			String box1= request.getParameter("box1");
			String box2= request.getParameter("box2");
			Query.update(box1,box2,bid);
			response.sendRedirect("boardlist");
		}else {
		
		String box1= request.getParameter("box1");
		String box2= request.getParameter("box2");
		Query.insert(box1,box2);

		

		response.sendRedirect("boardlist");
	}
	}
}

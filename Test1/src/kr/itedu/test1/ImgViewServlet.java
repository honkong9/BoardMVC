package kr.itedu.test1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImgView
 */
@WebServlet("/ImgView")
public class ImgViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("img1", "http://image.cine21.com/resize/cine21/person/2018/0724/14_18_10__5b56b6928655c[W680-].jpg");
		request.setAttribute("img2", "http://storage.googleapis.com/cr-resource/image/b48d38cb42adae700c7118da7a2cbea8/yoonging/1920/b1efca2e69ae59a2790d3df04fd41d85.jpg");
		
		RequestDispatcher dis = request.getRequestDispatcher("ImgView.jsp");
		dis.forward(request,  response);
	}



}

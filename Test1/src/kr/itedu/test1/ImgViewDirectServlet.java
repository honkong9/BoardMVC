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
@WebServlet("/ImgViewDirect")
public class ImgViewDirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgViewDirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("img5", "https://post-phinf.pstatic.net/MjAxNzA3MDZfNDAg/MDAxNDk5MzI3MTEyNDI5.k_8q_KLUkcp7P6P382gRtioTzV6Aj3JXTYBc4FxJJVMg.LrdXIY5Ol0-GNBrQaR_-ciaHnxms2Z7G7P9SOWPRYoYg.JPEG/9sgvq.jpg?type=w1200");
		request.setAttribute("img6", "http://pet.chosun.com/images/news/healthchosun_pet_201704/20170426133109_1160_3158_5548.jpg");
		
		response.sendRedirect("ImgView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

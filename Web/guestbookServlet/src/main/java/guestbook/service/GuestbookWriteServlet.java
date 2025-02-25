package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

@WebServlet("/GuestbookWriteServlet")
public class GuestbookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터
		request.setCharacterEncoding("UTF-8"); //post인 경우
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		GuestbookDTO guestbookDTO = new GuestbookDTO();
		guestbookDTO.setName(name);
		guestbookDTO.setEmail(email);
		guestbookDTO.setHomepage(homepage);
		guestbookDTO.setSubject(subject);
		guestbookDTO.setContent(content);
		
		//DB 연동 (.jar파일을 lib폴더에 복사)
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		guestbookDAO.guestbookWrite(guestbookDTO);
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //스트림 생성
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>작성하신 글을 저장하였습니다.<h3>");
		out.println("<button type='button' onclick=\"location.href='guestbookServlet/GuestbookListServlet?pg=1'\">글목록</button>");
		out.println("</body>");
		out.println("</html>");
	}

}

package com.ssafy.ws.step2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.ssafy.ws.step2.dto.Movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.

@WebServlet("/main")

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 public MainServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			super.destroy();
		}

		@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			super.init();
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String title = request.getParameter("title");
			String director = request.getParameter("director");
			String genre = request.getParameter("genre");
			int runningTime = Integer.parseInt(request.getParameter("runningTime"));
			
			Movie mo = new Movie(0, title, director, genre, runningTime);
			//2. logic 처리
			
			//3. 응답 페이지 작성(html)
			response.setContentType("text/html;charset=utf-8");
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("	<body>");
			out.println("		<h1>영화 정보</h1>");
			out.println("Movie [영화id = " + mo.getId() + ", 영화 제목 = "+ mo.getTitle() + ", 감독 = " + mo.getDirector()+ ", 장르 = "+mo.getGenre()+", 상영시간 = " + mo.getRunningTime() + "]");
			out.println("	</body>");
			out.println("</html>");
			
		}

	
}

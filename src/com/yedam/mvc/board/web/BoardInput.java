package com.yedam.mvc.board.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.mvc.board.dao.BoardsDAO;
import com.yedam.mvc.board.service.BoardVO;

/**
 * Servlet implementation class BoardInput
 */
@WebServlet("/BoardInput.do")
public class BoardInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		BoardsDAO dao = new BoardsDAO();
		BoardVO vo = new BoardVO();
		
		// boardInputForm.jsp에 설정된 name이름으로 파라미터값 설정
		vo.setBoardNo(Integer.parseInt(request.getParameter("boardNo")));
		vo.setWriter(request.getParameter("writer"));
		vo.setCreationDate(Date.valueOf(request.getParameter("creationDate")));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		
		String viewPage = null;
		int n = dao.insert(vo);
		
		if(n != 0) {
			viewPage = "BoardList.do";
		}else {
			String message = "입력한 내용을 DB에 저장하지 못했습니다.";
			request.setAttribute("msg", message);
			viewPage = "views/board/boardInputFail.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

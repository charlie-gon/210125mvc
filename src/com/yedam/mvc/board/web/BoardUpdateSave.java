package com.yedam.mvc.board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.mvc.board.dao.BoardsDAO;
import com.yedam.mvc.board.service.BoardVO;

/**
 * Servlet implementation class BoardUpdateSave
 */
@WebServlet("/BoardUpdateSave.do")
public class BoardUpdateSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateSave() {
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
		
		vo.setBoardNo(Integer.parseInt(request.getParameter("no")));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		
		int n = dao.update(vo);
		String viewPage = null;
		
		if(n != 0) {
			viewPage = "BoardList.do";
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

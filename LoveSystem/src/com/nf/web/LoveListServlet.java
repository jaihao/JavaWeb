package com.nf.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.dao.LoveInHeartDao;
import com.nf.entity.LoveInHeart;

/**
 * Servlet implementation class LoveListServlet
 */
@WebServlet("/List.do")
public class LoveListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoveListServlet() {
     }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LoveInHeart> list =new LoveInHeartDao().getLoveList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/showLoveList.jsp").forward(request, response);
		
	}

}

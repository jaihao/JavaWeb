package com.nf.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.dao.DromitoryDao;
import com.nf.entity.Dromitory;

/**
 * Servlet implementation class AddDromitory
 */
@WebServlet("/add.do")
public class AddDromitory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDromitory() {
        super();
        // TODO Auto-generated constructor stub
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String dromitoryId=request.getParameter("dromitoryId");
		String stuName=request.getParameter("stuName");
		String stuSex=request.getParameter("stuSex");
		String clsName=request.getParameter("clsName");
		int bedNo=Integer.parseInt(request.getParameter("bedNo"));
		String inDate=request.getParameter("inDate");
		
		//System.out.println(dromitoryId+stuName+stuSex+clsName+bedNo+inDate);
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date inDates = null;
		try {
			inDates = sdf.parse(inDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Dromitory d =new Dromitory();
		d.setDromitoryId(dromitoryId);
		d.setStuName(stuName);
		d.setStuSex(stuSex);
		d.setClsName(clsName);
		d.setBedNo(bedNo);
		d.setInDate(inDates);
		
		boolean bl=new DromitoryDao().addDromitory(d);
		if(bl){
			response.sendRedirect("/dromitorySys/index.do");
		}else{
			response.getWriter().append("登记入住失败，请重新登记");
		}
	}

}

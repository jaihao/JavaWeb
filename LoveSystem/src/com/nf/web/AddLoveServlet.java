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

import com.nf.dao.LoveInHeartDao;
import com.nf.entity.LoveInHeart;

/**
 * Servlet implementation class AddLoveServlet
 */
@WebServlet("/Add.do")
public class AddLoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLoveServlet() {
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

		String lname=request.getParameter("lname");
		String lsex=request.getParameter("lsex");
		//����ַ���ת��Double����
		Double lmoney=Double.parseDouble(request.getParameter("lmoney"));
		//�����ַ���תDate����
		String ltime=request.getParameter("ltime");
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		

		System.out.println(lname+lsex+ltime+lmoney);
		
		LoveInHeart l=new LoveInHeart();
		l.setLname(lname);
		l.setLsex(lsex);
		l.setLmoney(lmoney);
		Date q = null;
		try {
			q = sdf.parse(ltime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		l.setLtime(q);
		LoveInHeartDao li=new LoveInHeartDao();
		boolean bl =li.addLoveInHeart(l);
		String msg="";
		if(bl){
			msg="����ѳɹ���лл����֧�֣�ף�����Ҹ�����";
		}else{
			msg="ϵͳ���ϣ������������������";
		}
		request.getSession().setAttribute("msg",msg);
		response.sendRedirect("/LoveSystem/List.do");
	}

}

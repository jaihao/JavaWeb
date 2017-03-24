package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import entity.Employee;

/**
 * Servlet implementation class EmployeeAddServlet
 */
@WebServlet("/Add.do")
public class EmployeeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAddServlet() {
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
		PrintWriter out= response.getWriter();
		String ename=request.getParameter("ename");
		int eage=Integer.parseInt(request.getParameter("eage"));
		int esex=Integer.parseInt(request.getParameter("esex"));
		String eemail=request.getParameter("eemail");
		
		//System.out.println(ename+eage+esex+eemail);
		
		Employee e=new Employee();
		EmployeeDao d=new EmployeeDao();
		e.setEname(ename);
		e.setEage(eage);
		e.setEsex(esex);
		e.setEemail(eemail);
		if(d.addEmployee(e)){
			out.append("<script>alert('添加成功');location.href='showEmployee.jsp'</script>");
		}else{
			out.append("<script>alert('添加失败');location.href='addEmployee.jsp'</script>");
		}
		
		
	}

}

package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.testDao;
import model.test;

/**
 * Servlet implementation class TestController
 */
@WebServlet("/TestController")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	
		String action = request.getParameter("action");
		System.out.println(action);
		
		
		if(action.equalsIgnoreCase("Register")) {
			test t = new test();
			t.setName(request.getParameter("name"));
			t.setContact(Long.parseLong(request.getParameter("contact")));
			t.setGender(request.getParameter("gender"));
			t.setDob(request.getParameter("dob"));
			t.setAdddress(request.getParameter("address"));
			t.setEmail(request.getParameter("email"));
			t.setPassword(request.getParameter("password"));
			testDao.insertTest(t);
			response.sendRedirect("login.jsp");
		}
		else if(action.equalsIgnoreCase("login")) {
			test t = new test();
			t.setEmail(request.getParameter("email"));
			t.setPassword(request.getParameter("password"));
			String email = request.getParameter("email");
			boolean flag = testDao.checkEmail(email);
			
			if(flag == true) {
				test t1 = testDao.testlogin(t);
				if(t1 == null) {
					request.setAttribute("msg1", "password is incorrect");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else {
					HttpSession session = request.getSession();
					session.setAttribute("data", t1);
					request.getRequestDispatcher("home.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "email is not registerd");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			test t = testDao.getTestByID(id);
			request.setAttribute("test", t);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("update")) {
			test t  = new test();
			t.setId(Integer.parseInt(request.getParameter("id")));
			t.setName(request.getParameter("name"));
			t.setContact(Long.parseLong(request.getParameter("contact")));
			t.setGender(request.getParameter("gender"));
			t.setDob(request.getParameter("dob"));
			t.setAdddress(request.getParameter("address"));
			t.setEmail(request.getParameter("email"));
			t.setPassword(request.getParameter("password"));
			testDao.editTest(t);
			response.sendRedirect("home.jsp");
		}
		else if(action.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			testDao.deleteTest(id);
			response.sendRedirect("home.jsp");
		}
	}
	
	

}

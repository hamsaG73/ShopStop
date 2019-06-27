

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessLogin
 */
@WebServlet("/SessLogin")
public class SessLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try
		{
			response.setContentType("text/html");
			PrintWriter pwriter=response.getWriter();
			String name=request.getParameter("userName");
			String password=request.getParameter("userPassword");
			pwriter.print("hello  "+name +"<br>");
			pwriter.print("your password is:  "+password +"<br>");
			HttpSession session=request.getSession();
			pwriter.print("Session Id:" + session.getId()+"<br>");
			pwriter.print("Session CreationTime:" + session.getCreationTime()+"<br>");
			session.setAttribute("uname", name);
			session.setAttribute("upass", password);
			pwriter.print("<a href='SessWelcome'>View details</a>");
			pwriter.close();
		}
		catch(Exception exp)
		{
			System.out.println(exp);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<form action='UpdateVariable'>") ;
		out.println("<p style = 'color: #191970; text-align: center; font-size: 40px; '>Enter the Web API</p>");
		out.println("<div style = 'text-align: center'>");
		out.println("<input type='text' Name='WebAPI' style= 'background-color: #E0FFFF; width:300px; height:50px; border-color: #00FFFF; color:#00008B; font-size: 24px; text-align: center'/>") ;
		out.println("</div>");
		out.print("<br/>");	
		out.println("<div style = 'text-align: center'>");
		out.println("<input type='submit' value='Update' style='text-align: center; width: 100px; height 25px; background-color: #6495ED; color: #F0F8FF'>") ;
		out.println("</div>");
		out.println("</form>");
		out.println("<div style = 'text-align: center'>");
		out.println("<form action='MyFirst.html'>") ;
		out.println("<input type='submit' value='Home Page' style='text-align: center; width: 100px; height 25px; background-color: #6495ED; color: #F0F8FF'>") ;
		out.println("</form>");
		out.println("</div>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

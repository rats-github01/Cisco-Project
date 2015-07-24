

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Find
 */
@WebServlet("/Find")
public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		
		out.println("<form action='FindDocument'>") ;
		out.println("<p style = 'color: #191970; text-align: center; font-size: 40px; '>Enter the Web API</p>");
		out.println("<div style = 'text-align: center'>");
		out.println("<input type='text' Name='WebAPI' style= 'background-color: #E0FFFF; width:300px; height:50px; border-color: #00FFFF; color:#00008B; font-size: 24px; text-align: center'/>") ;
		out.println("</div>");
		out.print("<br/>");
		/*out.println("JVM:<input type='text' Name='JVM'/>") ;
		out.println("App Name:<input type='text' Name='AppName'/>") ;
		out.println("<fieldset>");
		out.println("<legend Name = 'APIX'> APIX </legend>");
		out.println("<input type='radio'  Name = 'APIX' value='true'>True<br>");
		out.println("<input type='radio'  Name = 'APIX' value='false'>False<br>");
		out.print("<br/>");
		out.println("</fieldset>");*/
		out.println("<div style = 'text-align: center'>");
		out.println("<input type='submit' value='Find' style = 'text-align: center; width: 100px; height 25px; background-color: #6495ED; color: #F0F8FF'>");
		out.println("</div>");
		out.println("</form>");
		out.println("<form action='MyFirst.html'");
		out.println("<div style = 'text-align: center'>");
		out.println("<input type='submit' value='Home Page' style = 'text-align: center; width: 100px; height 25px; background-color: #6495ED; color: #F0F8FF'>");
		out.println("</div>");
		out.println("</form>");
		out.print("</html>");
		
		
		
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");		
		out.println("<body>");
		out.println("<form action='InsertDocument'>") ;
		out.println("<table border='1' cellpadding= '2' style='background-color: #20B2AA; color:#E6E6FA; border: 3px solid #191970'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>");
		out.println("Key");
		out.println("</th>");
		out.println("<th>");
		out.println("Value");
		out.println("</th>");
		out.println("</thead>");
		out.println("<tbody>");
		out.println("<tr>");
		out.println("<td align ='center' valign='middle'>");
		out.println("Web Application API");
		out.println("</td>");
		out.println("<td align ='center' valign='middle'>");
		out.println("<input type='text' Name='WebAPI'/>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align ='center' valign='middle'>");
		out.println("JVM Name");
		out.println("</td>");
		out.println("<td align ='center' valign='middle'>");
		out.print("<input type='text' Name='JVM'/>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align ='center' valign='middle'>");
		out.println("App Name");
		out.println("</td>");
		out.println("<td align ='center' valign='middle'>");
		out.print("<input type='text' Name='AppName'/>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align ='center' valign='middle'>");
		out.println("APIX");
		out.println("</td>");
		out.println("<td align ='center' valign='middle'>");
		out.println("<input type='radio'  Name = 'APIX' value='true'>True<br>");
		out.println("<input type='radio'  Name = 'APIX' value='false'>False<br>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align ='center' valign='middle'>");
		out.println("WSGX");
		out.println("</td>");
		out.println("<td align ='center' valign='middle'>");
		out.println("<input type='radio'  Name = 'WSGX' value='true'>True<br>");
		out.println("<input type='radio'  Name = 'WSGX' value='false'>False<br>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align ='center' valign='middle'>");
		out.println("WSGI");
		out.println("</td>");
		out.println("<td align ='center' valign='middle'>");
		out.println("<input type='radio'  Name = 'WSGI' value='true'>True<br>");
		out.println("<input type='radio'  Name = 'WSGI' value='false'>False<br>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align ='center' valign='middle'>");
		out.println("Schema URL");
		out.println("</td>");
		out.println("<td align ='center' valign='middle'>");
		out.print("<input type='text' Name='SchemaUrl'/>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align ='center' valign='middle'>");
		out.println("Latest Release");
		out.println("</td>");
		out.println("<td align ='center' valign='middle'>");
		out.print("<input type='text' Name='LatestRelease'/>");
		out.println("</td>");
		out.println("</tr>");
		/*out.println("Web API:<input type='text' Name='WebAPI'/>");
		out.print("<br/>");
		out.println("JVM:<input type='text' Name='JVM'/>");
		out.print("<br/>");
		out.println("App Name:<input type='text' Name='AppName'/>");
		out.print("<br/>");
		out.println("<fieldset>");
		out.println("<legend Name = 'APIX'> APIX </legend>");
		out.println("<input type='radio'  Name = 'APIX' value='true'>True<br>");
		out.println("<input type='radio'  Name = 'APIX' value='false'>False<br>");
		out.print("<br/>");
		out.println("</fieldset>");
		out.println("<fieldset>");
		out.println("<legend Name = 'WSGX'> WSGX </legend>");
		out.println("<input type='radio'  Name = 'WSGX' value='true'>True<br>");
		out.println("<input type='radio'  Name = 'WSGX' value='false'>False<br>");
		out.print("<br/>");
		out.println("</fieldset>");
		out.println("<fieldset>");
		out.println("<legend Name = 'WSGI'> WSGI </legend>");
		out.println("<input type='radio'  Name = 'WSGI' value='true'>True<br>");
		out.println("<input type='radio'  Name = 'WSGI' value='false'>False<br>");
		out.print("<br/>");
		out.println("</fieldset>");
		out.println("Schema URL:<input type='text' Name='SchemaUrl'/>");
		out.print("<br/>");
		out.println("Latest Release:<input type='text' Name='LatestRelease'/>");
		out.print("<br/>");*/
		out.println("</tbody>");
		out.println("</table>");
		out.println("<input type='submit' value='Insert'  style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 30px;'>") ;
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.println("<form action='MyFirst.html'>") ;
		out.println("<input type='submit' value='Home Page' style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 30px;'>") ;
		out.println("</form>");
		
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

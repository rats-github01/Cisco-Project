

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * Servlet implementation class Confirmation
 */
@WebServlet("/Confirmation")
public class Confirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		String WebAPI = request.getParameter("WebAPI");
		/*String JVM = request.getParameter("JVM");
		String AppName = request.getParameter("AppName");
		String APIX = request.getParameter("APIX");*/
		MongoClient mongoClient = new MongoClient();
		mongoClient = new MongoClient("localhost", 27017);
		
		DB db = mongoClient.getDB("Web");
		DBCollection dbCollection = db.getCollection("Info");
		try{
	BasicDBObject query = new BasicDBObject("Web API", WebAPI);
	/*BasicDBObject query = new BasicDBObject("JVM", JVM);
	BasicDBObject query = new BasicDBObject("AppName", AppName);
	BasicDBObject query = new BasicDBObject("APIX", APIX);*/
	DBCursor cursor = dbCollection.find(query);	
	BasicDBObject dbObject = (BasicDBObject)cursor.next();
	
	 
	String webAPI = dbObject.getString("Web API");
	String JVMName = dbObject.getString("JVM");
	String AppName = dbObject.getString("App Name");
	String APIX = dbObject.getString("APIX");
	String WSGX = dbObject.getString("WSGX");
	String WSGI = dbObject.getString("WSGI");
	String SchemaUrl = dbObject.getString("Schema URL");
	String LatestRelease = dbObject.getString("Latest Release");
	
	out.println("Are you sure you want to delete the follwing document?");
	out.println("<html>");
	out.println("<body>");
	out.println("<form action='DeleteDocument'>") ;
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
	out.println("<input readonly Name = 'WebAPI' value= " + webAPI  + ">");
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td align ='center' valign='middle'>");
	out.println("JVM Name");
	out.println("</td>");
	out.println("<td align ='center' valign='middle'>");
	out.print( "<input readonly Name = 'JVM' value= " + JVMName  + ">");
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td align ='center' valign='middle'>");
	out.println("App Name");
	out.println("</td>");
	out.println("<td align ='center' valign='middle'>");
	out.print( "<input readonly Name = 'AppName' value= " + AppName  + ">");
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td align ='center' valign='middle'>");
	out.println("APIX");
	out.println("</td>");
	out.println("<td align ='center' valign='middle'>");
	out.print( "<input readonly Name = 'APIX' value= " + APIX  + ">");
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td align ='center' valign='middle'>");
	out.println("WSGX");
	out.println("</td>");
	out.println("<td align ='center' valign='middle'>");
	out.print(" <input readonly Name = 'WSGX' value= " + WSGX  + ">");
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td align ='center' valign='middle'>");
	out.println("WSGI");
	out.println("</td>");
	out.println("<td align ='center' valign='middle'>");
	out.print("<input readonly Name = 'WSGI' value= " + WSGI  + ">");
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td align ='center' valign='middle'>");
	out.println("Schema URL");
	out.println("</td>");
	out.println("<td align ='center' valign='middle'>");
	out.print( "<input readonly Name = 'Schema Url' value= " + SchemaUrl  + ">");
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td align ='center' valign='middle'>");
	out.println("Latest Release");
	out.println("</td>");
	out.println("<td align ='center' valign='middle'>");
	out.print( "<input readonly Name = 'Latest Release' value= " + LatestRelease  + ">");
	out.println("</td>");
	out.println("</tr>");
	out.println("</tbody>");
	out.println("</table>");	
		out.println("<input type='submit' value='Delete'  style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 30px;'>") ;
		out.println("</form>");
		out.println("<form action='Delete'>") ;
		out.println("<input type='submit' value='Back'  style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 30px;'>") ;
		out.println("</form>");
	out.println("</body>");
	out.println("</html>");
	/*out.println("<form action='DeleteDocument'>") ;
	out.println("Web API:<input readonly Name = 'WebAPI' value= " + webAPI  + ">");
	out.print("<br/>");
	out.println("JVM: <input readonly Name = 'JVM' value= " + JVMName  + ">");
	out.print("<br/>");
	out.println("App Name: <input readonly Name = 'AppName' value= " + AppName  + ">");
	out.print("<br/>");
	out.println("APIX: <input readonly Name = 'APIX' value= " + APIX  + ">");
	out.print("<br/>");
	out.println("WSGX: <input readonly Name = 'WSGX' value= " + WSGX  + ">");
	out.print("<br/>");
	out.println("WSGI: <input readonly Name = 'WSGI' value= " + WSGI  + ">");
	out.print("<br/>");
	out.println("Schema URL: <input readonly Name = 'Schema Url' value= " + SchemaUrl  + ">");
	out.print("<br/>");
	out.println("Latest Release: <input readonly Name = 'Latest Release' value= " + LatestRelease  + ">");
	out.print("<br/>");	
	out.println("<input type='submit' value='Delete'>") ;
	out.println("</form>");
	out.println("<form action='Delete'>") ;
	out.println("<input type='submit' value='Back'>") ;
	out.println("</form>");*/
		}
		catch(Exception e){
			out.println("No Document Found.");
			out.println("<form action='Delete'>") ;
			out.println("<input type='submit' value='Back'  style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 30px;'>") ;
			out.println("</form>");
		}
		mongoClient.close();
		
		
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

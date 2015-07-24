

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.*;

/**
 * Servlet implementation class FindDocument
 */
@WebServlet("/FindDocument")
public class FindDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindDocument() {
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
	out.println("<html>");
	out.println("<body>");
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
	out.println(webAPI);
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td align ='center' valign='middle'>");
	out.println("JVM Name");
	out.println("</td>");
	out.println("<td align ='center' valign='middle'>");
	out.print(JVMName);
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td align ='center' valign='middle'>");
	out.println("App Name");
	out.println("</td>");
	out.println("<td align ='center' valign='middle'>");
	out.print(AppName);
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td align ='center' valign='middle'>");
	out.println("APIX");
	out.println("</td>");
	out.println("<td align ='center' valign='middle'>");
	out.print(APIX);
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td align ='center' valign='middle'>");
	out.println("WSGX");
	out.println("</td>");
	out.println("<td align ='center' valign='middle'>");
	out.print(WSGX);
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td align ='center' valign='middle'>");
	out.println("WSGI");
	out.println("</td>");
	out.println("<td align ='center' valign='middle'>");
	out.print(WSGI);
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td align ='center' valign='middle'>");
	out.println("Schema URL");
	out.println("</td>");
	out.println("<td align ='center' valign='middle'>");
	out.print(SchemaUrl);
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td align ='center' valign='middle'>");
	out.println("Latest Release");
	out.println("</td>");
	out.println("<td align ='center' valign='middle'>");
	out.print(LatestRelease);
	out.println("</td>");
	out.println("</tr>");
	/*out.println("Web Application API: " + webAPI) ;
	out.print("<br/>");
	out.println("JVM Name: " + JVMName) ;
	out.print("<br/>");
	out.println("App Name: " + AppName);
	out.print("<br/>");
	out.println("APIX: " + APIX);
	out.print("<br/>");
	out.println("WSGX: " + WSGX);
	out.print("<br/>");
	out.println("WSGI: " + WSGI);
	out.print("<br/>");
	out.println("Schema URL: " + SchemaUrl);
	out.print("<br/>");
	out.println("Latest Release: " + LatestRelease);
	out.print("<br/>");	*/
	out.println("</tbody>");
	out.println("</table>");
	out.println("</body>");
	out.println("</html>");
		}
		catch(Exception e){
			out.println("No Document Found.");
		}
	
	out.println("<form action='Find'>") ;
	out.println("<input type='submit' value='Find another document' style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 30px;'>") ;
	out.println("</form>");
	out.println("<form action='MyFirst.html'>") ;
	out.println("<input type='submit' value='Home Page' style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 30px;'>") ;
	out.println("</form>");
	mongoClient.close();
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

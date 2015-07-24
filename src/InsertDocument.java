

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
 * Servlet implementation class InsertDocument
 */
@WebServlet("/InsertDocument")
public class InsertDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDocument() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		
		MongoClient mongoClient = new MongoClient();
		mongoClient = new MongoClient("localhost", 27017);
		
		DB db = mongoClient.getDB("Web");
		DBCollection dbCollection = db.getCollection("Info");
		
		
		String WebAPI = request.getParameter("WebAPI");
		String JVM = request.getParameter("JVM");
		String AppName = request.getParameter("AppName");
		String APIX = request.getParameter("APIX");
		String WSGX = request.getParameter("WSGX");
		String WSGI = request.getParameter("WSGI");
		String SchemaUrl = request.getParameter("SchemaUrl");
		String LatestRelease = request.getParameter("LatestRelease");
		try{
		BasicDBObject query = new BasicDBObject("Web API", WebAPI);
		DBCursor cursor = dbCollection.find(query);	
		BasicDBObject dbObject = (BasicDBObject)cursor.next();
		
		
		String JVMName = dbObject.getString("JVM");
		String appName = dbObject.getString("App Name");
		String apix = dbObject.getString("APIX");
		String wsgx = dbObject.getString("WSGX");
		String wsgi = dbObject.getString("WSGI");
		String schemaUrl = dbObject.getString("Schema Url");
		String latestRelease = dbObject.getString("Latest Release");
		out.println("The following document already exists!");
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
		out.println(WebAPI);
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
		out.print(appName);
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align ='center' valign='middle'>");
		out.println("APIX");
		out.println("</td>");
		out.println("<td align ='center' valign='middle'>");
		out.print(apix);
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align ='center' valign='middle'>");
		out.println("WSGX");
		out.println("</td>");
		out.println("<td align ='center' valign='middle'>");
		out.print(wsgx);
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align ='center' valign='middle'>");
		out.println("WSGI");
		out.println("</td>");
		out.println("<td align ='center' valign='middle'>");
		out.print(wsgi);
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
		out.print(latestRelease);
		out.println("</td>");
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		}
		catch(Exception e){
			BasicDBObject Web = new BasicDBObject();
			Web.put("Web API", WebAPI);
			Web.put("JVM", JVM);
			Web.put("App Name", AppName);
			Web.put("APIX", APIX);
			Web.put("WSGX", WSGX);
			Web.put("WSGI", WSGI);
			Web.put("Schema URL", SchemaUrl);
			Web.put("Latest Release", LatestRelease);
			dbCollection.insert(Web);				
			BasicDBObject query = new BasicDBObject("Web API", WebAPI);
	        DBCursor cursor = dbCollection.find(query);		       
	        BasicDBObject dbObject = (BasicDBObject)cursor.next();
	        String webAPI = dbObject.getString("Web API");
	        String JVMName = dbObject.getString("JVM");
	        String appName = dbObject.getString("App Name");
	        String apix = dbObject.getString("APIX");
	        String wsgx = dbObject.getString("WSGX");
			String wsgi = dbObject.getString("WSGI");
			String schemaUrl = dbObject.getString("Schema Url");
			String latestRelease = dbObject.getString("Latest Release");
			out.println("Document added.");
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
			out.println(WebAPI);
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
			out.print(appName);
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td align ='center' valign='middle'>");
			out.println("APIX");
			out.println("</td>");
			out.println("<td align ='center' valign='middle'>");
			out.print(apix);
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td align ='center' valign='middle'>");
			out.println("WSGX");
			out.println("</td>");
			out.println("<td align ='center' valign='middle'>");
			out.print(wsgx);
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td align ='center' valign='middle'>");
			out.println("WSGI");
			out.println("</td>");
			out.println("<td align ='center' valign='middle'>");
			out.print(wsgi);
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
			out.print(latestRelease);
			out.println("</td>");
			out.println("</tr>");
			out.println("</tbody>");
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		}
		out.println("<form action='Insert'>") ;
		out.println("<input type='submit' value='Insert another document'  style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 30px;'>") ;
		out.println("</form>");
		out.println("<form action='MyFirst.html'>") ;
		out.println("<input type='submit' value='Home Page'  style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 30px;'>") ;
		out.println("</form>");
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

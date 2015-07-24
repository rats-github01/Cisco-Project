

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
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.util.*;


/**
 * Servlet implementation class UpdateDocument
 */
@WebServlet("/UpdateDocument")
public class UpdateDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDocument() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		MongoClient mongoClient = new MongoClient();
		mongoClient = new MongoClient("localhost", 27017);
		
		DB db = mongoClient.getDB("Web");
		DBCollection dbCollection = db.getCollection("Info");
		PrintWriter out = response.getWriter();
		try{
			String WebAPI = request.getParameter("WebAPI");
			String JVM = request.getParameter("JVM");
			String AppName = request.getParameter("AppName");
			String APIX = request.getParameter("APIX");
			String WSGX = request.getParameter("WSGX");
	    	String WSGI = request.getParameter("WSGI");
	    	String SchemaUrl = request.getParameter("Schema URL");
	    	String LatestRelease = request.getParameter("Latest Release");
	    	BasicDBObject query = new BasicDBObject();
	    	query.put("Web API", WebAPI);

	    	BasicDBObject newDocument = new BasicDBObject();
	    	newDocument.put("JVM", JVM);
	    	newDocument.put("App Name", AppName);
			newDocument.put("APIX", APIX);
			//Comment
			newDocument.put("WSGX", WSGX);
			newDocument.put("WSGI", WSGI);
			newDocument.put("Schema URL", SchemaUrl);
			newDocument.put("Latest Release", LatestRelease);

	    	BasicDBObject updateObj = new BasicDBObject();
	    	updateObj.put("$set", newDocument);

	    	dbCollection.update(query, updateObj);
			/*BasicDBObject query = new BasicDBObject();
			query.put("Web API", WebAPI);
			

			BasicDBObject newDocument = new BasicDBObject();
			String change = "JVM";
			String update = JVM;
			newDocument.put(change, update);
			newDocument.put("App Name", AppName);
			newDocument.put("APIX", APIX);
			newDocument.put("WSGX", WSGX);
			newDocument.put("WSGI", WSGI);
			newDocument.put("Schema URL", SchemaUrl);
			newDocument.put("Latest Release", LatestRelease);
			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);

			dbCollection.update(query, updateObj);*/
			out.println("The following document has been updated!");
			out.print("<br/>");
			out.println("<html>");
			out.println("<body>");
			out.println("<table border='1' cellpadding= '2' style='background-color: #20B2AA; color:#E6E6FA; border: 3px solid #191970'>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th>");
			out.println("Component");
			out.println("</th>");
			out.println("<th>");
			out.println("Component Name");
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
			out.print(JVM);
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
			out.println("</table>");
			/*out.println("Web Application API: " + WebAPI) ;
			out.print("<br/>");
			out.println("JVM Name: " + JVM) ;
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
			
			
		}
		catch(Exception e){
			out.println("Unable to find document.");
			
		}

		out.println("<form action='Update'>") ;
		out.println("<input type='submit' value='Update another document'style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 30px;'>") ;
		out.println("</form>");
		out.println("<form action='MyFirst.html'>") ;
		out.println("<input type='submit' value='Home Page' style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 30px;'>") ;
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

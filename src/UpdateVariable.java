

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
import com.mongodb.MongoClient;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.net.UnknownHostException;
import java.util.*;

import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class UpdateVariable
 */
@WebServlet("/UpdateVariable")
public class UpdateVariable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVariable() {
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
		String WebAPI = request.getParameter("WebAPI");
		try{
		BasicDBObject Query = new BasicDBObject("Web API", WebAPI);
        DBCursor Cursor = dbCollection.find(Query);
        BasicDBObject dbObject = (BasicDBObject)Cursor.next();
        String webAPI = dbObject.getString("Web API");
        String JVMName = dbObject.getString("JVM");
        String appName = dbObject.getString("App Name");
        String APX = dbObject.getString("APIX");
        String WSGX = dbObject.getString("WSGX");
    	String WSGI = dbObject.getString("WSGI");
    	String SchemaUrl = dbObject.getString("Schema URL");
    	String LatestRelease = dbObject.getString("Latest Release");
    	
        
        out.println("<html>");   
        out.println("<body>");        
        out.println("<form action='UpdateDocument'>") ;
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
    	out.print("<input type = 'text' Name = 'JVM' value= " + JVMName + ">");
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td align ='center' valign='middle'>");
    	out.println("App Name");
    	out.println("</td>");
    	out.println("<td align ='center' valign='middle'>");
    	out.print("<input type = 'text' Name = 'AppName' value= " + appName + ">");
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td align ='center' valign='middle'>");
    	out.println("APIX");
    	out.println("</td>");
    	out.println("<td align ='center' valign='middle'>");
    	if(APX.equals("true")){
    	out.print("<input type='radio'  Name = 'APIX' value='true' checked = 'checked'>True<br>");
    	out.println("<input type='radio'  Name = 'APIX' value='false'>False<br>");
    	}
    	else{
    		out.println("<input type='radio'  Name = 'APIX' value='true' >True<br>");
			out.println("<input type='radio'  Name = 'APIX' value='false' checked = 'checked'>False<br>");
    	}
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td align ='center' valign='middle'>");
    	out.println("WSGX");
    	out.println("</td>");
    	out.println("<td align ='center' valign='middle'>");
    	if(WSGX.equals("true")){
    	out.print("<input type='radio'  Name = 'WSGX' value='true' checked = 'checked'>True<br>");
		out.println("<input type='radio'  Name = 'WSGX' value='false'>False<br>");
    	}
    	else{
			out.println("<input type='radio'  Name = 'WSGX' value='true'>True<br>");
			out.println("<input type='radio'  Name = 'WSGX' value='false' checked = 'checked'>False<br>");	
    	}    	
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td align ='center' valign='middle'>");
    	out.println("WSGI");
    	out.println("</td>");
    	out.println("<td align ='center' valign='middle'>");
    	if(WSGI.equals("true")){
			out.println("<input type='radio'  Name = 'WSGI' value='true'  checked = 'checked'>True<br>");
			out.println("<input type='radio'  Name = 'WSGI' value='false'>False<br>");
    	}
    	else{
    		out.println("<input type='radio'  Name = 'WSGI' value='true'>True<br>");
			out.println("<input type='radio'  Name = 'WSGI' value='false' checked = 'checked'>False<br>");
    	}	
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td align ='center' valign='middle'>");
    	out.println("Schema URL");
    	out.println("</td>");
    	out.println("<td align ='center' valign='middle'>");
    	out.print("<input type = 'text' Name = 'Schema URL' value= " + SchemaUrl + ">");
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td align ='center' valign='middle'>");
    	out.println("Latest Release");
    	out.println("</td>");
    	out.println("<td align ='center' valign='middle'>");
    	out.print("<input type = 'text' Name = 'Latest Release' value= " + LatestRelease + ">");
    	out.println("</td>");
    	out.println("</tr>");
       /* out.println("Web API:<input readonly Name = 'WebAPI' value= " + webAPI  + ">");
		out.print("<br />");
		out.println("JVM: <input type = 'text' Name = 'JVM' value= " + JVMName + ">");
		out.print("<br />");
		out.println("App Name: <input type = 'text' Name = 'AppName' value= " + appName + ">");
		out.print("<br />");
		if(APX.equals("true")){
		out.println("<fieldset>");
		out.println("<legend Name = 'APIX'> APIX </legend>");
		out.println("<input type='radio'  Name = 'APIX' value='true' checked = 'checked'>True<br>");
		out.println("<input type='radio'  Name = 'APIX' value='false'>False<br>");
		out.print("<br/>");
		out.println("</fieldset>");
		}
		else{
			out.println("<fieldset>");
			out.println("<legend Name = 'APIX'> APIX </legend>");
			out.println("<input type='radio'  Name = 'APIX' value='true' checked = 'checked'>True<br>");
			out.println("<input type='radio'  Name = 'APIX' value='false' checked = 'checked'>False<br>");
			out.print("<br/>");
			out.println("</fieldset>");
		}
		//COMMENT START
		if(WSGX.equals("true")){
			out.println("<fieldset>");
			out.println("<legend Name = 'WSGX'> WSGX </legend>");
			out.println("<input type='radio'  Name = 'WSGX' value='true' checked = 'checked'>True<br>");
			out.println("<input type='radio'  Name = 'WSGX' value='false'>False<br>");
			out.print("<br/>");
			out.println("</fieldset>");
			}
			else{
				out.println("<fieldset>");
				out.println("<legend Name = 'WSGX'> WSGX </legend>");
				out.println("<input type='radio'  Name = 'WSGX' value='false' checked = 'checked'>False<br>");
				out.println("<input type='radio'  Name = 'WSGX' value='true' checked = 'checked'>True<br>");
				out.print("<br/>");
				out.println("</fieldset>");
			}
		if(WSGI.equals("true")){
			out.println("<fieldset>");
			out.println("<legend Name = 'WSGI'> WSGI </legend>");
			out.println("<input type='radio'  Name = 'WSGI' value='false'>False<br>");
			out.println("<input type='radio'  Name = 'WSGI' value='true' checked = 'checked'>True<br>");
			out.print("<br/>");
			out.println("</fieldset>");
			}
			else{
				out.println("<fieldset>");
				out.println("<legend Name = 'WSGI'> WSGI </legend>");
				out.println("<input type='radio'  Name = 'WSGI' value='true' checked = 'checked'>True<br>");
				out.println("<input type='radio'  Name = 'WSGI' value='false' checked = 'checked'>False<br>");
				out.print("<br/>");
				out.println("</fieldset>");
			}
		out.println("Schema URL: <input type = 'text' Name = 'Schema URL' value= " + SchemaUrl + ">");
		out.print("<br />");
		out.println("Latest Release: <input type = 'text' Name = 'Latest Release' value= " + LatestRelease + ">");
		out.print("<br />");*/
    	out.println("</table>");
		out.println("<input type='submit' value='Update' style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin-top: 30px; margin: 10px; display: inline'>") ;
		out.println("</form>");
		out.println("<form action='Update'>") ;
		out.println("<input type='submit' value='Back' style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 10px; display: inline'>") ;
		out.println("</form>");
		out.println("<form action='MyFirst.html'>") ;
		out.println("<input type='submit' value='Home Page' style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 10px; display: inline'>") ;
		out.println("</form>");
		out.println("</html>");
		}
		catch(Exception e){
			out.println("No Document found with the Web API of " + WebAPI);
			out.println("<form action='Update'>") ;
			out.println("<input type='submit' value='Back' style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 10px; display: inline'>") ;
			out.println("</form>");
			out.println("<form action='MyFirst.html'>") ;
			out.println("<input type='submit' value='Home Page' style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 10px; display: inline'>") ;
			out.println("</form>");
		}
		mongoClient.close();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

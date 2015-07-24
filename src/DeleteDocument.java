

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

/**
 * Servlet implementation class DeleteDocument
 */
@WebServlet("/DeleteDocument")
public class DeleteDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDocument() {
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
		
		MongoClient mongoClient = new MongoClient();
		mongoClient = new MongoClient("localhost", 27017);
		
		DB db = mongoClient.getDB("Web");
		DBCollection dbCollection = db.getCollection("Info");
		
	
		try{
		BasicDBObject query = new BasicDBObject("Web API", WebAPI);

		DBCursor cursor = dbCollection.find(query);
		BasicDBObject dbObject = (BasicDBObject)cursor.next();
		dbCollection.remove(dbObject);
		out.println("Document deleted!");
		}
		catch(Exception e){
			out.println("Unable to Delete Document.");
		}
		out.println("<form action='Delete'>") ;
		out.println("<input type='submit' value='Delete another document'  style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 30px;'>") ;
		out.println("</form>");
		out.println("<form action='MyFirst.html'>") ;
		out.println("<input type='submit' value='Home Page'  style='background-color: #1E90FF; color: #ADD8E6; width: 250px; height: 60px; font-size: 20px; margin: 30px;'>") ;
		out.println("</form>");
		mongoClient.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

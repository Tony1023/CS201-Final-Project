package scheduler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SchedulerServlet
 */
@WebServlet("/SchedulerServlet")
public class SchedulerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchedulerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String targetID = request.getParameter("targetID");
		String userAvailability = "";
		String targetAvailability = "";
		
		Connection conn = null;
    	Statement st = null;
    	ResultSet rs = null;
    	String sqlString = "SELECT availability_string from User WHERE user_id=" + userID;
    	try {		
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		conn = DriverManager.getConnection("jdbc:mysql://localhost/cs201_final_project_db?user=root&password=password&useSSL=false");
    		st = conn.createStatement();
    		rs = st.executeQuery(sqlString);
    		
    		while(rs.next()) {
    			userAvailability = rs.getString("availability_string");
    		}
    		
    		sqlString = "SELECT availability_string from User WHERE user_id=" + targetID;
    		st = conn.createStatement();
    		rs = st.executeQuery(sqlString);
    		
    		while(rs.next()) {
    			targetAvailability = rs.getString("availability_string");
    		}
    		
    		System.out.println("User availabilty: " + userAvailability);
    		System.out.println("Target availabilty: " + targetAvailability);
    		
    	} catch(ClassNotFoundException cnfe) {
    		System.out.println("cnfe: " + cnfe.getMessage());
    	} catch (SQLException sqle) {
    		System.out.println("sqle: " + sqle.getMessage());
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(st != null) {
					st.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
		}
	}

}

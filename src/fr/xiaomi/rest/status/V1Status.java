package fr.xiaomi.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.sql.*;

import fr.xiaomi.dao.MySQLXiaomi;

@Path("/v1/status")
public class V1Status {

	private static final String API_VERSION = "0.0.1";
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Java Web Service</p>";
	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion(){
		return "<p> Version : <b>" + API_VERSION + "</b></p>";
	}
	
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception{
		PreparedStatement query = null;
		String myString = "";
		String returnString = "";
		Connection conn = null;
		
		try{
			conn = MySQLXiaomi.MySQLXiaomiConn().getConnection();
			query = conn.prepareStatement("Select * from testdata;");
			ResultSet rs = query.executeQuery();
			
			while(rs.next()){
				myString = rs.getInt("id") + " : " + rs.getString("name");
				returnString += "<p> user id :<b>" + myString + "</b></p>\n";
			}
			query.close();
			
			
			
			
		}catch(Exception e){
			
		}finally{
			if(conn != null){
				conn.close();
			}
		}
		
		return returnString;
	}

}

package fr.xiaomi.rest.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import fr.xiaomi.dao.MySQLXiaomi;
import fr.xiaomi.util.ToJson;


@Path("/v1/inventory")
public class V1Inventory {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnAllUsers() throws Exception{
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		
		try{
			conn = MySQLXiaomi.MySQLXiaomiConn().getConnection();
			query = conn.prepareStatement("SELECT * FROM testdata");
			
			ResultSet rs = query.executeQuery();
			
			ToJson converter = new ToJson();
			JSONArray json = new JSONArray();
			json = converter.toJSONArray(rs);
			query.close();
			
			returnString = json.toString();
			
			
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				conn.close();
			}
		}
		return returnString;
		
		
	}
	
}

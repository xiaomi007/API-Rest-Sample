package fr.xiaomi.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MySQLXiaomi {

	private static DataSource mySQLXiaomi = null;
	private static Context context = null, initContext = null;
	
	public static DataSource MySQLXiaomiConn() throws Exception{
		
		if(mySQLXiaomi != null){
			return mySQLXiaomi;
		}
		
		
		try{
			if(context == null){
				context = new InitialContext();
				initContext = (Context) context.lookup("java:/comp/env");
				
			}
			mySQLXiaomi = (DataSource) initContext.lookup("jdbc/javatest");
			
		} catch(Exception e){
			e.printStackTrace();
		}
		return mySQLXiaomi;	
		
	}
	
}

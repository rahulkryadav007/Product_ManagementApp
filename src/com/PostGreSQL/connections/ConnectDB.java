/**
 * 
 */
package com.PostGreSQL.connections;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
/**
 * @author Jai Shree Krishna
 *
 */
public class ConnectDB {
	
	static Connection connection = null;
	 public Connection EstablishConnection(String databaseName,String userName, String password) {
        try {
        	Class.forName("org.postgresql.Driver");//sending to  driver  
        	connection =DriverManager.getConnection("jdbc:postgresql://localhost/"+databaseName,userName,password);
            if(connection != null) {
            	System.out.println("[Connection To PostreSQL Established Succesfully]");
            }else {
            	 System.out.println("[Connection To PostGreSQL Not Established]");
            }
        }catch(Exception e) {
        	System.out.println(e);
        }//End of Try catch Block
        return connection;
       }// end of established connection
	   }// end of class


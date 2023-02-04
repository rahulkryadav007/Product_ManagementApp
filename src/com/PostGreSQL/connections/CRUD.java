/**
 * 
 */
package com.PostGreSQL.connections;

import java.sql.Connection;

import java.sql.PreparedStatement;

import com.PostGreSQL.products.Products;
import java.sql.ResultSet;

/**
 * @author Jai Shree Krishna
 *
 */
public class CRUD {
	private static boolean i;
	public static boolean Create_Operation(Products p) {
		Connection connection = null;
		boolean taskDone = false;
		try {
			ConnectDB CDB = new ConnectDB();
			connection =CDB.EstablishConnection("Product_Management", "postgres","rahulcse");
			String Query = "insert into products(pname,pcheck,pmnf) values (?,?,?);";
			PreparedStatement prepared = connection.prepareStatement(Query);
			prepared.setString(1,p.getProductName());
			prepared.setString(2,p.getProductCheck());
			prepared.setString(3,p.getMadeIn());
			prepared.executeUpdate();
			taskDone = true;
			
			}catch(Exception e) {
				System.out.println(e);
			}
		return taskDone;
	}
	
	public static void Read_Opearation() {
		Connection connection = null;
		try {
			ConnectDB CDB = new ConnectDB();
			connection =CDB.EstablishConnection("Product_Management", "postgres","rahulcse");
			String Query = "SELECT * FROM products;";
			PreparedStatement prepared = connection.prepareStatement(Query);
			ResultSet result = prepared.executeQuery();
			while(result.next()) {
				int pid = result.getInt(1);
				String pname = result.getString(2);
				String pcheck = result.getString(3);
				String pmnf = result.getString(4);
				System.out.println("_ _ __ _ _ _ _ _ ___ _ _ _ _ _ _ _ _ _ _");
				System.out.println("[Product ID: "+pid+"] [Product Name : "+pname+"] [ Product Quality Status: "+pcheck+"] [Product Made In:"+pmnf+"]");
				
			}
				 
			
		}catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public static boolean Update_Operation_pname(int pid, String pname) {
		Connection connection = null;
		boolean taskDone = false;
		try {
			ConnectDB CDB = new ConnectDB();
			connection = CDB.EstablishConnection("Product_Management", "postgres","rahulcse");
			String verifyQuery = "SELECT * FROM products where pid = "+pid+";";
			String Query  = "UPDATE products set pname = ? where pid = "+pid+";";
			PreparedStatement prepared = connection.prepareStatement(verifyQuery);
			ResultSet verify = prepared.executeQuery();
			boolean ifExists = verify.next();
			if(ifExists) {
				PreparedStatement pst = connection.prepareStatement(Query);
				pst.setString(1, pname);
                pst.executeUpdate();
                System.out.println("Product Name Succesfully changed..");
                taskDone = true;
			}else {
	             System.out.println("There is no product exists with id "+pid);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return taskDone;
	}
	public static boolean Update_Operation_pcheck(int pid, String pcheck) { 
		Connection connection = null;
		boolean taskDone = false;
		try {
			ConnectDB CDB = new ConnectDB();
			connection = CDB.EstablishConnection("Product_Management", "postgres","rahulcse");
			String verifyQuery = "SELECT * FROM products where pid = "+pid+";";
			String Query  = "UPDATE products set pcheck = ? where pid = "+pid+";";
			PreparedStatement prepared = connection.prepareStatement(verifyQuery);
			ResultSet verify = prepared.executeQuery();
			boolean ifExists = verify.next();
			if(ifExists) {
				PreparedStatement pst = connection.prepareStatement(Query);
				pst.setString(1, pcheck);
                pst.executeUpdate();
                System.out.println("Product Quality Succesfully changed..");
                taskDone = true;
			}else {
	             System.out.println("There is no product exists with id "+pid);
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return taskDone;
	}		
		public static boolean Update_Operation_pmnf(int pid, String pmnf) {
			Connection connection = null;
			boolean taskDone = false;
			try {
				ConnectDB CDB = new ConnectDB();
				connection = CDB.EstablishConnection("Product_Management", "postgres","rahulcse");
				String verifyQuery = "SELECT * FROM products where pid = "+pid+";";
				String Query  = "UPDATE products set pmnf = ? where pid = "+pid+";";
				PreparedStatement prepared = connection.prepareStatement(verifyQuery);
				ResultSet verify = prepared.executeQuery();
				boolean ifExists = verify.next();
				if(ifExists) {
					PreparedStatement pst = connection.prepareStatement(Query);
					pst.setString(1, pmnf);
	                pst.executeUpdate();
	                System.out.println("Product Manufacture Place  Succesfully changed..");
	                taskDone = true;
				}else {
		             System.out.println("There is no product exists with id "+pid);
				}
				
			}catch (Exception e) {
				System.out.println(e);
				
			}
			return taskDone;

		}
		public static boolean Delete_Operation(int pid) {
			Connection connection = null;
			boolean taskDone = false;
			try {
	             ConnectDB CDB = new ConnectDB();		 
			    connection = CDB.EstablishConnection("Product_Management","postgres","rahulcse");
	            String query="DELETE FROM products WHERE pid = "+pid+";";
	            String verifyQuery = "SELECT * FROM products where pid="+pid+";";
	            PreparedStatement verifycheck = connection.prepareStatement(verifyQuery);
	            PreparedStatement prepared = connection.prepareStatement(query);
	            ResultSet result = verifycheck.executeQuery();
	            boolean ifExists = result.next();
	            if(ifExists) {
	            	prepared.executeUpdate();
	            	System.out.println("Products Details Deleted Succesfully..");
	            	taskDone = true;
	            }else {
	            	System.out.println("There is NO Product exists with id "+pid);
	            }
	            
			}catch(Exception e) {
				System.out.println(e);
			}
			return taskDone;
		}
}

/**
 * 
 */
package com.PostGreSQL.operations;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.PostGreSQL.connections.ConnectDB;
import com.PostGreSQL.products.Products;
import com.PostGreSQL.connections.CRUD;
/**
 * @author Jai Shree Krishna
 *
 */
public class ProductApp {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		ConnectDB CDB = new ConnectDB();
		CDB.EstablishConnection("Product_Management", "postgres","rahulcse");
		while(true) {
			System.out.println("--------------------------------------------");
			System.out.println("(1) Register Product.");
			System.out.println("(2) Display  Product Details.");
			System.out.println("(3) Update Product Details.");
			System.out.println("(4) Delete  Product Details.");
			System.out.println("(5) Exit Product Application.");
			System.out.println("Enter Your Choice:");
			try {
			int choice = Integer.parseInt(br.readLine());
			switch(choice) {
			case 1:
				System.out.println("Register Product Portal.");
				System.out.println("Enter the Product Name : ");
				String pid  = br.readLine();
				System.out.println("Enter Product Quality : ");
				String pcheck = br.readLine();
				System.out.println("Enter Product Manufacture Place : ");
				String pmnf = br.readLine();
				if(pid=="" || pcheck=="" ||pmnf=="") {
					System.out.println("Empty Details Not Allowed");
				}
				else{ 
					Products p = new Products(pid, pcheck , pmnf);
					boolean done = CRUD.Create_Operation(p);
					if(done) {
						System.out.println("Inserted");
					}else {
						System.out.println("Not Inserted");
					}
				}
				break;
			case 2:
				System.out.println("Display  Product Details Portal.");
				CRUD.Read_Opearation();
				break;
			case 3:	
				System.out.println("Update Product Details Portal.");
				System.out.println("------------------------------");
				System.out.println("1.Update Product Name.");
				System.out.println("2.Update Product Quality Status.");
				System.out.println("3.Update Product Manufacturing Place.");
				int updateChoice = Integer.parseInt(br.readLine());
				switch(updateChoice) {
				case 1:
					System.out.print("Please Enter The Product ID: ");
					int pid1 = Integer.parseInt(br.readLine());
					System.out.println("Enter The New Name For The Product :");
					String pname1 = br.readLine();
					CRUD.Update_Operation_pname(pid1, pname1);
					break;
				case 2:	
					System.out.print("Please Enter The Product ID: ");
					int pid2 = Integer.parseInt(br.readLine());
					System.out.println("Enter The New  Quality Status For The Product: ");
					String pquality = br.readLine();
					CRUD.Update_Operation_pcheck(pid2, pquality    );
					break;
				case 3:
					System.out.print("Please Enter The Product ID: ");
					int pid3 = Integer.parseInt(br.readLine());
					System.out.println("Enter The New Manufacturing Place For The Product :");
					String pmnf1 = br.readLine();
					CRUD.Update_Operation_pmnf(pid3, pmnf1);
					break;
					default : System.out.println("[Please Choose the option 1,2,3 only.]");
				}
				break;
			case 4:  
				System.out.println("Delete Product Details Portal.");
				System.out.println("Enter the id of the product to delete : ");
				int pid4 = Integer.parseInt(br.readLine());
				CRUD.Delete_Operation(pid4);
				break;
			case 5:
				System.out.println("Thank You! Made in INDIA.");
				System.exit(0);
			default :
				System.out.println("Please Enter the choice between from 1 to 5.");
			  }//End of the switch case
			}catch(NumberFormatException nfc) {
				System.out.println("Empty Input Not Allowed.");
			}//End of Try Catch block
		}//end of the while loop
		}//end of main
	    }

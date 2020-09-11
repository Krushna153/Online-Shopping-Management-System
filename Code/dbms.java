package dbms_project;

import java.util.Scanner;

import com.mysql.jdbc.ResultSetMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class dbms 
{
	public static int i = 1;
	public static int j;
	public static void main(String[] args) 
	{
		
		
		boolean e1=false;
		while(e1==false)
        {
            
            Scanner input = new Scanner(System.in);
            System.out.println("Enter customer type :");
            System.out.print("\n1. Customer");
            System.out.print("\n2. Admin");
            System.out.print("\n0. Exit \n");
            int ctype = input.nextInt();
            
            switch(ctype)
            {
            case 1:
            	boolean e2=false;
            	while(e2==false)
                {
            	
            	System.out.println("\n\nEnter your choice");
            	System.out.print("\n1. Insert into order detail");
            	System.out.print("\n2. Generate Bill");
            	System.out.print("\n3. Display bill detail of a customer");
            	System.out.print("\n4. Make Payment");
            	System.out.print("\n0. Exit \n");
            	int ch = input.nextInt();
            	
            	
            	switch(ch)
            	{
            	case 1:
            		
            		System.out.println("Enter order id :");
                	int oid = input.nextInt();
                	System.out.println("Enter product id :");
                	int pid = input.nextInt();
                	System.out.println("Enter product quantity :");
                	int pqty = input.nextInt();
                	try 
                	{
            			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
            			System.out.println("Connection Successfull!!");
            			
            			String query = "call insert_order_detail(" + oid + "," + pid + "," + pqty +")";
                        String query1 = "select * from order_detail where order_id = " + oid ;
                        
                        Statement stmt = conn.createStatement();
                        Statement stmt1 = conn.createStatement();
            			
            			ResultSet rs = stmt.executeQuery(query);
            			ResultSet rs1 = stmt1.executeQuery(query1);

            			/*while(rs.next()) 
            			{
                            System.out.println("");
                            
            				System.out.println("\t order id \t product id \t product quantity \t product price \t product total price");
                            System.out.println("\t\t"+rs.getString(1)+ "\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5));
                                          // System.out.println(rs.getString(1)+ "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7) + "\t" + rs.getString(8)+ "\t" + rs.getString(9) +"\t" + rs.getString(10) +"\t" + rs.getString(11) + "\t" + rs.getString(12) +"\t" + rs.getString(13) +"\t" + rs.getString(14) + "\t" + rs.getString(15));
            			}*/
            			System.out.println("\n\t \t\t\t \t Order Details :\n\n");
            			System.out.println("\n Order id \t Product id \t Product quantity \t Product price \t Product total price\n\n");
            			while(rs1.next()) 
            			{
                            //System.out.println("");
                            System.out.println("  " + rs1.getString(1)+ "\t\t  " + rs1.getString(2) + "\t\t  " + rs1.getString(3) + "\t\t\t" + rs1.getString(4) + "\t\t\t" + rs1.getString(5));
                                          // System.out.println(rs.getString(1)+ "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7) + "\t" + rs.getString(8)+ "\t" + rs.getString(9) +"\t" + rs.getString(10) +"\t" + rs.getString(11) + "\t" + rs.getString(12) +"\t" + rs.getString(13) +"\t" + rs.getString(14) + "\t" + rs.getString(15));
            			}
            		}
            		catch(Exception e)
                	{
            			System.out.println(e);
            		}
            		
            		break;
            		
            	case 2:
            		//System.out.println("i = " + i);
            		System.out.println("Enter your order id: ");
            		int o_id = input.nextInt();
            		
            		try 
                	{
            			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
            			System.out.println("Connection Successfull!!");

                        //System.out.println(i);
            			String query = "call generate_bill(" + o_id + "," + i + ")";
            			i = i + 1;
                        //System.out.println(i);
            			Statement stmt = conn.createStatement();
            			
            			ResultSet rs3 = stmt.executeQuery(query);
            			
            			System.out.println("\n\t\tBill id \tBill Date \t  Customer id \t   Order id \t   Customer name \t Product id \t Product quantity \tProduct price \tProduct total price \tOrder total price \tOffer discount \t  Bill total price \t\tPayment status\n");
    					
            			while(rs3!=null) 
            			{    	        			
    	        			while(rs3.next()) 
    	        			{
    	        					System.out.print("\t\t"+rs3.getString(1)+ "\t\t" + rs3.getString(2) + "\t\t" + rs3.getString(3) + "\t\t" + rs3.getString(4) + "\t\t" + rs3.getString(5) + "\t\t\t" + rs3.getString(6) + "\t\t" + rs3.getString(7) + "\t\t" + rs3.getString(8) + "\t\t\t" + rs3.getString(9) + "\t\t\t" + rs3.getString(10) + "\t\t" + rs3.getString(11) + "\t\t\t" + rs3.getString(12) + "\t\t\t" + rs3.getString(13));
    	        					System.out.println("");
      	        			}
    	        	}	
            			
            		}
            		catch(Exception e)
                	{
            			System.out.println(e);
            		}
            		
            		break;
            		
            	case 3:				//cust_wise_bill_detail
            		
            		System.out.println("Enter your customer id: ");
            		int cid = input.nextInt();
            		
            		try 
                	{
            			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
            			System.out.println("Connection Successfull!!");
            			
            			String query = "call cust_wise_bill_detail(" + cid + ")";
                        
            			Statement stmt = conn.createStatement();
            			
            			ResultSet rs3 = stmt.executeQuery(query);

            			while(rs3!=null) 
            			{    	        			
    	        			while(rs3.next()) 
    	        			{
    	        				java.sql.ResultSetMetaData rsmd = rs3.getMetaData();
    	        				if(rsmd.getColumnCount()==3)
    	        				{
    	        					System.out.println("\t offer discount   max_order_total_price   bill_total_price");

    	        					System.out.print("\t\t"+rs3.getString(1)+ "\t\t" + rs3.getString(2) + "\t\t\t" + rs3.getString(3));
    	        				}
    	        				else if(rsmd.getColumnCount()==5)
    	        				{
    	        					System.out.println("\n");
    	        					System.out.println("\t product_id   product_quantity \t  prod_price \t prod_total_price  order_total_price\n");
    	        				
    	        					System.out.print("\t\t"+rs3.getString(1)+ "\t\t" + rs3.getString(2) + "\t\t" + rs3.getString(3) + "\t\t"+ rs3.getString(4) + "\t\t"+ rs3.getString(5) + "\n \n");
    	        				}
    	        				else
    	        				{
    	        					System.out.println("\t\tcustomer id \tcustomer name \t\torder id");
    	        					System.out.print("\t\t"+rs3.getString(1)+ "\t\t" + rs3.getString(2) + "\t\t\t" + rs3.getString(3) + "\t\t"+ rs3.getString(4) + "\n\n\n");
        	        				
    	        				}
    	        			}
    	        			if(stmt.getMoreResults()) 
    	        			{
    	        				rs3 = stmt.getResultSet();
    	        			}
    	        			else
    	        			{
    	        				rs3.close();
    	        				rs3 = null;
    	        			}
            			}	
            			
            		}
            		catch(Exception e)
                	{
            			System.out.println(e);
            		}
            		
            		
            		break;
            		
            	case 4:			//Payment
            		
            		System.out.println("Enter bill id : ");
            		int bid = input.nextInt();
            		System.out.println("Enter payment mode : ");
            		String pmode = input.next();
            		
            		try 
                	{
            			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
            			System.out.println("Connection Successfull!!");
            			
            			String query = "call payment(" + bid + ",'" + pmode + "')";
            			String query1 = "select distinctrow * from payment";
                        
            			Statement stmt = conn.createStatement();
            			Statement stmt1 = conn.createStatement();
            			
            			ResultSet rs3 = stmt.executeQuery(query);
            			ResultSet rs4 = stmt1.executeQuery(query1);
            			System.out.println("\t Discount and note ");
            			while(rs3 != null)
            			{
            				
            			while(rs3.next()) 
	        			{
            				
	        				System.out.println("\t\t"+rs3.getString(1) + '\n');
	        				//System.out.print("\n");
	        			//	System.out.print("\t\t"+rs3.getString(2) + '\n');
	     	        				
	        			}
            			if(stmt.getMoreResults()) 
	        			{
	        				rs3 = stmt.getResultSet();
	        			}
	        			else
	        			{
	        				rs3.close();
	        				rs3 = null;
	        			}
            			} 
            			System.out.println("\t\tbill_id \tpayment mode  \t\t payment date \t\tpayment_disc\t pay_amount    bill id  \torder id");
    	        		while(rs4.next()) 
    	        		{
    	        			
    	        			System.out.print("\t\t"+rs4.getString(1)+ "\t\t" + rs4.getString(2) + "\t\t" + rs4.getString(3) + "\t\t"+ rs4.getString(4) + "\t\t"+ rs4.getString(5) + "\t\t"+ rs4.getString(6) + "\t\t"+ rs4.getString(7) + '\n');
    	     	        				
    	        		}
    	        	            			
            		}
            		catch(Exception e)
                	{
            			System.out.println(e);
            		}
            		
            		break;
            		
            	case 0:
            		e2=true;
            		break;
            		
            	default :
            		System.out.println("Invalid choice...");
            	}
                }
            	
            	break;
                
            	
            case 2:
            	boolean e3=false;
            	while(e3==false)
                {
            	System.out.println("\n\nEnter your choice");
            	System.out.print("\n1. Year wise order detail");
            	System.out.print("\n2. Day wise count order");
            	System.out.print("\n3. Display highest payment mode used by customer");
            	System.out.print("\n4. Display highest selling product in a given range");
            	System.out.print("\n5. Display highest product return");
            	System.out.print("\n6. Display all order details");
            	System.out.print("\n7. Display top3 customers who orders frequently");
            	System.out.print("\n8. Display top3 customers who spends Rs the most for purchasing");
            	System.out.print("\n0. Exit \n");
            	int choice = input.nextInt();
            	
            	switch(choice)
            	{
            	case 1:

                	System.out.println("Enter year to see order detail : ");
                	int year = input.nextInt();
                	           	
        			        			
        			try
                	{
            			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
            			System.out.println("Connection Successfull!!");
            			String query3 = "call year_wise_order_detail('" + year + "')";
            			//String query5 = "cust_wise_bill_detail(" + cid + ")";
            			Statement stmt = conn.createStatement();
            			ResultSet rs3 = stmt.executeQuery(query3);
            			//ResultSet rs4 = stmt.executeQuery(query3);
            			System.out.println("\n\nYear wise order detail");
            			//System.out.print("\t\torder id \t\torder date \t\tcust id \tcustomer address\tproduct id \tproduct quantity  product price  product total price  total amount");
        				
            			while(rs3!=null) 
            			{    	        			
    	        			while(rs3.next()) 
    	        			{
    	        				java.sql.ResultSetMetaData rsmd = rs3.getMetaData();
    	        				if(rsmd.getColumnCount()==1)
    	        					System.out.print("Year: " + rs3.getString(1) + '\n');
    	        				else
    	        				{
    	        					System.out.print("\t\torder id \torder date \t\tcust id \tcustomer address\tproduct id \tproduct quantity  product price  product total price  total amount\n");
    	            				
    	        					System.out.println("\t\t"+rs3.getInt(1)+ "\t\t" + rs3.getDate(2) + "\t\t" + rs3.getInt(3) + "\t\t" + rs3.getString(4) + "\t\t" + rs3.getInt(5) + "\t\t" + rs3.getInt(6) + "\t\t\t" + rs3.getDouble(7) + "\t\t" + rs3.getDouble(8) + "\t\t" + rs3.getDouble(9));
    	        					System.out.println("");
    	        				}
    	        			}
    	        			if(stmt.getMoreResults()) 
    	        			{
    	        				rs3 = stmt.getResultSet();
    	        			}
    	        			else
    	        			{
    	        				rs3.close();
    	        				rs3 = null;
    	        			}
            			}	
            		}
            			
            		catch(Exception e) 
                	{
            			System.out.println(e);
            		}
        			
        			
        			
            		break;
            		
            	case 2:

                	System.out.println("Enter date : ");
                	String date = input.next();
            		
                	try
                	{
            			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
            			System.out.println("Connection Successfull!!");
            			String query4 = "select day_wise_cnt_order('" + date + "')";
            			//String query5 = "cust_wise_bill_detail(" + cid + ")";
            			Statement stmt = conn.createStatement();
            			//ResultSet rs3 = stmt.executeQuery(query3);
            			ResultSet rs4 = stmt.executeQuery(query4);
            			System.out.println("\n\nDay wise count order");
            			while(rs4!=null) 
            			{
            				
    	        			while(rs4.next()) 
    	        			{
    	        					System.out.print(rs4.getString(1) + '\n');		
    	        			}
    	        			
            			}
            		}
            			
            			
            		catch(Exception e) 
                	{
            			System.out.println(e);
            		}
                	
                	
            		break;
            		
            	case 3:
            		
            		try
                	{
            			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
            			System.out.println("Connection Successfull!!");
            			String query4 = "call pay_mode";
            			//String query5 = "cust_wise_bill_detail(" + cid + ")";
            			Statement stmt = conn.createStatement();
            			//ResultSet rs3 = stmt.executeQuery(query3);
            			ResultSet rs4 = stmt.executeQuery(query4);
            			
    	        			System.out.println("\t\tpayment mode \tmaximum no. of people chosen that mode");
    	        			while(rs4.next()) 
    	        			{
    	        					System.out.print("\t\t" + rs4.getString(1) + "\t\t" + rs4.getString(2) + '\n');
    	        				
    	        			}
    	        			
            		}
            			
            			
            		catch(Exception e) 
                	{
            			System.out.println(e);
            		}
            		
            		break;
            		
            	case 4:

            		System.out.println("Enter from date : ");
            		String fromdate = input.next();
            		
            		System.out.println("Enter to date : ");
            		String todate = input.next();
            		
            		
            		try
                	{
            			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
            			System.out.println("Connection Successfull!!");
            			String query4 = "call highest_sell('" + fromdate + "','" + todate + "')";
            			//String query5 = "cust_wise_bill_detail(" + cid + ")";
            			Statement stmt = conn.createStatement();
            			//ResultSet rs3 = stmt.executeQuery(query3);
            			ResultSet rs4 = stmt.executeQuery(query4);
            			
    	        		System.out.println("\t\torder id \tproduct id \tproduct quantity");	
    	        			while(rs4.next()) 
    	        			{
    	        					System.out.print("\t\t" + rs4.getString(1) + "\t\t" + rs4.getString(2) + "\t\t" + rs4.getString(3) + '\n');
    	        				
    	        			}
    	        			
            		}
            			
            			
            		catch(Exception e) 
                	{
            			System.out.println(e);
            		}
            		
            		break;
            		
            	case 5:
            		
            		try
                	{
            			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
            			System.out.println("Connection Successfull!!");
            			String query4 = "call highest_prod_return";
            			//String query5 = "cust_wise_bill_detail(" + cid + ")";
            			Statement stmt = conn.createStatement();
            			//ResultSet rs3 = stmt.executeQuery(query3);
            			ResultSet rs4 = stmt.executeQuery(query4);
            			System.out.println("\n\n\t Quantity of products returned ");
    	        		System.out.println("\t\tproduct id \tQuantity");
    	        			while(rs4.next()) 
    	        			{
    	        					System.out.print("\t\t" + rs4.getString(1) + "\t\t" + rs4.getString(2) + '\n');
    	        				
    	        			}
    	        			
            		}
            			
            			
            		catch(Exception e) 
                	{
            			System.out.println(e);
            		}
            		
            		break;
            		
            	case 6:
            		try
                	{
            			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
            			System.out.println("Connection Successfull!!");
            			String query4 = "call orderdetail";
            			//String query5 = "cust_wise_bill_detail(" + cid + ")";
            			Statement stmt = conn.createStatement();
            			//ResultSet rs3 = stmt.executeQuery(query3);
            			ResultSet rs3 = stmt.executeQuery(query4);
            			System.out.println("\t\torder id \t order date \tcustomer id \t\tcustomer address\t  total amount \torder id \tproduct id \tproduct qty \tproduct price \tproduct total price");
            			
            			while(rs3!=null) 
            			{    	        			
    	        			while(rs3.next()) 
    	        			{
    	        				java.sql.ResultSetMetaData rsmd = rs3.getMetaData();
    	        				if(rsmd.getColumnCount()==1)
    	        					System.out.print(rs3.getString(1) + '\n');
    	        				else
    	        					System.out.println("\t\t"+rs3.getString(1)+ "\t\t" + rs3.getString(2) + "\t\t" + rs3.getString(3) + "\t\t" + rs3.getString(4) + "\t\t" + rs3.getString(5) + "\t\t" + rs3.getString(6) + "\t\t" + rs3.getString(7) + "\t\t" + rs3.getString(8) + "\t\t" + rs3.getString(9) + "\t\t" + rs3.getString(10));
    	                         
    	        			}
    	        			if(stmt.getMoreResults()) 
    	        			{
    	        				rs3 = stmt.getResultSet();
    	        			}
    	        			else
    	        			{
    	        				rs3.close();
    	        				rs3 = null;
    	        			}
            			}		
    	        			
    	        			
            		}
            			
            			
            		catch(Exception e) 
                	{
            			System.out.println(e);
            		}
            		
            		break;
            		
            	case 7:
            		
            		try
                	{
            			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
            			System.out.println("Connection Successfull!!");
            			String query4 = "call top3_customers_based_on_order";
            			//String query5 = "cust_wise_bill_detail(" + cid + ")";
            			Statement stmt = conn.createStatement();
            			//ResultSet rs3 = stmt.executeQuery(query3);
            			ResultSet rs4 = stmt.executeQuery(query4);
            			System.out.println("\t\tcustomer id \tcustomer name\n");
    	        			
    	        			while(rs4.next()) 
    	        			{
    	        					System.out.print("\t\t" + rs4.getString(1) + "\t\t" + rs4.getString(2) + '\n');
    	        				
    	        			}
    	        			
            		}
            			
            			
            		catch(Exception e) 
                	{
            			System.out.println(e);
            		}
            		
            		
            		break;
            		
            	case 8:
            		
            		try
                	{
            			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
            			System.out.println("Connection Successfull!!");
            			String query4 = "call top3_customers_based_on_amount";
            			//String query5 = "cust_wise_bill_detail(" + cid + ")";
            			Statement stmt = conn.createStatement();
            			//ResultSet rs3 = stmt.executeQuery(query3);
            			ResultSet rs4 = stmt.executeQuery(query4);
            			
            			System.out.println("\t\tcustomer id \tcustomer name\n");
    	        			while(rs4.next()) 
    	        			{
    	        					System.out.print("\t\t" + rs4.getString(1) + "\t\t" + rs4.getString(2) + '\n');
    	        				
    	        			}
    	        			
            		}
            			
            			
            		catch(Exception e) 
                	{
            			System.out.println(e);
            		}
            		
            		
            		break;
            		
            	case 0:
            		e3=true;
            		break;
            		
            	default:
            		System.out.println("Invalid choice");
            	}
                }
            	break;
            	
            case 0:
            	e1=true;
            	break;
            	
            default :
            	System.out.println("Invalid Customer Type.");
            }
            

		}
	}
}
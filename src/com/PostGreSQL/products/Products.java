/**
 * 
 */
package com.PostGreSQL.products;

/**
 * @author Jai Shree Krishna
 *
 */
public class Products {
      private int productID;
      private String productName;
      private String productCheck;
      private String madeIn;
	/**
	 * 
	 */
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param productID
	 * @param productName
	 * @param productCheck
	 * @param madeIn
	 */
	public Products(int productID, String productName, String productCheck, String madeIn) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productCheck = productCheck;
		this.madeIn = madeIn;
	}
	/**
	 * @param productName
	 * @param productCheck
	 * @param madeIn
	 */
	public Products(String productName, String productCheck, String madeIn) {
		super();
		this.productName = productName;
		this.productCheck = productCheck;
		this.madeIn = madeIn;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCheck() {
		return productCheck;
	}
	public void setProductCheck(String productCheck) {
		this.productCheck = productCheck;
	}
	public String getMadeIn() {
		return madeIn;
	}
	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Product ID : "+this.productID+" ] [Product Name : "+this.productName+" ] "
				+ "[Product Quality Status : "+this.productCheck+" ] [Product Made In : "+this.madeIn+" ]";
	}
      
}

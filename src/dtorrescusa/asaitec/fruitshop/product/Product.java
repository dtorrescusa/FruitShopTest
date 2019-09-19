package dtorrescusa.asaitec.fruitshop.product;

/**
* Product is the class to describe a product
*  
* @author Daniel Torrescusa
* 
*/

public class Product 
{

	/**
	 * Product name
	 */
	private String name;
	final private String DEFAULT_NAME = "N/A";

	/**
	 * Product price
	 */
	private double price;
	final private double DEFAULT_PRICE = 0.0;

	/**
	 * 	Product default constructor
	 */
	public Product()
	{
		setName(DEFAULT_NAME);
		setPrice(DEFAULT_PRICE);
	}

	/**
	 * 	Product constructor
	 * @param n Product name
	 * @param p Product price
	 */	
	public Product(String n, double p)
	{
		setName(n);
		setPrice(p);
	}

	/**
	 * Method to obtain product name
	 * @return Product name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Method to assign product name
	 * @param n The product name 
	 */
	public void setName(String n) 
	{
		this.name = n;
	}

	/**
	 * Method to obtain product price
	 * @return Product price
	 */
	public Double getPrice() 
	{
		return price;
	}

	/**
	 * Method to assign product price
	 * @param p The product price
	 */
	public void setPrice(double p) 
	{
		this.price = p;
	}
}

package dtorrescusa.asaitec.fruitshop.purchase;

import dtorrescusa.asaitec.fruitshop.product.Product;

/**
* PurchaseLine is the class to describe a purchase
*  
* @author Daniel Torrescusa
* 
*/

public class PurchaseLine {

	/**
	 * Product product
	 */
	private Product product;

	/**
	 * Product quantity
	 */
	private double quantity;
	final private double DEFAULT_QUANTITY = 1.0;

	/**
	 * 	Purchase Line constructor
	 * @param p Product object
	 */
	public PurchaseLine(Product p)
	{
		setProduct(p);
		setQuantity(DEFAULT_QUANTITY);
	}

	/**
	 * 	Purchase Line constructor
	 * @param p Product object
	 * @param q Quantity
	 */
	public PurchaseLine(Product p, double q)
	{
		setProduct(p);
		setQuantity(q);
	}

	/**
	 * Method to obtain product 
	 * @return Product object
	 */
	public Product getProduct() 
	{
		return product;
	}

	/**
	 * Method to assign product
	 * @param p The product object
	 */
	public void setProduct(Product p) 
	{
		this.product = p;
	}

	/**
	 * Method to obtain product quantity
	 * @return Product quantity
	 */
	public Double getQuantity() 
	{
		return quantity;
	}

	/**
	 * Method to assign product quantity
	 * @param q The product quantity
	 */
	public void setQuantity(double q) 
	{
		this.quantity = q;
	}

	/**
	 * Method to calculate and return purchase line total price
	 * @return Purchase line total price
	 */
	public double getTotal()
	{
		double total = getProduct().getPrice() * this.getQuantity();
		return total;
	}
}

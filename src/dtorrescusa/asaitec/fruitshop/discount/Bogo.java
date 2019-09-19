package dtorrescusa.asaitec.fruitshop.discount;

/**
* Discount is the class to describe Buy One Get One kind of discount
*  
* @author Daniel Torrescusa
* 
*/

public class Bogo extends Discount {

	class Settings
	{
		private String product_to_buy;
		private double quantity_to_buy;
		private String free_product;
		private double free_quantity;
		private boolean apply_to_line = false;
		private boolean apply_to_purchase = true;
	}
}

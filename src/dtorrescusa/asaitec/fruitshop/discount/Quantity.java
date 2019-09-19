package dtorrescusa.asaitec.fruitshop.discount;

/**
* Discount is the class to describe a discount per total quantity in a purchase line 
*  
* @author Daniel Torrescusa
* 
*/

public class Quantity extends Discount {

	class Settings {
		private String product;
		private double quantity;
		private double free_quantity;
		private boolean apply_to_line = true;
		private boolean apply_to_purchase = false;
	}
}

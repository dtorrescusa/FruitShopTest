package dtorrescusa.asaitec.fruitshop.discount;

/**
* Discount is the class to describe a discount per total amount 
*  
* @author Daniel Torrescusa
* 
*/

public class Amount extends Discount {

	class Settings
	{
		private double amount;
		private double discount;
		private boolean apply_to_line = false;
		private boolean apply_to_purchase = true;
	}
}

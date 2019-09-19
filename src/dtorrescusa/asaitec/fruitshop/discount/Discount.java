package dtorrescusa.asaitec.fruitshop.discount;

/**
* Discount is the class to describe discounts in the purchase order
*  
* @author Daniel Torrescusa
* 
*/

public abstract class Discount 
{

	private String[] discount_type = {"BOGO", "AMOUNT", "QUANTITY"};

	class Settings 
	{
		private boolean apply_to_line;
		private boolean apply_to_purchase;
	}
}

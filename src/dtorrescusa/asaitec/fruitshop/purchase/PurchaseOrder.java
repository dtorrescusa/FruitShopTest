package dtorrescusa.asaitec.fruitshop.purchase;

import java.util.ArrayList;

/**
* PurchaseOrder is the class to describe an Order
*  
* @author Daniel Torrescusa
* 
*/

public class PurchaseOrder {

	/**
	 * Product lines list
	 */
	private ArrayList<PurchaseLine> poLines = new ArrayList<PurchaseLine>();

	/**
	 * Purchase order total amount
	 */
	private double grandTotal = 0.0;

	/**
	 * 	Purchase Order default constructor
	 */
	public PurchaseOrder()
	{
		setPOLines(new ArrayList<PurchaseLine>());
		setGrandTotal(0.0);
	}

	/**
	 * Method to obtain purchase order lines
	 * @return purchase order lines
	 */
	public ArrayList<PurchaseLine> getPOLines()
	{
		return poLines;
	}

	/**
	 * Method to assign list of purchase lines
	 * @param pl the purchase lines list
	 */
	public void setPOLines(ArrayList<PurchaseLine> pl)
	{
		this.poLines = pl;
	}

	/**
	 * Method to obtain purchase order total amount
	 * @return purchase order grand total
	 */
	public Double getGrandTotal()
	{
		double gt = 0;
		poLines = getPOLines();

		for(PurchaseLine pl: poLines)
		{
			gt += pl.getTotal();
		}
		setGrandTotal(gt);
		return gt;
	}

	/**
	 * Method to assign purchase order total amount
	 * @param gt the grand total
	 */
	public void setGrandTotal(double gt)
	{
		this.grandTotal = gt;
	}

	/**
	 * Method to add a new purchase line to the purchase order
	 * @param pl The new purchase line
	 */	
	public void addPOLine(PurchaseLine pl)
	{
		poLines.add(pl);
	}
	
}

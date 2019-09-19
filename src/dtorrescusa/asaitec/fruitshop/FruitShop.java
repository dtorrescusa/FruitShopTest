package dtorrescusa.asaitec.fruitshop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dtorrescusa.asaitec.fruitshop.product.Product;
import dtorrescusa.asaitec.fruitshop.purchase.PurchaseLine;
import dtorrescusa.asaitec.fruitshop.purchase.PurchaseOrder;

/**
* FruitShop is the main class and entry point
*  
* @author Daniel Torrescusa
* 
*/

public class FruitShop 
{

	/**
	 * Product list
	 */
	private static ArrayList<Product> productList = new ArrayList<Product>();

	/**
	 * Purchase order
	 */	
	private static PurchaseOrder po = null;

	/**
	 * Application entry point
	 *
	 * @param args an array of command-line arguments for the application
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		if (args.length != 2)
		{
			System.err.println("Invalid arguments:");
			System.err.println("  First parameter:  Path to a comma separated product, price pairs file.");
			System.err.println("                    Assuming first line for headers.");
			System.err.println("  Second parameter: Path to a comma separated product, quantity pairs file.");
			System.err.println("                    Assuming first line for headers.");
		}
		else
		{
			String productPath = args[0];		// Path to the product file
			String purchasePath = args[1];		// Path to the purchase file

			storeProducts(productPath);			// Read and store products
			storePurchase(purchasePath);		// Read and store purchase 

			listProducts();						// Show product list on screen
			listPurchase();						// Show purchase and receipt on screen
		}
	}

	/**
	 * Method to add a product to product list
	 *
	 * @param p a product to be added
	 */
	private static void addProduct(Product p)
	{
		productList.add(p);
	}

	/**
	 * Method to look for a product and get it
	 * @return product object
	 */
	private static Product getProduct(String n)
	{
		Product product = null;
		for (Product p : productList)
		{
			if (p.getName().equals(n)) 
			{
				product = p;
				break;
			}
		}
		return product;
	}

	/**
	 * Method to read products from a file and store internally
	 *
	 * @param productPath the path to a comma separated products file
	 * @throws IOException 
	 */
	private static void storeProducts(String productPath) throws IOException
	{
		Scanner productFile = new Scanner(new File(productPath));

		// Assuming first line are headers and skipping it
		String dummy = productFile.nextLine();

		// reading product file and adding it to product list
		while (productFile.hasNextLine()) 
		{
			String line = productFile.nextLine();
			String[] l = line.split(",");
			String name = l[0];
			double price = Double.valueOf(l[1]);
			Product product = new Product(name, price);
			addProduct(product);
		}
		productFile.close();
	}

	/**
	 * Method to read purchase from a file and store internally
	 *
	 * @param purchasePath the path to a comma separated purchase file
	 * @throws IOException 
	 */
	private static void storePurchase(String purchasePath) throws IOException
	{
		Scanner purchaseFile = new Scanner(new File(purchasePath));

		// Assuming first line are headers and skipping it
		String dummy = purchaseFile.nextLine();

		// reading purchase file and adding product lines to current or new purchase order
		while (purchaseFile.hasNextLine())
		{
			String line = purchaseFile.nextLine();
			String[] l = line.split(",");
			String name = l[0];
			Product product = getProduct(name);
			if (product != null)
			{
				double quantity = Double.valueOf(l[1]);
				if (po == null)
				{
					po = new PurchaseOrder();
				}
				po.addPOLine(new PurchaseLine(product, quantity));
			}
			else
			{
				System.err.println("****** Product " + name + " doesn't exist in shop product list. This product will be ignored. Please review purchase file ******");
			}
		}
		purchaseFile.close();
	}

	/**
	 * Method to list products on screen
	 * 
	 */
	public static void listProducts()
	{
		System.out.println("###### PRODUCT LIST START ######");
		for(Product p : productList)
		{
			System.out.println("Product, Price: " + p.getName() + ", " + p.getPrice());
		}
		System.out.println("###### PRODUCT LIST FINISH ######");
	}

	/**
	 * Method to list purchase and receipt on screen
	 * 
	 */	
	public static void listPurchase()
	{
		ArrayList<PurchaseLine> poLines = po.getPOLines();
		System.out.println("###### PURCHASE ORDER START ######");
		for(PurchaseLine pl : poLines)
		{
			System.out.println("Product, Price, Quantity => Total Line: " + pl.getProduct().getName() + ", " + pl.getProduct().getPrice() + ", " + pl.getQuantity() + " => " + pl.getTotal());
		}
		System.out.println("###### PURCHASE ORDER END ######");
		System.out.println("###### PURCHASE ORDER GRAND TOTAL: " + po.getGrandTotal() + " ######");
	}
}

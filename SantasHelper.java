/* 
 * This program  will help Santa calculate and display the sub-total, tax, and grand total of the toys entered by the user.
 * Brad Klucas 12/05/18
 */
import java.text.*;
import java.util.*;

public class SantasHelper {
// declare variables
	static String iString; //helps convert some inputs to numbers
	static String iFName, iLName, iToy1, iToy2; //variables for the names of the objects
	static double iToy1Price, iToy2Price, cSubTotal, cTax, cTotal;
	static String oToy1Price, oToy2Price, oSubTotal, oTax, oTotal; //Output variables from the prev vars
	static Scanner myScanner; //input device
	static NumberFormat nfc; //used for formatting to currency
	static String iChoice;

public static void main(String [] args) {
	
	//call initialization
	init();
	
	//call input
	input();
	
	//call calculations
	calc();
	
	//call output
	output();
	
	System.out.println("Ho Ho Ho! Program completed! Merry Christmas, " + iFName + "!");
	
	/*try {
	System.out.println("Enter 'y' to restart Santa's Helper.");
	iChoice = myScanner.next();
	}
	catch (Exception e) {
	System.out.println("You need to give a letter.");
	}
	*/
}

static void init() {
	//set scanner to console
	myScanner = new Scanner(System.in);
	
	//change delimiter from blank space to enter key
	//to allow spaces in strings
	myScanner.useDelimiter(System.getProperty("line.separator"));
			
	//set formatter to use U.S. currency format
	nfc = NumberFormat.getCurrencyInstance(java.util.Locale.US);
}

public static void input() {
	//prompt for first name, last name, names of the toys, and the toy costs. Then move value from iString to appropriate variable and test
	//  to see if the user entered the correct data
	System.out.print("Enter First Name: ");
	iFName = myScanner.next();
	
	if(iFName.trim().isEmpty()) {
	System.out.println("You cannot leave first name blank"); //check to make sure iFName is not null
	}
	
	System.out.print("Enter Last Name: ");
	iLName = myScanner.next();
	
	if(iLName.trim().isEmpty()) {
	System.out.println("You cannot leave last name blank"); //check to make sure iLName is not null
		}
	
	System.out.print("Enter the first toy's name: ");
	iToy1 = myScanner.next();
	
	if(iToy1.trim().isEmpty()) {
	System.out.println("You cannot leave toy name blank"); //check to make sure iToy1 is not null
		}
	
	try {
	System.out.print("Enter the price of the first toy: ");
	iString = myScanner.next();
	iToy1Price = Double.parseDouble(iString); //this puts the value (string value) from iString to the proper variable
}
		
	catch (Exception e){
	System.out.println("You need to give a number.");
	input();
}
	
	System.out.print("Enter the second toy's name: ");
	iToy2 = myScanner.next();
	
	if(iToy2.trim().isEmpty()) {
	System.out.println("You cannot leave toy name blank"); //check to make sure iToy2 is not null
		}
	
	try {
	System.out.print("Enter the price of the second toy: ");
	iString = myScanner.next();
	iToy2Price = Double.parseDouble(iString);
}
	
	catch (Exception e) {
	System.out.println("You need to give a number.");
	input();
}
	
}

public static void calc() {
	//calculate the necessary calculations
	cSubTotal = iToy1Price + iToy2Price;
	cTax = cSubTotal * .07;
	cTotal = cTax + cSubTotal;
	
}

public static void output() {
	//display to user the results
	System.out.println("Name: " + iFName + " " + iLName);
	
	//format and display
	oToy1Price = nfc.format(iToy1Price);
	System.out.println("First Toy Name and Price: " + iToy1 + ": " + oToy1Price);
	
	oToy2Price = nfc.format(iToy2Price);
	System.out.println("Second Toy Name and Price: " + iToy2 + ": " + oToy2Price);
	
	oSubTotal = nfc.format(cSubTotal);
	System.out.println("SubTotal: " + oSubTotal);
	
	oTax = nfc.format(cTax);
	System.out.println("Tax: " + oTax);
	
	oTotal = nfc.format(cTotal);
	System.out.println("Total Amount: " + oTotal);
	
}
}

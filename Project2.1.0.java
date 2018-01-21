import java.io.*;               // Access PrintWriter and related classes
import java.util.Scanner;       // Input Scanner from Library



// PHASE 2.1 INPUT FILE
public class Project2.1.0 {

   public static String statusTester(String fileInput) {
      
      int length = 0;            // Find length of String
      String status = "Valid";   // Setting status to Vaild
      
      length = String.valueOf(fileInput).length();    // Determine length of string
   
      // Check if number is equal to 8 digits 
      if (length != 8) {
         status = "Invalid";        // Rewrite status if found false 
      } 
      
      // Check if number only has 0's and 1's input
      for(int i = 0; i < length; i++) {
         // Check Character to ASCII standard 48 = 0 and 49 = 1
         if (fileInput.charAt(i) != 48 && fileInput.charAt(i) != 49) {
            status = "Invalid";     // Rewrite status if found false
         }                             
      } 
   
      return status; // Return the status of the string 
   } // End Method (statusTester)

// ****************************************************************************

   public static int calculationResult(String fileInput, String status) {
      
      int decimalValue = 0;      // Decimal number result
      int power = 0;             // Power to the base for calculations
      int numberTemp = 0;        // Temp filler
      
      // Convert String intp int for calculations
      int result = Integer.parseInt(fileInput);
   
      // Computation of the decimal value of a binary number 
   
      while (true){
            // Calculations for binary number into decimal 
         if (result != 0) {
               // Takes 1 digit from input number
            numberTemp = result % 10;
            decimalValue += numberTemp * Math.pow(2, power);  // Calculate number pending on power status
            result = result / 10;
            power++;       // Increment power for future calculation 
         }
         else {
            break;   
         }
      } // End While
         
      return decimalValue;
   } // End Method (calculationResult)

// ****************************************************************************
   
   public static void main (String [] args) {
      
      Scanner console = new Scanner(System.in); 
      
      // Declarations
      String fileInput = "";     // UserInput; Binary Input
      String status = "";   // Setting status to Vaild
      int decimalValue = 0;      // Decimal number result
    
      // Ask for vaild user input
      System.out.println("This program will calculate your binary numbers into a total" 
                         + "\nPlease enter a 8 digit binary number. ex: 10010101");
      fileInput = console.nextLine();                 // Recieved string input 
    
      System.out.println("String: " + fileInput);     // Output of users input
      
      status = statusTester(fileInput); 
      
      System.out.println("Status: " + status);
      
      if (status == "Valid") {
      
         decimalValue = calculationResult(fileInput, status);
                  
         // Output decimal value to console
         System.out.println("Decimal Value: " + decimalValue);
   
      } // End status check        
   
   } // End Method (Main)

} // End Class (Project2)
import java.io.*;               // Access PrintWriter and related classes
import java.util.Scanner;       // Input Scanner from Library

public class Project2.1 {

   public static void main (String [] args) {
      
      Scanner console = new Scanner(System.in); 
      
      // Declarations
      String status = "Valid";   // Setting status to Vaild
      String userInput = "";     // UserInput; Binary Input
      int decimalValue = 0;      // Decimal number result
      int length = 0;            // Find length of String   
      int power = 0;             // Power to the base for calculations
      int numberTemp = 0;        // Temp filler
      
      // Ask for vaild user input
      System.out.println("This program will calculate your binary numbers into a total" 
                         + "\nPlease enter a 8 digit binary number. ex: 10010101");
      userInput = console.nextLine();                 // Recieved string input 
      
      length = String.valueOf(userInput).length();    // Determine length of string
      
      System.out.println("String: " + userInput);     // Output of users input
      
      // Check if number is equal to 8 digits 
      if (length != 8) {
         status = "Invalid";        // Rewrite status if found false 
      } 
      
      // Check if number only has 0's and 1's input
      for(int i = 0; i < length; i++) {
         // Check Character to ASCII standard 48 = 0 and 49 = 1
          if (userInput.charAt(i) != 48 && userInput.charAt(i) != 49) {
            status = "Invalid";     // Rewrite status if found false
         }                             
      } 
   
      
      System.out.println("Status: " + status);
      
      // Convert String intp int for calculations
      int result = Integer.parseInt(userInput);
   
      // If string is valid, begin calculations 
      if (status == "Valid") {
         while (true){
            // Calculations for binary number into decimal 
            if (result != 0) {
               // Takes 1 digit from input number
               numberTemp = result % 10;
               decimalValue += numberTemp*Math.pow(2, power);  // Calculate number pending on power status
               result = result/10;
               power++;       // Increment power for future calculation 
            }
            else {
               break;   
            }
         } // End While
         
         // Output decimal value to console
         System.out.println("Decimal Value: " + decimalValue);
      } // End status check
         
   
   } // End Main

} // End Class


import java.io.*;               // Access PrintWriter and related classes
import java.util.Scanner;       // Input Scanner from Library

public class Project2 { 

// ****************************************************************************

   public static String printInfo(String input, Scanner console) {
   
      switch(input) {
         case "InputFile":
            System.out.println("This program will calculate your binary numbers into a total" 
                         + "\nPlease enter the FILE NAME you wish to run? \nExample: File_Name.txt");
         
            input = console.nextLine(); 
            break;
      
         case "OutputFile":
            System.out.println("Please provide a file name for your Report. \nExample: Report_Name.txt");
         
            input = console.nextLine(); 
            break;
      }
   
      return input;
   } // End Method (printInfo)
   
// ****************************************************************************

   public static void processUserNumbers(Scanner userFile, String fileInput, PrintWriter reportFile) throws IOException {
   
      int decimalValue = 0;   // Decimal number result
      String status = "";     // Setting status to Vaild
      String line1 = "";
      String line2 = "";
      String line3 = "";
   
      while (userFile.hasNextLine()) {
         
         fileInput = userFile.nextLine();    // Inputs next data line         
            
         line1 = "\r\nString: " + fileInput;  // Output of users input
      
         status = validateNumber(fileInput);   // Test data to see if its valid
      
         line2 = "\r\nStatus: " + status;                 // Update status
         
         reportFile.print(line1 + line2);      // Print to output file  
      
         if (status == "Valid") {            // If status is vaild, begin calculations
         
            decimalValue = evaluateNumber(fileInput, status);  // Calculation results
                  
         // Output decimal value to console
            line3 = "\r\nDecimal Value: " + decimalValue;
            
            reportFile.println(line3);      // Print to output file  
         
         } // End status check 
               
      } // End while
                
   } // End Method processUserNumbers    

// ****************************************************************************

   public static String validateNumber(String fileInput) {
      
      int length = 0;            // Find length of String
      String status = "Valid";   // Setting status to Vaild
      
      length = String.valueOf(fileInput).length();    // Determine length of string
   
      // Check if number is equal to 8 digits 
      if (length != 8) {
         status = "Invalid\r\n";        // Rewrite status if found false 
      } 
      
      // Check if number only has 0's and 1's input
      for(int i = 0; i < length; i++) {
         // Check Character to ASCII standard 48 = 0 and 49 = 1
         if (fileInput.charAt(i) != 48 && fileInput.charAt(i) != 49) {
            status = "Invalid\r\n";     // Rewrite status if found false
         }                             
      } // End For
   
      return status; // Return the status of the string 
   } // End Method (validateNumber)

// ****************************************************************************

   public static int evaluateNumber(String fileInput, String status) {
      
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
   } // End Method (evaluateNumber) 
   
// ****************************************************************************
 
   public static void processFileNumbers(String fileInput, String status, String digit) throws IOException  {
   
      Scanner console = new Scanner(System.in);
      
      String output = "";
       
      File userFileName = new File(fileInput);        // Input file that user requested 
      Scanner userFile = new Scanner(userFileName);   // Sanner opens and reads
      
      FileWriter reportDataFile = new FileWriter(status);    
      PrintWriter reportFile = new PrintWriter(reportDataFile); // Writer Output File
   
      processUserNumbers(userFile, fileInput, reportFile);       // Starts reading file and calculates 
   
      reportFile.close();  // Close file writer
      userFile.close(); // Close file 
   } // End method (processFileNumbers)         

// ****************************************************************************
   
   public static void main (String[] args) throws IOException { 
      
      Scanner console = new Scanner(System.in); 
      
      // Declarations
      String fileInput = "";     // UserInput; Binary Input
      String extra1 = "InputFile";
      String extra2 = "OutputFile";
      
      // Both call printInfo Method with different parameters 
      fileInput =  printInfo(extra1, console);       
      extra1 = printInfo(extra2, console);            
      
      // Begins process to eval. file
      processFileNumbers(fileInput, extra1, extra2);
                
      System.exit(0);   // Exit system   
   } // End Method (Main)

} // End Class (Project2)
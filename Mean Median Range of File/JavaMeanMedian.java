// JavaMeanMedian.java  -- compute mean and median of a disk file
//
// This sample provides the first part of the code for computing the mean
// but only has part of the code for completing the median.
// It is your task to complete the code to compute the mean and median values.

// Name: Jibran Akhter
// Date: 5/12/2024
// Version: 1.0
// Program: Mean and Median of a Disk File

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class JavaMeanMedian {
    static final String FILEPATH = "Desktop";   // path name where file is located

    public static void main(String[] args) {
        // variables to control the disk file
        Scanner infile;         // input file object
        String filename;        // name of the file
        int  recordCount = 0;   // number of records (lines) in the file
        // variables for fields of each record in the file
        String lineFromFile;    // used when reading a line at a time from file
        int    acctNo = 0;      // account number from a record in the file
        String customer = "";   // customer name from a record in the file
        double acctBal = 0.0;   // account balance from a record in the file
        // varible used to determine the mean and median
        double total = 0;       // used when computing the mean
        double mean= 0;         // mean (average) of all account balances
        double median = 0.0;    // median value of account balances
        ArrayList<Double> balances = new ArrayList<Double>(); // List to store balances
        
        // create the Scanner objects for the keyboard and disk access
        Scanner stdin = new Scanner(System.in);

        // get just the name of the file from the keyboard
        System.out.printf ("Enter the name of the data file: ");
        filename = stdin.nextLine();  // read the filename from standard in
        String loginID = System.getenv("USER");  // MacOS or Linux?
        if (loginID == null) loginID = System.getenv("USERNAME"); // Windows?
        String BalancesFileName = "/Users/" + loginID +
                                    "/" + FILEPATH + "/" + filename;  

        try {
            // ---- PART 1, Count the number of records in the file
            infile = new Scanner(new File(BalancesFileName));
            while (infile.hasNextInt()) {
                acctNo = infile.nextInt();      // read int for account number
                customer = infile.next();       // read string for customer name
                acctBal = infile.nextDouble();  // read double for acct balance  
                total += acctBal;
                balances.add(acctBal);
                recordCount++;
            }
            infile.close();
            System.out.printf("%d Records in %s\n", recordCount, filename);
            mean = total / recordCount;

            // ---- PART 2, Determine the median
            Collections.sort(balances);
            if (recordCount % 2 == 1)
                median = balances.get(recordCount / 2);
            else
                median = (balances.get(recordCount / 2 - 1) + balances.get(recordCount / 2)) / 2.0;

        } catch (IOException ioe) {
            System.out.println("Exception occurred opening or reading " + BalancesFileName);
        }
        
        // Compute and display the results
        System.out.printf("The mean of %s is %.3f\n", filename, mean);
        System.out.printf("The median of %s is %.3f\n", filename, median);
    }
    
}
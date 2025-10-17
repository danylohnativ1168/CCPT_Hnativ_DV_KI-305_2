package org.example;

import java.io.*;
import java.util.*;

/**
 * Lab1HnativKI305
 * <p>
 * This program draws a specific triangular pattern using a given symbol
 * and saves the same pattern to a text file named "MyFile.txt".
 * The user specifies the number of rows and the filling symbol.
 * </p>
 *
 * @author Danylo
 * @version 1.0
 */
public class Lab1HnativKI305
{
    /**
     * Default constructor.
     * Initializes the Lab1HnativKI305 class.
     */
    public Lab1HnativKI305() {
        // No initialization needed
    }

    /**
     * Main method — entry point of the program.
     * <p>
     * The method requests the user to enter the size of the pattern (number of rows)
     * and a symbol for filling. Then it generates a pattern of characters based on
     * specific geometric conditions, outputs it to the console, and writes it to a file.
     * </p>
     *
     * @param args command line arguments (not used)
     * @throws FileNotFoundException if file cannot be created or opened
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        int nRows;           // Number of rows in the pattern
        char[][] arr;        // Jagged array to conceptually store the pattern
        String filler;       // Symbol used to draw the pattern

        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Enter size: ");
        nRows = in.nextInt();  // Read number of rows
        in.nextLine();         // Consume newline

        // Initialize a jagged 2D array (each row has an increasing number of columns)
        arr = new char[nRows][];
        for (int i = 0; i < nRows; i++)
        {
            arr[i] = new char[i + 1];
        }

        System.out.print("\nEnter symbol: ");
        filler = in.nextLine();  // Read symbol from user

        // Generate the pattern
        for (int i = 0; i < nRows; i++)
        {
            for (int j = 0; j < nRows; j++)
            {
                int mid = (nRows - 1) / 2;  // Middle index

                // Determine whether to print the filler symbol or a space
                if ((i <= mid && j >= nRows - 1 - i) || (i > mid && j >= i))
                {
                    System.out.print(filler);
                    fout.print(filler);
                }
                else
                {
                    System.out.print(" ");
                    fout.print(" ");
                }
            }

            System.out.println(); // Move to the next line in console
            fout.println();       // Move to the next line in file
        }

        // Save and close file
        fout.flush();
        fout.close();
    }
}

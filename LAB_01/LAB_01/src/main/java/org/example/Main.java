package org.example;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int nRows;
        char[][] arr;
        String filler;

        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Enter size: ");
        nRows = in.nextInt();
        in.nextLine();

        arr = new char[nRows][];
        for(int i = 0; i < nRows; i++)
        {
            arr[i]= new char[i+1];
        }

        System.out.print("\nEnter symbol: ");
        filler = in.nextLine();
        exit:
        for (int i = 0; i < nRows; i++)
        {
            for (int j = 0; j < nRows; j++)
            {
                int mid = (nRows - 1) / 2;

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
            System.out.println();
            fout.println();
        }

        fout.flush();
        fout.close();
    }
}
package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int noOfSeats = scanner.nextInt();
        
        System.out.println("Cinema:");
        System.out.printf(" ");
        for (int i = 0; i < noOfSeats; i++) {
            System.out.printf(" " + (i + 1));
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print(i+1);
            for (int j = 0; j < noOfSeats; j++) {
                System.out.print(" S");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Enter a row number:");
        int rowNum = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int seatNum = scanner.nextInt();


        int totalSeats = rows * noOfSeats;
        if (totalSeats <= 60) {
            System.out.println("Ticket price: $" + 10);
        } else {
            if (rowNum <= rows / 2) {
                System.out.println("Ticket price: $" + 10);
            } else {
                System.out.println("Ticket price: $" + 8);
            }
        }

        System.out.println("Cinema:");
        System.out.printf(" ");
        for (int i = 0; i < noOfSeats; i++) {
            System.out.printf(" " + (i + 1));
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print(i+1);
            for (int j = 0; j < noOfSeats; j++) {
                if(rowNum==i+1 && seatNum==j+1){
                    System.out.print(" B");
                } else {
                    System.out.print(" S");
                }
            }
            System.out.println();
        }
    }
}
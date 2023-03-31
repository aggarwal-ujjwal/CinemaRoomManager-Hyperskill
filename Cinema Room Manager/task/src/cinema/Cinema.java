package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
//        final int row = 7;
//        final int col = 8;
//
//        System.out.println("Cinema:");
//        System.out.printf(" ");
//        for (int i = 0; i < col; i++) {
//            System.out.printf(" " + (i + 1));
//        }
//        System.out.println();
//
//        for (int i = 0; i < row; i++) {
//            System.out.print(i+1);
//            for (int j = 0; j < col; j++) {
//                System.out.print(" S");
//            }
//            System.out.println();
//        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int noOfSeats = scanner.nextInt();

        System.out.println("Total income:");
        int totalSeats = rows * noOfSeats;
        if (totalSeats <= 60) {
            System.out.println("$" + totalSeats * 10);
        } else {
            int frontRows = rows / 2;
            int backRows = rows - frontRows;

            System.out.println("$" + (frontRows * noOfSeats * 10 + backRows * noOfSeats * 8))
            ;

        }

    }
}
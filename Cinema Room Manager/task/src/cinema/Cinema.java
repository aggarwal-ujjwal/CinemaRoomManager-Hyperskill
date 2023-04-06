package cinema;

import java.util.*;

public class Cinema {

    public static void printSeats(String[][] r) {
        System.out.println("Cinema: ");
        System.out.println(Arrays.deepToString(r)
                .replace(",", "")
                .replace("[", "")
                .replace("]", "\n"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();
        String[][] arr = new String[rows + 1][seats + 1];
        int choice = -1;

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                arr[i][j] = i == 0 ? String.valueOf(j) : j == 0 ? String.valueOf(i) : "S";
            }
        }
        arr[0][0] = "  ";

        while (choice != 0) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "0. Exit");
            choice = sc.nextInt();

            if (choice == 1){
                showTheSeats(rows, seats, arr);
            } else if (choice == 2) {
                buyTicket(rows, seats, arr);
            } else {
                break;
            }
        }
        //Refactoring the whole function and dividing it into 3
    }

    public static int showTheSeats(int rows, int seats, String[][] arr){

        printSeats(arr);
        return 0;
    }

    public static int buyTicket(int rows, int seats, String[][] arr){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int chosenRow = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int chosenSeat = sc.nextInt();
        int price = rows * seats <= 60 || chosenRow <= rows / 2 ? 10 : 8;

        System.out.println("Ticket price: $" + price + "\n");

        arr[chosenRow][chosenSeat] = "B";
        return 0;
    }

}
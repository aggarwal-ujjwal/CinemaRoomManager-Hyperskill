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
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                arr[i][j] = i == 0 ? String.valueOf(j) : j == 0 ? String.valueOf(i) : "S";
            }
        }
        arr[0][0] = "  ";

        printSeats(arr);

        System.out.println("Enter a row number:");
        int chosenRow = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int chosenSeat = sc.nextInt();
        int price = rows * seats <= 60 || chosenRow <= rows / 2 ? 10 : 8;

        System.out.println("Ticket price: $" + price);

        arr[chosenRow][chosenSeat] = "B";

        printSeats(arr);
    }
}
package cinema;

import java.util.*;

public class Cinema {

    static int purchasedTickets = 0;
    static int currentIncome = 0;
    static int totalIncome = 0;


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

        totalIncome = totalIncome(rows,seats);

        while (choice != 0) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit\n");
            choice = sc.nextInt();

            if (choice == 1){
                showTheSeats(rows, seats, arr);
            } else if (choice == 2) {
                buyTicket(rows, seats, arr);
            } else if (choice == 3) {
                showStats(rows,seats);
            }else {
                break;
            }
        }
        //Refactoring the whole function and dividing it into 3
    }

    private static void showStats(int rows, int seats) {
        System.out.printf("Number of purchased tickets: %d\n" +
                "Percentage: %.2f%%\n" +
                "Current income: $%d\n" +
                "Total income: $%d\n",
                purchasedTickets,
                (double)purchasedTickets/(rows*seats)*100,
                currentIncome,
                totalIncome);
        System.out.println();
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

        if(chosenRow>rows || chosenRow<=0 || chosenSeat > seats || chosenSeat <=0){
            System.out.println("Wrong input!");
            buyTicket(rows, seats, arr);
        }
        int price = rows * seats <= 60 || chosenRow <= rows / 2 ? 10 : 8;

        System.out.println("Ticket price: $" + price + "\n");
        purchasedTickets++;
        currentIncome += price;
        arr[chosenRow][chosenSeat] = "B";
        return 0;
    }

    private static int totalIncome(int rows, int seats) {
        if (rows * seats <= 60) {
            return rows*seats*10;
        } else {
            return (rows/2)*seats*10 + (rows-rows/2)*seats*8;
        }
    }


}
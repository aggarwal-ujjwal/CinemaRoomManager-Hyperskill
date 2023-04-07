package cinema;

import java.security.KeyPair;
import java.util.*;

public class Cinema {

    static int purchasedTickets = 0;
    static int currentIncome = 0;
    static int totalIncome = 0;

    private Map<PairKey, String> myMap = new HashMap<>();

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
        if(){

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

    public void addToMap(int id, String name, String value) {
        PairKey pair = new PairKey(id, name);
        myMap.put(pair, value);
    }

    public boolean hasPair(int id, String name) {
        PairKey pair = new PairKey(id, name);
        return myMap.containsKey(pair);
    }

    private static class PairKey {
        private int id;
        private int name;

        public PairKey(int id, int name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PairKey pairKey = (PairKey) o;
            return id == pairKey.id && name == pairKey.name;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + name;//name.hashCode();
            return result;
        }
    }
    /*
    In this example, we define a private inner class PairKey to represent the key of the Map.
    The PairKey class has fields for the id and name of the pair, and overrides the equals and
    hashCode methods to ensure that pairs with the same id and name are considered equal.

    The addToMap method adds a new entry to the Map with a key of type PairKey and a value of value.

    The hasPair method checks if a pair with the given id and name exists in the Map by creating a
    new PairKey object and using the containsKey method of the Map to check if it exists.

    Note that using a custom class to represent the key requires more code than using a library
    like Apache Commons Lang, but it provides more flexibility and control over the key representation.

    Use of 31
    The number 31 is often used in the hashCode method in Java because it is an odd prime number.
     Using a prime number in the hashCode method can help to reduce collisions and improve the
     distribution of hash values across a range of inputs.

    In particular, multiplying a hash code by 31 has been shown to produce good results for many
    types of inputs, including strings and other common Java types. This is because 31 is a small
    prime number that is close to the average length of strings and many other data types, so it
    can help to distribute the hash values evenly across a range of input values.

    It's worth noting that the choice of 31 is not a hard and fast rule, and other prime numbers
    could be used in the hashCode method as well. However, 31 has become a common choice in Java and
    is often recommended in Java code conventions and style guides.
     */
}
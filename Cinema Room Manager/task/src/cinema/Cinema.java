package cinema;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        final int row = 7;
        final int col = 8;

        System.out.println("Cinema:");
        System.out.printf(" ");
        for (int i = 0; i < col; i++) {
            System.out.printf(" " + (i + 1));
        }
        System.out.println();

        for (int i = 0; i < row; i++) {
            System.out.print(i+1);
            for (int j = 0; j < col; j++) {
                System.out.print(" S");
            }
            System.out.println();
        }

    }
}
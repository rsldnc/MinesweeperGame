import java.util.Scanner;

public class minesweeperGame {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int row , col;

        System.out.println("Welcome to Minesweeper Game!");
        System.out.println("Enter the number of rows for the game board: ");
        row = inp.nextInt();

        System.out.println("Enter the number of columns for the game board: ");
        col = inp.nextInt();

        Minesweeper minesweeper = new Minesweeper(row, col);
        MinesweeperController minesweeperController = new MinesweeperController();
        minesweeperController.play(minesweeper);
    }
}

import java.util.Scanner;

public class MinesweeperController {
    boolean isInBoundaries(int row, int col, Minesweeper minesweeper)
    {
        return (!(row >= minesweeper.row || row < 0 || col >= minesweeper.col || col < 0));
    }

    boolean isItBomb(int row, int col, Minesweeper minesweeper)
    {
        return minesweeper.minesArr[row][col].equals("*");
    }

    int calculatePoint(int row, int col, Minesweeper minesweeper)
    {
        int i = row - 1;
        int point = 0;
        while (i <= row + 1 && i < minesweeper.row)
        {
            if (i < 0)
            {
                i++;
                continue;
            }
            int j = col - 1;
            while (j <= col + 1 && j < minesweeper.col)
            {
                if (j < 0 || (i == row && j == col))
                {
                    j++;
                    continue;
                }
                if (minesweeper.minesArr[i][j].equals("*"))
                    point++;
                j++;
            }
            i++;
        }
        return point;
    }

    static void printGameBoard(Minesweeper minesweeper)
    {
        for (int i = 0; i < minesweeper.row; i++)
        {
            for (int j = 0; j < minesweeper.col; j++)
                System.out.print(minesweeper.board[i][j] + " ");
            System.out.println();
        }
    }

    void play(Minesweeper minesweeper)
    {
        Scanner inp = new Scanner(System.in);
        int row, col;
        while (minesweeper.isFinished == 0)
        {
            printGameBoard(minesweeper);
            do {
                System.out.println("Enter a row number: ");
                row = inp.nextInt();

                System.out.println("Enter a column number: ");
                col = inp.nextInt();
            }while (!(isInBoundaries(row, col, minesweeper)) || !(minesweeper.board[row][col].equals("-")));

            if (isItBomb(row, col, minesweeper))
            {
                minesweeper.isFinished = -1;
                break;
            }
            else
            {
                minesweeper.board[row][col] = String.valueOf(calculatePoint(row, col, minesweeper));
                minesweeper.moves--;
            }

            if (minesweeper.moves == 0)
                minesweeper.isFinished = 1;
        }

        if (minesweeper.isFinished == -1)
            System.out.println("Game is over because you stepped on a mine!!");
        else
        {
            System.out.println("You Won the Game !");
            printGameBoard(minesweeper);
        }
    }
}

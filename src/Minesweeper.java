import java.util.Random;

public class Minesweeper {
    int row, col, mines, moves;
    int isFinished;
    String[][] board;
    String[][] minesArr;

    Minesweeper(int row, int column)
    {
        this.row = row;
        this.col = column;
        this.mines = (row * column) / 4;
        this.moves = (row * column) - this.mines;
        this.isFinished = 0;
        this.board = new String[this.row][this.col];
        this.minesArr = new String[this.row][this.col];

        setBoard();
        setMinesArr();
    }

    void setBoard()
    {
        for (int i = 0; i < this.row ; i++)
        {
            for (int j = 0; j < this.col ; j++)
                this.board[i][j] = "-";
        }
    }

    void setMinesArr()
    {
        for (int i = 0; i < this.row ; i++)
        {
            for (int j = 0; j < this.col ; j++)
                this.minesArr[i][j] = "-";
        }

        Random random = new Random();
        int m = 0;

        while (m < mines)
        {
            int r = random.nextInt(this.row - 1);
            int c = random.nextInt(this.col - 1);

            if (!(minesArr[r][c].equals("*")))
            {
                minesArr[r][c] = "*";
                m++;
            }
        }
    }
}

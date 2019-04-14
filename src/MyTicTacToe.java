import java.util.Scanner;

/**
 * @author Diana Soldan
 * @date : 4/7/2019
 */
public class MyTicTacToe {
    public static final char SYMBOL_X = 'X';
    public static final char SYMBOL_O = 'O';

    public static final int GAME_SIZE = 3;
    char[][] game = new char[3][3];

    Player player1;
    Player player2;

    public MyTicTacToe(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void showGame() {
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void initBoard() {


        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                game[i][j] = '.';
            }
        }
    }

    public Move readMove() {
        Scanner s = new Scanner(System.in);
        System.out.println("make move");
        String myMove = s.nextLine();
        String[] mySplit = myMove.split("-");
        int line = Integer.valueOf(mySplit[0]);
        int col = Integer.valueOf(mySplit[1]);
        Move move = new Move(line, col);
        return move;
    }

    public void makeMove(Move move, char symbol) {
        game[move.line][move.col] = symbol;
    }

    public boolean isWinLine(int line, char symbol) {
        boolean isWin = true;
        int i = 0;
        while (i < GAME_SIZE && isWin == true) {
            if (game[line][i] != symbol) {
                isWin = false;

            }
            i++;
        }
        return isWin;
    }

    //testez coloane
    public boolean isWinCol(int col, char symbol) {
        boolean isWin = true;
        int i = 0;
        while (i < GAME_SIZE && isWin == true) {
            if (game[i][col] != symbol) {
                isWin = false;

            }
            i++;
        }
        return isWin;

    }

    public boolean isWinDiag1(char symbol) {
        Boolean isWin = true;
        int i = 0;
        while (i < GAME_SIZE && isWin == true) {
            if (game[i][i] != symbol) {

                isWin = false;
            }
            i++;
        }
        return isWin;
    }

    public boolean isWinDiag2(char symbol) {
        Boolean isWin = true;
        int i = 0;
        while (i < GAME_SIZE - i - 1 && isWin == true) {
            if (game[i][GAME_SIZE - i - 1] != symbol) {

                isWin = false;
            }
            i++;
        }
        return isWin;
    }

    public boolean isWin(Move move, char symbol) {
        Boolean isWin = false;

        //testez linii
        isWin = isWinLine(move.line, symbol);
        if (isWin == false) {
            isWin = isWinCol(move.col, symbol);
        }

        //testez diagonala principala
        if (isWin == false && move.line == move.col) {
            isWin = isWinDiag1(symbol);

        }
        //testez diagonala 2
        if (move.line == GAME_SIZE - move.col - 1) {
            isWin = isWinDiag2(symbol);
        }
        return isWin;

    }

    public void playGame() {
        initBoard();
        System.out.println("Incepe jocul");
        showGame();
        Player curentPlayer = player1;
        char currentSymbol = SYMBOL_X;
        int nrMoves = 0;
        boolean isWin = false;

        while (isWin == false && nrMoves < GAME_SIZE*GAME_SIZE) {
            //citesc mutarea
            Move move = readMove();
            //validez mutarea
            //efectuez mutarea
            makeMove(move, currentSymbol);
            showGame();

            //numar mutarea
            nrMoves++;
            if (nrMoves >= 2 * GAME_SIZE - 1) {

                //testez daca avem stare de win

                isWin = isWin(move, currentSymbol);
            }
            //daca nu e win sau mai am mutari, schimb jucatorul
            if (curentPlayer == player1) {
                curentPlayer = player2;
                currentSymbol = SYMBOL_O;
            } else {
                curentPlayer = player1;
                currentSymbol = SYMBOL_X;
            }
        }
        //afisez mesaj corespunzator
        if (isWin == true) {
            System.out.println(curentPlayer.name + " este castigator");

        }else {
            System.out.println("niciun castigator");
        }
    }

}


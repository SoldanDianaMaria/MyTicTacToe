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
                System.out.println(game[i][j] + " ");
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

    public boolean isWin() {
        //testez linii
        //testez coloane
        //testez diagonala principala
        //testez diagonala 2
        return false;
    }

    public void playGame() {
        initBoard();
        System.out.println("Incepe jocul");
        showGame();
        Player curentPlayer = player1;
        int nrMoves = 0;
        boolean isWin = false;

        while (isWin = false && nrMoves < 9) {
            //citesc mutarea
            //validez mutarea
            //efectuez mutarea
            //numar mutarea
            //testez daca avem stare de win
            //daca nu e win sau mai am mutari, schimb jucatorul
        }
        //afisez mesaj corespunzator
    }

}


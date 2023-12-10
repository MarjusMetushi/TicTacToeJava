import java.util.Scanner;
public class tictactoe {
    private static boolean gameWon = false;
    private static char currentPlayer = 'X';
    private static char[][] theBoard = new char[3][3];
    private static boolean draw = false;
    public static void main(String[] args) {
        startTheBoard();
        printTheBoard();
        while (!gameWon) {
            makeAMove();
            printTheBoard();
            checkForWin();
            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            switchPlayers();
        }
        if (draw) {
            System.out.println("Draw");
        }
        
    }
    private static void startTheBoard() {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    theBoard[row][col] = ' ';
                }
            }
        }
    private static void printTheBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(theBoard[row][col]);
                if (col < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("-----------");
            }
        }
    }
    private static void makeAMove() {
        Scanner scanner = new Scanner(System.in);
        int row,col;
        do{
            System.out.println("Player " + currentPlayer + ", enter your row (0,1,2)");
            row = scanner.nextInt();
            System.out.println("Player " + currentPlayer + ", enter your column(0,1,2)");
            col = scanner.nextInt();
        }
        while(row < 0 || row>2 || col<0 || col>2|| theBoard[row][col]!=' ');
        theBoard[row][col] = currentPlayer;
        
    }
    private static void checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (theBoard[i][0]==currentPlayer && theBoard[i][1]==currentPlayer && theBoard[i][2]==currentPlayer
                || theBoard[0][i]==currentPlayer && theBoard[1][i]==currentPlayer && theBoard[2][i]==currentPlayer
                || theBoard[0][0]==currentPlayer && theBoard[1][1]==currentPlayer && theBoard[2][2]== currentPlayer
                || theBoard[0][2]==currentPlayer && theBoard[1][1]==currentPlayer && theBoard[2][0]==currentPlayer ) {
                gameWon = true;
                return;
            }
        }
        boolean isFull = true;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (theBoard[row][col]==' ') {
                    isFull = false;
                    break;
                }
            }
        }
        if (isFull&&!gameWon) {
            System.out.println("Draw");
            draw=true;
        }
        while (true) {
            if (!isFull) {
                break;
            }
        }
    }
    
    private static void switchPlayers() {
        if (currentPlayer=='X') {
            currentPlayer = 'O';
        }
        else{
            currentPlayer = 'X';
        }
    }
}
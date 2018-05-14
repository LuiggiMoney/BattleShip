/**
 * @author LuiggiFernandez
 */
import java.util.*;

public class BattleShip {
    static Scanner K = new Scanner(System.in);
    static String red="\033[31m"; 
    static String reset="\u001B[0m";
    private final ArrayList<String[]> CompGame = new ArrayList<>();
    private final ArrayList<String[]> UserGame = new ArrayList<>();
    private static void InitBoard() { //10x10 boardgame for battleship initializer
        String board_2D[][] = new String [10][10];
        // BattleshipTitle
        System.out.println("▀█████████▄     ▄████████     ███         ███      ▄█          ▄████████    ▄████████    ▄█    █▄     ▄█     ▄███████▄ \n" +
                          "  ███    ███   ███    ███ ▀█████████▄ ▀█████████▄ ███         ███    ███   ███    ███   ███    ███   ███    ███    ███ \n" +
                          "  ███    ███   ███    ███    ▀███▀▀██    ▀███▀▀██ ███         ███    █▀    ███    █▀    ███    ███   ███▌   ███    ███ \n" +
                          " ▄███▄▄▄██▀    ███    ███     ███   ▀     ███   ▀ ███        ▄███▄▄▄       ███         ▄███▄▄▄▄███▄▄ ███▌   ███    ███ \n" +
                          "▀▀███▀▀▀██▄  ▀███████████     ███         ███     ███       ▀▀███▀▀▀     ▀███████████ ▀▀███▀▀▀▀███▀  ███▌ ▀█████████▀  \n" +
                          "  ███    ██▄   ███    ███     ███         ███     ███         ███    █▄           ███   ███    ███   ███    ███        \n" +
                          "  ███    ███   ███    ███     ███         ███     ███▌    ▄   ███    ███    ▄█    ███   ███    ███   ███    ███        \n" +
                          "▄█████████▀    ███    █▀     ▄████▀      ▄████▀   █████▄▄██   ██████████  ▄████████▀    ███    █▀    █▀    ▄████▀      \n" +
                          "                                                  ▀                                                                    ");
        int indexY = 0;
        int indexX;
        System.out.println("\n\t\tYour Board\t\t\t\t\t\tComputer's Board");
        for (String[] row : board_2D) { //red color for even rows
            if (indexY % 2 == 0) {
                System.out.printf(red+"% 2d",indexY);
                System.out.print(" |");
                for (String column : board_2D[0]) {
                    System.out.print("   |");
                }
                System.out.print("\t\t");
                System.out.printf(red+"% 2d",indexY);
                System.out.print(" |");
                indexY++;
                for (String column : board_2D[0]) {
                    System.out.print("   |");
                }
            } else {
                System.out.printf("% 2d",indexY);
                System.out.print(" |");
                for (String column : board_2D[0]) {
                    System.out.print("   |");
                }
                System.out.print("\t\t");
                System.out.printf("% 2d",indexY);
                System.out.print(" |");
                indexY++;
                for (String column : board_2D[0]) {
                    System.out.print("   |");
                }
            }
            System.out.println("\n---|–––|–––|–––|–––|–––|–––|–––|–––|–––|–––|\t\t---|–––|–––|–––|–––|–––|–––|–––|–––|–––|–––|");
        }
        System.out.print("   |");
        for (indexX = 0; indexX <10; indexX++) {
            System.out.printf("% 1d", indexX);
            System.out.print(" |");
        }
        System.out.print("\t\t");
        System.out.print("   |");
        for (indexX = 0; indexX <10; indexX++) {
            System.out.printf("% 1d", indexX);
            System.out.print(" |");
        }
        System.out.println("\n");
    }
    public static int IAx() {
        int posX;
        posX = (int) (Math.random()*10);
        return posX;
    }
    public static int IAy() {
        int posY;
        posY = (int) (Math.random()*10);
        return posY;
    }
    public static void AdvancedIA(int X, int Y) {
        
    }
    public static String[][] CompPos() {
        String CompXY [][] = new String[10][10];
        int x;
        int y;
        for (int i = 0; i < 10; i++) {
            x = IAx();
            y = IAy();
            while (CompXY[x][y] != null) {
                x = IAx();
                y = IAy();
            }
            CompXY[x][y]="@";
        }
        return CompXY;
    }
    public static String[][] UserPos() {
        String UserXY [][] = new String[10][10];
        int x;
        int y;
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter X Y coordinates: ");
            x = K.nextInt();
            y = K.nextInt();
            while (UserXY[x][y] != null) {
                System.out.println("Those coordinates are already in use, select other coordinates!");
                System.out.print("Enter X Y coordinates: ");
                x = K.nextInt();
                y = K.nextInt();
            }
            UserXY[x][y]="@";
        }
        System.out.println("\n");
        return UserXY;
    }
    public static boolean CompTurn(String[][] CompHits, String[][] UserXY_Ships) {
        boolean HIT = false;
        int x;
        int y;
        do {
            x = IAx();
            y = IAy();
        } while (CompHits[x][y] != null);
        if (UserXY_Ships[x][y] != null) {
            UserXY_Ships[x][y] = "#";
            CompHits[x][y] = "@";
            HIT = true;
        } else {
            CompHits[x][y] = "X";
        }
        return HIT;
    }
    public static boolean UserTurn(String[][] UserHits, String[][] CompXY_Ships) {
        boolean HIT = false;
        int x;
        int y;
        do {
            System.out.println("Enter X Y coordinates to attack:");
            x = K.nextInt();
            y = K.nextInt();
        } while (UserHits[x][y] != null);
        if (CompXY_Ships[x][y] != null) {
            UserHits[x][y] = "#";
            HIT = true;
        } else {
            UserHits[x][y] = "X";
        }
        return HIT;
    }
    public static void Board(String[][] UserXY_Ships, String[][] CompHits, String[][] UserHits, String[][] CompXY_Ships) {
        String board_2D[][] = new String [10][10];
        int indexY;
        int indexX;
        System.out.println("\n\t\tYour Board\t\t\t\t\t\tComputer's Board");
        for (indexY = 0; indexY < board_2D.length; indexY++) { //red color for even rows
            if (indexY % 2 == 0) {
                System.out.printf(red+"% 2d",indexY);
                System.out.print(" |");
                for (indexX = 0; indexX < board_2D[0].length; indexX++) {
                    if (CompHits[indexY][indexX] != null && UserXY_Ships[indexY][indexX] != null) {
                        System.out.print(" # |");
                    } else if (UserXY_Ships[indexY][indexX] != null) {
                        System.out.print(" @ |");
                    } else if (CompHits[indexY][indexX] != null) {
                        System.out.print(" X |");
                    } else {
                        System.out.print("   |");
                    }
                }
                System.out.print("\t\t");
                System.out.printf(red+"% 2d",indexY);
                System.out.print(" |");
                for (indexX = 0; indexX < board_2D[0].length; indexX++) {
                    if (UserHits[indexY][indexX] != null && CompXY_Ships[indexY][indexX] != null) {
                        System.out.print(" # |");
                    } else if (UserHits[indexY][indexX] != null) {
                        System.out.print(" X |");
                    } else {
                        System.out.print("   |");
                    }
                }
            } else {
                System.out.printf("% 2d",indexY);
                System.out.print(" |");
                for (indexX = 0; indexX < board_2D[0].length; indexX++) {
                    if (CompHits[indexY][indexX] != null && UserXY_Ships[indexY][indexX] != null) {
                        System.out.print(" # |");
                    } else if (UserXY_Ships[indexY][indexX] != null) {
                        System.out.print(" @ |");
                    } else if (CompHits[indexY][indexX] != null) {
                        System.out.print(" X |");
                    } else {
                        System.out.print("   |");
                    }
                }
                System.out.print("\t\t");
                System.out.printf("% 2d",indexY);
                System.out.print(" |");
                for (indexX = 0; indexX < board_2D[0].length; indexX++) {
                    if (UserHits[indexY][indexX] != null && CompXY_Ships[indexY][indexX] != null) {
                        System.out.print(" # |");
                    } else if (UserHits[indexY][indexX] != null) {
                        System.out.print(" X |");
                    } else {
                        System.out.print("   |");
                    }
                }
            }
            System.out.println("\n---|–––|–––|–––|–––|–––|–––|–––|–––|–––|–––|\t\t---|–––|–––|–––|–––|–––|–––|–––|–––|–––|–––|");
        }
        System.out.print("   |");
        for (indexX = 0; indexX <10; indexX++) {
            System.out.printf("% 1d", indexX);
            System.out.print(" |");
        }
        System.out.print("\t\t");
        System.out.print("   |");
        for (indexX = 0; indexX <10; indexX++) {
            System.out.printf("% 1d", indexX);
            System.out.print(" |");
        }
        System.out.println("\n");
    }
    public static void main(String[] args) {
        InitBoard();
        game();
    }
    
    public static void game() {
        int Turn = 1;
        int CompCounter = 0;
        int UserCounter = 0;
        boolean GameResult = false;
        String[][] CompXY_Ships = CompPos();
        String[][] CompHits = new String [10][10];
        String[][] UserXY_Ships = UserPos();
        String[][] UserHits = new String [10][10];
        while (CompCounter < 10 || UserCounter < 10) {
            Board(UserXY_Ships, CompHits, UserHits, CompXY_Ships);
            if (UserTurn(UserHits, CompXY_Ships)) UserCounter++;
            if (CompTurn(CompHits, UserXY_Ships)) CompCounter++;
            System.out.println("Turn: "+Turn+"\nRival Hits: "+CompCounter + "\nUser Hits: " + UserCounter);
            Turn++;
        }    
        if (UserCounter == 10) GameResult = true;
        if (CompCounter == 10) GameResult = false;
        if (GameResult) System.out.println("USER WINS!");
        else System.out.println("COMPUTER WINS!");
        System.exit(0);
    }
}

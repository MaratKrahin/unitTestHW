import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] motions = new char[3][3];

        for (int i = 0; i < 9; i++) {
            System.out.printf("Ход игрока %d, введите координаты (через пробел)\n", i % 2 + 1);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (stepAndCheckWin(motions, x, y, (i % 2 == 0) ? 'X' : 'O')) {
                break;
            }
        }
        System.out.println("Game Finished");
    }

    public static boolean stepAndCheckWin(char[][] motions, int x, int y, char symbol) {
        motions[x][y] = symbol;
        printField(motions);
        return checkStatus(motions);
    }

    private static void printField(char[][] motions) {
        for (int i = 0; i < motions.length; i++) {
            for (int j = 0; j < motions[i].length; j++) {
                System.out.printf("%s", motions[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean checkStatus(char[][] motions) {
        if (motions[0][0] != 0 && motions[0][0] == motions[0][1] && motions[0][1] == motions[0][2]) {
            System.out.printf("Win %s\n", motions[0][1]);
            return true;
        }
        if (motions[1][0] != 0 && motions[1][0] == motions[1][1] && motions[1][1] == motions[1][2]) {
            System.out.printf("Win %s\n", motions[1][0]);
            return true;
        }
        if (motions[2][0] != 0 && motions[2][0] == motions[2][1] && motions[2][1] == motions[2][2]) {
            System.out.printf("Win %s\n", motions[2][0]);
            return true;
        }
        if (motions[0][0] != 0 && motions[0][0] == motions[1][0] && motions[1][0] == motions[2][0]) {
            System.out.printf("Win %s\n", motions[0][0]);
            return true;
        }
        if (motions[0][1] != 0 && motions[0][1] == motions[1][1] && motions[1][1] == motions[2][1]) {
            System.out.printf("Win %s\n", motions[1][0]);
            return true;
        }
        if (motions[0][2] != 0 && motions[0][2] == motions[1][2] && motions[1][2] == motions[2][2]) {
            System.out.printf("Win %s\n", motions[2][0]);
            return true;
        }
        if (motions[0][0] != 0 && motions[0][2] == motions[1][1] && motions[1][1] == motions[2][0]) {
            System.out.printf("Win %s\n", motions[0][0]);
            return true;
        }
        if (motions[0][2] != 0 && motions[0][2] == motions[1][1] && motions[1][1] == motions[2][0]) {
            System.out.printf("Win %s\n", motions[0][0]);
            return true;
        }
        return false;
    }
}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        fill(0, 0);
        print();
    }

    private static boolean fill(int row, int col) {
        if (row == 9) {
            return true;
        }
        if (col == 9) {
            return fill(row + 1, 0);
        }

        if (board[row][col] == 0) {
            boolean[] used = new boolean[10];
            for (int i = 0; i < 9; i++) {
                used[board[row][i]] = true;
                used[board[i][col]] = true;
            }
            int i1 = (row / 3) * 3;
            int j1 = (col / 3) * 3;
            for (int i = i1; i < i1 + 3; i++) {
                for (int j = j1; j < j1 + 3; j++) {
                    used[board[i][j]] = true;
                }
            }
            for (int i = 1; i <= 9; i++) {
                if (!used[i]) {
                    board[row][col] = i;
                    if (fill(row, col + 1)) {
                        return true;
                    }
                }
            }
            board[row][col] = 0;
            return false;
        } else {
            return fill(row, col + 1);
        }
    }

    private static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
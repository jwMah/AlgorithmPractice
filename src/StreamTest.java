import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        int[][] clone = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            clone[i] = grid[i].clone();
        }


        int[] temp;
        for (int i = 0; i < grid.length; i++) {
            temp = clone[i].clone();
            for (int j = 0; j < grid.length; j++) {
                grid[j][grid.length - 1 - i] = temp[j];
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

}

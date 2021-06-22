package bj1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input[] = in.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int min = 64;
        grid = new char[m][n];
        Main a = new Main();
        for(int i=0; i<m; i++){
            String line = in.readLine();
            for(int j=0; j<n; j++)
                grid[i][j] = line.charAt(j);
        }
        int row = m-8+1;
        int col = n-8+1;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                min = Math.min(min,a.numOfChange(i,j));
            }
        }
        System.out.println(min);
    }
    public int numOfChange(int x, int y){
        int num = 0;
        int x_end = x+8;
        int y_end = y+8;
        char[][] chess = new char[8][8];
        int r=0;
        for(int i=x;i<x_end;i++){
            int c = 0;
            for(int j=y;j<y_end;j++){
                chess[r][c++] = grid[i][j];
            }
            r++;
        }
        if(chess[x][y] == 'B'){ //왼쪽 맨 위 칸이 B
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    //B여야하는 위치 : i가 0, 2, 4, ...(짝수)이면 j는 0, 2 , 4 (짝수)
                    if(i % 2 == 0){ //높이가 0, 2,4,..짝수
                        if(j % 2 == 0 && chess[i][j] == 'B')
                            continue;
                        else if(j % 2 == 1 && chess[i][j] == 'W')
                            continue;
                        else
                            num++;
                    }//W여야하는 위치 : i가 1,3,5,7,... (홀수)이면 j도 1,3,5,7,...(홀수)
                    else{//높이 홀수
                        if(j % 2 == 0 && chess[i][j] == 'W')
                            continue;
                        else if(j % 2 == 1 && chess[i][j] == 'B')
                            continue;
                        else
                            num++;
                    }
                }
            }
        }
        else{
            for(int i=0;i<8;i++) {
                for (int j=0;j<8;j++) {
                    //B여야하는 위치 : i가 0, 2, 4, ...(짝수)이면 j는 0, 2 , 4 (짝수)
                    if(i % 2 == 0){ //높이가 0, 2,4,..짝수
                        if(j % 2 == 0 && chess[i][j] == 'W')
                            continue;
                        else if(j % 2 == 1 && chess[i][j] == 'B')
                            continue;
                        else
                            num++;
                    }//W여야하는 위치 : i가 1,3,5,7,... (홀수)이면 j도 1,3,5,7,...(홀수)
                    else{//높이 홀수
                        if(j % 2 == 0 && chess[i][j] == 'B')
                            continue;
                        else if(j % 2 == 1 && chess[i][j] == 'W')
                            continue;
                        else
                            num++;
                    }
                }
            }
        }
        return num;
    }
}

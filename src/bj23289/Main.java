package bj23289;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static int r, c;
    static int[][] grid; //방 배치 정보
    static int[][] temperature; //방 온도 정보

    static int[][] heat_temp;


    static int[][] dirs = {{0,0},{0,1},{0,-1},{-1,0},{1,0}};
    static HashMap<Integer,int[][]> heat_map = new HashMap<>();
    static boolean[][][] wallMap;
    static boolean[][][][] controlMap;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        int k = sc.nextInt();
        grid = new int[r + 1][c + 1];
        temperature = new int[r+1][c+1];
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int w = sc.nextInt();
        wallMap = new boolean[r+2][c+2][2];
        for (int i = 0; i < w; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int t = sc.nextInt();
            wallMap[x][y][t] = true;
        }
        heat_map.put(1,new int[][]{{-1,1},{0,1},{1,1}});
        heat_map.put(2,new int[][]{{-1,-1},{0,-1},{1,-1}});
        heat_map.put(3,new int[][]{{-1,-1},{-1,0},{-1,1}});
        heat_map.put(4,new int[][]{{1,-1},{1,0},{1,1}});
        int eat_choco = 0;
        while(true) {
            heat();
            temperature_control();
            outside_decrease();
            eat_choco++;
            if(eat_choco > 100) {
                break;
            }
            if(check(k)) {
                break;
            }
        }
        print2();
        System.out.println(eat_choco);
    }

    private static void temperature_control() {
        heat_temp = new int[r+1][c+1];
        controlMap = new boolean[r+2][c+2][r+2][c+2];
        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                control(i,j);
            }
        }
        copyToTemp();
    }

    private static void control(int y, int x) {
        for (int i = 1; i < 5; i++) {

            int ny = y + dirs[i][0];
            int nx = x + dirs[i][1];

            if(!check2(i,y,x,ny,nx)) {
                continue;
            }

            int dif = Math.abs(temperature[y][x] - temperature[ny][nx]) / 4;
            if(temperature[y][x] < temperature[ny][nx]) {
                heat_temp[ny][nx] -= dif;
                heat_temp[y][x] += dif;
            } else {
                heat_temp[ny][nx] += dif;
                heat_temp[y][x] -= dif;
            }
            controlMap[y][x][ny][nx] = true; controlMap[ny][nx][y][x] = true;
        }
    }

    private static boolean check2(int dir, int y, int x, int ny, int nx) {
        if(ny < 1 || ny >= temperature.length || nx < 1 || nx >= temperature[0].length || controlMap[y][x][ny][nx])
            return false;
        if(dir == 1) {
            if(wallMap[y][x][1])
                return false;
            return true;
        } else if(dir == 2) {
            if(wallMap[ny][nx][1])
                return false;
            return true;
        } else if(dir == 3) {
            if(wallMap[y][x][0])
                return false;
            return true;
        } else {
            if(wallMap[ny][nx][0])
                return false;
            return true;
        }
    }

    private static void print2() {
        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                System.out.print(temperature[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void print() {
        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                System.out.print(heat_temp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void heat() {
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if(grid[i][j] >= 1 && grid[i][j] < 5) {
                    //히터가 있는 칸 발견 시
                    heat_temp = new int[r+1][c+1];
                    int dir_idx = grid[i][j];
                    int ny = i + dirs[dir_idx][0];
                    int nx = j + dirs[dir_idx][1];
                    heat_temp[ny][nx] = 5;
                    heat_dfs(ny,nx,dir_idx,5);
                    //print();
                    copyToTemp();
                }
            }
        }
    }

    private static void copyToTemp() {
        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                temperature[i][j] += heat_temp[i][j];
            }
        }
    }

    private static void heat_dfs(int y, int x, int idx,int h) {
        if(h == 0 || y < 1 || y >= heat_temp.length || x < 1 || x >= heat_temp[0].length) {
            //전파되는 온도가 1보다 작아지거나 해당 칸이 방의 범위에서 벗어나는 경우 종료
            return;
        }
        /*
        * 벽이 있을 경우 전파안되는 조건
        * */
        heat_temp[y][x] = h;
        int[][] spread_dirs = heat_map.get(idx);
        for (int i = 0; i < spread_dirs.length; i++) {
            if(!spread_check(idx,y,x,i)) {
                continue;
            }
            int ny = y + spread_dirs[i][0];
            int nx = x + spread_dirs[i][1];
            heat_dfs(ny,nx,idx,h-1);
        }

    }

    private static boolean spread_check(int idx, int y, int x, int i) {
        switch (idx) {
            case 1: //방향 오른쪽
                if(i == 0) { //오른쪽 위
                    if(wallMap[y][x][0] || wallMap[y-1][x][1])
                        return false;
                    return true;
                }
                if(i == 1) { //오른쪽
                    if(wallMap[y][x][1])
                        return false;
                    return true;
                }
                if(i == 2) {
                    if(wallMap[y+1][x][0] || wallMap[y+1][x][1])
                        return false;
                    return true;
                }
            case 2: //왼쪽
                if(i == 0) {
                    if(wallMap[y][x][0] || wallMap[y-1][x-1][1])
                        return false;
                    return true;
                }
                if(i == 1) {
                    if(wallMap[y][x-1][1])
                        return false;
                    return true;
                }
                if(i == 2) {
                    if(wallMap[y+1][x][0] || wallMap[y+1][x-1][1])
                        return false;
                    return true;
                }
            case 3: //위
                if(i == 0) { //위쪽에서 왼쪽
                    if(wallMap[y][x-1][0] || wallMap[y][x-1][1])
                        return false;
                    return true;
                }
                if(i == 1) {
                    if(wallMap[y][x][0])
                        return false;
                    return true;
                }
                if(i == 2) { //위쪽에서 오른쪽
                    if(wallMap[y][x-1][0] || wallMap[y][x][1])
                        return false;
                    return true;
                }
            case 4: //아래
                if(i == 0) {//아래 왼쪽
                    if(wallMap[y+1][x-1][0] || wallMap[y][x-1][1])
                        return false;
                    return true;
                }
                if(i == 1) { //아래 가운데
                    if(wallMap[y+1][x][0])
                        return false;
                    return true;
                }
                if(i == 2) { //아래 오른쪽
                    if(wallMap[y+1][x][1] || wallMap[y+1][x+1][0])
                        return false;
                    return true;
                }

        }
        return false;
    }

    private static void outside_decrease() {
        for (int i = 1; i < temperature.length; i++) {
            for (int j = 1; j < temperature[0].length; j++) {
                if(i == 1 || i == temperature.length - 1) {
                    if(temperature[i][j] >= 1)
                        temperature[i][j]--;
                } else {
                    if(j == 1 || j == temperature[0].length - 1) {
                        if(temperature[i][j] >= 1)
                            temperature[i][j]--;
                    }
                }
            }
        }
    }

    private static boolean check(int k) {
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if(grid[i][j] == 5 && temperature[i][j] < k)
                    return false;
            }
        }
        return true;
    }
}

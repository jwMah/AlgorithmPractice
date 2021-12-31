package bj21608;

import java.util.*;

public class Main {
    static int N;
    static int[][] grid;
    static int[][] classroom;
    static Map<Integer,int[]> map;
    static int[][] abs = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new int[N+1][N+1];
        map = new HashMap<>();
        for (int i = 0; i < N * N; i++) {
            int student = sc.nextInt();
            int like1 = sc.nextInt();
            int like2 = sc.nextInt();
            int like3 = sc.nextInt();
            int like4 = sc.nextInt();
            map.put(student,new int[]{like1,like2,like3,like4});
            find_seat(student, new int[]{like1,like2,like3,like4});
        }

        int ans = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                int like_count = likeCount(i,j,grid[i][j]);
                if(like_count == 2){
                    like_count = 10;
                } else if(like_count == 3) {
                    like_count = 100;
                } else if(like_count == 4) {
                    like_count = 1000;
                } else {

                }
                ans += like_count;
            }
        }

        System.out.println(ans);
    }

    private static int likeCount (int i, int j, int student) {
        int count = 0;
        //int[] friends = new int[]{0,0,0,0};
//        if(map.containsKey(student)) {
//            int[] friends = map.get(student);
//        } else {
//            return 0;
//        }
        int[] friends = map.get(student);
        for (int[] a : abs) {
            int y = i + a[0];
            int x = j + a[1];
            if(y < 1 || y >= N+1 || x < 1 || x >= N+1)
                continue;

            for (int friend : friends) {
                if(grid[y][x] == friend)
                    count++;
            }
        }
        return count;
    }

    public static void find_seat(int student, int[] friends) {
        classroom = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(grid[i][j] == 0) {
                    classroom[i][j] = friendsNumCount(i,j,friends);
                }
            }
        }

        int max = 0;
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                max = Math.max(classroom[i][j],max);
            }
        }

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(classroom[i][j] == max) {
                    list.add(new int[]{i,j});
                }
            }
        }

        if(list.size() > 1) {
            int[] index = findOneSeat(list);
            grid[index[0]][index[1]] = student;
        } else {
            int[] index = list.get(0);
            grid[index[0]][index[1]] = student;
        }
    }

    private static int[] findOneSeat(ArrayList<int[]> list) {
        int max = 0;
        classroom = new int[N+1][N+1];

        for (int[] ints : list) {
            int count = 0;
            for (int[] a : abs) {
                int y = ints[0] + a[0];
                int x = ints[1] + a[1];

                if(y < 1 || y >= N+1 || x < 1 || x >= N+1)
                    continue;
                if(grid[y][x] == 0)
                    count++;
            }
            max = Math.max(max,count);
            classroom[ints[0]][ints[1]] = count;
        }

        int y = -1;
        int x = -1;

        for (int i = N; i > 0; i--) {
            for (int j = N; j > 0; j--) {
                if(classroom[i][j] == max) {
                    y = i;
                    x = j;
                }
            }
        }

        return new int[]{y,x};
    }


    private static int friendsNumCount(int i, int j, int[] friends) {
        int count = 0;
        for (int[] a : abs) {
            int y = i + a[0];
            int x = j + a[1];

            if(y < 1 || y >= N+1 || x < 1 || x >= N+1)
                continue;
            for (int friend : friends) {
                if(grid[y][x] == friend)
                    count++;
            }
        }
        return count;
    }
}

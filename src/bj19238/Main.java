package bj19238;

import java.util.*;

public class Main {
    static int[][] grid;
    static int[][] passenger;
    static int N,M,fuel,y,x,move_count, ride_count;
    static List<int[]> list;
    //static Map<int[],int[]> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        fuel = sc.nextInt();
        grid = new int[N+1][N+1];
        list = new ArrayList<>();
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        //taxi pos
        y = sc.nextInt();
        x = sc.nextInt();


        for (int i = 2; i < M+2; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int dest_r = sc.nextInt();
            int dest_c = sc.nextInt();
            list.add(new int[]{r,c,dest_r,dest_c});
            //map.put(new int[]{r,c},new int[]{dest_r,dest_c});
        }
        int a = 0;

        while (!list.isEmpty()) {
            passenger = new int[N+1][N+1];
            int passenger_y = -1;
            int passenger_x = -1;
            findPassenger();

            for (int i = passenger.length - 1; i > 0; i--) {
                for (int j = passenger[0].length - 1; j > 0; j--) {
                    if(passenger[i][j] == 1) {
                        passenger_y = i;
                        passenger_x = j;
                    }
                }
            }

            if(passenger_y == -1 && passenger_x == -1) {
                fuel = -1;
                break;
            }

            fuel -= move_count;
            y = passenger_y;
            x= passenger_x;

            //System.out.println(y + "," + x);
            //System.out.println("fuel : " + fuel);

            if(fuel < 0) {
                fuel = -1;
                break;
            }

            int dest_y = -1;
            int dest_x = -1;
            int[] dest = new int[]{-1,-1,-1,-1};
            for (int[] ints : list) {
                if(y == ints[0] && x == ints[1]) {
                    dest = ints;
                    dest_y = ints[2];
                    dest_x = ints[3];
                }
            }
            //System.out.println(dest_y + "," + dest_x);

            findAndMove2(dest_y,dest_x);

            if(ride_count == 0) {
                fuel = -1;
                break;
            }
            fuel -= ride_count;

            if(fuel < 0) {
                fuel = -1;
                break;
            }

            fuel += ride_count;
            fuel += ride_count;
            //System.out.println("fuel : " + fuel);
            list.remove(dest);
            y = dest_y;
            x = dest_x;
        }

        System.out.println(fuel);
    }

    private static void findPassenger() {
        boolean[][] visited = new boolean[N+1][N+1];
        Queue<int[]> queue = new LinkedList<>();
        int min_count = Integer.MAX_VALUE;
        move_count = 0;
        queue.offer(new int[]{y,x,0});
        visited[y][x] = true;
        while(!queue.isEmpty()) {
            int[] start = queue.poll();
            int count = start[2];
            for (int[] ints : list) {
                if(start[0] == ints[0] && start[1] == ints[1] && count <= min_count) {
                    //System.out.println("dest : " + start[0] + ", " + start[1]);
                    min_count = count;
                    passenger[start[0]][start[1]] = 1;
                }
            }
            for (int[] dir : dirs) {
                int ny = start[0] + dir[0];
                int nx = start[1] + dir[1];

                if(ny < 1 || ny >= N+1 || nx < 1 || nx >= N+1 || grid[ny][nx] == 1 || visited[ny][nx]) {
                    continue;
                }

                visited[ny][nx] = true;
                queue.offer(new int[]{ny,nx,count + 1});

            }
        }
        move_count = min_count;
    }

    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void findAndMove2(int dest_y, int dest_x) {
        boolean[][] visited = new boolean[N+1][N+1];
        Queue<int[]> queue = new LinkedList<>();
        ride_count = 0;
        queue.offer(new int[]{y,x,0});
        visited[y][x] = true;
        while(!queue.isEmpty()) {
            int[] start = queue.poll();
            int count = start[2];
            if(start[0] == dest_y && start[1] == dest_x) {
                ride_count = count;
                return;
            }
            for (int[] dir : dirs) {
                int ny = start[0] + dir[0];
                int nx = start[1] + dir[1];

                if(ny < 1 || ny >= N+1 || nx < 1 || nx >= N+1 || grid[ny][nx] == 1 || visited[ny][nx]) {
                    continue;
                }

                visited[ny][nx] = true;
                queue.offer(new int[]{ny,nx,count + 1});

            }
        }
    }
}

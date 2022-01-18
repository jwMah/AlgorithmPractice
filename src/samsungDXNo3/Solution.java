package samsungDXNo3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static UserSolution usersolution = new UserSolution();
    private static BufferedReader br;
    private static StringTokenizer line;

    private static final int MALE = 0;
    private static final int FEMALE = 1;

    private static final int INIT = 0;
    private static final int ADDMEMBER = 1;
    private static final int GETDISTANCE = 2;
    private static final int COUNTMEMBER = 3;

    private static final int COUPLE = 0;
    private static final int PARENT = 1;
    private static final int CHILD = 2;

    private static final int NAME_LEN_MAX = 19;

    private static int score = 0;

    private static void toArray(char dst[], String s) {
        for (int i = 0; i < s.length(); i++)
            dst[i] = s.charAt(i);
        dst[s.length()] = 0;
    }

    private static void cmd_init() {
        String buf;

        char initialMemberName[] = new char[NAME_LEN_MAX + 1];
        buf = line.nextToken();
        toArray(initialMemberName, buf);

        int initialMemberSex = Integer.parseInt(line.nextToken());

        usersolution.init(initialMemberName, initialMemberSex);
    }

    private static void cmd_addMember() {
        String buf;

        char newMemberName[] = new char[NAME_LEN_MAX + 1];
        buf = line.nextToken();
        toArray(newMemberName, buf);

        int newMemberSex = Integer.parseInt(line.nextToken());

        int relationship = Integer.parseInt(line.nextToken());

        char existingMemberName[] = new char[NAME_LEN_MAX + 1];
        buf = line.nextToken();
        toArray(existingMemberName, buf);

        boolean userAns = usersolution.addMember(newMemberName, newMemberSex, relationship, existingMemberName);

        int ans = Integer.parseInt(line.nextToken());
        boolean ansbool = ans == 1 ? true : false;

        if (ansbool != userAns) {
            score = 0;
        }
    }

    private static void cmd_getDistance() {
        String buf;

        char nameA[] = new char[NAME_LEN_MAX + 1];
        buf = line.nextToken();
        toArray(nameA, buf);

        char nameB[] = new char[NAME_LEN_MAX + 1];
        buf = line.nextToken();
        toArray(nameB, buf);

        int userAns = usersolution.getDistance(nameA, nameB);
        int ans = Integer.parseInt(line.nextToken());

        if (ans != userAns) {
            score = 0;
        }
    }

    private static void cmd_countMember() {
        String buf;

        char name[] = new char[NAME_LEN_MAX + 1];
        buf = line.nextToken();
        toArray(name, buf);

        int dist = Integer.parseInt(line.nextToken());

        int userAns = usersolution.countMember(name, dist);
        System.out.println("나의 멤버 수 정답 : " + userAns);
        int ans = Integer.parseInt(line.nextToken());
        System.out.println("주어진 멤버 수 정답 : " + ans);
        if (ans != userAns) {
            score = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new java.io.FileInputStream("/Users/mah/sample_input2.txt"));

        br = new BufferedReader(new InputStreamReader(System.in));
        line = new StringTokenizer(br.readLine(), " ");

        int TC = Integer.parseInt(line.nextToken());
        int scoreIdx = Integer.parseInt(line.nextToken());

        for (int testcase = 1; testcase <= TC; testcase++) {
            score = scoreIdx;

            line = new StringTokenizer(br.readLine(), " ");
            int cmdCnt = Integer.parseInt(line.nextToken());

            for (int cmdIdx = 0; cmdIdx < cmdCnt; ++cmdIdx) {
                line = new StringTokenizer(br.readLine(), " ");
                int c_num = Integer.parseInt(line.nextToken());

                switch (c_num) {
                    case INIT:
                        cmd_init();
                        break;

                    case ADDMEMBER:
                        cmd_addMember();
                        break;

                    case GETDISTANCE:
                        cmd_getDistance();
                        break;

                    case COUNTMEMBER:
                        cmd_countMember();
                        break;

                    default:
                        break;
                }
            }
            System.out.println("#" + testcase + " " + (score == scoreIdx ? scoreIdx : 0));
        }
    }
}

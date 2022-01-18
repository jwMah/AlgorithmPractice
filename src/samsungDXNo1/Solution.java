package samsungDXNo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    private final static int CMD_INIT				= 1;
    private final static int CMD_BUY				= 2;
    private final static int CMD_SELL				= 3;
    private final static int CMD_CANCEL				= 4;
    private final static int CMD_BEST_PROFIT		= 5;

    private final static UserSolution usersolution = new UserSolution();

    private static boolean run(BufferedReader br) throws Exception
    {
        StringTokenizer st;

        int numQuery;

        int mNumber, mStock, mQuantity, mPrice;

        int userAns, ans;

        boolean isCorrect = false;

        numQuery = Integer.parseInt(br.readLine());

        for (int q = 0; q < numQuery; ++q)
        {
            st = new StringTokenizer(br.readLine(), " ");

            int cmd;
            cmd = Integer.parseInt(st.nextToken());

            switch(cmd)
            {
                case CMD_INIT:
                    usersolution.init();
                    isCorrect = true;
                    break;
                case CMD_BUY:
                    mNumber = Integer.parseInt(st.nextToken());
                    mStock = Integer.parseInt(st.nextToken());
                    mQuantity = Integer.parseInt(st.nextToken());
                    mPrice = Integer.parseInt(st.nextToken());
                    userAns = usersolution.buy(mNumber, mStock, mQuantity, mPrice);
                    ans = Integer.parseInt(st.nextToken());
                    if (userAns != ans) {
                        isCorrect = false;
                    }
                    break;
                case CMD_SELL:
                    mNumber = Integer.parseInt(st.nextToken());
                    mStock = Integer.parseInt(st.nextToken());
                    mQuantity = Integer.parseInt(st.nextToken());
                    mPrice = Integer.parseInt(st.nextToken());
                    userAns = usersolution.sell(mNumber, mStock, mQuantity, mPrice);
                    ans = Integer.parseInt(st.nextToken());
                    if (userAns != ans) {
                        isCorrect = false;
                    }
                    break;
                case CMD_CANCEL:
                    mNumber = Integer.parseInt(st.nextToken());
                    usersolution.cancel(mNumber);
                    break;
                case CMD_BEST_PROFIT:
                    mStock = Integer.parseInt(st.nextToken());
                    userAns = usersolution.bestProfit(mStock);
                    ans = Integer.parseInt(st.nextToken());
                    if (userAns != ans) {
                        isCorrect = false;
                    }
                    break;
                default:
                    isCorrect = false;
                    break;
            }
        }

        return isCorrect;
    }

    public static void main(String[] args) throws Exception
    {
        int TC, MARK;

        System.setIn(new java.io.FileInputStream("/Users/mah/sample_input1.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        TC = Integer.parseInt(st.nextToken());
        MARK = Integer.parseInt(st.nextToken());

        for (int testcase = 1; testcase <= TC; ++testcase)
        {
            int score = run(br) ? MARK : 0;
            //usersolution.mapListPrint();
            System.out.println("#" + testcase + " " + score);
        }

        br.close();
    }
}

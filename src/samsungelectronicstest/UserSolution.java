package samsungelectronicstest;



public class UserSolution {
    public final static int N = 4;
    //public static int[][] record = new int[N][10];
    public static int[] guess_result;

    public static void randomFunction(int hit, int miss){

        int hit_count = hit;
        int miss_count = miss;
        for(int i=0;i<guess_result.length;i++){
            //guess_result[i] = random.nextInt(10);
            for(int j=0;j<i;j++){
                if(guess_result[i] == guess_result[j])
                    i--;
            }
        }
    }

    public void doUserImplementation(int guess[]) {
        // Implement a user's implementation function
        //
        // The array of guess[] is a return array that
        // is your guess for what digits[] would be.
        Solution.Result result = new Solution.Result();
        guess_result = guess;

        randomFunction(0,0);
        result = Solution.query(guess_result);
        while(result.hit < N){
            if(result.hit == 0){
                if(result.miss == 0){
                    randomFunction(0,0);
                    result = Solution.query(guess_result);
                    continue;
                } else if(result.miss == 1){
                    randomFunction(0,1);
                    result = Solution.query(guess_result);
                    continue;
                } else if(result.miss == 2){

                } else if(result.miss == 3){

                } else {

                }
            }

            if(result.hit == 1){
                if(result.miss == 0){
                    //int except = random.nextInt(3);
                } else if(result.miss == 1){

                } else if(result.miss == 2){

                } else {

                }
            }

            if(result.hit == 2){
                if(result.miss == 0){

                } else if(result.miss == 1){

                } else {

                }
            }

            if(result.hit == 3){
                if(result.miss == 0){

                } else if(result.miss == 1){

                } else {

                }
            }


        }

    }
}

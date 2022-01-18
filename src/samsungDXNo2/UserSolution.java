package samsungDXNo2;

class UserSolution
{
    // Main API :
    //   Solution.fire(int r, int c)

    private final static int MISS 		= 0;
    private final static int CARRIER 	= 1;
    private final static int BATTLESHIP = 2;
    private final static int CRUISER 	= 3;
    private final static int SUBMARINE 	= 4;
    private final static int DESTROYER 	= 5;
    private static int l;
    public void init(int limit)
    {
         l = limit;
    }

    public void play()
    {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int result = Solution.fire(i,j);
                if(result != MISS) {
                    //물체 타격시

                }
            }
        }
    }
}

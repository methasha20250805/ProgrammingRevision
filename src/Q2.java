public class Q2 {
 //To calculate the sum of the array
    public static int sum(int[] values){
        int sum = 0;
        for (int value : values){
            sum += value;
        }
        return sum;
    }
// To calculate  the strike rate
    public static double strikeRate(int runs,int balls){
        if(balls==0){
            return 0;
        }
        return runs*100.0/balls;
    }

    public static int topScorerIndex(int[] runs){
        int highestIndex = 0;

        for (int i=0; i<runs.length; i++){
            if(runs[i]>runs[highestIndex]){
                highestIndex = i;
            }
        }
        return highestIndex;
    }

    public static int countDucks(int[] runs){
        int count = 0;
        for (int i=0; i<runs.length; i++){
            if (i == 0){
            count++;
            }
        }
        return count;
    }

    public static void printScorecard(String[] names, int[] runs, int[] balls) {

        System.out.println("Batter Runs Balls SR");

        for (int i = 0; i < names.length; i++) {
            double sr = strikeRate(runs[i], balls[i]);

            System.out.printf(
                    "%-10s%5d%7d%9.2f%n",
                    names[i], runs[i], balls[i], sr
            );
        }

        System.out.println("--------------------------------");

        int totalRuns = sum(runs);
        int totalBalls = sum(balls);

        System.out.println(
                "Total: " + totalRuns + " runs off " + totalBalls + " balls"
        );

        System.out.printf(
                "Team strike rate: %.2f%n",
                strikeRate(totalRuns, totalBalls)
        );

        int topIndex = topScorerIndex(runs);

        System.out.println(
                "Top scorer: " + names[topIndex] + " (" + runs[topIndex] + ")"
        );

        System.out.println("Ducks: " + countDucks(runs));



        }

    public static void main(String[] args) {
        String[] names = {"Nimal", "Pathum", "Ruwan", "Saman", "Dinesh"};
        int[] runs = {45, 12, 78, 0, 33};
        int[] balls = {38, 20, 52, 3, 25};
        printScorecard(names, runs, balls);
    }
    }



package org.example.algoritmica.progdinamic;

public class CoinChange {

    public static int countWays(int[] coins, int suma, int pos, String way) {
        //System.out.println("sum: " + suma);
        if (suma == 0) {
            System.out.println("way: " + way);
            return 1;
        }
        if (suma < 0) {
            //System.out.println("way: " + way);
            return 0;
        }

        int result = 0;
        for (int i = pos; i < coins.length; i++) {
            result += countWays(coins, suma - coins[i], i, way + " " + coins[i]);
        }
        return result;
    }

//    public static int countWays(int[] coins, int suma, int acumulado, int pos, String way) {
//        //System.out.println("sum: " + suma);
//        if (acumulado == suma) {
//            System.out.println("way: " + way);
//            return 1;
//        }
//        if (acumulado > suma) {
//            System.out.println("way: " + way);
//            return 0;
//        }
//
//        int result = 0;
//        for (int i = pos; i < coins.length; i++) {
//            result += countWays(coins, suma, acumulado + coins[i], i, way + " " + coins[i]);
//        }
//        return result;
//    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3};
        System.out.println("countWays: " + countWays(coins, 4, 0, ""));

//        int[] coins = new int[]{2, 5, 3, 6};
//        System.out.println("countWays: " + countWays(coins, 10, 0, 0, ""));

        // 1 2 3
        // sum: 4, retornar: 3 1
        // sum: 5, retornar: 3 2
        // sum: 6, retornar: 3 3
        // sum: 7, retornar: 3 3 1
        // sum: 8, retornar: 3 3 2

        // 2, 3, 10
        // sum: 14, retornar: 10 2 2

        // 2, 3, 5, 6
        // suma: 11, retornar: 6 5
        // suma: 13, retornar: 6 5 2
    }

}

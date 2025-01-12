package org.example.selu.ArraysPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockBuyAndSell {

    static int stockBuySell(int[] prices) {
        // first we will get the buying stocks
        // are that which values are less than the previous ones
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // If the price on the current day is higher than the previous day
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;

    }

    /** Returns how much we are holding and how much we are getting profit
     *
     * @param prices
     * @param fee
     * @return
     */
    static int[] StockBuySellWithTransactionFee(int[] prices, int fee) {
        int hold = -prices[0];
        int cash = 0;
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i]-fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return new int[]{cash,hold};
    }

    @Deprecated
    static int stockBuySellWithMaxOne(int[] prices) {
        // first we will get the buying stocks
        // are that which values are less than the previous ones
        int maxProfit = 0;
        int localProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // If the price on the current day is higher than the previous day
            if (prices[i] > prices[i - 1]) {
                localProfit += prices[i] - prices[i - 1];
                maxProfit = Math.max(maxProfit, localProfit);
            } else {
                maxProfit = Math.max(maxProfit, localProfit);
                localProfit = 0;
            }
        }
        return maxProfit;

    }

    static int stockBuySellWithMaxOneNew(int[] prices) {
        int maxProfit = 0;
        int minProfit = Integer.MAX_VALUE;

        for(int i =0; i < prices.length; i++) {
            minProfit = Math.min(prices[i], minProfit);

            int profit = prices[i] - minProfit;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
//        System.out.println(stockBuySell(new int[]{4,2,2,4}));
//        Arrays.stream(StockBuySellWithTransactionFee(new int[]{100, 180, 260, 310, 40, 535, 695}, 100)).forEach(System.out::println);
        System.out.println(stockBuySellWithMaxOneNew(new int[]{3, 5, 1, 10}));
        System.out.println(stockBuySellWithMaxOneNew(new int[] {7, 6, 4, 3, 1} ));
        System.out.println(stockBuySellWithMaxOneNew(new int[]{1, 3, 6, 9, 11}));

    }

}

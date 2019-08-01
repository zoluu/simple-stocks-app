package StocksApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StocksApp {
    public static void main(String[] args) {
        File filePath = new File("C:/Users/zoeyl/Documents/Computer_Science/Projects/Investment_Decision_Tool_1/Data_Stocks.csv");

        // Read file date into array
        ArrayList<Stocks> stocks = new ArrayList<>();
        try (Scanner sc = new Scanner(filePath)) {
            while ((sc.hasNext())) {
                String[] line = sc.nextLine().split(",");
                Stocks s = new Stocks(line[0], line[1], line[2], line[3]);
                stocks.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Find the stocks with the minimum standard deviation, maximum expected return and maximum sharpe ratio
        Stocks minStdDevStock = stocks.stream().min(Comparator.comparingDouble(Stocks::getStandardDeviation)).get();
        Stocks maxExpReturnStock = stocks.stream().max(Comparator.comparingDouble(Stocks::getExpectedReturn)).get();
        Stocks maxSharpeRatioStock = stocks.stream().max(Comparator.comparingDouble(Stocks::getSharpeRatio)).get();

        System.out.println("Stock with the minimum standard deviation: \n" + minStdDevStock);
        System.out.println("Stock with the maximum expected return: \n" + maxExpReturnStock);
        System.out.println("Stock with the maximum sharpe ratio: \n" + maxSharpeRatioStock);
    }
}

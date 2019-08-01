package StocksApp;

public class Stocks {
    private String stockName;
    private String stockID;
    private double expectedReturn;
    private double standardDeviation;
    private double sharpeRatio;

    public Stocks(String stockName, String stockID, String expectedReturn, String standardDeviation){
        this.stockName = stockName;
        this.stockID = stockID;
        this.expectedReturn = Double.valueOf(expectedReturn);
        this.standardDeviation = Double.valueOf(standardDeviation);

        this.sharpeRatio = this.expectedReturn/this.standardDeviation;
    }

    public String getStockName() {
        return stockName;
    }

    public String getStockID() {
        return stockID;
    }

    public double getExpectedReturn() {
        return expectedReturn;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public double getSharpeRatio() {
        return sharpeRatio;
    }

    // Allow user to see the details of the stock
    @Override
    public String toString() {
        return  "  Stock Name: " + getStockName() +
                "\n   Stock ID: " + getStockID() +
                "\n   Expected Return: " + getExpectedReturn() +
                "\n   Standard Deviation " + getStandardDeviation() +
                "\n   Sharpe Ratio: " + getSharpeRatio();
    }
}

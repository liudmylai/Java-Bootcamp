## Stock Trading
Create a Stock Trading Java application using Object-Oriented Concepts, that covers every topic and concepts from module two. It is also challenge to get creative and research.

### Requirements and Features
**PERSONAL ACCOUNT**
- A personal account has a portfolio and funds available.
- The investor's portfolio tracks how many shares they own of each stock.
- Buy trades made from a personal account are free.
- Sell trades made in a personal account are immediately charged a 5% fee.

**TFSA ACCOUNT**
- A TFSA has a portfolio and funds available.
- The investor's portfolio tracks how many shares they own of each stock.
- Every trade (buy/sell) made from a TFSA is charged a 1% fee.

**TRADE**
- A trade can be: MARKET_BUY or MARKET_SELL.
- A trade is identified by the:
  - stock (AAPL, FB, GOOG, TSLA).
  - type of trade ( MARKET_BUY, MARKET_SELL ).
  - the amount of shares being purchased/sold.
  - the price of the stock at that day.

**Buy Tests**
- Shares of a stock for a Personal account increase after purchase.
- Shares of a stock for a TFSA increase after purchase.
- No shares are added in the event of insufficient funds.
- Funds available in a Personal account decrease after purchase.
- Funds available in a TFSA decrease after purchase (must account for TRADE_FEE).

**Sell Tests**
- Shares of a stock for a Personal account decrease after purchase.
- Shares of a stock for a TFSA decrease after purchase.
- No funds are added if shares being sold exceeds shares owned.
- Funds available in a Personal account increase after sale (must account for SALE_FEE).
- Funds available in a TFSA increase after sale (must account for TRADE_FEE).

### Learning Objectives
- Practice planning code around classes and objects
- Practice applying Encapsulation using getters and setters
- Practice applying Polymorphism using method overloading and method overriding
- Practice exception handling
- Practice using FileInputStream and Scanner to read data from the text file
- Practice using HashMap and Stream Pipelines
- Practice customizing equals() and hashCode()
- Practice Unit Testing and Test Driven Development

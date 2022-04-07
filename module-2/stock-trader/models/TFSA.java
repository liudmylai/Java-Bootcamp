package models;

public class TFSA extends Account {

    public TFSA (double funds) {
        super(funds);
    }
    public TFSA (TFSA source) {
        super(source);
    }
    
    @Override
    public boolean makeTrade(Trade trade) {
        return true;
    } 
}

package models;

public class Personal extends Account {

    public Personal(double funds) {
        super(funds);
    }
    public Personal(Personal source) {
        super(source);
    }

    @Override
    public boolean makeTrade(Trade trade) {
        return true;
    }

}

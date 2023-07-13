package designpattern.behavioral.interpreter.with.reflections;

public class Gallons extends Expression {
    @Override
    public String gallons(double quantity) {
        return String.valueOf(quantity);
    }

    @Override
    public String quarts(double quantity) {
        return String.valueOf(quantity * 4);
    }

    @Override
    public String pints(double quantity) {
        return String.valueOf(quantity * 8);
    }

    @Override
    public String cups(double quantity) {
        return String.valueOf(quantity * 16);
    }

    @Override
    public String tablespoons(double quantity) {
        return String.valueOf(quantity * 256);
    }
}

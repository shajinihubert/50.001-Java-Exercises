package TaxVisitor;

public class Car implements Visitable {
    private double value;

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Car (double value) {
        this.value = value;
    }

    public double getValue(){
        return value;
    }

}
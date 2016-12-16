package TaxVisitor;

public class Chocolate implements Visitable {
    private double value;

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Chocolate (double value) {
        this.value = value;
    }

    public double getValue(){
        return value;
    }

}

package TaxVisitor;

public class Electronics implements Visitable {
    private double value;

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Electronics (double value) {
        this.value = value;
    }

    public double getValue(){
        return value;
    }

}

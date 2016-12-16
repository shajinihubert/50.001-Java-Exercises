package TaxVisitor;

public class TaxVisitor implements Visitor {

    private double total = 0;
    private boolean normal = true;

    public TaxVisitor (String taxtype) {
        if (taxtype == "TAXHOLIDAY") normal = false;
    }

    @Override
    public void visit(Car c) {
        double taxrate = 0.4;
        if (!normal) taxrate = 0.3;
        total += c.getValue() * taxrate;
    }

    @Override
    public void visit(Electronics e) {
        double taxrate = 0.8;
        if (!normal) taxrate = 0.5;
        total += e.getValue() * taxrate;
    }

    @Override
    public void visit (Chocolate c) {
        double taxrate = 0.2;
        if (!normal) taxrate = 0.1;
        total += c.getValue() * taxrate;
    }

    public double getTotal () {
        return total;
    }
}


package Visitor;

public class Book implements Visitable {
    private double weight;

    public void accept(Visitor v) { //connects both parent interfaces; concrete accept
        v.visit(this);
    }

    public Book (double weight) {
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

}

package LineSegment;

public class LineSegment implements Comparable<LineSegment>{
    protected double x1, y1;
    protected double x2, y2;
    public double len;

    LineSegment(){
        x1=y1=1;
        x2=y2=2;
    }
    LineSegment(double x1, double y1, double x2, double y2) {
        this.x1 = x1; this.y1 = y1;
        this.x2 = x2; this.y2 = y2;
        this.len = Math.sqrt(Math.pow(this.x2-this.x1, 2)+Math.pow(this.y2-this.y1, 2));
    }

    public double getX1() {
        return x1;
    }
    public double getY1() {
        return y1;
    }
    public double getX2() {
        return x2;
    }
    public double getY2() {
        return y2;
    }
    public String toString() {
        return "(" + x1 + "," + y1 + "):(" + x2 + "," + y2+ ")";
    }
	@Override
	public int compareTo(LineSegment s) {
		if (this.len > s.len)
			return 1 ;
		else if (this.len == s.len)
			return 0;
		else
			return -1;
	}

}

package LineSegment;

import java.util.Collections;
import java.util.LinkedList;

public class TestCompare {
    public static void main(String[] args) {
        LinkedList<LineSegment> s = new LinkedList<LineSegment>();
        s.add(new LineSegment(0,0,1,1));
        s.add(new LineSegment(1,1,3,3));
        s.add(new LineSegment(1,0,1,1));
        Collections.sort(s);
        System.out.println(s);
    }
}

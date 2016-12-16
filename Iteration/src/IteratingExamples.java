
import java.util.Iterator;
import java.util.List;

public class IteratingExamples {
   public static int Act2Iterator(List<Integer> integers) {
            int sum = 0;
            Iterator<Integer> listSum = integers.iterator();
                while (listSum.hasNext()){
                	sum += listSum.next();
                }
                  return sum;

    }
   
   public static int Act2ForEach(List<Integer> integers) {
       int sum = 0;
       for (int i: integers) {
           sum += i;
       }
       return sum;
   }

}
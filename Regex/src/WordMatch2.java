public class WordMatch2 {
    public static boolean wordMatch(String in1, String in2) {
        boolean Found = true;
        char arr1[]=in1.toCharArray();
        char arr2[]=in2.toCharArray();
        int i = 0;
        while ((Found == true) && (i < arr1.length)) {
            boolean foundChar = false;
            int j = 0;
            while ((foundChar == false) && (j < arr2.length)) {
                if (arr1[i] == arr2[j]) foundChar = true;
                j++;
            }
            if (foundChar == false) Found = false;
            i++;
        }
        return Found;
    }
}
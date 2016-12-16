public class WordMatch {
    public static boolean wordMatch(String in1, String in2) {

        for (int i = 0; i < in1.length(); i++) {
            String input = Character.toString(in1.charAt(i));
            String stringRegex = ".*" + input + ".*";

            if (in2.matches(stringRegex)) {
                continue;
            } else return false;
        }
        return true;
    }

    public static String wordRecursive(String input1, String input2) {

        String[] splitS = input2.split(" ");
        String newinput2 = "";

        for (int i = 1; i < splitS.length; i++) {
            newinput2 = newinput2 + splitS[i] + " ";
        }

        if(wordMatch(input1,splitS[0])==true){
            return splitS[0] + " " + wordRecursive(input1,newinput2);
            }
        else if (splitS.length == 1){
            return "";
        }
        else {
            return wordRecursive(input1, newinput2);
        }
    }
}
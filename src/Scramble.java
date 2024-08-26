import java.util.ArrayList;
import java.util.List;

public class Scramble {

    public static String scrambleWord(String str) {
        if(str.length() >= 2) {
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == 'A' && str.charAt(i + 1) != 'A') {
                    str = swap(str, i);
                    i++;
                }
            }
            return str;
        }
        else return str;
    }

    public static void scrambleOrRemove(List<String> wordList) {
        /*for(int i = 0; i < wordList.size(); i++){
            if(scrambleWord(wordList.get(i)) == wordList.get(i)){
                wordList.remove(i);
            }
            else wordList.set(i, scrambleWord(wordList.get(i)));
        }*/

        List<String> modifiedWords = new ArrayList<>();

        for (String word : wordList) {
            String scrambledWord = scrambleWord(word);
            if (!scrambledWord.equals(word)) {
                modifiedWords.add(scrambledWord);
            }
        }

        wordList.clear();
        wordList.addAll(modifiedWords);
    }

    public static String swap (String str, int i){
        String swapped = str.substring(0,i) + str.charAt(i+1) + str.charAt( i) + str.substring(i+2);
        return swapped;
    }
}

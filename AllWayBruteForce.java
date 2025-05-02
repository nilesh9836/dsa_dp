import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<String>> result = allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"});
        for (List<String> way : result) {
            System.out.println(way);
        }
    }

    public static List<List<String>> allConstruct(String target, String[] wordBank) {
        if (target.equals("")) {
            List<List<String>> base = new ArrayList<>();
            base.add(new ArrayList<>()); // One valid way: the empty combination
            return base;
        }

        List<List<String>> allWays = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct(suffix, wordBank);
                for (List<String> way : suffixWays) {
                    List<String> targetWay = new ArrayList<>();
                    targetWay.add(word);
                    targetWay.addAll(way);
                    allWays.add(targetWay);
                }
            }
        }

        return allWays;
    }
}

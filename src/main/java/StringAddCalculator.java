import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        return sum(getTokens(s));
    }

    private static String[] getTokens(String s) {
        Matcher m = Pattern.compile("(//(?<del>.)\n)?(?<text>.*)").matcher(s);
        StringBuilder delimiter = new StringBuilder(",|:");

        if(m.find()) {
            delimiter.append("|" + m.group("del"));
        }
        return m.group("text").split(delimiter.toString());
    }

    private static int sum(String[] tokens) throws RuntimeException {
        return Arrays.stream(tokens).mapToInt(token -> {
            int num = Integer.parseInt(token);
            if (num < 0) throw new RuntimeException("minus no no");
            return num;
        }).sum();
    }
}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Medium_3 {
    public static void start(String args) {
        System.out.println(decode(args));
    }

    private static String decode(String source) {
        StringBuffer dest = new StringBuffer();
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            matcher.find();
            while (number-- != 0) {
                dest.append(matcher.group());
            }
        }
        return dest.toString();
    }
}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFindExample {
    public static void main(String[] args) {
        String phoneNumber = "Number 1: +7 (981) 222-22-22, number 2: +7 (956) 956-45-23, " +
                "number 3: +7 (999) 779-85-40.";
        String regex = "(?:\\+7)? ?\\((?<code>\\d{3})\\) ?\\1-\\d{2}-\\d{2}";
        Pattern pattern =  Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        while (matcher.find()){
            System.out.println(matcher.group());
            System.out.println(matcher.group("code"));
        }
    }
}






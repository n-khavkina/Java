package lambda.task1;

import java.util.function.Predicate;

public class PredicateExample {
    public void stringTest(String s, Predicate<String> predicate){
        if(predicate.test(s)){
            System.out.println(s);
        }
    }
}
class Main{
    public static void main(String[] args) {
        PredicateExample predicateExample = new PredicateExample();
        int i = 7;
        predicateExample.stringTest("abc", s -> s != null);
        predicateExample.stringTest("abc", s -> !s.isEmpty());
        predicateExample.stringTest("JAVA", s -> s.matches("^[NJ]\\w*A$"));
    }
}

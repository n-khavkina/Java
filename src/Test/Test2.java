package Test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public void lookForStrigns(String s) {
        Pattern pat = Pattern.compile("[^\\w\\s]+");
        Matcher mat = pat.matcher(s);
        int count = 0;
        StringBuilder str2 = new StringBuilder("");
        while (mat.find()) {
            if (count < mat.end() - mat.start()) {
                count += mat.end() - mat.start();
            }
            str2.append(mat.group());
        }
        System.out.println("Количество знаков: " + count + ". " + "Сами знаки: " + str2);
    }
}

class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Test2 ls = new Test2();
        ls.lookForStrigns(str);
    }
}


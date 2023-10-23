package stream.task1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Collection<String> col = new ArrayList<>();
        col.add("s fa");
        col.add("login");
        col.add("aaaaaaaaaaaaaaaaa");
        col.add("   ..//");
        // узнать, содержит ли какая-нибудь из строк слово login
        System.out.println(col.stream().anyMatch(s -> s.matches("login")));
        System.out.println("----------------------------------------------");
        // найти самую длинную строку
        System.out.println(col.stream().
                sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).
                skip(col.size() - 1).
                findFirst().orElse(" "));
        System.out.println("----------------------------------------------");
        // найти самую короткую строку
        System.out.println(col.stream().
                sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).
                findFirst().orElse(" "));
        System.out.println("----------------------------------------------");
        // найти строки-слова (не содержат пробелов и знаков препинания)
        System.out.println(col.stream().filter(s -> s.matches("[\\w\\S]+")).
                collect(Collectors.toList()));
        System.out.println("----------------------------------------------");
        //получить все слова используемые в строках
        col.stream().flatMap((value) -> {
            String[] split = value.split("[\\W]+");
            return (Stream) Arrays.asList(split).stream();
        }).forEach(System.out::println);
    }
}

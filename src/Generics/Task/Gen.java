package Generics.Task;

public class Gen <T>{
    public static void method1(Gen<? extends A> value){
        System.out.println("setA");
    }
    public static void method2(Gen <? super B> value2){
        System.out.println("setB");
    }

    public static void main(String[] args) {
        Gen<A> genA = new Gen();
        Gen<B> genB = new Gen();
        Gen<C> genC = new Gen();

        method1(genC);
        method2(genB);

    }
}

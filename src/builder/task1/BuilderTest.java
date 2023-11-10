package builder.task1;

public class BuilderTest {
    public static void main(String[] args) {
        Builder builder = new PersonBuilder();
        Director director = new Director();
        builder = director.createNewPerson(builder);
        System.out.println(builder.createPerson());
    }
}

package builder.task2;


import java.time.LocalDate;
import java.time.LocalTime;

public class BuilderTest2 {
    public static void main(String[] args) {
        Person2 person2 = Person2.builder().
                name("Иван")
                        .surname("Иванов")
                .address(
                        Address.builder()
                                .city("Москва")
                                .country("Россия")
                                .street("Ленинский проспект")
                                .houseNumber(1)
                                .build()
                )
                .birthInfo(
                        BirthInfo.builder()
                                .birthday(LocalDate.of(1990, 1, 1))
                                .birthtime(LocalTime.of(12,30))
                                .birthplace("Санкт-Петербург")
                                .weight(3700.0)
                                .height(50.0)
                                .build()
                )
                .build();
        System.out.println(person2);
    }
}

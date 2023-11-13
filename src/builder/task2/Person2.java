package builder.task2;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person2 {
    private String name;
    private String surname;
    private BirthInfo birthInfo;
    private Address address;
}

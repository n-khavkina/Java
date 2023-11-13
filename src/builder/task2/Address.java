package builder.task2;

import lombok.*;

@Builder
@Data
public class Address {
    private String country;

    private String city;

    private String street;

    private Integer houseNumber;
}

package ir.sleepycat.springdesignpatterns.designpatterns.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Integer age;

}

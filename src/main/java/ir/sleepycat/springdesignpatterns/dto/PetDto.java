package ir.sleepycat.springdesignpatterns.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PetDto {
    private String name;
    private String type;
    private String sound;
    private String group;
}

package hw4.builder;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class MetalAndColorsData {

    private Integer odd;
    private Integer even;
    private List<String> elements;
    private String color;
    private String metal;
    private List<String> vegetables;
}

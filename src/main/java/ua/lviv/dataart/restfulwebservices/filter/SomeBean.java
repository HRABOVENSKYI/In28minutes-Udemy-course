package ua.lviv.dataart.restfulwebservices.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SomeBean {
    private String field1;

    private String field2;

    @JsonIgnore
    private String field3;
}

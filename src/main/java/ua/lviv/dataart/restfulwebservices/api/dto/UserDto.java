package ua.lviv.dataart.restfulwebservices.api.dto;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private Integer id;
    private String name;
    private Integer age;
    private Set<PostSimpleDto> posts;
}

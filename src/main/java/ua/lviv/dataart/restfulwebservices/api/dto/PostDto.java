package ua.lviv.dataart.restfulwebservices.api.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostDto {
    private Integer id;
    private String description;
}

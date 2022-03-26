package ua.lviv.dataart.restfulwebservices.api.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostSimpleDto {
    private Integer id;
    private String description;
}

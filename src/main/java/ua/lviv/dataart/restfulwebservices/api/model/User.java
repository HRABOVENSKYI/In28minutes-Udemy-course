package ua.lviv.dataart.restfulwebservices.api.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer age;

    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Post> posts;

    public void addPost(Post post) {
        post.setUser(this);
        this.posts.add(post);
    }

    public void removePost(Post post) {
        post.setUser(null);
        this.posts.remove(post);
    }
}

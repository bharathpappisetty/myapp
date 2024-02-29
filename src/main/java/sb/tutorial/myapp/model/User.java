package sb.tutorial.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
    private String id;
    private String name;
    private int age;
}

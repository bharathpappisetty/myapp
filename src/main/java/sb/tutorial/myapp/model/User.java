package sb.tutorial.myapp.model;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = " Id is mandatory")
    private String id;
    private String name;
    private int age;
}

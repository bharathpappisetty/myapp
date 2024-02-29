package sb.tutorial.myapp.model.dto;

import lombok.Data;

@Data
public class UserDto {
    private String userId;
    private String userName;
    private int age;
    private String responseMsg;
}

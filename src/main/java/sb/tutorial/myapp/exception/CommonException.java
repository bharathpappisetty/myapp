package sb.tutorial.myapp.exception;

import lombok.Data;

@Data
public class CommonException {
    private String message;
    private String error;
    private String code;
}

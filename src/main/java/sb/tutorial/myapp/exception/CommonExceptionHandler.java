package sb.tutorial.myapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonException handleUserNotFoundException(UserNotFoundException userNotFoundException, WebRequest req) {
        System.out.println(userNotFoundException.getMessage());
        CommonException exception = new CommonException();
        exception.setCode(HttpStatus.BAD_REQUEST.toString());
        exception.setMessage(userNotFoundException.getMessage());
        exception.setError(UserNotFoundException.class.getCanonicalName());
        return exception;
    }


}

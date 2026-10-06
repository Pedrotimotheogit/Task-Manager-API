package taskmanager.infrastructure.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import taskmanager.domain.TaskNotFoundExecption;

@RestControllerAdvice
public class GlobalExecptionHandler {
    @ExceptionHandler(TaskNotFoundExecption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleTaskNotFoundExecption(TaskNotFoundExecption e) {
        return e.getMessage();
    }

}

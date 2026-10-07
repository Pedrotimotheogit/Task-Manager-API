package taskmanager.infrastructure.http.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import taskmanager.application.input.CreateTaskInput;

import java.util.Optional;

public record CreateTaskRequest (
        @NotBlank @Size(min = 3, max = 100) String title,
        Optional< @Size(max = 100) String> description)
{
    public CreateTaskInput toInput() {
        return new CreateTaskInput(title, description);
    }
}

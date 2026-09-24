package taskmanager.application.input;

import lombok.Getter;
import taskmanager.domain.TaskStatus;

import java.util.Optional;


public record UpdateTaskInput (Optional<String> title, Optional<String> description, Optional<TaskStatus> status){
}

package taskmanager.application;

import org.springframework.stereotype.Service;
import taskmanager.application.input.CreateTaskInput;
import taskmanager.application.output.TaskOutput;
import taskmanager.domain.Task;
import taskmanager.domain.TaskRepository;

@Service
public class CreateTaskUseCase {
    private final TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(CreateTaskInput input) {
        var task = new Task(input.title(), input.description());
        //repository save
        var saved = repository.save(task);
        return  TaskOutput.from(saved);
    }
}

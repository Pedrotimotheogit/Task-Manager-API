package taskmanager.application;

import org.springframework.stereotype.Service;
import taskmanager.application.input.UpdateTaskInput;
import taskmanager.application.output.TaskOutput;
import taskmanager.domain.Task;
import taskmanager.domain.TaskId;
import taskmanager.domain.TaskNotFoundExecption;
import taskmanager.domain.TaskRepository;

@Service
public class UpdateTaskUseCase {
    private final TaskRepository repository;

    public UpdateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id, UpdateTaskInput input) {
        var task = repository.findById(id).orElseThrow(() -> new TaskNotFoundExecption(id));
        task.update(input.title(), input.description(), input.status());

        var updated = repository.save(task);
        return TaskOutput.from(updated);
    }
}

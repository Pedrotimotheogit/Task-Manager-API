package taskmanager.application;

import org.springframework.stereotype.Service;
import taskmanager.application.output.TaskOutput;
import taskmanager.domain.TaskId;
import taskmanager.domain.TaskNotFoundExecption;
import taskmanager.domain.TaskRepository;

@Service
public class GetTaskByIdUseCase {
    private final TaskRepository repository;

    public GetTaskByIdUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id) {
        return repository.findById(id).map(TaskOutput::from).orElseThrow(() -> new TaskNotFoundExecption(id));
    }
}

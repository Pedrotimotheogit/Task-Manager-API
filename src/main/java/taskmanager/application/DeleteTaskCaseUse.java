package taskmanager.application;

import org.springframework.stereotype.Service;
import taskmanager.application.output.TaskOutput;
import taskmanager.domain.TaskId;
import taskmanager.domain.TaskNotFoundExecption;
import taskmanager.domain.TaskRepository;

@Service
public class DeleteTaskCaseUse {
    private final TaskRepository repository;

    public DeleteTaskCaseUse(TaskRepository repository) {
        this.repository = repository;
    }

    public void execute(TaskId id) {
        if (repository.findById(id).isEmpty()) {
            throw new TaskNotFoundExecption(id);
        }
        repository.delete(id);
    }
}

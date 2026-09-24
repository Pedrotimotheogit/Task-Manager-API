package taskmanager.application;

import org.springframework.stereotype.Service;
import taskmanager.application.output.TaskOutput;
import taskmanager.domain.TaskRepository;

import java.util.List;

@Service
public class GetTaskCaseUse {
    private final TaskRepository repository;

    public GetTaskCaseUse(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskOutput> execute() {
        var tasks = repository.findAll();
        return tasks.stream().map(TaskOutput::from).toList();
    }
}

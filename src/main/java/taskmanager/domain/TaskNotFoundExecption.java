package taskmanager.domain;

public class TaskNotFoundExecption extends RuntimeException {
    public TaskNotFoundExecption(TaskId id) {
        super("Task not found with ID: " + id);
    }
}

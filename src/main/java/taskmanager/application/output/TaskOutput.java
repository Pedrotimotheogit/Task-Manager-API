package taskmanager.application.output;

import taskmanager.domain.Task;

import java.util.Optional;

public record TaskOutput(String id, String title,Optional<String> description, String status) {
    public static TaskOutput from(Task task) {
        // task.getId() returns a TaskId record; calling toString() on it produces
        // "TaskId[id=...]". Use the record accessor id() to get the inner UUID.
        return new TaskOutput(task.getId().id().toString(), task.getTitle(), task.getDescription(), task.getStatus().name());
    }
}

//public static TaskOutput from(Task task) {
//        return new TaskOutput(task.getId().toString(), task.getTitle(), task.getDescription(), task.getStatus().name());
package taskmanager.infrastructure.http;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import taskmanager.application.*;
import taskmanager.domain.TaskId;
import taskmanager.infrastructure.http.request.CreateTaskRequest;
import taskmanager.infrastructure.http.request.UpdateTaskRequest;
import taskmanager.infrastructure.http.response.TaskResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;
    private final GetTaskCaseUse getTaskCaseUse;
    private final GetTaskByIdUseCase getTaskByIdUseCase;
    private final DeleteTaskCaseUse deleteTaskCaseUse;
    private final UpdateTaskUseCase updateTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase,  GetTaskCaseUse getTaskCaseUse, GetTaskByIdUseCase getTaskByIdUseCase, DeleteTaskCaseUse deleteTaskCaseUse, UpdateTaskUseCase updateTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.getTaskCaseUse = getTaskCaseUse;
        this.getTaskByIdUseCase = getTaskByIdUseCase;
        this.deleteTaskCaseUse = deleteTaskCaseUse;
        this.updateTaskUseCase = updateTaskUseCase;
    }

    @PostMapping
    TaskResponse create(@RequestBody @Valid CreateTaskRequest request){
        var input = request.toInput();
        var output = createTaskUseCase.execute(input);
        return TaskResponse.from(output);
    }

    @GetMapping
    List<TaskResponse> list(){
        return getTaskCaseUse.execute().stream().map(TaskResponse::from).toList();
    }

    @GetMapping("/{id}")
    TaskResponse read(@PathVariable UUID id){
        var output = getTaskByIdUseCase.execute(new TaskId(id));
        return TaskResponse.from(output);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id){
        deleteTaskCaseUse.execute(new TaskId(id));
    }

    @PatchMapping("/{id}")
    TaskResponse update(@PathVariable UUID id, @RequestBody UpdateTaskRequest request){
        var input = request.toInput();
        var output = updateTaskUseCase.execute(new TaskId(id), input);
        return TaskResponse.from(output);
    }
}

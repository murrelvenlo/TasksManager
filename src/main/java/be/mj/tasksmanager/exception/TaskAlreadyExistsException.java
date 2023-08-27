package be.mj.tasksmanager.exception;

public class TaskAlreadyExistsException extends RuntimeException
{
    public TaskAlreadyExistsException(String message) {
        super(message);
    }
}

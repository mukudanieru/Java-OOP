package projectcoding.taskmanager.task;

public class Task {
    
    private String name;
    private int startTime;
    private int executionTime;
    private int deadline;

    public Task() {
        this.startTime = -1;
        this.executionTime = -1;
    }

    public Task(String name, int executionTime, int deadline) {
        this.name = name;
        this.startTime = -1;
        this.executionTime = executionTime;
        this.deadline = deadline;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public int getExecutionTime() {
        return this.executionTime;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getDeadline() {
        return this.deadline;
    }

    public void execute(int time) {
        startTime = time;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int getEndTime() {
        return this.startTime + this.executionTime;
    }

    public boolean delayed() {
        return (this.getEndTime() > deadline);
    }
}

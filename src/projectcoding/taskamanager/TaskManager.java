package projectcoding.taskamanager;

import java.util.Scanner;

import projectcoding.taskamanager.task.Task;

public class TaskManager {
    private static final Scanner input = new Scanner(System.in);
    private static Task[] taskManager;
    public static void main(String[] args) {
        System.out.print("Number of task: ");
        int numOfTask = input.nextInt();
        input.nextLine();

        createTasks(numOfTask);
        simulateTasks();
        outputTasks();

        input.close();
    }

    private static void createTasks(int numTask) {
        taskManager = new Task[numTask];

        for (int i = 0; i < numTask; i++) {
            System.out.print("\nTask " + (i+1) + ": ");
            String taskName = input.nextLine();

            System.out.print("Execution: ");
            int execution = input.nextInt();
            input.nextLine();

            System.out.print("Deadline: ");
            int deadline = input.nextInt();
            input.nextLine();

            taskManager[i] = new Task(taskName, execution, deadline);
        }
    }

    private static void simulateTasks() {
        int time = 0;
        for (Task task : taskManager) {
            task.execute(time);
            time = task.getEndTime();
        }
    }

    private static void outputTasks() {
        System.out.printf(
            "\n%-10s%-10s%-10s%-10s%-10s\n",
    "Tasks",
            "Start", 
            "End", 
            "Deadline", 
            "Missed");

        for (Task task : taskManager) {
            Task obj = task;
            String isDelayed = (obj.delayed()) ? "Yes" : "No";

            System.out.printf(
            "%-10s%-10d%-10d%-10d%-10s\n", 
            obj.getName(),
            obj.getStartTime(),
            obj.getEndTime(),
            obj.getDeadline(),
            isDelayed);
        }
    }
}

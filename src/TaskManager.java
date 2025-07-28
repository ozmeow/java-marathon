import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private int nextId;

    public TaskManager() {
    tasks = new ArrayList<>();
    nextId = 1;
    }

    public void addTask(String title) {
        Task task = new Task(nextId++, title);
        tasks.add(task);
        System.out.println("Задача добавлена: " + title);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
            return;
        }

        System.out.println("список задач:");
        for (Task task : tasks) {
            String status = task.isDone() ? "[x]" : "[ ]";
            System.out.println(task);
            System.out.println(task.getId() + "." + status + " " + task.getTitle());
        }
    }

    public void markTaskDone(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDone(true);
                System.out.println("Задача " + id + " отмечена как выполнена.");
                return;
            }
        }
        System.out.println("Задача с ID " + id + " не найдена");
    }

    public void deleteTask(int id) {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getId() == id) {
                taskToRemove = task;
                break;
            }
        }

        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Задача " + id + " удалена.");
        } else {
            System.out.println("Задача с ID " + id + " не найдена");
        }
    }
}

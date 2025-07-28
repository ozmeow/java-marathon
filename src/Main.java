//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("простой ToDo - manager");
        System.out.println("Доступные команды:");
        System.out.println("1. add <...> - добавить задачу");
        System.out.println("2. list - показать все задачи");
        System.out.println("3. done <id> - отметить задачу выполненной");
        System.out.println("4. delete <id> - удалить задачу");
        System.out.println("5. exit - выход");

        while (true) {
            System.out.println("\nВведите команду: ");
            String command = scanner.nextLine().trim();

            if (command.equalsIgnoreCase("exit")) {
                break;
            } else if (command.startsWith("add ")) {
                String title = command.substring(4).trim();
                if (!title.isEmpty()) {
                    manager.addTask(title);
                } else {
                    System.out.println("Ошибка: описание задачи не может быть пустым");
                    }
                } else if (command.equals("list")) {
                manager.listTasks();
            } else if (command.startsWith("done ")) {
                try {
                    int id = Integer.parseInt(command.substring(5).trim());
                    manager.markTaskDone(id);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: неверный формат ID задачи");
                }
            } else if (command.startsWith("delete ")) {
                try {
                    int id = Integer.parseInt(command.substring(7).trim());
                    manager.deleteTask(id);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: неверный формат ID задачи");
                }
            } else {
                System.out.println("Неизвестная команда. Попробуйте снова.");
            }
        }
        scanner.close();
        System.out.println("Работа завершена.");
    }
}
import java.io.*;
import java.util.*;

public class TaskTracker {
    private static final String FILE_NAME = "tasks.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = loadTasks();

        System.out.println("--- Welcome to Personal Task Tracker ---");

        while (true) {
            System.out.println("\n1. View Tasks | 2. Add Task | 3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.println("\nYour Tasks:");
                if (tasks.isEmpty()) System.out.println("No tasks found.");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
            } else if (choice == 2) {
                System.out.print("Enter task description: ");
                String task = scanner.nextLine();
                tasks.add(task);
                saveTasks(tasks);
                System.out.println("Task added successfully!");
            } else if (choice == 3) {
                System.out.println("Exiting... Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    private static void saveTasks(List<String> tasks) {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                out.println(task);
            }
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    private static List<String> loadTasks() {
        List<String> tasks = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return tasks;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                tasks.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error loading tasks: " + e.getMessage());
        }
        return tasks;
    }
}

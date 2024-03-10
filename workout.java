import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Exercise {
    private String name;
    private int duration; // in seconds

    public Exercise(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}

class Workout {
    private String date;
    private List<Exercise> exercises;

    public Workout(String date) {
        this.date = date;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public void displayWorkout() {
        System.out.println("Workout on " + date + ":");
        for (Exercise exercise : exercises) {
            System.out.println(exercise.getName() + " - Duration: " + exercise.getDuration() + " seconds");
        }
    }
}

public class WorkoutApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Workout App!");

        System.out.print("Enter the date of your workout (e.g., YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Workout workout = new Workout(date);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Exercise");
            System.out.println("2. View Workout");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter exercise name: ");
                    String exerciseName = scanner.nextLine();

                    System.out.print("Enter exercise duration (in seconds): ");
                    int exerciseDuration = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    Exercise exercise = new Exercise(exerciseName, exerciseDuration);
                    workout.addExercise(exercise);
                    System.out.println("Exercise added!");
                    break;

                case 2:
                    workout.displayWorkout();
                    break;

                case 3:
                    System.out.println("Exiting Workout App. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

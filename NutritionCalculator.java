import java.util.Scanner;

public class NutritionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your body weight (kg): ");
        int weight = scanner.nextInt();

        System.out.print("Enter your height (cm): ");
        int height = scanner.nextInt();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your gender (male/female): ");
        String gender = scanner.next();

        if (gender.equals("male")) {
            double bmr = 88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age);
            double dailyCalories = bmr * 1.375;

            System.out.println("Your daily calories (default activity): " + dailyCalories);
        } else if (gender.equals("female")) {
            double bmr = 447.6 + (9.2 * weight) + (3.1 * height) - (4.3 * age);
            double dailyCalories = bmr * 1.375;

            System.out.println("Your daily calories (default activity): " + dailyCalories);
        } else {
            System.out.println("Error! Try again.");
        }

        
        scanner.close();
    }
}

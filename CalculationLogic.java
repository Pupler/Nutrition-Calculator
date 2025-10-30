public class CalculationLogic {
    
    public static double calculateBMR(String gender, int weight, int height, int age) {
        if (gender.equals("male")) {
            return 88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age);
        } else if (gender.equals("female")) {
            return 447.6 + (9.2 * weight) + (3.1 * height) - (4.3 * age);
        } else {
           System.out.println("Error eccured!");
           return 0;
        }
    }
    
    public static double getActivityMultiplier(String activity) {
        if (activity.contains("Sedentary")) return 1.2;
        if (activity.contains("Light")) return 1.375;
        if (activity.contains("Regular")) return 1.55;
        if (activity.contains("Intensive")) return 1.725;
        if (activity.contains("Sportsman")) return 1.9;
        return 1.375; // Default value
    }
    
    public static double getGoalMultiplier(String goal) {
        if (goal.contains("Weight Loss")) return -500;
        if (goal.contains("Maintenance")) return 0;
        if (goal.contains("Muscle Gain")) return 500;
        return 0; // Default value
    }
}
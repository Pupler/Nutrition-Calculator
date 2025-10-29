import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;

public class NutritionCalculator {
    public static void main(String[] args) {
        // Window creation
        JFrame frame = new JFrame("Nutrition Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,400);
        frame.setLayout(new GridLayout(7,2));

        // Components adding
        frame.add(new JLabel("Weight (kg):"));
        JTextField weightTextField = new JTextField();
        frame.add(weightTextField);

        frame.add(new JLabel("Height (cm):"));
        JTextField heightTextField = new JTextField();
        frame.add(heightTextField);

        frame.add(new JLabel("Age:"));
        JTextField ageTextField = new JTextField();
        frame.add(ageTextField);

        frame.add(new JLabel("Gender:"));
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"male", "female"});
        frame.add(genderComboBox);

        frame.add(new JLabel("Activity:"));
        JComboBox<String> activityComboBox = new JComboBox<>(new String[]{
            "Sedentary (low physical activity)",
            "Light exercises (1-2 trainings per week)",
            "Regular exercises (3-5 trainings per week)",
            "Intensive exercises (6-7 trainings per week)",
            "Sportsman (2 trainings per day)"
        });
        frame.add(activityComboBox);

        frame.add(new JLabel("Goal:"));
        JComboBox<String> goalComboBox = new JComboBox<>(new String[]{
            "Weight Loss",
            "Maintenance",
            "Muscle Gain"
        });
        frame.add(goalComboBox);

        JButton calculateButton = new JButton("Calculate");
        frame.add(calculateButton);

        JLabel resultCalculation = new JLabel("Daily calories:");
        frame.add(resultCalculation);


        // Button events
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int weight = Integer.parseInt(weightTextField.getText());
                    int height = Integer.parseInt(heightTextField.getText());
                    int age = Integer.parseInt(ageTextField.getText());
                    String gender = (String) genderComboBox.getSelectedItem();
                    String activity = (String) activityComboBox.getSelectedItem();
                    String goal = (String) goalComboBox.getSelectedItem();


                    double goalMultiplier = 0; // Default value
                    if (goal.contains("Weight Loss")) {
                        goalMultiplier = -500;
                    } else if (goal.contains("Maintenance")) {
                        goalMultiplier = 0;
                    } else if (goal.contains("Muscle Gain")) {
                        goalMultiplier = 500;
                    } else {
                        System.out.println("Error occured!");
                    }


                    double activityMultiplier = 1.375; // Default value
                    if (activity.contains("Sedentary")) {
                        activityMultiplier = 1.2;
                    } else if (activity.contains("Light")) {
                        activityMultiplier = 1.375;
                    } else if (activity.contains("Regular")) {
                        activityMultiplier = 1.55;
                    } else if (activity.contains("Intensive")) {
                        activityMultiplier = 1.725;
                    } else if (activity.contains("Sportsman")) {
                        activityMultiplier = 1.9;
                    } else {
                        System.out.println("Error occured!");
                    }


                    double bmr = 0;
                    if (gender.equals("male")) {
                        bmr = 88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age);
                    } else if (gender.equals("female")) {
                        bmr = 447.6 + (9.2 * weight) + (3.1 * height) - (4.3 * age);
                    } else {
                        System.out.println("Error eccured!");
                    }

                    double dailyCalories = (bmr * activityMultiplier) + goalMultiplier;
                    resultCalculation.setText("Daily calories: " + String.format("%.0f", dailyCalories));


                    } catch (Exception ex) {
                        resultCalculation.setText("Error occured! Try again.");
                    }

            }
        });
    


        // Show window
        frame.setVisible(true);
    }
}

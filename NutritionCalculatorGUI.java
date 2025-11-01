import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NutritionCalculatorGUI {

    public void createAndShowWindow() {
        // Window creation
        JFrame frame = new JFrame("Nutrition Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,450);
        frame.setLayout(new GridLayout(7,2, 5, 5));

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


        // STYLES

        // Colors
        frame.getContentPane().setBackground(new Color(240, 240, 240));
        calculateButton.setBackground(new Color(70, 130, 180));
        calculateButton.setForeground(Color.WHITE);

        // Images
        ImageIcon icon = new ImageIcon("images/icon.png");
        frame.setIconImage(icon.getImage());

        // Fonts
        Font customFont = new Font("Montserrat", Font.PLAIN, 14);

        weightTextField.setFont(customFont);
        heightTextField.setFont(customFont);
        ageTextField.setFont(customFont);
        genderComboBox.setFont(customFont);
        activityComboBox.setFont(customFont);
        goalComboBox.setFont(customFont);
        calculateButton.setFont(customFont);
        resultCalculation.setFont(customFont);

        for (Component comp : frame.getContentPane().getComponents()) {
            if (comp instanceof JLabel) {
                ((JLabel) comp).setFont(customFont);
            }
        }

        // Borders
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Inputs
        weightTextField.setMargin(new Insets(5, 5, 5, 5));
        heightTextField.setMargin(new Insets(5, 5, 5, 5));
        ageTextField.setMargin(new Insets(5, 5, 5, 5));

        // Button
        calculateButton.setBackground(new Color(70, 130, 240));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);
        calculateButton.setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 25));
        calculateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));


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


                    double goalMultiplier = CalculationLogic.getGoalMultiplier(goal);

                    double activityMultiplier = CalculationLogic.getActivityMultiplier(activity);
                    
                    double bmr = CalculationLogic.calculateBMR(gender, weight, height, age);

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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NutritionCalculator {
    public static void main(String[] args) {
        // Window creation
        JFrame frame = new JFrame("Nutrition Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.setLayout(new GridLayout(5,2));

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
                    
                    double bmr = 0;
                    if (gender.equals("male")) {
                        bmr = 88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age);
                    } else if (gender.equals("female")) {
                        bmr = 447.6 + (9.2 * weight) + (3.1 * height) - (4.3 * age);
                    } else {
                        System.out.println("Error eccured!");
                    }

                    double dailyCalories = bmr * 1.375;
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

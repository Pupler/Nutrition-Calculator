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

        frame.add(new JLabel("Calculation result:"));


        // Button events
        



        // Show window
        frame.setVisible(true);
    }
}

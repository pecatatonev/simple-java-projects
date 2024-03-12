package tempretureConverter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI extends JFrame {
    private JTextField inputField;
    private JTextField resultField;
    private JComboBox<String> sourceUnitComboBox;
    private JComboBox<String> targetUnitComboBox;

    public TemperatureConverterGUI() {
        setTitle("Temperature Converter");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};
        sourceUnitComboBox = new JComboBox<>(units);
        targetUnitComboBox = new JComboBox<>(units);

        inputField = new JTextField(15);
        inputField.setMaximumSize(inputField.getPreferredSize());
        panel.add(inputField);

        JButton convertButton = new JButton("Convert");
        panel.add(convertButton);
        
        JButton resetButton = new JButton("Reset");
        panel.add(resetButton);

        resultField = new JTextField(40);
        resultField.setEditable(false);
        resultField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(resultField);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.add(sourceUnitComboBox);
        topPanel.add(targetUnitComboBox);
        panel.add(topPanel);

        add(panel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                resultField.setText("");
            }
        });
    }


    private void convertTemperature() {
    	try {
            double temperature = Double.parseDouble(inputField.getText());
            String sourceUnit = (String) sourceUnitComboBox.getSelectedItem();
            String targetUnit = (String) targetUnitComboBox.getSelectedItem();
            double result = 0.0;

            if (sourceUnit.equals(targetUnit)) {
                resultField.setText("Source and target units are the same.");
                return;
            }

            if (sourceUnit.equals("Celsius")) {
                if (targetUnit.equals("Fahrenheit")) {
                    result = (temperature * 9 / 5) + 32;
                } else if (targetUnit.equals("Kelvin")) {
                    result = temperature + 273.15;
                }
            } else if (sourceUnit.equals("Fahrenheit")) {
                if (targetUnit.equals("Celsius")) {
                    result = (temperature - 32) * 5 / 9;
                } else if (targetUnit.equals("Kelvin")) {
                    result = (temperature - 32) * 5 / 9 + 273.15;
                }
            } else if (sourceUnit.equals("Kelvin")) {
                if (targetUnit.equals("Celsius")) {
                    result = temperature - 273.15;
                } else if (targetUnit.equals("Fahrenheit")) {
                    result = (temperature - 273.15) * 9 / 5 + 32;
                }
            }
            
            String formattedResult = String.format("%.2f", result);
            resultField.setText(temperature + " " + sourceUnit + " is equal to " + formattedResult + " " + targetUnit);
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TemperatureConverterGUI converter = new TemperatureConverterGUI();
                converter.setVisible(true);
            }
        });
    }
}




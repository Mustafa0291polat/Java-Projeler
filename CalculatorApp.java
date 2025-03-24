import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hesap Makinesi");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2));

        JLabel num1Label = new JLabel("Sayı 1:");
        JTextField num1Field = new JTextField();
        JLabel num2Label = new JLabel("Sayı 2:");
        JTextField num2Field = new JTextField();
        JLabel operatorLabel = new JLabel("Operatör (+, -, *, /):");
        JTextField operatorField = new JTextField();
        JButton calculateButton = new JButton("Hesapla");
        JButton clearButton = new JButton("C");
        JLabel resultLabel = new JLabel("Sonuç: ");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    String operator = operatorField.getText();

                    double result = 0;
                    boolean validOperation = true;

                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 == 0) {
                                resultLabel.setText("Hata: Sıfıra bölme!");
                                validOperation = false;
                            } else {
                                result = num1 / num2;
                            }
                            break;
                        default:
                            resultLabel.setText("Geçersiz operatör!");
                            validOperation = false;
                    }

                    if (validOperation) {
                        resultLabel.setText("Sonuç: " + result);
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Hata: Geçerli sayılar girin!");
                }
            }
        });

        // "C" butonu tıklanınca tüm girişleri sıfırlar
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1Field.setText("");
                num2Field.setText("");
                operatorField.setText("");
                resultLabel.setText("Sonuç: ");
            }
        });

        frame.add(num1Label);
        frame.add(num1Field);
        frame.add(num2Label);
        frame.add(num2Field);
        frame.add(operatorLabel);
        frame.add(operatorField);
        frame.add(calculateButton);
        frame.add(clearButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}

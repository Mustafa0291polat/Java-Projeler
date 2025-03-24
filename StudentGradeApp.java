import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Not Hesaplama");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(8, 2));
        
        JLabel nameLabel = new JLabel("İsim:");
        JTextField nameField = new JTextField();
        JLabel surnameLabel = new JLabel("Soyisim:");
        JTextField surnameField = new JTextField();
        JLabel classLabel = new JLabel("Sınıf:");
        JTextField classField = new JTextField();
        JLabel courseLabel = new JLabel("Ders Adı:");
        JTextField courseField = new JTextField();
        JLabel midtermLabel = new JLabel("Vize Notu:");
        JTextField midtermField = new JTextField();
        JLabel finalLabel = new JLabel("Final Notu:");
        JTextField finalField = new JTextField();
        JButton calculateButton = new JButton("Hesapla");
        JLabel resultLabel = new JLabel("");
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    String surname = surnameField.getText();
                    String className = classField.getText();
                    String courseName = courseField.getText();
                    double midterm = Double.parseDouble(midtermField.getText());
                    double finalExam = Double.parseDouble(finalField.getText());
                    
                    double average = (midterm * 0.4) + (finalExam * 0.6);
                    String status = (average >= 50) ? "Geçti" : "Kaldı";
                    
                    resultLabel.setText("Öğrenci: " + name + " " + surname + " (" + className + ")\n" +
                            "Ders: " + courseName + " - Ortalama: " + average + " - " + status);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Lütfen geçerli notlar girin!");
                }
            }
        });
        
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(surnameLabel);
        frame.add(surnameField);
        frame.add(classLabel);
        frame.add(classField);
        frame.add(courseLabel);
        frame.add(courseField);
        frame.add(midtermLabel);
        frame.add(midtermField);
        frame.add(finalLabel);
        frame.add(finalField);
        frame.add(calculateButton);
        frame.add(resultLabel);
        
        frame.setVisible(true);
    }
}

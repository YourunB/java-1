import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form {
   public Form() {
      // Создаем окно
      JFrame frame = new JFrame("Калькулятор суммы");
      frame.setSize(500, 300); // Устанавливаем размер окна
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Закрытие окна при выходе
      frame.setLayout(new GridLayout(4, 2, 5, 5)); // Сетка 4 строки, 2 колонки

      // Создаем компоненты
      JLabel label1 = new JLabel("Число 1:");
      JTextField field1 = new JTextField();

      JLabel label2 = new JLabel("Число 2:");
      JTextField field2 = new JTextField();

      JButton calcButton = new JButton("Посчитать");

      JLabel resultLabel = new JLabel("Результат:");
      JLabel resultValue = new JLabel("");

      // Обработка кнопки
      calcButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               double num1 = Double.parseDouble(field1.getText());
               double num2 = Double.parseDouble(field2.getText());
               double sum = num1 + num2;
               resultValue.setText(String.valueOf(sum));
            } catch (NumberFormatException ex) {
               resultValue.setText("Ошибка ввода");
            }
         }
      });

      // Добавляем компоненты в окно
      frame.add(label1);
      frame.add(field1);
      frame.add(label2);
      frame.add(field2);
      frame.add(calcButton);
      frame.add(new JLabel("")); // Пустая ячейка
      frame.add(resultLabel);
      frame.add(resultValue);

      // Показываем окно
      frame.setVisible(true);
   }
}
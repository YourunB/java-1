import javax.swing.*;

public class Form {
   public Form() {
      // Создаем окно
      JFrame frame = new JFrame("Калькулятор суммы");
      frame.setSize(300, 200); // Устанавливаем размер окна
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Закрытие окна при выходе
      frame.setVisible(true); // Делаем окно видимым
   }
}
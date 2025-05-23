import javax.swing.*;
import java.awt.*;

public class FormCoordinates {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new FormCoordinates().createAndShowGUI());
  }

  private void createAndShowGUI() {
    JFrame frame = new JFrame("Поиск пересечений");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 700);
    frame.setLayout(null); // абсолютное позиционирование

    // Координаты отрезка
    JLabel segmentLabel = new JLabel("Координаты отрезка:");
    segmentLabel.setFont(new Font("Arial", Font.BOLD, 16));
    segmentLabel.setBounds(10, 10, 250, 20);
    frame.add(segmentLabel);

    // Поля ввода координат отрезка (x1, y1, x2, y2)
    JTextField x1Field = new JTextField();
    JTextField y1Field = new JTextField();
    JTextField x2Field = new JTextField();
    JTextField y2Field = new JTextField();
    frame.add(new JLabel("x") {{ setBounds(25, 22, 20, 20); }});
    frame.add(new JLabel("y") {{ setBounds(75, 22, 20, 20); }});
    frame.add(new JLabel("x") {{ setBounds(125, 22, 20, 20); }});
    frame.add(new JLabel("y") {{ setBounds(175, 22, 20, 20); }});
    x1Field.setBounds(10, 40, 40, 25);
    y1Field.setBounds(60, 40, 40, 25);
    x2Field.setBounds(110, 40, 40, 25);
    y2Field.setBounds(160, 40, 40, 25);
    frame.add(x1Field);
    frame.add(y1Field);
    frame.add(x2Field);
    frame.add(y2Field);

    // Таблица отрезков
    JTable segmentTable = new JTable(0, 4);
    JScrollPane segmentScroll = new JScrollPane(segmentTable);
    segmentScroll.setBounds(220, 10, 300, 80);
    frame.add(segmentScroll);

    // Кнопки
    JButton addSegmentButton = new JButton("Добавить отрезок");
    JButton deleteSegmentButton = new JButton("Удалить отрезок");
    addSegmentButton.setBounds(10, 70, 190, 25);
    deleteSegmentButton.setBounds(10, 100, 190, 25);
    frame.add(addSegmentButton);
    frame.add(deleteSegmentButton);

    // Координаты прямоугольной области
    JLabel rectTopLeftLabel = new JLabel("Верхний левый угол прямоугольной области:");
    rectTopLeftLabel.setBounds(10, 140, 300, 20);
    frame.add(rectTopLeftLabel);

    JTextField rectX1Field = new JTextField();
    JTextField rectY1Field = new JTextField();
    frame.add(new JLabel("x") {{ setBounds(25, 150, 20, 20); }});
    frame.add(new JLabel("y") {{ setBounds(80, 150, 20, 20); }});
    rectX1Field.setBounds(10, 170, 40, 25);
    rectY1Field.setBounds(60, 170, 40, 25);
    frame.add(rectX1Field);
    frame.add(rectY1Field);

    JLabel rectBottomRightLabel = new JLabel("Нижний правый угол прямоугольной области:");
    rectBottomRightLabel.setBounds(10, 200, 300, 20);
    frame.add(rectBottomRightLabel);

    JTextField rectX2Field = new JTextField();
    JTextField rectY2Field = new JTextField();
    frame.add(new JLabel("x") {{ setBounds(25, 210, 20, 20); }});
    frame.add(new JLabel("y") {{ setBounds(80, 210, 20, 20); }});
    rectX2Field.setBounds(10, 230, 40, 25);
    rectY2Field.setBounds(60, 230, 40, 25);
    frame.add(rectX2Field);
    frame.add(rectY2Field);

    JButton setRectButton = new JButton("Установить координаты прямоугольной области");
    setRectButton.setBounds(10, 260, 500, 25);
    frame.add(setRectButton);

    JButton drawButton = new JButton("Отобразить отрезки и прямоугольную область");
    drawButton.setBounds(10, 300, 500, 25);
    frame.add(drawButton);

    JTextArea drawArea = new JTextArea();
    JScrollPane drawScroll = new JScrollPane(drawArea);
    drawScroll.setBounds(10, 340, 500, 150);
    frame.add(drawScroll);

    JButton intersectButton = new JButton("Отобразить координаты отрезков, пересекающих прямоугольную область");
    intersectButton.setBounds(10, 500, 500, 25);
    frame.add(intersectButton);

    JTextArea resultArea = new JTextArea("Компонент JTextArea или JTable");
    resultArea.setBounds(200, 540, 200, 100);
    frame.add(resultArea);

    // Панель отрисовки (пока пустая)
    JPanel canvasPanel = new JPanel();
    canvasPanel.setBackground(Color.WHITE);
    canvasPanel.setBounds(320, 140, 200, 110);
    frame.add(canvasPanel);

    frame.setVisible(true);
  }
}

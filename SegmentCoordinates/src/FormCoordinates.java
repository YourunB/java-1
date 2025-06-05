import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FormCoordinates {
  static class Segment {
    int x1, y1, x2, y2;
    Segment(int x1, int y1, int x2, int y2) {
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
    }
  }

  private final List<Segment> segments = new ArrayList<>();
  private int rectX1, rectY1, rectX2, rectY2;

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new FormCoordinates().createAndShowGUI());
  }

  public void createAndShowGUI() {
    JFrame frame = new JFrame("Поиск пересечений");
    frame.setDefaultCloseOperatio n(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 700);
    frame.setLayout(null);

    JLabel segmentLabel = new JLabel("Координаты отрезка:");
    segmentLabel.setFont(new Font("Arial", Font.BOLD, 16));
    segmentLabel.setBounds(10, 10, 250, 20);
    frame.add(segmentLabel);

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

    DefaultTableModel tableModel = new DefaultTableModel(new String[]{"x1", "y1", "x2", "y2"}, 0);
    JTable segmentTable = new JTable(tableModel);
    JScrollPane segmentScroll = new JScrollPane(segmentTable);
    segmentScroll.setBounds(220, 10, 300, 80);
    frame.add(segmentScroll);

    JButton addSegmentButton = new JButton("Добавить отрезок");
    JButton deleteSegmentButton = new JButton("Удалить отрезок");
    addSegmentButton.setBounds(10, 70, 190, 25);
    deleteSegmentButton.setBounds(10, 100, 190, 25);
    frame.add(addSegmentButton);
    frame.add(deleteSegmentButton);

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

    JPanel drawArea = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for (Segment s : segments) {
          g.drawLine(s.x1, s.y1, s.x2, s.y2);
        }
        g.setColor(Color.RED);
        g.drawRect(Math.min(rectX1, rectX2), Math.min(rectY1, rectY2),
            Math.abs(rectX2 - rectX1), Math.abs(rectY2 - rectY1));
      }
    };
    drawArea.setBackground(Color.WHITE);
    drawArea.setBounds(10, 340, 500, 150);
    frame.add(drawArea);

    JButton intersectButton = new JButton("Отобразить координаты отрезков, пересекающих прямоугольную область");
    intersectButton.setBounds(10, 500, 500, 25);
    frame.add(intersectButton);

    JTextArea resultArea = new JTextArea();
    resultArea.setBounds(200, 540, 200, 100);
    resultArea.setEditable(false);
    frame.add(resultArea);

    JPanel canvasPanel = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for (Segment s : segments) {
          g.drawLine(s.x1, s.y1, s.x2, s.y2);
        }
        g.setColor(Color.RED);
        g.drawRect(Math.min(rectX1, rectX2), Math.min(rectY1, rectY2),
            Math.abs(rectX2 - rectX1), Math.abs(rectY2 - rectY1));
      }
    };
    canvasPanel.setBackground(Color.WHITE);
    canvasPanel.setBounds(320, 140, 200, 110);
    frame.add(canvasPanel);

    addSegmentButton.addActionListener(e -> {
      try {
        int x1 = Integer.parseInt(x1Field.getText());
        int y1 = Integer.parseInt(y1Field.getText());
        int x2 = Integer.parseInt(x2Field.getText());
        int y2 = Integer.parseInt(y2Field.getText());
        tableModel.addRow(new Object[]{x1, y1, x2, y2});
        segments.add(new Segment(x1, y1, x2, y2));
        canvasPanel.repaint();
      } catch (NumberFormatException ignored) {}
    });

    deleteSegmentButton.addActionListener(e -> {
      int selected = segmentTable.getSelectedRow();
      if (selected != -1) {
        tableModel.removeRow(selected);
        segments.remove(selected);
        canvasPanel.repaint();
      }
    });

    setRectButton.addActionListener(e -> {
      try {
        rectX1 = Integer.parseInt(rectX1Field.getText());
        rectY1 = Integer.parseInt(rectY1Field.getText());
        rectX2 = Integer.parseInt(rectX2Field.getText());
        rectY2 = Integer.parseInt(rectY2Field.getText());
        canvasPanel.repaint();
      } catch (NumberFormatException ignored) {}
    });

    drawButton.addActionListener(e -> canvasPanel.repaint());

    intersectButton.addActionListener(e -> {
      StringBuilder result = new StringBuilder();
      ArrayList<Segment> intersectedSegments = new ArrayList<>();
      tableModel.setRowCount(0); // Очищаем таблицу

      for (Segment s : segments) {
        if (segmentIntersectsRect(s)) { // Проверяем пересечение
          intersectedSegments.add(s);
          result.append(String.format("(%d, %d)-(%d, %d)\n", s.x1, s.y1, s.x2, s.y2));
          tableModel.addRow(new Object[]{s.x1, s.y1, s.x2, s.y2});
        }
      }

      resultArea.setText(result.toString());
      segments.clear();
      segments.addAll(intersectedSegments);
      drawArea.repaint();
    });

    frame.setVisible(true);
  }

  private boolean segmentIntersectsRect(Segment s) {
    int minX = Math.min(rectX1, rectX2);
    int maxX = Math.max(rectX1, rectX2);
    int minY = Math.min(rectY1, rectY2);
    int maxY = Math.max(rectY1, rectY2);

    if (lineIntersectsRect(s.x1, s.y1, s.x2, s.y2, minX, minY, maxX, maxY)) return true;
    return false;
  }

  private boolean lineIntersectsRect(int x1, int y1, int x2, int y2,
                                     int rx1, int ry1, int rx2, int ry2) {
    return lineIntersectsLine(x1, y1, x2, y2, rx1, ry1, rx2, ry1) ||
        lineIntersectsLine(x1, y1, x2, y2, rx2, ry1, rx2, ry2) ||
        lineIntersectsLine(x1, y1, x2, y2, rx2, ry2, rx1, ry2) ||
        lineIntersectsLine(x1, y1, x2, y2, rx1, ry2, rx1, ry1) ||
        (x1 >= rx1 && x1 <= rx2 && y1 >= ry1 && y1 <= ry2 &&
            x2 >= rx1 && x2 <= rx2 && y2 >= ry1 && y2 <= ry2);
  }

  private boolean lineIntersectsLine(int x1, int y1, int x2, int y2,
                                     int x3, int y3, int x4, int y4) {
    int d1 = direction(x3, y3, x4, y4, x1, y1);
    int d2 = direction(x3, y3, x4, y4, x2, y2);
    int d3 = direction(x1, y1, x2, y2, x3, y3);
    int d4 = direction(x1, y1, x2, y2, x4, y4);
    return ((d1 * d2 < 0) && (d3 * d4 < 0));
  }

  private int direction(int xi, int yi, int xj, int yj, int xk, int yk) {
    return (xk - xi) * (yj - yi) - (xj - xi) * (yk - yi);
  }
}

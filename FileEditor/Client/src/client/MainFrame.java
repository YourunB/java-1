package client;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class MainFrame extends JFrame {

    JTextArea textArea = new JTextArea();
    JButton openButton = new JButton("Открыть файл");
    JButton saveButton = new JButton("Сохранить файл");
    JButton readLinesButton = new JButton("Построчное чтение файла");
    JFileChooser jFileChooser1 = new JFileChooser();

    public MainFrame() {
        setTitle("Работа с файлами");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        openButton.setBounds(10, 10, 150, 30);
        saveButton.setBounds(170, 10, 150, 30);
        readLinesButton.setBounds(330, 10, 200, 30);
        textArea.setBounds(10, 50, 560, 300);

        add(openButton);
        add(saveButton);
        add(readLinesButton);
        add(textArea);

        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });

        readLinesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readFileLineByLine();
            }
        });
    }

    void openFile() {
        int result = jFileChooser1.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                textArea.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    void saveFile() {
        int result = jFileChooser1.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(textArea.getText());
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    void readFileLineByLine() {
        int result = jFileChooser1.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                textArea.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}

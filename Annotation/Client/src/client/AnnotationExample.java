import javax.swing.*;

import java.awt.event.*;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Descr {
    String text();

    int num() default 1;
}

@Descr(num = 100, text = "class")
public class AnnotationExample extends JFrame {
    @Descr(num = 10, text = "Button1")
    private JButton jButton1 = new JButton("Button1");

    @Descr(num = 20, text = "Button2")
    private JButton jButton2 = new JButton("Button2");

    private JButton jButton3 = new JButton("Аннотация для класса");
    private JButton jButton4 =
        new JButton("Аннотация для метода без параметров");
    private JButton jButton5 = new JButton("Количество параметров");
    private JButton jButton6 =
        new JButton("Аннотация для метода с параметрами");
    private JTextArea jTextArea1 = new JTextArea();

    public AnnotationExample() {
        setTitle("Annotation Example");
        setLayout(null);

        jButton1.setBounds(20, 20, 200, 30);
        jButton2.setBounds(20, 60, 200, 30);
        jButton3.setBounds(20, 100, 300, 30);
        jButton4.setBounds(20, 140, 300, 30);
        jButton5.setBounds(20, 180, 300, 30);
        jButton6.setBounds(20, 220, 300, 30);
        jTextArea1.setBounds(350, 20, 400, 300);

        add(jButton1);
        add(jButton2);
        add(jButton3);
        add(jButton4);
        add(jButton5);
        add(jButton6);
        add(jTextArea1);

        // Обработчик для кнопки 3: вывод аннотации класса
        jButton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Descr descr =
                        AnnotationExample.class.getAnnotation(Descr.class);
                    jTextArea1.append("Класс: num=" + descr.num() + ", text=" +
                                      descr.text() + "\n");
                }
            });

        // Обработчик для кнопки 1: вывод аннотации поля jButton1
        jButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Field field =
                            AnnotationExample.class.getDeclaredField("jButton1");
                        Descr descr = field.getAnnotation(Descr.class);
                        jTextArea1.append("jButton1: num=" + descr.num() +
                                          ", text=" + descr.text() + "\n");
                    } catch (NoSuchFieldException ex) {
                        jTextArea1.append("Ошибка: " + ex.getMessage() + "\n");
                    }
                }
            });

        // Обработчик для кнопки 2: вывод аннотации поля jButton2
        jButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Field field =
                            AnnotationExample.class.getDeclaredField("jButton2");
                        Descr descr = field.getAnnotation(Descr.class);
                        jTextArea1.append("jButton2: num=" + descr.num() +
                                          ", text=" + descr.text() + "\n");
                    } catch (NoSuchFieldException ex) {
                        jTextArea1.append("Ошибка: " + ex.getMessage() + "\n");
                    }
                }
            });

        // Обработчик для кнопки 4: вывод аннотации метода M1
        jButton4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Method method =
                            AnnotationExample.class.getDeclaredMethod("M1");
                        Descr descr = method.getAnnotation(Descr.class);
                        jTextArea1.append("Метод M1: num=" + descr.num() +
                                          ", text=" + descr.text() + "\n");
                    } catch (NoSuchMethodException ex) {
                        jTextArea1.append("Ошибка: " + ex.getMessage() + "\n");
                    }
                }
            });

        // Обработчик для кнопки 6: вывод аннотации метода M2
        jButton6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Method method =
                            AnnotationExample.class.getDeclaredMethod("M2",
                                                                      String.class,
                                                                      String.class);
                        Descr descr = method.getAnnotation(Descr.class);
                        jTextArea1.append("Метод M2: num=" + descr.num() +
                                          ", text=" + descr.text() + "\n");
                    } catch (NoSuchMethodException ex) {
                        jTextArea1.append("Ошибка: " + ex.getMessage() + "\n");
                    }
                }
            });

        // Обработчик для кнопки 5: получение информации о количестве параметров методов
        jButton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jTextArea1.append("Кол-во параметров M1: " +
                                      getMethodInfo("M1") + "\n");
                    jTextArea1.append("Кол-во параметров M2: " +
                                      getMethodInfo("M2", String.class,
                                                    String.class) + "\n");
                }
            });

        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Descr(num = 200, text = "method M1")
    private void M1() {
    }

    @Descr(num = 300, text = "method M2")
    private void M2(String a, String b) {
    }

    private Integer getMethodInfo(String name, Class<?>... params) {
        try {
            Method method =
                AnnotationExample.class.getDeclaredMethod(name, params);
            return method.getParameterTypes().length; // Заменено на старый способ
        } catch (NoSuchMethodException e) {
            jTextArea1.append("Ошибка: " + e.getMessage() + "\n");
            return null;
        }
    }

    public static void main(String[] args) {
        new AnnotationExample();
    }
}

public class JPanel2 extends javax.swing.JPanel {

    public JPanel1() {
        initComponents();
    }

    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 51,
                                         255)); // Устанавливаем цвет панели
        setLayout(null);

        jButton1.setText("jButton1");
        add(jButton1); // Добавляем на панель кнопку
        jButton1.setBounds(169, 129, 55, 21);
    }

    private javax.swing.JButton jButton1;

}

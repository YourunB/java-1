public class JPanel1 extends javax.swing.JPanel {

    public JPanel1() {
        initComponents();
    }

    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 255,
                                         102)); // ������������� ���� ������
        setLayout(null);

        jButton1.setText("jButton1");
        add(jButton1); // ��������� �� ������ ������
        jButton1.setBounds(163, 119, 55, 21);
    }

    private javax.swing.JButton jButton1;

}

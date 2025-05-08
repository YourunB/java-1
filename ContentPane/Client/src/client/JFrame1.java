import javax.swing.JFrame;

public class JFrame1 extends javax.swing.JFrame {

    public JFrame1() {
        initComponents();
    } // �����������

    private void initComponents() {

        jButton1 = new javax.swing.JButton(); // �������� �����������
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("jButton1");
        getContentPane().add(jButton1); // ���������� ���������� �� ������� contentPane
        jButton1.setBounds(150, 140, 55, 21);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 170, 167, 78);

        jMenu1.setText("Content"); // ��������� �������


        jMenuItem1.setText("content1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    this.setContentPane(new JPanel2());
                    this.revalidate(); // ���������� ����������� ����������
                }
            });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("content2");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    this.setContentPane(new JPanel2());
                    this.revalidate();
                }
            });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1); // ����������� ������� ����

        setBounds(0, 0, 416, 340);
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new JFrame1().setVisible(true); // �������� � ����������� �����
                }
            });
    }

    private javax.swing.JButton jButton1; // ��������� ������
    private javax.swing.JMenu jMenu1; // �������
    private javax.swing.JMenuBar jMenuBar1; // ������� ����
    private javax.swing.JMenuItem jMenuItem1; // ������� ����
    private javax.swing.JMenuItem jMenuItem2; // ������� ����
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1; // ��������� �������


}

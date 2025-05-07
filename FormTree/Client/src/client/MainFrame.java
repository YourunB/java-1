package client;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    private JTree tree;
    private DefaultTreeModel model;
    private JPanel panel;
    private JButton addSiblingButton;
    private JButton addChildButton;
    private JButton deleteButton;

    public MainFrame() {
        setTitle("������ �����");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- �������� ������ ---
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("World");
        DefaultMutableTreeNode country = new DefaultMutableTreeNode("Russia");
        DefaultMutableTreeNode state = new DefaultMutableTreeNode("MO");
        DefaultMutableTreeNode city = new DefaultMutableTreeNode("Noginsk");

        root.add(country);
        country.add(state);
        state.add(city);

        model = new DefaultTreeModel(root);
        tree = new JTree(model);

        // --- ��������� ������ � ����� ���� ---
        add(new JScrollPane(tree), BorderLayout.CENTER);

        // --- �������� ������ � �������� ---
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));

        addSiblingButton = new JButton("�������� �����");
        addChildButton = new JButton("�������� ��������");
        deleteButton = new JButton("������� ����");

        panel.add(addSiblingButton);
        panel.add(addChildButton);
        panel.add(deleteButton);

        // --- ��������� ������ � ��� ���� ---
        add(panel, BorderLayout.SOUTH);

        // --- ����������� ������� ---
        addSiblingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addSiblingButtonActionPerformed(evt);
            }
        });

        addChildButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addChildButtonActionPerformed(evt);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
    }

    // --- �������� �������� ���� ---
    private void addSiblingButtonActionPerformed(ActionEvent evt) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
            if (parent != null) {
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("����� ����");
                int selectedIndex = parent.getIndex(selectedNode);
                model.insertNodeInto(newNode, parent, selectedIndex + 1);
                TreeNode[] nodes = model.getPathToRoot(newNode);
                TreePath path = new TreePath(nodes);
                tree.scrollPathToVisible(path);  // <- �������� �����
            }
        }
    }

    // --- �������� �������� ���� ---
    private void addChildButtonActionPerformed(ActionEvent evt) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("����� ��������");
            model.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
            TreeNode[] nodes = model.getPathToRoot(newNode);
            TreePath path = new TreePath(nodes);
            tree.scrollPathToVisible(path);  // <- �������� �����
        }
    }

    // --- ������� ���� ---
    private void deleteButtonActionPerformed(ActionEvent evt) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (selectedNode != null && selectedNode.getParent() != null) {
            model.removeNodeFromParent(selectedNode);
        }
    }

    // --- ����� ����� � ��������� ---
    public static void main(String[] args) {
        // ����� ����� ��� �����
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}

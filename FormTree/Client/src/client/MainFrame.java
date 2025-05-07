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
        setTitle("Дерево узлов");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Создание дерева ---
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("World");
        DefaultMutableTreeNode country = new DefaultMutableTreeNode("Russia");
        DefaultMutableTreeNode state = new DefaultMutableTreeNode("MO");
        DefaultMutableTreeNode city = new DefaultMutableTreeNode("Noginsk");

        root.add(country);
        country.add(state);
        state.add(city);

        model = new DefaultTreeModel(root);
        tree = new JTree(model);

        // --- Добавляем дерево в центр окна ---
        add(new JScrollPane(tree), BorderLayout.CENTER);

        // --- Создание панели с кнопками ---
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));

        addSiblingButton = new JButton("Добавить брата");
        addChildButton = new JButton("Добавить дочерний");
        deleteButton = new JButton("Удалить узел");

        panel.add(addSiblingButton);
        panel.add(addChildButton);
        panel.add(deleteButton);

        // --- Добавляем панель в низ окна ---
        add(panel, BorderLayout.SOUTH);

        // --- Обработчики событий ---
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

    // --- Добавить братский узел ---
    private void addSiblingButtonActionPerformed(ActionEvent evt) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
            if (parent != null) {
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("Новый брат");
                int selectedIndex = parent.getIndex(selectedNode);
                model.insertNodeInto(newNode, parent, selectedIndex + 1);
                TreeNode[] nodes = model.getPathToRoot(newNode);
                TreePath path = new TreePath(nodes);
                tree.scrollPathToVisible(path);  // <- Исправил метод
            }
        }
    }

    // --- Добавить дочерний узел ---
    private void addChildButtonActionPerformed(ActionEvent evt) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("Новый дочерний");
            model.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
            TreeNode[] nodes = model.getPathToRoot(newNode);
            TreePath path = new TreePath(nodes);
            tree.scrollPathToVisible(path);  // <- Исправил метод
        }
    }

    // --- Удалить узел ---
    private void deleteButtonActionPerformed(ActionEvent evt) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (selectedNode != null && selectedNode.getParent() != null) {
            model.removeNodeFromParent(selectedNode);
        }
    }

    // --- Точка входа в программу ---
    public static void main(String[] args) {
        // Здесь вызов без лямбд
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}

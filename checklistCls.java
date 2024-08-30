package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class checklistCls extends JFrame {

    private DefaultListModel<TaskItem> listModel;
    private JList<TaskItem> taskList;

    public void checklistApp() {
        // Initialize the list model and task list
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        taskList.setBackground(Color.LIGHT_GRAY);
        taskList.setForeground(Color.LIGHT_GRAY); // Set text color if needed

        taskList.setOpaque(false);

        // Set the custom renderer for the task list
        taskList.setCellRenderer(new TaskItemRenderer());

        // Add mouse listener to the JList
        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) { // Left click
                    int index = taskList.locationToIndex(e.getPoint());
                    if (index != -1) {
                        TaskItem item = listModel.getElementAt(index);
                        item.setSelected(!item.isSelected());
                        taskList.repaint(); // Refresh the list to show changes
                    }
                }
            }
        });

        // Show the checklist UI
        showChecklist();
    }

    private void showChecklist() {
        // Create the main frame for the checklist
        JFrame checklistLayout = new JFrame("Checklist");
        checklistLayout.setSize(300, 400);
        checklistLayout.setLocationRelativeTo(null); // Center the frame on the screen
        checklistLayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        checklistLayout.getContentPane().setBackground(Color.DARK_GRAY);
        checklistLayout.setLayout(null);
        checklistLayout.setResizable(false);

        // Create and configure the "Add Task" button
        JButton addTaskButton = new JButton("+");
        addTaskButton.setBounds(50, 20, 200, 30);
        addTaskButton.setBackground(Color.BLACK); // Set background to black
        addTaskButton.setForeground(Color.ORANGE);
        addTaskButton.setFont(new Font("Dialog", Font.BOLD, 30));

        // Create the scroll pane for the task list
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(50, 70, 200, 250);
        scrollPane.getViewport().setBackground(Color.GRAY);

        // Add components to the main frame
        checklistLayout.add(addTaskButton);
        checklistLayout.add(scrollPane);
        checklistLayout.setVisible(true);

        // Add action listener to the "Add Task" button
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addList();
            }
        });
    }

    private void addList() {
        // Show an input dialog to enter a new task
        String newTask = JOptionPane.showInputDialog(this, "Enter New Task");
        if (newTask != null && !newTask.trim().isEmpty()) {
            // Add the new task to the list model
            listModel.addElement(new TaskItem(newTask.trim()));
        }
    }

    public static void main(String[] args) {
        // Start the application
        SwingUtilities.invokeLater(() -> new checklistCls());
    }
}

class TaskItem {
    private String taskName;
    private boolean isSelected;

    public TaskItem(String taskName) {
        this.taskName = taskName;
        this.isSelected = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public String toString() {
        return taskName;
    }
}

class TaskItemRenderer extends JPanel implements ListCellRenderer<TaskItem> {

    private JCheckBox checkBox;
    private JLabel label;

    public TaskItemRenderer() {
        setLayout(new BorderLayout());
        checkBox = new JCheckBox();
        label = new JLabel();
        add(checkBox, BorderLayout.WEST);
        add(label, BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends TaskItem> list, TaskItem value, int index, boolean isSelected, boolean cellHasFocus) {
        checkBox.setSelected(value.isSelected());
        label.setText(value.getTaskName());

        // Update the background and foreground based on selection
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setOpaque(true); // Ensure the background color is visible

        return this;
    }
}

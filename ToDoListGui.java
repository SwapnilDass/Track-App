package org.example;



import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.stopWatchCls.showStopwatch;
import static org.example.worldClockCls.worldClock;

public class ToDoListGui extends JFrame {

    private DefaultListModel<String> listModel;
    private JList<String> taskList;

    private JSONObject ToDoList;

    public ToDoListGui(){

        super ("Track");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //setting the size of our gui
        setSize(450, 650);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        addGuiComponents();

    }
    private void addGuiComponents() {

        JLabel AppText = new JLabel("TracK");
        AppText.setBounds(0, 10,200, 53);
        AppText.setFont(new Font("Dialog", Font.BOLD, 30));
        add(AppText);

        JButton ChecklistButton = new JButton("Checklist");
        ChecklistButton.setBounds(0, 200,200, 53);
        AppText.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(ChecklistButton);

        JButton ShowCalendarButton = new JButton("Calendar");
        ShowCalendarButton.setBounds(0, 300,200, 53);
        ShowCalendarButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(ShowCalendarButton);

        JButton worldClockBtn = new JButton("World Clock");
        worldClockBtn.setBounds(0, 400,200, 53);
        worldClockBtn.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(worldClockBtn);

        JButton utilitiesBtn = new JButton("Utilities");
        utilitiesBtn.setBounds(0, 500,200, 53);
        utilitiesBtn.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(utilitiesBtn);



        ChecklistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChecklist();
            }
        });
        ShowCalendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                showDate();
            }
        });
        worldClockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                worldClock();
            }
        });
        utilitiesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                showUtilities();
            }
        });
    }
    //DEFINING showCheckList() function
    private void showChecklist(){
        JFrame checklistlayout = new JFrame("Checklist");
        checklistlayout.setSize(300,400);
        checklistlayout.setLocationRelativeTo(this);
        checklistlayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        checklistlayout.setLayout(null);

        JButton addTaskButton = new JButton("+");
        addTaskButton.setBounds(50, 20,200, 30);
        addTaskButton.setFont(new Font("Dialog", Font.BOLD, 30));

        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(50, 70, 200, 250);


        checklistlayout.add(addTaskButton);
        checklistlayout.add(scrollPane);
        checklistlayout.setVisible(true);

        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addList();
            }
        });

    }
    private void addList(){
        String newTask = JOptionPane.showInputDialog(this,"Enter new Task");
        if (newTask != null && !newTask.trim().isEmpty()) {
            listModel.addElement(newTask.trim());
        }
    }

    //DEFINING ShowDate() function
    private void showDate(){
        JFrame calenderLayout = new JFrame("Calendar");
        calenderLayout.setSize(300,400);
        calenderLayout.setLocationRelativeTo(this);
        calenderLayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        calenderLayout.setLayout(null);

        JButton showCalenderbtn = new JButton("Show Calendar");
        showCalenderbtn.setBounds(50, 50,200, 30);
        showCalenderbtn.setFont(new Font("Dialog", Font.PLAIN, 20));

        JButton addReminderbtn = new JButton("Add a Reminder");
        addReminderbtn.setBounds(50, 100,200, 30);
        addReminderbtn.setFont(new Font("Dialog", Font.PLAIN, 20));

        calenderLayout.add(addReminderbtn);
        calenderLayout.add(showCalenderbtn);

        addReminderbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addReminder();
            }
        });
        showCalenderbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCalendar();
            }
        });

        calenderLayout.setVisible(true);
    }
    //DEFINING showCalendar() function
    private void showCalendar(){
        JFrame showCalenderLayout = new JFrame("Calendar");
        showCalenderLayout.setSize(300,400);
        showCalenderLayout.setLocationRelativeTo(this);
        showCalenderLayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showCalenderLayout.setLayout(null);

        JCalendar calender = new JCalendar();
        calender.setBounds(10,10,280,300);

        showCalenderLayout.add(calender);
        showCalenderLayout.setVisible(true);

    }
    //DEFINING addReminder() function
    private void addReminder(){
        JFrame addReminderLayout = new JFrame("Add Reminder");
        addReminderLayout.setSize(300,400);
        addReminderLayout.setLocationRelativeTo(this);
        addReminderLayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addReminderLayout.setLayout(null);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(10,10,280,300);

        addReminderLayout.add(dateChooser);
        addReminderLayout.setVisible(true);

    }
    //DEFINING showUtilities() function
    private  void showUtilities(){
        JFrame utilitiesLayout = new JFrame("Utilities");
        utilitiesLayout.setSize(300,400);
        utilitiesLayout.setLocationRelativeTo(this);
        utilitiesLayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        utilitiesLayout.setLayout(null);


        JButton stopwatchBtn = new JButton("Stopwatch");
        stopwatchBtn.setBounds(50, 100,200, 30);
        stopwatchBtn.setFont(new Font("Dialog", Font.PLAIN, 20));

        JButton timerBtn = new JButton("Timer");
        timerBtn.setBounds(50, 150,200, 30);
        timerBtn.setFont(new Font("Dialog", Font.PLAIN, 20));


        utilitiesLayout.add(stopwatchBtn);
        utilitiesLayout.add(timerBtn);

        utilitiesLayout.setVisible(true);

        stopwatchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStopwatch();
            }
        });


    }



}

package org.example;



import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

//import static org.example.checklistCls.CheckListApp;
import static org.example.stopWatchCls.showStopwatch;
import static org.example.timerCls.showTimer;
import static org.example.worldClockCls.worldClock;

public class ToDoListGui extends JFrame {

    private DefaultListModel<String> listModel;
    private JList<String> taskList;

    private JSONObject ToDoList;

    public ToDoListGui(){

        super ("Track");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //setting the size of our gui
        setSize(550, 325);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.DARK_GRAY);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        addGuiComponents();

    }
    private void addGuiComponents() {

        JLabel AppText = new JLabel("Track");
        AppText.setBounds(190, 10,380, 80);
        Font font = new Font("Dialog", Font.BOLD, 50);
        AppText.setFont(font);
        AppText.setForeground(Color.ORANGE);
        add(AppText);

        JButton ChecklistButton = new JButton("Checklist");
        ChecklistButton.setBounds(30, 100,200, 53);
        ChecklistButton.setFont(new Font("Dialog", Font.BOLD, 20));
        ChecklistButton.setBackground(Color.BLACK); // Set background to black
        ChecklistButton.setForeground(Color.orange);
        add(ChecklistButton);

        JButton ShowCalendarButton = new JButton("Calendar");
        ShowCalendarButton.setBounds(290, 100,200, 53);
        ShowCalendarButton.setFont(new Font("Dialog", Font.BOLD, 20));
        ShowCalendarButton.setBackground(Color.BLACK); // Set background to black
        ShowCalendarButton.setForeground(Color.orange);
        add(ShowCalendarButton);

        JButton worldClockBtn = new JButton("World Clock");
        worldClockBtn.setBounds(30, 200,200, 53);
        worldClockBtn.setFont(new Font("Dialog", Font.BOLD, 20));
        worldClockBtn.setBackground(Color.BLACK); // Set background to black
        worldClockBtn.setForeground(Color.orange);
        add(worldClockBtn);

        JButton utilitiesBtn = new JButton("Utilities");
        utilitiesBtn.setBounds(290, 200,200, 53);
        utilitiesBtn.setFont(new Font("Dialog", Font.BOLD, 20));
        utilitiesBtn.setBackground(Color.BLACK); // Set background to black
        utilitiesBtn.setForeground(Color.orange);
        add(utilitiesBtn);



        ChecklistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checklistCls checkListApp = new checklistCls();
                checkListApp.checklistApp();


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


    //DEFINING ShowDate() function
    private void showDate(){
        JFrame calenderLayout = new JFrame("Calendar");
        calenderLayout.setSize(300,225);
        calenderLayout.setLocationRelativeTo(this);
        calenderLayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        calenderLayout.getContentPane().setBackground(Color.DARK_GRAY);
        calenderLayout.setLayout(null);
        calenderLayout.setResizable(false);

        JButton showCalenderbtn = new JButton("Show Calendar");
        showCalenderbtn.setBounds(50, 50,200, 30);
        showCalenderbtn.setBackground(Color.BLACK); // Set background to black
        showCalenderbtn.setForeground(Color.orange);
        showCalenderbtn.setFont(new Font("Dialog", Font.BOLD, 20));

        JButton addReminderbtn = new JButton("Add a Reminder");
        addReminderbtn.setBounds(50, 100,200, 30);
        addReminderbtn.setBackground(Color.BLACK); // Set background to black
        addReminderbtn.setForeground(Color.orange);
        addReminderbtn.setFont(new Font("Dialog", Font.BOLD, 20));

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
        showCalenderLayout.setSize(350,375);
        showCalenderLayout.setLocationRelativeTo(this);
        showCalenderLayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showCalenderLayout.getContentPane().setBackground(Color.DARK_GRAY);
        showCalenderLayout.setLayout(null);
        showCalenderLayout.setResizable(false);

        JCalendar calender = new JCalendar();
        calender.setForeground(Color.black);

        // Set the background color of the calendar
        calender.setBackground(Color.LIGHT_GRAY);

        // Set the background color for the days of the month
        calender.getDayChooser().setBackground(Color.GRAY);

        // Set the background color for the selected day
        calender.getDayChooser().getDayPanel().setBackground(Color.DARK_GRAY);

        // Set the color of the weekday header (Sun, Mon, Tue, etc.)
        calender.getDayChooser().getDayPanel().setForeground(Color.BLUE);

        // Set the color of the month title
        calender.getMonthChooser().getComboBox().setBackground(Color.DARK_GRAY);
        calender.getMonthChooser().getComboBox().setForeground(Color.ORANGE);

        // Set the color of the year title
        calender.getYearChooser().getSpinner().setForeground(Color.RED);

        // Set bounds for the calendar
        calender.setBounds(30, 10, 280, 300);

        calender.setBounds(30,10,280,300);

        showCalenderLayout.add(calender);
        showCalenderLayout.setVisible(true);

    }
    //DEFINING addReminder() function
    private void addReminder(){
        JFrame addReminderLayout = new JFrame("Add Reminder");
        addReminderLayout.setSize(300,500);
        addReminderLayout.setLocationRelativeTo(this);
        addReminderLayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addReminderLayout.getContentPane().setBackground(Color.DARK_GRAY);
        addReminderLayout.setLayout(null);
        addReminderLayout.setResizable(false);

        JDateChooser dateChooser = new JDateChooser();

// Change the background color of the date chooser
        dateChooser.getCalendarButton().setBackground(Color.LIGHT_GRAY); // Button color
        dateChooser.getDateEditor().getUiComponent().setBackground(Color.GRAY); // Text field color

// Change the text color of the date chooser
        dateChooser.getDateEditor().getUiComponent().setForeground(Color.BLACK);

// Optionally, you can also change the border color of the text field
        dateChooser.getDateEditor().getUiComponent().setBorder(BorderFactory.createLineBorder(Color.GRAY));

// Set the bounds as you did before
        dateChooser.setBounds(50, 10, 200, 250);

        JButton reminderbtn = new JButton("Add Reminder Description");
        reminderbtn.setBounds(25, 280, 250, 40);
        reminderbtn.setBackground(Color.BLACK); // Set background to black
        reminderbtn.setForeground(Color.ORANGE);
        reminderbtn.setFont(new Font("Dialog", Font.BOLD, 15));

        JList<String> reminderList = new JList<>(listModel);
        reminderList.setBackground(Color.GRAY); // Set a lighter background to contrast with dark gray
        reminderList.setForeground(Color.BLACK);
        reminderList.setOpaque(true);

        JScrollPane listScrollPane = new JScrollPane(reminderList);
        listScrollPane.setBounds(25, 330, 250, 100); // Adjust bounds as necessary
        listScrollPane.getViewport().setBackground(Color.GRAY);

        addReminderLayout.add(reminderbtn);
        addReminderLayout.add(listScrollPane);

        reminderbtn.addActionListener(e -> reminderdesc(dateChooser.getDate()));

        addReminderLayout.add(dateChooser);
        addReminderLayout.setVisible(true);

    }
    private void reminderdesc(Date selectedDate){
        if (selectedDate == null){
            JOptionPane.showMessageDialog(null,"Please select a date first");
            return;
        }
        JList<String> list = new JList<>();
        String newTask = JOptionPane.showInputDialog("Enter Description");

        if (newTask != null && !newTask.trim().isEmpty()){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String datestr = dateFormat.format(selectedDate);

            //Combine the date and the task description
            String reminder = datestr + ": " + newTask.trim();

            listModel.addElement(reminder);
        }

    }
    //DEFINING showUtilities() function
    private  void showUtilities(){
        JFrame utilitiesLayout = new JFrame("Utilities");
        utilitiesLayout.setSize(300,225);
        utilitiesLayout.setLocationRelativeTo(this);
        utilitiesLayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        utilitiesLayout.getContentPane().setBackground(Color.darkGray);
        utilitiesLayout.setLayout(null);
        utilitiesLayout.setResizable(false);


        JButton stopwatchBtn = new JButton("Stopwatch");
        stopwatchBtn.setBounds(50, 50,200, 30);
        stopwatchBtn.setBackground(Color.BLACK); // Set background to black
        stopwatchBtn.setForeground(Color.ORANGE);
        stopwatchBtn.setFont(new Font("Dialog", Font.BOLD, 20));

        JButton timerBtn = new JButton("Timer");
        timerBtn.setBounds(50, 100,200, 30);
        timerBtn.setBackground(Color.BLACK); // Set background to black
        timerBtn.setForeground(Color.ORANGE);
        timerBtn.setFont(new Font("Dialog", Font.BOLD, 20));


        utilitiesLayout.add(stopwatchBtn);
        utilitiesLayout.add(timerBtn);

        utilitiesLayout.setVisible(true);

        stopwatchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStopwatch();
            }
        });
        timerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTimer();
            }
        });
    }
}

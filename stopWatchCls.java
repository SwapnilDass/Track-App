package org.example;

import javax.swing.*;
import java.awt.*;


public class stopWatchCls {

    private static Timer timer;
    public static int elapsedTime = 0; // Time in milliseconds
    private static boolean isRunning = false;
    private static JLabel timeDisplay;



    static void showStopwatch() {

        JFrame stopwatchLayout = new JFrame("Utilities");
        stopwatchLayout.setSize(300, 350);
        stopwatchLayout.setLocationRelativeTo(null);
        stopwatchLayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        stopwatchLayout.getContentPane().setBackground(Color.DARK_GRAY);
        stopwatchLayout.setLayout(null);
        stopwatchLayout.setResizable(false);

        // Time Display Button
        timeDisplay = new JLabel(formatTime(elapsedTime), SwingConstants.CENTER);
        timeDisplay.setBounds(43, 50, 200, 50);
        timeDisplay.setFont(new Font("Dialog", Font.BOLD, 30));
        timeDisplay.setForeground(Color.orange);
        stopwatchLayout.add(timeDisplay);

        //Start Button
        JButton startButton = new JButton("Start");
        startButton.setBounds(50, 150, 80, 50);
        startButton.setBackground(Color.BLACK); // Set background to black
        startButton.setForeground(Color.ORANGE);
        startButton.addActionListener(e -> startsStopwatch());
        stopwatchLayout.add(startButton);

        //Stop Button
        JButton stopButton = new JButton("Stop");
        stopButton.setBounds(150, 150, 80, 50);
        stopButton.setBackground(Color.BLACK); // Set background to black
        stopButton.setForeground(Color.ORANGE);
        stopButton.addActionListener(e -> stopStopwatch());
        stopwatchLayout.add(stopButton);

        //Reset Button
        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(100, 225, 80, 50);
        resetButton.setBackground(Color.BLACK); // Set background to black
        resetButton.setForeground(Color.ORANGE);
        resetButton.addActionListener(e -> resetStopwatch());
        stopwatchLayout.add(resetButton);

        //Timer to update the stopwatch every 100 milliseconds
        timer = new Timer(100, e -> updateStopWatch());

        stopwatchLayout.setVisible(true);



    }
    private static void startsStopwatch(){
        if (!isRunning){
            timer.start();
            isRunning = true;
        }
    }
    private static void stopStopwatch(){
        if (isRunning){
            timer.stop();
            isRunning = false;
        }
    }
    private static void resetStopwatch(){
        timer.stop();
        isRunning = false;
        elapsedTime = 0;
        timeDisplay.setText(formatTime(elapsedTime));
    }
    private  static void updateStopWatch(){
        elapsedTime += 100;
        timeDisplay.setText(formatTime(elapsedTime));
    }
    private static String formatTime(int timeInMillis) {
        int seconds = (timeInMillis / 1000) % 60;
        int minutes = (timeInMillis / 60000) % 60;
        int hours = (timeInMillis / 3600000);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

}

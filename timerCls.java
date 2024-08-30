package org.example;

//import javax.management.timer.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class timerCls {

    static void showTimer() {

        JFrame timerLayout = new JFrame("Timer");
        timerLayout.setLocationRelativeTo(null);
        timerLayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        timerLayout.setSize(450, 200);
        timerLayout.setLayout(new GridLayout(4, 2, 10, 10));
        timerLayout.getContentPane().setBackground(Color.DARK_GRAY);
        timerLayout.setResizable(false);

        //Create scroll bars
        JScrollBar hourScrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0, 24);
        JScrollBar minuteScrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0, 60);
        JScrollBar secondScrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0, 60);

        //Labels to show selected values
        JLabel hourLabel = new JLabel("Hour: 0");
        hourLabel.setForeground(Color.orange);
        JLabel minuteLabel = new JLabel("Minute: 0");
        minuteLabel.setForeground(Color.orange);
        JLabel secondLabel = new JLabel("Second: 0");
        secondLabel.setForeground(Color.orange);

        //Add listeners to update labels when the scroll bar values change
        hourScrollBar.addAdjustmentListener(e -> hourLabel.setText("Hour: " + ( hourScrollBar.getValue())));
        hourScrollBar.setBackground(Color.BLACK);
        hourScrollBar.setForeground(Color.ORANGE);

        minuteScrollBar.addAdjustmentListener(e -> minuteLabel.setText("Minute: " + ( minuteScrollBar.getValue())));
        minuteScrollBar.setBackground(Color.BLACK);
        minuteScrollBar.setForeground(Color.ORANGE);

        secondScrollBar.addAdjustmentListener(e -> secondLabel.setText("Second: " +  ( secondScrollBar.getValue())));
        secondScrollBar.setBackground(Color.BLACK);
        secondScrollBar.setForeground(Color.ORANGE);

        hourScrollBar.setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {

            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.ORANGE; // Color of the thumb
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton decreaseButton = super.createDecreaseButton(orientation);
                decreaseButton.setBackground(Color.BLACK);
                decreaseButton.setForeground(Color.ORANGE);
                return decreaseButton;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton increaseButton = super.createIncreaseButton(orientation);
                increaseButton.setBackground(Color.BLACK);
                increaseButton.setForeground(Color.ORANGE);
                return increaseButton;
            }
        });
        minuteScrollBar.setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {

            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.ORANGE; // Color of the thumb
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton decreaseButton = super.createDecreaseButton(orientation);
                decreaseButton.setBackground(Color.BLACK);
                decreaseButton.setForeground(Color.ORANGE);
                return decreaseButton;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton increaseButton = super.createIncreaseButton(orientation);
                increaseButton.setBackground(Color.BLACK);
                increaseButton.setForeground(Color.ORANGE);
                return increaseButton;
            }
        });
        secondScrollBar.setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {

            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.ORANGE; // Color of the thumb
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton decreaseButton = super.createDecreaseButton(orientation);
                decreaseButton.setBackground(Color.BLACK);
                decreaseButton.setForeground(Color.ORANGE);
                return decreaseButton;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton increaseButton = super.createIncreaseButton(orientation);
                increaseButton.setBackground(Color.BLACK);
                increaseButton.setForeground(Color.ORANGE);
                return increaseButton;
            }
        });

        //Button to start the timer
        JButton startButton = new JButton("Start Timer");
        startButton.setBackground(Color.BLACK); // Set background to black
        startButton.setForeground(Color.orange);
        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int hours = hourScrollBar.getValue();
                int minutes = minuteScrollBar.getValue();
                int seconds = secondScrollBar.getValue();
                int totalSeconds = hours * 3600 + minutes * 60 + seconds;


                JFrame timerCountdownLayout = new JFrame("Timer Countdown");
                timerCountdownLayout.setSize(400, 200);
                timerCountdownLayout.setLayout(new GridLayout(1,1));
                JLabel countdownLabel = new JLabel("", SwingConstants.CENTER);
                countdownLabel.setFont(new Font("Serif", Font.BOLD, 30));
                timerCountdownLayout.getContentPane().setBackground(Color.DARK_GRAY);
                timerCountdownLayout.add(countdownLabel);
                timerCountdownLayout.setLocationRelativeTo(null);
                timerCountdownLayout.setVisible(true);
                //timerCountdownLayout.setResizable(false);

                startCountdown(totalSeconds,countdownLabel, timerCountdownLayout);


            }
        });

        //Add components to the frame
        timerLayout.add(hourLabel);
        timerLayout.add(hourScrollBar);
        timerLayout.add(minuteLabel);
        timerLayout.add(minuteScrollBar);
        timerLayout.add(secondLabel);
        timerLayout.add(secondScrollBar);
        timerLayout.add(new JLabel());  // Placeholder to fill the grid
        timerLayout.add(startButton);

        timerLayout.setVisible(true);

    }

    // Method to start the countdown
    static void startCountdown(int totalSeconds, JLabel countdownLabel, JFrame timerCountdownLayout) {
        Timer timer = new Timer(1000, new ActionListener() {
            int timeLeft = totalSeconds;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {
                    int hours = timeLeft / 3600;
                    int minutes = (timeLeft % 3600) / 60;
                    int seconds = timeLeft % 60;
                    countdownLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
                    countdownLabel.setForeground(Color.orange);
                    timeLeft--;
                } else {
                    ((Timer) e.getSource()).stop();
                    countdownLabel.setText("00:00:00");
                    System.out.println("Timer finished!");
                    JOptionPane.showMessageDialog(timerCountdownLayout, "Time's up!");
                    timerCountdownLayout.dispose();
                }
            }
        });
        timer.start();
    }

}




























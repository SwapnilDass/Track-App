package org.example;

import javax.swing.*;
import java.awt.*;
import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class worldClockCls {

    private List<JLabel> clockLabels = new ArrayList<>();

    static void worldClock() {
        JFrame clockLayout = new JFrame("World Clock");
        clockLayout.setSize(300, 400);
        clockLayout.setLocationRelativeTo(null); // Center the frame on the screen
        clockLayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        clockLayout.setLayout(new GridLayout(0, 1)); // Grid layout with one column

        addClock("UTC","UTC",clockLayout);
        addClock("New York", "America/New_York", clockLayout);
        addClock("London", "Europe/London", clockLayout);
        addClock("Tokyo", "Asia/Tokyo", clockLayout);
        addClock("Sydney", "Australia/Sydney", clockLayout);

        Timer timer = new Timer(1000, e -> updateClocks(clockLayout));
        timer.start();

        clockLayout.setVisible(true);
    }


    public static void addClock(String city, String zoneId, JFrame frame) {
        JLabel mylabel = new JLabel(city + ": " + getCurrentTime(zoneId), SwingConstants.CENTER);
        mylabel.setFont(new Font("Dialog", Font.BOLD, 18));
        frame.add(mylabel);
    }

    public static String getCurrentTime(String zoneId) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(zoneId));
        return now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
    private static void updateClocks(JFrame frame) {
        for (Component comp : frame.getContentPane().getComponents()) {
            if (comp instanceof JLabel) {
                JLabel label = (JLabel) comp;
                String text = label.getText();
                String zoneId = text.split(":")[0].trim();
                label.setText(zoneId + ": " + getCurrentTime(zoneId));
            }
        }
    }

}


package org.example;

import javax.swing.*;
import java.awt.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class worldClockCls {

    private static Map<JLabel, String> labelZoneMap = new HashMap<>();

    static void worldClock() {
        JFrame clockLayout = new JFrame("World Clock");
        clockLayout.setSize(300, 400);
        clockLayout.setLocationRelativeTo(null); // Center the frame on the screen
        clockLayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        clockLayout.getContentPane().setBackground(Color.darkGray);
        clockLayout.setLayout(new GridLayout(0, 1)); // Grid layout with one column

        addClock("UTC", "UTC", clockLayout);
        addClock("New York", "America/New_York", clockLayout);
        addClock("London", "Europe/London", clockLayout);
        addClock("Tokyo", "Asia/Tokyo", clockLayout);
        addClock("Sydney", "Australia/Sydney", clockLayout);
        addClock("Toronto", "America/Toronto", clockLayout); // Added Toronto
        addClock("Dhaka", "Asia/Dhaka",clockLayout );
        addClock("Mumbai", "Asia/Kolkata", clockLayout);

        Timer timer = new Timer(1000, e -> updateClocks());
        timer.start();

        clockLayout.setVisible(true);
    }

    public static void addClock(String city, String zoneId, JFrame frame) {
        JLabel myLabel = new JLabel(city + ": " + getCurrentTime(zoneId), SwingConstants.CENTER);
        myLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        frame.add(myLabel);

        // Store the mapping of label to zoneId
        labelZoneMap.put(myLabel, zoneId);
    }

    public static String getCurrentTime(String zoneId) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(zoneId));
        return now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    private static void updateClocks() {
        for (Map.Entry<JLabel, String> entry : labelZoneMap.entrySet()) {
            JLabel label = entry.getKey();
            String zoneId = entry.getValue();
            String city = label.getText().split(":")[0].trim();
            label.setText(city + ": " + getCurrentTime(zoneId));
            label.setForeground(Color.orange);
        }
    }
}


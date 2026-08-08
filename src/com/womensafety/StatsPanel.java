package com.womensafety;

import javax.swing.*;
import java.awt.*;

public class StatsPanel extends JPanel {

    public DashboardCard activeCard;
    public DashboardCard resolvedCard;
    public DashboardCard usersCard;
    public DashboardCard todayCard;

    public StatsPanel() {

        setLayout(new GridLayout(1,4,20,20));
        setBackground(new Color(240,242,247));

        activeCard = new DashboardCard("🚨 Active Alerts","0",new Color(220,53,69));

        resolvedCard = new DashboardCard("✅ Resolved","0",new Color(40,167,69));

        usersCard = new DashboardCard("👥 Users","0",new Color(0,123,255));

        todayCard = new DashboardCard("📅 Today","0",new Color(255,153,0));

        add(activeCard);
        add(resolvedCard);
        add(usersCard);
        add(todayCard);

    }

}
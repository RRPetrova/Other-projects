package clock;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockFrame extends JFrame {

    SimpleDateFormat simpleTimeFormat;
    SimpleDateFormat simpleDateFormat;
    SimpleDateFormat simpleDayFormat;
    JLabel jLabelForTime;
    JLabel jLabelForDate;
    JLabel jLabelForDay;
    String currTime;
    String currDate;
    String currDay;

    ClockFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clock app");
        this.setLayout(new FlowLayout());
        this.setResizable(true);
        this.setBackground(Color.CYAN);
        this.setSize(350, 200);

        simpleTimeFormat = new SimpleDateFormat("H:mm:ss a");
        simpleDayFormat = new SimpleDateFormat("EEEE");
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        jLabelForTime = new JLabel();
        jLabelForTime.setBackground(Color.GREEN);
        jLabelForTime.setFont(new Font("Serif", Font.ITALIC, 50));
        jLabelForTime.setOpaque(true);

        jLabelForDay= new JLabel();
        jLabelForDay.setBackground(Color.GREEN);
        jLabelForDay.setFont(new Font("Tahoma", Font.BOLD, 20));

        jLabelForDate= new JLabel();
        jLabelForDate.setBackground(Color.GREEN);
        jLabelForDate.setFont(new Font("Arial", Font.BOLD, 35));

        this.add(jLabelForTime);
        this.add(jLabelForDay);
        this.add(jLabelForDate);
        this.setVisible(true);

        setTime();
    }

    private void setTime() {

        while (true) {
            currTime = simpleTimeFormat.format(Calendar.getInstance().getTime());
            jLabelForTime.setText(currTime);

            currDay = simpleDayFormat.format(Calendar.getInstance().getTime());
            jLabelForDay.setText(currDay);

            currDate = simpleDateFormat.format(Calendar.getInstance().getTime());
            jLabelForDate.setText(currDate);


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

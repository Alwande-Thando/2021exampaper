package za.co.prog6112.q1;

import javax.swing.*;
import java.awt.*;

/** GUI for selecting an instrument and level and viewing lesson costs. */
public class MusicalLessonsFrame extends JFrame {
    private final MusicalLessons lessons = new MusicalLessons();
    private final JComboBox<String> instrumentBox = new JComboBox<>(lessons.getInstruments());
    private final JComboBox<String> levelBox = new JComboBox<>(lessons.getLevels());
    private final JLabel costLabel = new JLabel("Select an instrument and level, then Submit.");

    public MusicalLessonsFrame() {
        super("Musical Lesson Costs");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(520, 260);
        setLocationRelativeTo(null);

        JPanel selections = new JPanel(new GridLayout(2, 2, 10, 10));
        selections.add(new JLabel("Instrument:")); selections.add(instrumentBox);
        selections.add(new JLabel("Musical level:")); selections.add(levelBox);

        JButton submit = new JButton("Submit");
        JButton report = new JButton("Average level report");
        JPanel buttons = new JPanel();
        buttons.add(submit); buttons.add(report);

        costLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(selections, BorderLayout.NORTH);
        add(costLabel, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        setJMenuBar(createMenuBar());

        submit.addActionListener(e -> submitSelection());
        report.addActionListener(e -> showReport());
    }

    private JMenuBar createMenuBar() {
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> dispose());
        file.add(exit);

        JMenu tools = new JMenu("Tools");
        JMenuItem submit = new JMenuItem("Submit");
        JMenuItem report = new JMenuItem("Average level report");
        submit.addActionListener(e -> submitSelection());
        report.addActionListener(e -> showReport());
        tools.add(submit); tools.add(report);
        bar.add(file); bar.add(tools);
        return bar;
    }

    private void submitSelection() {
        String instrument = (String) instrumentBox.getSelectedItem();
        String level = (String) levelBox.getSelectedItem();
        double cost = lessons.getLessonCost(instrument, level);
        costLabel.setText(String.format("%s lesson (%s): R%.2f", instrument, level, cost));
    }

    private void showReport() {
        JOptionPane.showMessageDialog(this, lessons.createAverageReport(),
                "Average Lesson Cost Report", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MusicalLessonsFrame().setVisible(true));
    }
}

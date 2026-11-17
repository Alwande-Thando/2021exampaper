package za.co.prog6112.q3;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/** GUI loads snake types into a combo box and displays selected file details. */
public class SnakeBiteFrame extends JFrame {
    private final JComboBox<String> snakeBox = new JComboBox<>();
    private final DefaultListModel<String> detailModel = new DefaultListModel<>();
    private final JList<String> detailList = new JList<>(detailModel);
    private List<SnakeInfo> snakes = List.of();

    public SnakeBiteFrame() {
        super("Snake Bite Medical Information");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(540, 300);
        setLocationRelativeTo(null);

        JButton submit = new JButton("Submit");
        JButton clear = new JButton("Clear");
        JPanel top = new JPanel();
        top.add(new JLabel("Select snake:"));
        top.add(snakeBox);
        top.add(submit);
        top.add(clear);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(detailList), BorderLayout.CENTER);

        submit.addActionListener(e -> displaySelectedSnake());
        clear.addActionListener(e -> detailModel.clear());

        // Populate the combo box from the sequential file as the form starts.
        loadSnakeTypes();
    }

    private void loadSnakeTypes() {
        try {
            snakes = new SnakeFileReader().loadSnakes(Path.of("snakes.txt"));
            snakeBox.removeAllItems();
            for (SnakeInfo snake : snakes) snakeBox.addItem(snake.getType());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Could not load snakes.txt. Keep it in the project working directory.\n" + ex.getMessage(),
                    "File error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displaySelectedSnake() {
        int selectedIndex = snakeBox.getSelectedIndex();
        if (selectedIndex < 0 || selectedIndex >= snakes.size()) return;

        SnakeInfo selected = snakes.get(selectedIndex);
        detailModel.clear();
        detailModel.addElement("Snake type: " + selected.getType());
        detailModel.addElement(selected.getFatalityRanking());
        detailModel.addElement(selected.getMedicalAssistance());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SnakeBiteFrame().setVisible(true));
    }
}

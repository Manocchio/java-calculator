package view;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    JPanel operationsField = new JPanel(null);
    JPanel operationHistory = new JPanel();
    JPanel currentOperation = new JPanel();
    JPanel fieldsPanel = new JPanel(null);

    final Color DARKER_BG = new Color(19, 19, 19);
    final Color DEFAULT_BG = new Color(55, 54, 61);


    public Window() {
        initFrame();
        initComponents();
    }


    private void initFrame() {
        setTitle("Calculadora");
        setLayout(null);
        setVisible(true);
        setSize(new Dimension(320, 535));
        setLocationRelativeTo(null);
        setResizable(false);
        this.getContentPane().setBackground(DEFAULT_BG);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        operationsField.setSize(getWidth(), 150);
        operationsField.setBackground(DARKER_BG);
        add(operationsField);

        operationHistory.setSize(new Dimension(operationsField.getWidth(), operationsField.getHeight() / 2));
        operationHistory.setLocation(0, 0);
        operationHistory.setBackground(DARKER_BG);

        currentOperation.setSize(new Dimension(operationsField.getWidth() - 18, operationsField.getHeight() / 2));
        currentOperation.setLocation(0, operationHistory.getHeight());
        currentOperation.setBackground(DARKER_BG);
        currentOperation.setBorder(BorderFactory.createLineBorder(Color.white));

        operationsField.add(operationHistory);
        operationsField.add(currentOperation);

        fieldsPanel.setSize(new Dimension(getWidth(), getHeight() - (operationsField.getHeight() + 15)));
        fieldsPanel.setLocation(0, getHeight() - fieldsPanel.getHeight());
        fieldsPanel.setBackground(DEFAULT_BG);

        add(fieldsPanel);

        int placedBtn = 0;
        int currentRow = 1;
        for (int i = 9; i >= 0; i--) {
            repaint();
            Button button = new Button("" + i);
            button.setLocation(fieldsPanel.getWidth()  - button.getWidth() * 2, 10);

            if (currentRow >= 1) {
                button.setLocation(fieldsPanel.getWidth() - ((button.getWidth() * placedBtn) + (button.getWidth() * 2)),  (currentRow - 1) * button.getHeight() + 10);
            }


            if(i == 0) {
                button.setLocation(fieldsPanel.getWidth()  - button.getWidth() * 3, (currentRow - 1) * button.getHeight() + 10);
            }

            fieldsPanel.add(button);
            repaint();
            placedBtn++;
            if(placedBtn % 3 == 0) {
                placedBtn = 0;
                currentRow++;
            }
        }
    }


}

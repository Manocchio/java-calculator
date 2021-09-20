package view;


import controller.Operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame implements ActionListener {

    JPanel operationsField = new JPanel(null);
    private Font font = new Font("Century Gothic", 1, 35);
    private Font fontHistory = new Font("Century Gothic", 1, 10);

    final int SUM = 1;
    final int SUB = 2;
    final int DIV = 3;
    final int MUL = 4;
    JPanel operationHistory = new JPanel();
    JPanel currentOperation = new JPanel();
    JPanel fieldsPanel = new JPanel(null);
    ArrayList<Button> numberBtns = new ArrayList();
    Button equalsBtn = new Button("=");
    Button clearBtn = new Button("C");
    Button plusBtn = new Button("+");
    Button subBtn = new Button("-");
    Button timesBtn = new Button("x");
    Button divBtn = new Button("÷");
    JLabel entries = new JLabel("");
    JLabel history = new JLabel("");


    Operations baseUla = new Operations();

    final Color DARKER_BG = new Color(19, 19, 19);
    final Color DEFAULT_BG = new Color(55, 54, 61);
    final Color OPERATIONS_BG = new Color(22, 27, 34, 255);


    int firstEntry = 0, secondEntry = 0, desiredOperation = 0, operationCounter = 0;
    double result = 0;


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
        currentOperation.setLayout(new FlowLayout(FlowLayout.RIGHT));
        currentOperation.setBackground(DARKER_BG);


        operationHistory.setSize(new Dimension(operationsField.getWidth() - 18, operationsField.getHeight() / 2));
        operationHistory.setLocation(0, 0);
        operationHistory.setLayout(new FlowLayout(FlowLayout.RIGHT));
        operationHistory.setBackground(DARKER_BG);


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
            button.setLocation(fieldsPanel.getWidth() - button.getWidth() * 2, 10);
            button.addActionListener(this);

            if (currentRow >= 1) {
                button.setLocation(fieldsPanel.getWidth() - ((button.getWidth() * placedBtn) + (button.getWidth() * 2)), (currentRow - 1) * button.getHeight() + 10);
            }


            if (i == 0) {
                button.setLocation(fieldsPanel.getWidth() - button.getWidth() * 3, (currentRow - 1) * button.getHeight() + 10);
            }

            fieldsPanel.add(button);
            repaint();
            placedBtn++;
            numberBtns.add(button);
            if (placedBtn % 3 == 0) {
                placedBtn = 0;
                currentRow++;
            }
        }

        equalsBtn.setLocation(numberBtns.get(9).getX() + equalsBtn.getWidth(), numberBtns.get(9).getY());
        equalsBtn.setBackground(Color.red);
        equalsBtn.addActionListener(this);
        fieldsPanel.add(equalsBtn);
        repaint();


        clearBtn.setLocation(numberBtns.get(9).getX() - equalsBtn.getWidth(), numberBtns.get(9).getY());
        clearBtn.setBackground(OPERATIONS_BG);
        clearBtn.addActionListener(this);
        fieldsPanel.add(clearBtn);
        repaint();


        plusBtn.setLocation(numberBtns.get(0).getX() + plusBtn.getWidth(), numberBtns.get(0).getY());
        plusBtn.setSize(45, 54);
        plusBtn.setBackground(OPERATIONS_BG);
        plusBtn.addActionListener(this);
        fieldsPanel.add(plusBtn);

        subBtn.setBackground(OPERATIONS_BG);
        subBtn.setLocation(numberBtns.get(3).getX() + subBtn.getWidth(), numberBtns.get(3).getY());
        subBtn.setSize(45, 54);
        subBtn.addActionListener(this);
        fieldsPanel.add(subBtn);


        timesBtn.setBackground(OPERATIONS_BG);
        timesBtn.setLocation(numberBtns.get(6).getX() + timesBtn.getWidth(), numberBtns.get(6).getY());
        timesBtn.setSize(45, 54);
        timesBtn.addActionListener(this);
        fieldsPanel.add(timesBtn);


        divBtn.setBackground(OPERATIONS_BG);
        divBtn.setLocation(equalsBtn.getX() + divBtn.getWidth(), equalsBtn.getY());
        divBtn.setSize(45, 54);
        divBtn.addActionListener(this);
        fieldsPanel.add(divBtn);


        entries.setOpaque(true);
        entries.setForeground(Color.WHITE);
        entries.setBackground(DARKER_BG);
        entries.setFont(font);
        entries.setVerticalAlignment(JLabel.CENTER);
        entries.setVerticalTextPosition(JLabel.CENTER);


        currentOperation.add(entries);


        history.setOpaque(true);
        history.setForeground(Color.WHITE);
        history.setBackground(DARKER_BG);
        history.setFont(font);
        history.setVerticalAlignment(JLabel.CENTER);
        history.setVerticalTextPosition(JLabel.CENTER);


        operationHistory.add(history);

    }

    int didOperation = 0;

    private void doOperation(int operation, Button element) {
        operationCounter++;

        if (operationCounter > 1) {
            if (!entries.getText().equals("")) {
                secondEntry = Integer.parseInt(entries.getText());
            } else {
                secondEntry = 0;
            }

            result = baseUla.doMath(desiredOperation, firstEntry, secondEntry);
            firstEntry = (int) result;
            result = 0;
            entries.setText(String.valueOf(firstEntry));
            desiredOperation = operation;
            history.setText(entries.getText() + " " + element.getText());
            entries.setText("");
        } else {
            firstEntry = Integer.parseInt(entries.getText());
            history.setText(entries.getText() + " " + element.getText());
            desiredOperation = operation;
            entries.setText("");

        }
    }

    private void clearAll() {
        entries.setText("");
        history.setText("");
        result = 0;
        firstEntry = 0;
        secondEntry = 0;
        operationCounter = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(equalsBtn)) {
            if (operationCounter != 0) {

                int temporaryResult;
                temporaryResult = (int) baseUla.doMath(desiredOperation, firstEntry, Integer.parseInt(entries.getText()));

                String operator;

                switch (desiredOperation) {
                    case SUM:
                        operator = "+";
                        break;
                    case SUB:
                        operator = "-";
                        break;
                    case MUL:
                        operator = "x";
                        break;
                    case DIV:
                        operator = "÷";
                        break;
                    default:
                        operator = "";
                        break;


                }

                history.setText(firstEntry + " " + operator + " " + entries.getText() + " = ");
                entries.setText(String.valueOf(temporaryResult));
                operationCounter = 0;
            }
        } else if (e.getSource().equals(clearBtn)) {
            clearAll();
        } else if (e.getSource().equals(subBtn)) {
            doOperation(SUB, subBtn);

        } else if (e.getSource().equals(plusBtn)) {
            doOperation(SUM, plusBtn);

        } else if (e.getSource().equals(timesBtn)) {

            doOperation(MUL, timesBtn);

        } else if (e.getSource().equals(divBtn)) {
            doOperation(DIV, divBtn);

        } else {
            JButton buttonPressed = (Button) e.getSource();

            entries.setText(entries.getText() + buttonPressed.getText());

        }
    }
}

package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
public class Button extends JButton  {
    public String typeButton = "";

    private String defaultText = "0";
    private Font font = new Font("Century Gothic", 1, 18);

    public Button(String text) {

        this.defaultText = text;
        setText(defaultText);
        setSize(new Dimension(75, 54));
        setForeground(Color.WHITE);
        setOpaque(true);
        setBackground(new Color(19, 19, 19));
        setFocusPainted(false);
        setBorder((Border) null);
        setFont(font);
        setFocusPainted(false);
    }

    public Button() {
        setText(defaultText);
        setForeground(Color.WHITE);
        setSize(new Dimension(50, 50));
        setOpaque(true);
        setBackground(new Color(19, 19, 19));
        setBorder((Border) null);
        setFont(font);
        setFocusPainted(false);

    }





}

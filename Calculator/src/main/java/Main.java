import view.Window;

import javax.swing.*;


/***
 * @author gustavo.manocchio
 */

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 new Window();
            }
        });
    }
}

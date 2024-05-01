import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import javax.script.*;

class FDemo extends JFrame implements ActionListener {
    JTextField tx1;
    JButton b[] = new JButton[20];
    int k = 0;
    int x, y, w, h;
    String data[] = {"B", "C", "1/x", "sqrt", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3",
            "-", "0", ".", "=", "+"};

    FDemo() {
        x = 0;
        y = 100;
        w = 100;
        h = 100;
        setLayout(null);
        Font f = new Font("", Font.BOLD, 30);
        tx1 = new JTextField();
        tx1.setSize(400, 100);
        tx1.setLocation(0, 0);
        tx1.setFont(f);
        tx1.setHorizontalAlignment(JTextField.RIGHT);
        add(tx1);
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 4; j++) {
                b[k] = new JButton(data[k]);
                b[k].setSize(w, h);
                b[k].setLocation(x, y);
                b[k].setFont(f);
                add(b[k]);
                b[k].addActionListener(this);
                k++;
                x = x + 100;
            }
            x = 0;
            y = y + 100;
        }
        b[0].setText("B");
        b[1].setText("C");
        b[2].setText("1/x");
        b[3].setText("sqrt");
        b[18].setText("=");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b[0]) {
            String S1 = tx1.getText();
            tx1.setText(S1.substring(0, S1.length() - 1));
        } else if (e.getSource() == b[1]) {
            tx1.setText("");
        } else if (e.getSource() == b[2]) {
            String S1 = tx1.getText();
            double a = Double.parseDouble(S1);
            a = 1 / a;
            tx1.setText("" + a);
        } else if (e.getSource() == b[3]) {
            String S1 = tx1.getText();
            double a = Double.parseDouble(S1);
            tx1.setText("" + Math.sqrt(a));
        } else if (e.getSource() == b[18]) {
            String S1 = tx1.getText();
            ScriptEngineManager sem = new ScriptEngineManager();
            ScriptEngine se = sem.getEngineByName("js");
            try {
                tx1.setText("" + se.eval(S1));
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        } else {
            JButton b1 = (JButton) e.getSource();
            String S5 = tx1.getText() + b1.getText();
            tx1.setText(S5);
        }
    }
}

class Demo20 {
    public static void main(String ar[]) {
        FDemo f = new FDemo();
        f.setVisible(true);
        f.setSize(420, 650);
        f.setLocation(200, 100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JFrame last;

    public Window () {
        super("Barcode Generator");
        Dimension size = Toolkit. getDefaultToolkit(). getScreenSize();
        setBounds(size.width / 4, size.height / 4, size.width / 2, size.height / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
    }

    public void run() {
        JTextField tf_codeword = new JTextField("Barcode Input");
        JButton button_confirm = new JButton("Okay");
        button_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (last != null) last.dispose();
                if (tf_codeword.getText().length() == 0) return;
                last = new BarcodePanel(tf_codeword.getText());
            }
        });

        add(tf_codeword);
        add(button_confirm);
        setVisible(true);
    }
}

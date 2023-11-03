package gui;

import util.BarcodeUtility;

import javax.swing.*;
import java.awt.*;

public class BarcodePanel extends JFrame {
    private static final int SIZE_WIDE = 6;
    private static final int SIZE_SLIM = 2;
    private static final int SIZE_HEIGHT = 150;
    private static final int BORDER_BUFFER_HEIGHT = 31;
    private String barcode;


    public BarcodePanel (String codeword) {
        super("Generated Barcode");
        this.barcode = BarcodeUtility.constructBarcode(codeword);

        int height = SIZE_HEIGHT + 30 + BORDER_BUFFER_HEIGHT;
        int width = 30;
        for (int i = 0; i < barcode.length(); i++) {
            if (barcode.charAt(i) == 's') {
                width += SIZE_SLIM;
            } else {
                width += SIZE_WIDE;
            }
        }

        setBackground(Color.GRAY);
        setSize(width, height);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void paint(Graphics G) {
        super.paint(G);

        boolean color_black = true;

        int x = 15;

        for(int i = 0; i < barcode.length(); i++) {
            char currentChar = barcode.charAt(i);
            int currentWidth;
            System.out.println(i + " " + currentChar);

            if (currentChar == 's') {
                currentWidth = SIZE_SLIM;
            } else {
                currentWidth = SIZE_WIDE;
            }

            if (color_black) {
                G.setColor(Color.BLACK);
            } else {
                G.setColor(Color.WHITE);
            }
            color_black = !color_black;

            G.fillRect(x, 15 + BORDER_BUFFER_HEIGHT, currentWidth, SIZE_HEIGHT);
            x += currentWidth;
        }
    }
}

package blackjack.view.GuiUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame {
    private Dimension m_windowSize;

    /**
     * The window to use for the game
     * @param title The title of the window
     * @param windowSize The screen size dimensions of the window
     */
    public GameWindow(String title, Dimension windowSize) {
        super(title);
        setVisible(true);
        setSize(windowSize);
        setBounds(0, 0, windowSize.width, windowSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        m_windowSize = windowSize;
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    /**
     * Gets the window's dimensions in pixels
     * @return THe window's dimensions in pixels
     */
    public Dimension GetSize() { return m_windowSize; }

    /**
     * Resizes the window to be a new size
     * @param newSize The new size of the window
     */
    public void Resize(Dimension newSize) {
        m_windowSize = newSize;
        setSize(newSize);
    }


}

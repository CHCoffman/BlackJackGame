package blackjack.view.GuiUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame {
    private Dimension m_windowSize;
    public GameWindow(String title, Dimension windowSize) {
        super(title);
        setVisible(true);
        setSize(windowSize);
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
    public Dimension GetSize() { return m_windowSize; }
    public void Resize(Dimension newSize) {
        m_windowSize = newSize;
        setSize(newSize);
    }


}

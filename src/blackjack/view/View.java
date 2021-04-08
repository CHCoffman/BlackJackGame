package blackjack.view;
import blackjack.view.guiUtils.Window;
import blackjack.view.guiUtils.ImageActionComponent;
import blackjack.view.BlackjackCardView;

import javax.swing.*;
import java.awt.*;

public class View {
    public static void main(String[] args) {
        Window w = new Window("Blackjack", new Dimension(800, 600));
        BlackjackCardView v = new BlackjackCardView(5, BlackjackCardView.CardSuite.CLUBS);
        JPanel p = new JPanel();
        p.add(v.GetComponent());
        w.add(p);
        w.pack();
        w.setVisible(true);
    }
}

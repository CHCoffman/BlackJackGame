package blackjack.view;

import blackjack.model.Card;
import blackjack.model.Game;
import blackjack.view.GuiUtils.GameWindow;
import blackjack.view.ViewExceptions.BlackjackDeckDataStoreException;

import javax.swing.*;
import java.awt.*;

import blackjack.view.GuiUtils.GameWindow;
import blackjack.view.ViewExceptions.BlackjackGUIException;
import blackjack.model.AbstractModel;

/**
 * A container for the visual representation of a blackjack game
 */
public class View implements ViewEventListener {
    private BlackjackGameComponent m_game;
    private GameWindow m_window;
    public View(Game game) {
        BlackjackDeckDataStore.Initialize();
        m_window = new GameWindow("Blackjack", new Dimension(800, 600));
        m_game = new BlackjackGameComponent(game);
        m_window.add(m_game);
        m_window.repaint();
        m_window.setVisible(true);
    }

    public void ShowWinMessage() {
        m_window.getContentPane().removeAll();
        JLabel winLabel = new JLabel("You Won!!");
        winLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        m_window.add(winLabel, BorderLayout.CENTER);
        Dimension position = CalculateScreenPosition();
        m_window.setLocation(position.width, position.height);
        m_window.pack();
        m_window.revalidate();
        m_window.repaint();

    }

    public void ShowLoseMessage() {
        m_window.getContentPane().removeAll();
        JLabel winLabel = new JLabel("You Lost :(");
        winLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        m_window.add(winLabel, BorderLayout.CENTER);
        Dimension position = CalculateScreenPosition();
        m_window.setLocation(position.width, position.height);
        m_window.pack();
        m_window.revalidate();
        m_window.repaint();
    }
    private Dimension CalculateScreenPosition() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension winSize = m_window.getContentPane().getSize();
        return new Dimension((int)(screenSize.width * 0.5) - winSize.width, (int)(screenSize.height * 0.5) - winSize.height);
    }
    /**
     * Receive and/or process a view event
     *
     * @param state The GameState to act as the view event
     * @throws BlackjackGUIException If something goes wrong
     */
    @Override
    public void ReceiveEvent(ViewEvent state) throws BlackjackGUIException {
        switch(state.GetType()) {
            case UPDATE: m_game.UpdateViewComponent((GameState)state); break;
            case WIN: ShowWinMessage(); break;
            case LOSE: ShowLoseMessage(); break;
        }
        if(state.GetType() == ViewEvent.ViewEventType.UPDATE) {
            m_game.UpdateViewComponent((GameState) state);
        }
    }
}

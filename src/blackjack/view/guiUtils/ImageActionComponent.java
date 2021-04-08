package blackjack.view.guiUtils;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;

public class ImageActionComponent extends JLabel {
    private ImageIcon m_srcImage = null;
    public ImageActionComponent(ImageActionComponent o) {
        m_srcImage = o.m_srcImage;
    }
    public ImageActionComponent(String fileSourcePath, Dimension displayDimensions) {
        super();
        try {
            BufferedImage imgRaw  = ImageIO.read(new File(fileSourcePath));
            m_srcImage = new ImageIcon(imgRaw);
            Scale(displayDimensions);
            setIcon(m_srcImage);
            setMinimumSize(displayDimensions);
            setMinimumSize(displayDimensions);
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
                    Scale(new Dimension((int)(m_srcImage.getIconWidth() * 2.0), m_srcImage.getIconHeight() * 2));
                    setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
                    repaint(getBounds());
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    Scale(new Dimension((int)(m_srcImage.getIconWidth() / 2.0), (int)(m_srcImage.getIconHeight() / 2)));
                    setBorder(BorderFactory.createEmptyBorder());
                    repaint(getBounds());
                }
            });
        }
        catch(IOException e) {
            System.out.println("Failed to load file: " + fileSourcePath + "." + e.getMessage());
        }
    }
    public void Scale(Dimension pixelDimensions) {
        m_srcImage.setImage(m_srcImage.getImage().getScaledInstance(pixelDimensions.width, pixelDimensions.height, Image.SCALE_FAST));
    }
}

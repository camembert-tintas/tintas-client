package gui;

import java.awt.Cursor;
import java.awt.Insets;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * The Class EncryptButton.
 */
public class ConnexionButton extends JButton {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -385448256396761889L;

    /**
     * Instantiates a new encrypt button.
     */
    public ConnexionButton() {
        initButton();
    }

    /**
     * Inits the button.
     */
    private final void initButton() {
        setBorderPainted(false);
        setBorder(null);
        setMargin(new Insets(0, 0, 0, 0));
        setContentAreaFilled(false);
        try {
            setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/img/connexion.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            setRolloverIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/img/connexion-active.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            setPressedIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/img/connexion.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}

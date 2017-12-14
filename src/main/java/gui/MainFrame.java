package gui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * The Class MainFrame.
 */
public class MainFrame extends JFrame {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1154231331655816759L;

    /** The main panel. */

    private ConnexionPanel connexionPanel;
    private GamePanel gamePanel;
    
    private static JPanel cardLayoutPanel;
    
    private static CardLayout cl;

    /**
     * Instantiates a new main frame.
     */
    public MainFrame() {
        initFrameOptions();
        initFrameComponents();
    }

    /**
     * Inits the frame components.
     */
    private final void initFrameComponents() {
    	cl = new CardLayout();
    	cardLayoutPanel = new JPanel();
    	
        connexionPanel = new ConnexionPanel();
        gamePanel = new GamePanel();
        
        cardLayoutPanel.add(connexionPanel);
        cardLayoutPanel.add(gamePanel);
        
        cardLayoutPanel.setLayout(cl);
        setContentPane(cardLayoutPanel);
        
        pack();
        setVisible(true);
    }
    
    

    public static CardLayout getCl() {
		return cl;
	}
    
    public static JPanel getCardLayoutPanel() {
		return cardLayoutPanel;
	}

	/**
     * Inits the frame options.
     */
    private final void initFrameOptions() {
        setTitle("Tintas");

        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

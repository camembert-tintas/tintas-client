package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;


/**
 * The Class MainPanel.
 */
public class GamePanel extends JPanel {

	

    /** The Constant LABEL_POLICE. */
    private static final Font LABEL_POLICE = new Font("Monospaced", Font.BOLD, 20);

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1334162767247634819L;

    /** The Constant WIDTH_PANEL. */
    private static final int WIDTH_PANEL = 800;


    
    private JPanel firstPlayerPane;
    private JPanel secondPlayerPane;
    private JPanel gamePane;
    
    

    public GamePanel() {
        initPanelOptions();
        initPanelComponents();
    }


    private final void initGamePane() {
    	gamePane = new JPanel();
    	gamePane.setBackground(new Color(255, 0, 0));
    	gamePane.setPreferredSize(new Dimension(800, 400));
    	add(gamePane, BorderLayout.CENTER);
    }
    
    private final void initFirstPlayerPane() {
    	firstPlayerPane = new JPanel();
    	firstPlayerPane.setBackground(new Color(0, 255, 0));
    	firstPlayerPane.setPreferredSize(new Dimension(120, 400));
    	add(firstPlayerPane, BorderLayout.WEST);
        
    }

    private final void initSecondPlayerPane() {
    	secondPlayerPane = new JPanel();
    	secondPlayerPane.setBackground(new Color(0, 0, 255));
    	secondPlayerPane.setPreferredSize(new Dimension(120, 400));
    	add(secondPlayerPane, BorderLayout.EAST);
        
    }

    private final void initPanelComponents() {
        initGamePane();
        initFirstPlayerPane();
        initSecondPlayerPane();
    }


    private final void initPanelOptions() {
        setLayout(new BorderLayout());
    }
}



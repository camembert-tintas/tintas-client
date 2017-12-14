package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


/**
 * The Class MainPanel.
 */
public class ConnexionPanel extends JPanel {

    /**
     * The listener interface for receiving encryptButton events. The class that
     * is interested in processing a encryptButton event implements this
     * interface, and the object created with that class is registered with a
     * component using the component's <code>addEncryptButtonListener<code>
     * method. When the encryptButton event occurs, that object's appropriate
     * method is invoked.
     *
     * @see EncryptButtonEvent
     */
    class ConnexionButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	connect();
        }
        
        private void connect() {
        	MainFrame.getCl().next(MainFrame.getCardLayoutPanel());
        }

    }

    /** The Constant LABEL_POLICE. */
    private static final Font LABEL_POLICE = new Font("Monospaced", Font.BOLD, 20);

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1334162767247634819L;

    /** The Constant WIDTH_PANEL. */
    private static final int WIDTH_PANEL = 400;
    
    
    private JTextField loginTextField;

    private JTextField passwordTextField;   


    /**
     * Instantiates a new main panel.
     */
    public ConnexionPanel() {
        initPanelOptions();
        initPanelComponents();
    }

    /**
     * Inits the buttons pane.
     */
    private final void initButtonsPane() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setPreferredSize(new Dimension(WIDTH_PANEL, 40));

        JButton connexionButton = new ConnexionButton();
        connexionButton.addActionListener(new ConnexionButtonListener());

        controlPanel.add(connexionButton);


        add(controlPanel, BorderLayout.SOUTH);
    }

    /**
     * Inits the form pane.
     */
    private final void initFormPane() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new FlowLayout());
        formPanel.setPreferredSize(new Dimension(WIDTH_PANEL, 150));
        formPanel.setBackground(new Color(51, 122, 183));

        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setFont(LABEL_POLICE);

        loginTextField = new JTextField();
        loginTextField.setPreferredSize(new Dimension(WIDTH_PANEL - 10, 25));
        loginTextField.setBorder(new LineBorder(Color.black, 3));

        JLabel passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setFont(LABEL_POLICE);

        passwordTextField = new JTextField();
        passwordTextField.setPreferredSize(new Dimension(WIDTH_PANEL - 10, 25));
        passwordTextField.setBorder(new LineBorder(Color.black, 3));


        
        formPanel.add(loginLabel);
        formPanel.add(loginTextField);
        
        formPanel.add(passwordLabel);
        formPanel.add(passwordTextField);
        
        add(formPanel, BorderLayout.NORTH);
    }

    /**
     * Inits the panel components.
     */
    private final void initPanelComponents() {
        initFormPane();
        initButtonsPane();
    }

    /**
     * Inits the panel options.
     */
    private final void initPanelOptions() {
        setLayout(new BorderLayout());
    }



}

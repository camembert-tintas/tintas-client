package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.naming.CommunicationException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import utility.DataBaseConnection;
import utility.RandomGenerator;


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
        	try(Connection con = DataBaseConnection.connect();
        			PreparedStatement preparedStatement = con.prepareStatement(
        					"SELECT COUNT(*) FROM player WHERE login = ? AND password = ?")) {
        		preparedStatement.setString(1, loginTextField.getText().trim());
        		preparedStatement.setString(2, passwordTextField.getText().trim());
        		
        		try(ResultSet resultSet = preparedStatement.executeQuery()) {
            		while (resultSet.next()) {
            			if (resultSet.getInt(1) == 1) {
            				MainFrame.startGame();
            	        	MainFrame.getCl().next(MainFrame.getCardLayoutPanel());
            			}
            			else {
            				errorArea.setText("INFO: Erreur d'identifiants !");
            			}
            		}       			
        		}
        		
        	} catch (Exception e) {
				e.printStackTrace();
				errorArea.setText("INFO: Erreur de connexion !");
			}
        	
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
    
    private JLabel errorArea;


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
        formPanel.setPreferredSize(new Dimension(WIDTH_PANEL, 500));
//        formPanel.setBackground(new Color(51, 122, 183));
        formPanel.setBackground(new Color(RandomGenerator.generate(), RandomGenerator.generate(), 
        		RandomGenerator.generate()));

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


        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/img/tintas.jpg"));
        
        JLabel label = new JLabel(imageIcon);
        
        formPanel.add(label);
        
        JPanel loginPanel = new JPanel();
        loginPanel.add(loginLabel);
        loginPanel.add(loginTextField);
        loginPanel.setBackground(new Color(RandomGenerator.generate(), RandomGenerator.generate(), 
        		RandomGenerator.generate()));
        
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordTextField);
        passwordPanel.setBackground(new Color(RandomGenerator.generate(), RandomGenerator.generate(), 
        		RandomGenerator.generate()));
        
        formPanel.add(loginPanel);
        formPanel.add(passwordPanel);
        
        errorArea = new JLabel("INFO: ");
        errorArea.setPreferredSize(new Dimension(400, 20));
        errorArea.setFont(new Font("Monospaced", Font.BOLD, 14));
//        errorArea.setForeground(Color.RED);
        errorArea.setForeground(new Color(RandomGenerator.generate(), RandomGenerator.generate(), 
        		RandomGenerator.generate()));
        
        formPanel.add(errorArea);
        
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

package gui;


public class TintasUserInterface {


    private static TintasUserInterface userInterface;


    public static final TintasUserInterface start() {
        if (userInterface == null) {
            userInterface = new TintasUserInterface();
        }

        return userInterface;
    }

    private MainFrame window;

    private TintasUserInterface() {
        window = new MainFrame();
    }
}

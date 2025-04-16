package cz.cvut.fel.pjv;

import javax.swing.*;
import java.awt.*;
import java.util.logging.*;

public class Main extends JFrame {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public Main(String title) throws HeadlessException {
        super(title);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {

//        // Set the logging level to ALL to see all messages
//        logger.setLevel(Level.ALL);
//        ConsoleHandler handler = new ConsoleHandler();
//        handler.setLevel(Level.ALL);
//        logger.addHandler(handler);
//        logger.setUseParentHandlers(false);

//        new Main("Logging Example");

        // Set the logging level to ALL to see all messages - this will display all messages from all classes
        Logger.getLogger("").setLevel(Level.ALL);
        Logger.getLogger("").getHandlers()[0].setLevel(Level.ALL);

        logger.severe("SEVERE: This is not pronounced 'SÍVR'!");
        logger.info("Hello, World!");
        logger.fine("This is a fine message.");
        logger.finer("This is a finer message.");
        logger.finest("This is a finest message.");
    }
}
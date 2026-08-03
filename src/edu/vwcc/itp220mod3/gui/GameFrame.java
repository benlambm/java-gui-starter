package edu.vwcc.itp220mod3.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import edu.vwcc.itp220mod3.model.Bow;
import edu.vwcc.itp220mod3.model.Camera;
import edu.vwcc.itp220mod3.model.Game;

/**
 * The window: a JFrame holding a toolbar (north) and the game panel
 * (center). Mostly provided -- but the Camera button is yours to wire.
 *
 * NEW CONCEPT -- lambdas (and why listeners need them).
 *
 * A GUI is event-driven: nothing happens until the user acts, and you
 * REGISTER code to run when they do. addActionListener wants an object
 * with one method, actionPerformed(e). Writing a whole class for one
 * method got old decades ago, so Java lets you write just the method
 * body inline:
 *
 *     bowButton.addActionListener(e -> game.getHunter().setShootBehavior(new Bow()));
 *
 * Read "->" as "when this fires, do this": the e is the event object
 * (we don't even use it), the right side is the body. That single line
 * IS the strategy pattern meeting the GUI: a button click swaps the
 * hunter's behavior object at runtime.
 */
public class GameFrame extends JFrame {

    private final Game game = new Game();

    public GameFrame() {
        super("ITP 220 · Module 3 — The Hunting Ground");
        game.spawnStartingAnimals();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Toolbar: choose your instrument -------------------------
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toolbar.add(new JLabel("Instrument:"));

        JRadioButton bowButton = new JRadioButton("Bow", true);
        JRadioButton cameraButton = new JRadioButton("Camera");
        ButtonGroup group = new ButtonGroup(); // makes them exclusive
        group.add(bowButton);
        group.add(cameraButton);
        toolbar.add(bowButton);
        toolbar.add(cameraButton);

        // WORKED EXAMPLE: clicking Bow hands the hunter a new Bow.
        bowButton.addActionListener(e -> game.getHunter().setShootBehavior(new Bow()));

        /*
         * Instructions:
         * Wire the Camera button, following the Bow line above exactly:
         * when clicked, the hunter should be handed a new Camera().
         *
         * No test covers this line -- the proof is on screen. Run the
         * game, click Camera, shoot a bear: if the score jumps 100 and
         * the bear fades instead of vanishing, you wired it.
         */
        // TODO: your code goes here

        add(toolbar, BorderLayout.NORTH);
        add(new GamePanel(game), BorderLayout.CENTER);

        pack();                        // size the window to fit the panel
        setLocationRelativeTo(null);   // center on screen
    }
}

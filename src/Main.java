import javax.swing.SwingUtilities;

import edu.vwcc.itp220mod3.gui.GameFrame;

/**
 * The launcher -- PROVIDED, nothing to implement. Run it any time.
 *
 * On a fresh clone the window opens and the field is FROZEN: animals
 * stand still, clicks do nothing, the instrument corner is blank. That
 * is correct. Every TODO you finish thaws it a little -- movement when
 * Game.update works, species walking their own walks as Duck and Bear
 * come alive, scoring when the strategies land. Run early, run often;
 * watching the game wake up is the best progress bar in this course.
 *
 * The one line of ceremony: Swing components must be created on Swing's
 * own thread (the Event Dispatch Thread). invokeLater says "run this
 * there." Every Swing program you ever write starts with this line.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameFrame().setVisible(true));
    }
}

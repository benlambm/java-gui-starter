package edu.vwcc.itp220mod3.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import edu.vwcc.itp220mod3.model.Animal;
import edu.vwcc.itp220mod3.model.Game;
import edu.vwcc.itp220mod3.model.ShotResult;

/**
 * The drawing surface -- PROVIDED, nothing to implement here, but READ
 * it: this file is your first look at how a GUI actually works, and
 * none of it is magic.
 *
 * Three ideas carry the whole file:
 *
 * 1. A JPanel draws itself in paintComponent(Graphics). You never call
 *    it -- Swing calls it whenever the panel needs repainting, and we
 *    nudge Swing with repaint(). Everything on screen is painted fresh,
 *    from back to front, ~60 times a second.
 *
 * 2. A javax.swing.Timer is the game's heartbeat. Every 16 ms it fires,
 *    we advance the model (game.update) and request a repaint. Model
 *    first, then draw -- the panel only ever DRAWS the model, it never
 *    changes it outside the timer tick and the click handler.
 *
 * 3. A MouseAdapter turns clicks into model calls (game.shoot). Notice
 *    the division of labor: THIS class knows about pixels and mouse
 *    events; Game knows the rules. The model never imports Swing, and
 *    the panel never decides what a hit is worth.
 */
public class GamePanel extends JPanel {

    /** The world is a little wider than the visible panel (see Animal). */
    public static final int PANEL_WIDTH = 800;
    public static final int PANEL_HEIGHT = 520;
    private static final int GRASS_TOP = 300;

    private static final Color SKY = new Color(0xcf, 0xe8, 0xff);
    private static final Color GRASS = new Color(0x7b, 0xb6, 0x61);
    private static final Color INK = new Color(0x17, 0x28, 0x4a);

    private final Game game;
    private String lastMessage = "Click an animal...";

    public GamePanel(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

        // The click handler: pixels in, model call out.
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ShotResult result = game.shoot(e.getX(), e.getY());
                // Until Game.shoot is implemented it returns null;
                // this check keeps the unfinished game from crashing.
                if (result != null) {
                    lastMessage = result.message();
                }
            }
        });

        // The heartbeat: 16 ms is about 60 frames per second. The lambda
        // syntax here is explained in GameFrame -- read that comment.
        Timer heartbeat = new Timer(16, e -> {
            game.update(0.016);
            repaint();
        });
        heartbeat.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Back to front: sky, grass, animals, HUD.
        g2.setColor(SKY);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setColor(GRASS);
        g2.fillRect(0, GRASS_TOP, getWidth(), getHeight() - GRASS_TOP);

        for (Animal a : game.getAnimals()) {
            drawAnimal(g2, a);
        }

        g2.setColor(INK);
        g2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        g2.drawString("Score: " + game.getScore(), 16, 28);
        String instrument = game.getHunter().getBehaviorName();
        g2.drawString("Instrument: " + instrument, getWidth() - 220, 28);
        g2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        g2.drawString(lastMessage, 16, getHeight() - 16);
    }

    /**
     * One animal: a colored disc with its name and value underneath.
     * The PANEL owns the colors, not the model -- how a thing looks is
     * view business; how it behaves is model business.
     */
    private void drawAnimal(Graphics2D g2, Animal a) {
        int x = (int) Math.round(a.getX());
        int y = (int) Math.round(a.getY());
        int r = 22;

        Color body;
        if (a.getName().equals("Deer")) {
            body = new Color(0x8b, 0x5a, 0x2b); // brown
        } else if (a.getName().equals("Duck")) {
            body = new Color(0x2a, 0x7f, 0x8a); // teal
        } else if (a.getName().equals("Bear")) {
            body = new Color(0x3f, 0x3f, 0x3f); // dark gray
        } else {
            // Adding your own species (stretch goal)? Give it a color
            // here, or it walks the world in magenta.
            body = Color.MAGENTA;
        }

        // A photographed animal fades -- visible proof of Camera state.
        if (a.isPhotographed()) {
            body = new Color(body.getRed(), body.getGreen(), body.getBlue(), 110);
        }

        g2.setColor(body);
        g2.fillOval(x - r, y - r, r * 2, r * 2);
        g2.setColor(INK);
        g2.drawOval(x - r, y - r, r * 2, r * 2);

        g2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        String label = a.getName() + " (" + a.getPoints() + ")";
        int labelWidth = g2.getFontMetrics().stringWidth(label);
        g2.drawString(label, x - labelWidth / 2, y + r + 14);
    }
}

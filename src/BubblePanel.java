import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.Timer;

public class BubblePanel extends JPanel {

    private ArrayList<Bubble> bubbleList;
    private int size = 30;
    private Timer timer;
    private final int DELAY = 33; // ms of delay for 30 fps

    public BubblePanel() { //Constructor

        bubbleList = new ArrayList<Bubble>(); //Set up array list

        addMouseListener(new BubbleListener());
        addMouseMotionListener(new BubbleListener());
        addMouseWheelListener(new BubbleListener());

        timer = new Timer(DELAY, new BubbleListener());

        setBackground(Color.BLACK); //Set background for panel to black
        setPreferredSize(new Dimension(600,400)); //Set size

        timer.start();
    }

    public void paintComponent(Graphics page) {
        super.paintComponent(page);

        //draw all the bubbles from bubblelist
        for (Bubble bubble:bubbleList) {
            page.setColor(bubble.color);
            page.fillOval(bubble.x - bubble.size/2, bubble.y - bubble.size/2, bubble.size, bubble.size); // So it looks like we clicked right in the center of the bubble
        }
        //Write the number of bubbles on the screen

        page.setColor(Color.GREEN);
        page.drawString("Count: " + bubbleList.size(), 5, 15);
    }

    private class BubbleListener implements MouseListener, MouseMotionListener, MouseWheelListener, ActionListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            //Add to the bubblelist my mouse location and repaint
            bubbleList.add(new Bubble(e.getX(), e.getY(), size));
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            //Add to the bubblelist my mouse location and repaint
            bubbleList.add(new Bubble(e.getX(), e.getY(), size));
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            // Change the bubble size whenever the wheel is moved
            size -= e.getWheelRotation();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Update the location of each bubble for animation
            for(Bubble bubble:bubbleList)
                bubble.update();

            // Repaint screen
            repaint();
        }
    }




    private class Bubble {
        /**A Bubble needs an x, y location and a size */
        public int x;
        public int y;
        public int size;
        public Color color;
        public int xspeed;
        public int yspeed;
        private final int MAX_SPEED = 5;

        public Bubble(int newX, int newY, int newSize) { //Constructor
            x = newX;
            y = newY;
            size = newSize;
            color = new Color((float)Math.random(), //Everytime bubble is created it will use a random color
                    (float)Math.random(),
                    (float)Math.random());
            xspeed = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);  // Has the chance to go -5 to +5 in either direction
            yspeed = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);  // Has the chance to go -5 to +5 in either direction

            if (xspeed == 0 && yspeed == 0) { //Now every bubble will have movement
                xspeed = 1;
                xspeed = 1;
            }

        }

        public void update() {

            x += xspeed;
            y += yspeed;

            // Collision detection with the edges of the panel
            if (x < 0 || x > getWidth()) {
                xspeed = -1 * xspeed; // Reverses the speed if it meets collision
            }
            if (y < 0 || y > getHeight()) {
                yspeed = -yspeed; // Same as above just another way to write it
            }


        }

    }
}

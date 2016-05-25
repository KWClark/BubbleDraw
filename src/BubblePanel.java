import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BubblePanel extends JPanel {

    private ArrayList<Bubble> bubbleList;
    private int size = 40;

    public BubblePanel() { //Constructor

        bubbleList = new ArrayList<Bubble>(); //Set up array list

        addMouseListener(new BubbleListener());

        setBackground(Color.BLACK); //Set background for panel to black
        setPreferredSize(new Dimension(600,400)); //Set size
    }

    public void paintComponent(Graphics page) { //Overriding paint method
        super.paintComponent(page);

        //draw all the bubbles from bubblelist
        for (Bubble bubble:bubbleList) {
            page.fillOval(bubble.x, bubble.y, bubble.size, bubble.size);
        }
        //Write the number of bubbles on the screen

        page.setColor(Color.GREEN);
        page.drawString("Count: " + bubbleList.size(), 5, 15);
    }

    private class BubbleListener implements MouseListener {

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
    }




    private class Bubble {
        /**A Bubble needs an x, y location and a size */
        public int x;
        public int y;
        public int size;

        public Bubble(int newX, int newY, int newSize) { //Constructor
            x = newX;
            y = newY;
            size = newSize;
        }
    }
}

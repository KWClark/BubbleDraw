import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class BubblePanel extends JPanel {

    private ArrayList<Bubble> bubbleList;

    public BubblePanel() { //Constructor

        bubbleList = new ArrayList<Bubble>(); //Set up array list

        setBackground(Color.BLACK); //Set background for panel to black
        setPreferredSize(new Dimension(600,400)); //Set size
    }

    public void paintComponent(Graphics page) { //Overriding paint method
        super.paintComponent(page);

        //draw all the bubbles from bubblelist
        //Write the number of bubbles on the screen

        page.setColor(Color.GREEN);
        page.drawString("Count: " + bubbleList.size(), 5, 15);
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

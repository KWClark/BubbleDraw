import javax.swing.*;

public class BubbleDraw extends JFrame {

    public static void main(String[] args) {
        //set up the frame for BubbleDraw app
        JFrame frame = new JFrame("Kevin's BubbleDraw App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new BubblePanel()); //Create new bubble panel

        frame.pack();
        frame.setVisible(true);
    }
}

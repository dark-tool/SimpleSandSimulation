import javax.swing.JFrame;

public class MyFrame {
    JFrame frame;
    MyPanel panel;

    public MyFrame()
    {
        frame = new JFrame("Sand Simulation");
        panel = new MyPanel();
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

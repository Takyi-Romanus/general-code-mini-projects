import javax.swing.JFrame;

public class guiDemo{
    private JFrame frame;
    private int width;
    private int height;

    public guiDemo(int w, int h) {
        frame = new JFrame();
        width = w;
        height = h;
    };

    public void setUpGUI() {
        frame.setSize(width,height);
        frame.setTitle("GUI Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
};
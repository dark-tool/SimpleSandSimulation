import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener{
    MyPanel panel;

    public MouseInputs(MyPanel panel)
    {
        this.panel = panel;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX() / panel.pixelSize;
        int y = e.getY() / panel.pixelSize;
        panel.setPixel(x, y);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX() / panel.pixelSize;
        int y = e.getY() / panel.pixelSize;
        panel.setPixel(x, y);
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {} 
}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener{
    int[][] matrix;
    int maxCol = 30;
    int maxRow = 30;
    int pixelSize = 20;
    int panelWidth = (maxCol * pixelSize);
    int panelHeight = (maxRow * pixelSize);
    Timer timer;
    MouseInputs mouseInputs;

    public MyPanel()
    {
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        matrix = new int[maxRow][maxCol];
        mouseInputs = new MouseInputs(this);
        this.addMouseListener(mouseInputs);
        this.addMouseMotionListener(mouseInputs);

        timer = new Timer(20, this);
        timer.start();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.drawMatrix(g);
        // this.drawGrid(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int y = maxRow-2; y >= 0; y--)
        {
            for(int x = 0; x < maxCol; x++)
            {
                if(matrix[y][x] == 1)
                {
                    if(matrix[y+1][x] == 0)
                    {
                        matrix[y+1][x] = 1;
                        matrix[y][x] = 0;
                    } else if(x > 0 && matrix[y+1][x-1] == 0)
                    {
                        matrix[y+1][x-1] = 1;
                        matrix[y][x] = 0;
                    } else if(x < maxCol-1 && matrix[y+1][x+1] == 0)
                    {
                        matrix[y+1][x+1] = 1;
                        matrix[y][x] = 0;
                    }
                }
            }
        }
        repaint();
    }

    public void drawMatrix(Graphics g)
    {
        for(int y = 0; y < maxRow; y++)
        {
            for(int x = 0; x < maxCol; x++)
            {
                if(matrix[y][x] == 0)
                {
                    g.setColor(Color.BLACK);
                    g.fillRect(x*pixelSize, y*pixelSize, pixelSize, pixelSize);
                } else {
                    g.setColor(Color.YELLOW);
                    g.fillRect(x*pixelSize, y*pixelSize, pixelSize, pixelSize);
                }
            }
        }
    }

    public void drawGrid(Graphics g)
    {
        g.setColor(Color.WHITE);
        for(int i = 1; i < maxRow; i++)
        {
            g.drawLine(0, (pixelSize*i), panelWidth, (pixelSize*i));
        }
        for(int j = 1; j < maxCol; j++)
        {
            g.drawLine((pixelSize*j), 0, (pixelSize*j), panelHeight);
        }
    }

    public void setPixel(int x, int y)
    {
        matrix[y][x] = 1;
        repaint();
    }
}

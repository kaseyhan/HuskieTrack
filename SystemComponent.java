import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.awt.Rectangle;

public class SystemComponent extends JComponent
{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
     
    private Door d1;
    private Door d2;
    private Door d3;
    private Door d4;
    private Door d5;
    private Door d6;

    private Room r1;
    private Room r2;
    private Room r3;
    private Room r4;
    private Room r5;
    private Room r6;
    public SystemComponent()
    {
        d1 = new Door(150, 300);
        d2 = new Door(350, 300);
        d3 = new Door(550, 300);
        d4 = new Door(150, 400);
        d5 = new Door(350, 400);
        d6 = new Door(550, 400);

        r1 = new Room(d1, 100, 100, 200, 200);
        r2 = new Room(d2, 300, 100, 200, 200);
        r3 = new Room(d3, 500, 100, 200, 200);
        r4 = new Room(d4, 100, 400, 200, 200);
        r5 = new Room(d5, 300, 400, 200, 200);
        r6 = new Room(d6, 500, 400, 200, 200);
    }

    /**
     * called when the door's sensor breaks. calls Door.break() and returns the current time.
     * @return  timestamp   the time at the method call
     */
    public String doorBreak()
    {
        d1.breaks();
        String timestamp = sdf.format(new Timestamp(System.currentTimeMillis()));
        return timestamp;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        //drawing all the rooms
        r1.draw(g2);
        g2.drawString("1", 200, 200);
        r2.draw(g2);
        g2.drawString("2", 400, 200);
        r3.draw(g2);
        g2.drawString("3", 600, 200);
        r4.draw(g2);
        g2.drawString("4", 200, 500);
        r5.draw(g2);
        g2.drawString("5", 400, 500);
        r6.draw(g2);
        g2.drawString("6", 600, 500);
        
        //drawing the key
        Rectangle box = new Rectangle(770, 280, 135, 70);
        g2.draw(box);
        g2.drawString("KEY:", 825, 300);
        g2.setColor(Color.blue);
        g2.drawString("Blue: Unbroken Sensor", 775, 320);
        g2.setColor(Color.red);
        g2.drawString("Red: Broken Sensor", 780, 340);
        
    }

}
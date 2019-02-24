import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Line2D.Double;
import java.awt.BasicStroke;

public class Room
{
    private int xLeft;
    private int width;
    private int yTop;
    private int height;
    private Door door;
    private int doorNum;
    /**
     * Constructor for Room Objects
     * 
     * @param   d   this room's door
     * @param   x   room's x coordinate
     * @param   y   room's y coordinate
     * @param   w   room's width
     * @param   h   room's height
     */
    public Room(Door d, int x, int y, int w, int h)
    {
        this.xLeft = x;
        this.width = w;
        this.yTop = y;
        this.height = h;
        this.door = d;
    }
    
    public void draw(Graphics2D g2)
    {
        //drawing the room
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(2));
        Rectangle room = new Rectangle(this.xLeft, this.yTop, this.width, this.height);
        g2.draw(room);
        
        //drawing the door
        g2.setColor(this.door.getColor());
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(this.door.getX(), this.door.getY(), this.door.getX() + 100, this.door.getY());

        //resetting the pen
        g2.setStroke(new BasicStroke(1));
        g2.setColor(Color.black);
    }
}
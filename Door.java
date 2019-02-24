import java.awt.Color;

public class Door
{
    private int x;
    private int y;
    private boolean isBroken;
    private Color color;
    /**
     * Constructor for Door Objects
     * 
     * @param   xCoord  door's x coordinate
     * @param   yCoord  door's y coordinate
     */
    public Door(int xCoord, int yCoord)
    {
        this.x = xCoord;
        this.y = yCoord;
        this.isBroken = false;
        this.color = Color.blue;
    }
    
    public int getX()
    {
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }
    
    public Color getColor()
    {
        return this.color;
    }
    
    public boolean getIsBroken()
    {
        return this.isBroken;
    }
   
    
    public void breaks()
    {
        this.color = Color.red;
        this.isBroken = true;
    }
    
}
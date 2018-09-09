
import java.awt.*;

public class Ellipse extends Item
{
  private Point startPt;
  private Point endPt;
  private Point minPt;  			
  private int width, height;

  public Ellipse(Point point1, Point point2)
  {
      this.startPt = point1;
      this.endPt = point2;
      this.minPt = new Point(Math.min(point1.x, point2.x), Math.min(point1.y, point2.y)); 
      this.width = Math.abs(point1.x - point2.x);
      this.height = Math.abs(point1.y - point2.y);
  }
 
  public Ellipse(Point point1)
  {
      this.startPt = point1;
  }
  
  public Ellipse()
  {
  }

    public void setEndPt(Point point) 
    {
        this.endPt = point;
        this.minPt.x = Math.min(startPt.x, point.x);
        this.minPt.y = Math.min(startPt.y, point.y);
        this.width = Math.abs(startPt.x - point.x);
        this.height = Math.abs(startPt.y - point.y);
    }

    public void setStartPt(Point startPt) 
    {
        this.startPt = startPt;
    }

    public void setMinPt(Point minPt) 
    {
        this.minPt = minPt;
    }
    
    public Point getStartPt() 
    {
        return startPt;
    }

    public Point getEndPt() 
    {
        return endPt;
    }

    public Point getMinPt()
    {
        return minPt;
    }

    public int getWidth() 
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

  public boolean includes(Point point) 
  {
    return true;       //((distance(point, point1 ) < 10.0) ||  
                       //(distance(point, point2)< 10.0));
  }

  public void render() 
  {
    uiContext.draw(this);
  }

  public String toString() 
  {
    return "Ellipse  with \n  "
            + "Start Point: " + startPt + "\n  "
            + "End Point: " + endPt + "\n  "
            + "Height: " + height + "\n  "
            + "Width: " + width;
  }
}

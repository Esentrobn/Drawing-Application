
import java.awt.*;
import java.text.*;

public class EllipseCommand extends Command
{

  private Ellipse ellipse;
  private int pointCount;

  public EllipseCommand()
  {
    this(null, null);
    pointCount = 0;
  }

    public EllipseCommand(Point point)
    {
        this(point, point);
        pointCount = 1;
    }

  public EllipseCommand(Point startPt, Point endPt)
  {
    ellipse = new Ellipse(startPt, endPt);
    pointCount = 2;
  }

  public void setEllipsePoint(Point point) 
  {

    if (++pointCount == 1) 
    {
      ellipse.setStartPt(point);

    } 
    
    else if (pointCount == 2)
    {
      ellipse.setEndPt(point);
    }
  }

  public void execute() 
  {
    model.addItem(ellipse);
  }

  public boolean undo() 
  {
    model.removeItem(ellipse);
    return true;
  }

  public boolean redo()
  {
    execute();
    return true;
  }

  public boolean end() 
  {
    if (ellipse.getStartPt() == null) 
    {
      undo();
      return false;
    }

    else if (ellipse.getEndPt() == null) 
    {
       ellipse.setEndPt(ellipse.getStartPt());
    }

    return true;
  }
    
}

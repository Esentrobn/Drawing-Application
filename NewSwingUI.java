
import java.awt.*;
//import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
public class NewSwingUI implements UIContext 
{
  private Graphics graphics;
  private static NewSwingUI swingUI;
 
  private NewSwingUI() 
  {
  }
  
  public static NewSwingUI getInstance() 
  {
    if (swingUI == null) 
    {
      swingUI = new NewSwingUI();
    }
    
    return swingUI;
  }
  
  public  void setGraphics(Graphics graphics) 
  {
    this.graphics = graphics;
  }
  
   public void draw(Label label) 
   {
      if (label.getStartingPoint() != null) 
      {
         if (label.getText() != null) 
          {
            graphics.drawString(label.getText(), (int) label.getStartingPoint().getX(), (int) label.getStartingPoint().getY());
          }
    }

    int length = graphics.getFontMetrics().stringWidth(label.getText());
    graphics.drawString("_", (int) label.getStartingPoint().getX() + length, (int) label.getStartingPoint().getY());
  }

  public void draw(Line line) 
  {
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    
    if (line.getPoint1() != null) 
    {
      i1 = Math.round((float) (line.getPoint1().getX()));
      i2 = Math.round((float) (line.getPoint1().getY()));
      if (line.getPoint2() != null) {
        i3 = Math.round((float) (line.getPoint2().getX()));
        i4 = Math.round((float) (line.getPoint2().getY()));
      } 
      else 
      {
        i3 = i1;
        i4 = i2;
      }
      graphics.drawLine(i1, i2, i3, i4);
    }
  }
  
  public void draw(Item item) 
  {
    System.out.println( "Cant draw unknown Item \n");
  }

    public void draw(Ellipse ellipse)
    {
//        Shape ellipse2D = null;
//        ellipse2D =  new Ellipse2D.Float(ellipse.getMinPt().x, 
//                ellipse.getMinPt().y, ellipse.getWidth(), ellipse.getHeight());
//        Graphics2D graph = (Graphics2D)graphics;
//        graph.draw(ellipse2D);
        graphics.drawOval(ellipse.getMinPt().x, ellipse.getMinPt().y, 
                ellipse.getWidth(),  ellipse.getHeight());
    }

    
}
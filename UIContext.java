
import java.awt.geom.Ellipse2D;

public interface UIContext 
{
  public abstract void draw(Line line);
  public abstract void draw(Ellipse ellipse);
  public abstract void draw(MyPolygon polygon);
  public abstract void draw(Label label);
  public abstract void draw(Item item);
}

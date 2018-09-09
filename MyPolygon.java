
import java.awt.*;
import java.util.*;

public class MyPolygon extends Item 
{

    private Line newline;
    private Point startPt;
    private Point prevEndPt;
    private ArrayList<Line> polyLine;
    
    public MyPolygon(Point point1, Point point2) 
    {
        this.polyLine = new ArrayList();
        this.startPt = point1;
        this.prevEndPt = point2;
        this.newline = new Line(point1, point2);
        this.polyLine.add(newline);
    }

    public MyPolygon(Point point1) 
    {
        this.polyLine = new ArrayList();
      this.startPt = point1;
    }

    public MyPolygon() 
    {
        this.polyLine = new ArrayList();
    }

    @Override
    public boolean includes(Point point) {
        for(Line l : polyLine){
            if(l.includes(point))
                return  true;
        }
      return false;
   //((distance(point, point1 ) < 10.0) || (distance(point,  
                                        point2)< 10.0));
    }
    
    @Override
    public void render() 
    {
      uiContext.draw(newline);
    }

    public void setNextline(Point newEndPt) 
    {
        this.newline = new Line(prevEndPt, newEndPt);
        polyLine.add(newline);
    }

    public void setStartPt(Point startPt)
    {
        this.startPt = startPt;
    }

    public void setPrevEndPt(Point prevEndPt)
    {
        this.prevEndPt = prevEndPt;
    }

    public Line getNewline() {
        return newline;
    }

    public Point getStartPt() 
    {
        return startPt;
    }

    public Point getPrevEndPt() 
    {
        return prevEndPt;
    }
    
    public boolean complete()
    {
        if(prevEndPt == startPt)
            return  true;
        else
            return  false;
    }
    


    public String toString() 
    {
        if(complete())
            return "A complete polygon with "
                    + polyLine.size() + "sides.";
        else
            return "An incomplet polygon with " + polyLine.size() + "lines";
    }
    
}

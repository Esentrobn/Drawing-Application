public class PolygonCommand extends LineCommand 
{
    private MyPolygon polygon;
    private int pointCount;
    
    public PolygonCommand() 
    {
      this(null, null);
      pointCount = 0;
    }

    public PolygonCommand(Point point) 
    {
      this(point, null);
      pointCount = 1;
    }
 
    public PolygonCommand(Point point1, Point point2) 
    {
        super(point1, point2);
      //polygon = new MyPolygon(point1, point2);
      pointCount = 2;
    }

    public void setPolygonPoint(Point point)
    {
      if (++pointCount == 1)
      {
          polygon.setStartPt(point);
      } 
      else if (pointCount == 2) 
      {
          polygon.setNextline(point);
          polygon.setPrevEndPt(point);
      }
    }

    public boolean polygonCmdComplete()
    {
        return polygon.complete();
    }

    @Override
    public void execute() 
    {
      model.addItem(polygon);
    }

    @Override
    public boolean undo() 
    {
      model.removeItem(polygon);
      return true;
    }

    @Override
    public boolean redo() 
    {
      execute();
      return true;
    }
  
    @Override
    public boolean end() 
    {
      if (polygon.getStartPt() == null) 
      {
        undo();
        return false;
      }
      if (polygon.getNewline() == null) 
      {
          polygon.setPrevEndPt(polygon.getStartPt());
      }
      return true;
    }
}

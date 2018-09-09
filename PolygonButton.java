import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PolygonButton extends JButton implements ActionListener
{

    protected JPanel drawingPanel;
    protected View view;
    private MouseHandler mouseHandler;
    private PolygonCommand polygonCommand;
    private LineCommand lineCommand;
    private UndoManager undoManager;
    
    public PolygonButton(UndoManager undoManager, View jFrame, JPanel jPanel) 
    {
      super("MyPolygon");
      this.undoManager = undoManager;
      addActionListener(this);
      view = jFrame;
      drawingPanel = jPanel;
      mouseHandler = new MouseHandler();
    }
  
    public void actionPerformed(ActionEvent event) 
    {
      view.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
      drawingPanel.addMouseListener(mouseHandler);
    
    }

    private class MouseHandler extends MouseAdapter 
    {
        private int pointCount = 0;
        private Point polygonStartPt, nextLineStartPt;
        
        @Override
      public void mouseClicked(MouseEvent event) 
      {
        if (++pointCount == 1) 
        {
            polygonStartPt = View.mapPoint(event.getPoint());
            // polygonCommand = new PolygonCommand(polygonStartPt);
            lineCommand = new LineCommand(polygonStartPt);
            undoManager.beginCommand(lineCommand);
           // undoManager.beginCommand(polygonCommand);
        }
        else if (pointCount >= 2)
        {
            nextLineStartPt = View.mapPoint(event.getPoint());
            if(nextLineStartPt.distance(polygonStartPt) <= 1)
             {
                pointCount = 0;
                lineCommand.setLinePoint(nextLineStartPt);
                drawingPanel.removeMouseListener(this);
                view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                undoManager.endCommand(lineCommand);
             }
             else
              {
                lineCommand.setLinePoint(nextLineStartPt);
                undoManager.endCommand(lineCommand);
                lineCommand = new LineCommand(nextLineStartPt);
                undoManager.beginCommand(lineCommand);
            }
        }
      }
    }
    
}

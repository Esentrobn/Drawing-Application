
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EllipseButton extends JButton implements ActionListener 
{

    protected JPanel drawingPanel;
    protected View view;
    private MouseHandler mouseHandler;
    private EllipseCommand ellipseCommand;
    private UndoManager undoManager;
    
    public EllipseButton(UndoManager undoManager, View jFrame, JPanel jPanel) 
    {
      super("Ellipse");
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

      public void mouseClicked(MouseEvent event) 
      {
        if (++pointCount == 1) 
        {
            ellipseCommand = new EllipseCommand(View.mapPoint(event.getPoint()));
            undoManager.beginCommand(ellipseCommand);
        } 
		if (pointCount == 2) 
		{

            pointCount = 0;
            ellipseCommand.setEllipsePoint(View.mapPoint(event.getPoint()));
            drawingPanel.removeMouseListener(this);
            view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            undoManager.endCommand(ellipseCommand);
          }
      }
    }
}

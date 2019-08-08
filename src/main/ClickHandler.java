package main;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.StartAndEndPointMode;
import model.persistence.ApplicationState;

public class ClickHandler extends MouseAdapter {
	private ICommand command = null;
	private ShapeList shapelist;
	private ShapeList selectedshapelist = new ShapeList();
	private ApplicationState appState;
	Point start;
	Point end;
	
	public ClickHandler(ShapeList shapelist,ApplicationState appState) {
		this.shapelist = shapelist;
		this.appState = appState;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.start = new Point(e.getX(), e.getY());
    }
     
	@Override
    public void mouseReleased(MouseEvent e) {
		this.end = new Point(e.getX(), e.getY());
		if (appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.DRAW)) {
			command = new CreateShapeCommand(shapelist,appState,start,end);
			command.run();
		} else if (appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.SELECT)) {
			command = new SelectShapeCommand(shapelist,appState,start,end,selectedshapelist);
			command.run();

		} else if (appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.MOVE)) {
			command = new MoveShapeCommand(shapelist,appState,start,end,selectedshapelist);
			command.run();
		}
		
    }
	
}

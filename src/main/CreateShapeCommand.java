package main;


import model.persistence.ApplicationState;

public class CreateShapeCommand implements ICommand {
	private ShapeList shapelist;
	private ApplicationState appState;
	private Point start;
	private Point end;
	
	
	public CreateShapeCommand(ShapeList shapelist,ApplicationState appState,Point start, Point end) {
		this.shapelist = shapelist;
		this.appState = appState;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		start.setX(Math.min(start.getX(), end.getX()));
		start.setY(Math.min(start.getY(), end.getY()));
		end.setX(Math.max(start.getX(), end.getX()));
		end.setY(Math.max(start.getY(), end.getY()));
		ShapeBuilder shape = new ShapeBuilder();
		shape.setShapeType(appState.getActiveShapeType());
		shape.setPrimaryColor(appState.getActivePrimaryColor());
		shape.setSecondaryColor(appState.getActiveSecondaryColor());
		shape.setShapeShadingType(appState.getActiveShapeShadingType());
		shape.setStartAndEndPointMode(appState.getActiveStartAndEndPointMode());
		shape.setStartPoint(start);
		shape.setEndPoint(end);
		shapelist.add(shape);
	}

	@Override
	public ShapeList getList() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

package main;

import model.persistence.ApplicationState;

public class SelectShapeCommand implements ICommand {
	private ShapeList shapelist;
	private ApplicationState appState;
	private Point start;
	private Point end;
	private ShapeList selectedshapelist;
	
	public SelectShapeCommand(ShapeList shapelist,ApplicationState appState,Point start, Point end, ShapeList selectedshapelist) {
		this.shapelist = shapelist;
		this.appState = appState;
		this.start = start;
		this.end = end;
		this.selectedshapelist = selectedshapelist;
	}
	
	@Override
	public void run() {
		BoundingBox r0 = new BoundingBox(start.getX(),start.getY(),end.getX(),end.getY());
		for (IShapes shape : shapelist.getShapeList()) {
			BoundingBox r1 = new BoundingBox(shape.getStartPoint().getX(),shape.getStartPoint().getY(),shape.getEndPoint().getX(),shape.getEndPoint().getY());
			if (r1.intersects(r0)) {
				selectedshapelist.add(shape);
			} else if (!r1.intersects(r0)){
				selectedshapelist.remove(shape);

			} else {
				return;
			}
		}
		appState.setSelectedShapeList(selectedshapelist);
		appState.setShapeList(shapelist);
	}

	@Override
	public ShapeList getList() {
		return null;
	}

}

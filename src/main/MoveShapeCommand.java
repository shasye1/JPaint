package main;

import model.persistence.ApplicationState;

public class MoveShapeCommand implements ICommand, IUndoable {
	private ShapeList shapelist;
	private ApplicationState appState;
	private Point start;
	private Point end;
	private ShapeList selectedshapelist;
	
	public MoveShapeCommand(ShapeList shapelist,ApplicationState appState,Point start, Point end, ShapeList selectedshapelist) {
		this.shapelist = shapelist;
		this.appState = appState;
		this.start = start;
		this.end = end;
		this.selectedshapelist = selectedshapelist;
	}

	@Override
	public void run() {
		int dx = end.getX()-start.getX();
		int dy = end.getY()-start.getY();
		Point Newstart;
		Point Newend;
		for (IShapes shape : shapelist.getShapeList()) {
			if (selectedshapelist.contains(shape)) {
				int changedX1 = shape.getStartPoint().getX() + dx;
				int changedY1 = shape.getStartPoint().getY() + dy;
				int changedX2 = shape.getEndPoint().getX() + dx;
				int changedY2 = shape.getEndPoint().getY() + dy;
				Newstart = new Point(changedX1,changedY1);
				Newend = new Point(changedX2,changedY2);
				shape.setStartPoint(Newstart);
				shape.setEndPoint(Newend);
			}
		}
		shapelist.notifyObservers();
		CommandHistory.add(this);
	}

	@Override
	public ShapeList getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void undo() {
		int dx = end.getX()-start.getX();
		int dy = end.getY()-start.getY();
		Point Oldstart;
		Point Oldend;
		for (IShapes shape : shapelist.getShapeList()) {
			if (selectedshapelist.contains(shape)) {
				int X1 = shape.getStartPoint().getX() - dx;
				int Y1 = shape.getStartPoint().getY() - dy;
				int X2 = shape.getEndPoint().getX() - dx;
				int Y2 = shape.getEndPoint().getY() - dy;
				Oldstart = new Point(X1,Y1);
				Oldend = new Point(X2,Y2);
				shape.setStartPoint(Oldstart);
				shape.setEndPoint(Oldend);
			}
		}
		shapelist.notifyObservers();

	}

	@Override
	public void redo() {
		int dx = end.getX()-start.getX();
		int dy = end.getY()-start.getY();
		Point Newstart;
		Point Newend;
		for (IShapes shape : shapelist.getShapeList()) {
			if (selectedshapelist.contains(shape)) {
				int changedX1 = shape.getStartPoint().getX() + dx;
				int changedY1 = shape.getStartPoint().getY() + dy;
				int changedX2 = shape.getEndPoint().getX() + dx;
				int changedY2 = shape.getEndPoint().getY() + dy;
				Newstart = new Point(changedX1,changedY1);
				Newend = new Point(changedX2,changedY2);
				shape.setStartPoint(Newstart);
				shape.setEndPoint(Newend);
			}
		}
		shapelist.notifyObservers();
	}
	

}

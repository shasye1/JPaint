package main;

public class PasteCommand implements ICommand, IUndoable {
	private ShapeList shapelist;
	private ShapeList copiedshapelist;
	private IShapes copy;
	Point start;
	Point end;
	
	public PasteCommand(ShapeList shapelist, ShapeList copiedshapelist) {
		this.copiedshapelist = copiedshapelist;
		this.shapelist = shapelist;
	}
	
	@Override
	public void run() {
		for (IShapes shape : copiedshapelist.getShapeList()) {
			start = new Point(shape.getStartPoint().getX()+30, shape.getStartPoint().getY()+30);
			end = new Point(shape.getEndPoint().getX()+30, shape.getEndPoint().getY()+30);
			shape.setStartPoint(start);
			shape.setEndPoint(end);
			try {
				copy = shape.clone(shape);
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			shapelist.add((IShapes) copy);
		}
		CommandHistory.add(this);
	}

	@Override
	public ShapeList getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void undo() {
		shapelist.remove((IShapes) copy);
	}

	@Override
	public void redo() {
		shapelist.add((IShapes) copy);
		
	}

}

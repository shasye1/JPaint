package main;

public class DeleteCommand implements ICommand, IUndoable{
	private ShapeList shapelist;
	private ShapeList selectedshapelist;
	
	public DeleteCommand(ShapeList shapelist, ShapeList selectedshapelist) {
		this.selectedshapelist = selectedshapelist;
		this.shapelist = shapelist;
	}
	
	@Override
	public void run() {
		try {
		for (IShapes shape : shapelist.getShapeList()) {
			if (shapelist.getShapeList() == null) {
				return;
			} else if (selectedshapelist.contains(shape)) {
				shapelist.remove(shape);
			}
		}
		} catch (Exception e) {
			return;
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
		for (IShapes shape : shapelist.getShapeList()) {
			if (selectedshapelist.contains(shape)) {
				shapelist.add(shape);
			}
		}
		shapelist.notifyObservers();
	}

	@Override
	public void redo() {
		for (IShapes shape : shapelist.getShapeList()) {
			if (selectedshapelist.contains(shape)) {
				shapelist.remove(shape);
			}
		}
		shapelist.notifyObservers();
	}

}

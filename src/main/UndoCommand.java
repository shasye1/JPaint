package main;

public class UndoCommand implements ICommand {

	@Override
	public void run() {
		CommandHistory.undo();
	}

	@Override
	public ShapeList getList() {
		// TODO Auto-generated method stub
		return null;
	}

}

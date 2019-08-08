package main;

public class RedoCommand implements ICommand{

	@Override
	public void run() {
		CommandHistory.redo();
	}

	@Override
	public ShapeList getList() {
		// TODO Auto-generated method stub
		return null;
	}

}

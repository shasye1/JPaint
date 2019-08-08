package main;
import java.lang.Object;

public class CopyCommand implements ICommand {
	private ShapeList selectedshapelist;
	private ShapeList copiedshapelist = new ShapeList();
	private IShapes copy;
	
	public CopyCommand(ShapeList selectedshapelist) {
		this.selectedshapelist = selectedshapelist;
	}
	
	@Override
	public void run() {
		for (IShapes shape : selectedshapelist.getShapeList()) {
			try {
				copy = shape.clone(shape);
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			copiedshapelist.add((IShapes) copy);
		
		}
		System.out.println(copiedshapelist.getShapeList());
	}

	@Override
	public ShapeList getList() {
		return this.copiedshapelist;
	}
}

package main;

import java.awt.Graphics2D;
import java.util.EnumMap;

import model.ShapeColor;
import model.ShapeType;
import view.gui.PaintCanvas;

public class DrawShapeHandler implements IObserver {
	private ShapeList shapelist;
	private PaintCanvas paintCanvas;
	IOperator operatorStrategy = null;
	EnumMap<ShapeColor, java.awt.Color> map = new EnumMap<ShapeColor, java.awt.Color>(ShapeColor.class);
	
	public DrawShapeHandler(ShapeList shapelist, PaintCanvas paintCanvas) {
		this.shapelist = shapelist;
		this.paintCanvas = paintCanvas;
	}
	
	public void update() {
		map.put(ShapeColor.WHITE, java.awt.Color.WHITE);
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
		graphics2d.setColor(map.get(ShapeColor.WHITE));
		graphics2d.fillRect(0, 0, 10000, 10000);
		for (IShapes shape : shapelist.getShapeList()) {
			if (shapelist.getShapeList() == null) {
				return;
			} else if (shape.getShapeType().equals(ShapeType.RECTANGLE)) {
				operatorStrategy = new DrawRect();
				shape.draw(paintCanvas, operatorStrategy);
			} else if (shape.getShapeType().equals(ShapeType.ELLIPSE)) {
				operatorStrategy = new DrawEllipse();
				shape.draw(paintCanvas, operatorStrategy);
			} else if (shape.getShapeType().equals(ShapeType.TRIANGLE)) {
				operatorStrategy = new DrawTriangle();
				shape.draw(paintCanvas, operatorStrategy);
			}
		}
		
	}
	

}

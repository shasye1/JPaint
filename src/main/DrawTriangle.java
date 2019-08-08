package main;

import java.awt.Graphics2D;
import java.util.EnumMap;

import model.ShapeColor;
import model.ShapeShadingType;
import view.gui.PaintCanvas;

public class DrawTriangle implements IOperator {

	@Override
	public void draw(PaintCanvas paintcanvas, ShapeShadingType shade_type, Point start, Point end, ShapeColor pcolor, ShapeColor scolor) {
		EnumMap<ShapeColor, java.awt.Color> map = new EnumMap<ShapeColor, java.awt.Color>(ShapeColor.class);
		map.put(ShapeColor.BLACK, java.awt.Color.BLACK);
		map.put(ShapeColor.BLUE, java.awt.Color.BLUE);
		map.put(ShapeColor.CYAN, java.awt.Color.CYAN);
		map.put(ShapeColor.DARK_GRAY, java.awt.Color.DARK_GRAY);
		map.put(ShapeColor.GRAY, java.awt.Color.GRAY);
		map.put(ShapeColor.GREEN, java.awt.Color.GREEN);
		map.put(ShapeColor.LIGHT_GRAY, java.awt.Color.LIGHT_GRAY);
		map.put(ShapeColor.MAGENTA, java.awt.Color.MAGENTA);
		map.put(ShapeColor.ORANGE, java.awt.Color.ORANGE);
		map.put(ShapeColor.PINK, java.awt.Color.PINK);
		map.put(ShapeColor.WHITE, java.awt.Color.WHITE);
		map.put(ShapeColor.YELLOW, java.awt.Color.YELLOW);
		map.put(ShapeColor.RED, java.awt.Color.RED);
		
		Graphics2D graphics2d = paintcanvas.getGraphics2D();
		int xs[] = new int[3];
		int ys[] = new int[3];
		xs[0] = start.getX();
		xs[1] = start.getX();
		xs[2] = end.getX();
		ys[0] = start.getY();
		ys[1] = end.getY();
		ys[2] = end.getY();
		if (shade_type.equals(shade_type.FILLED_IN)) {
			graphics2d.setColor(map.get(pcolor));
			graphics2d.fillPolygon(xs, ys, 3);
		} else if (shade_type.equals(shade_type.OUTLINE)) {
			graphics2d.setColor(map.get(pcolor));
			graphics2d.drawPolygon(xs, ys, 3);;
		} else if (shade_type.equals(shade_type.OUTLINE_AND_FILLED_IN)) {
			graphics2d.setColor(map.get(pcolor));
			graphics2d.fillPolygon(xs, ys, 3);
			graphics2d.setColor(map.get(scolor));
			graphics2d.drawPolygon(xs, ys, 3);
		}
	}

}

package main;

import model.ShapeColor;
import model.ShapeShadingType;
import view.gui.PaintCanvas;

public interface IOperator {

	void draw(PaintCanvas paintcanvas, ShapeShadingType shade_type, Point start, Point end, ShapeColor pcolor, ShapeColor scolor);

}

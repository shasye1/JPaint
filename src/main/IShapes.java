package main;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;
import view.gui.PaintCanvas;

public interface IShapes {
	ShapeType getShapeType();
	ShapeColor getPrimaryColor();
	ShapeColor getSecondaryColor();
	ShapeShadingType getShapeShadingType();
	StartAndEndPointMode getStartAndEndPointMode();
	Point getStartPoint();
	Point getEndPoint();
		
	void setShapeType(ShapeType shape_type);
	void setPrimaryColor(ShapeColor pcolor);
	void setSecondaryColor(ShapeColor scolor);
	void setShapeShadingType(ShapeShadingType shade_type);
	void setStartAndEndPointMode(StartAndEndPointMode start_end);
	void setStartPoint(Point start);
	void setEndPoint(Point end);
	void draw(PaintCanvas paintcanvas, IOperator operator);
	IShapes clone(IShapes a) throws CloneNotSupportedException;
}

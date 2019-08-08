package main;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;
import view.gui.PaintCanvas;

public class ShapeBuilder implements IShapes, Cloneable {
	private ShapeType shape_type;
	private ShapeColor pcolor;
    private ShapeColor scolor;
    private ShapeShadingType shade_type;
    private StartAndEndPointMode start_end;
    private Point start;
    private Point end;
    private IShapes copy;
    
    @Override
    public IShapes clone(IShapes a) throws CloneNotSupportedException {
    	copy = new ShapeBuilder();
    	this.copy.setShapeType(a.getShapeType());
    	this.copy.setPrimaryColor(a.getPrimaryColor());
    	this.copy.setSecondaryColor(a.getSecondaryColor());
    	this.copy.setShapeShadingType(a.getShapeShadingType());
    	this.copy.setStartAndEndPointMode(a.getStartAndEndPointMode());
    	this.copy.setStartPoint(a.getStartPoint());
    	this.copy.setEndPoint(a.getEndPoint());
    	return copy;
    }
    
    @Override
	public void draw(PaintCanvas paintcanvas, IOperator operator) {
		operator.draw(paintcanvas, shade_type, start, end, pcolor, scolor);
	}
    
	@Override
	public void setShapeType(ShapeType shape_type) {
		this.shape_type = shape_type;
	}

	@Override
	public void setPrimaryColor(ShapeColor pcolor) {
		this.pcolor = pcolor;
	}

	@Override
	public void setSecondaryColor(ShapeColor scolor) {
		this.scolor = scolor;
	}

	@Override
	public void setShapeShadingType(ShapeShadingType shade_type) {
		this.shade_type = shade_type;
	}

	@Override
	public void setStartAndEndPointMode(StartAndEndPointMode start_end) {
		this.start_end = start_end;
	}
    
	@Override
	public  ShapeType getShapeType() {
		return shape_type;
	}
	
	@Override
	public ShapeColor getPrimaryColor() {
		return pcolor;
	}
	
	@Override
	public ShapeColor getSecondaryColor() {
		return scolor;
	}
	
	@Override
	public ShapeShadingType getShapeShadingType() {
		return shade_type;
	}
	
	@Override
	public StartAndEndPointMode getStartAndEndPointMode() {
		return start_end;
	}

	@Override
	public Point getStartPoint() {
		return start;
	}

	@Override
	public Point getEndPoint() {
		return end;
	}

	@Override
	public void setStartPoint(Point start) {
		this.start = start;
	}

	@Override
	public void setEndPoint(Point end) {
		this.end = end;
	}
	
	
    
    
}

package model.interfaces;

import main.ShapeList;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;

public interface IApplicationState {
	void CopyCommand(ShapeList selectedlist);
	void PasteCommand(ShapeList shapelist, ShapeList copiedshapelist);
	void UndoCommand();
	void RedoCommand();

    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();
	void setSelectedShapeList(ShapeList selectedshapelist);
	ShapeList getSelectedShapeList();
	void setShapeList(ShapeList shapelist);
	ShapeList getShapeList();
	ShapeList getCopiedShapeList();
	void DeleteCommand(ShapeList shapelist, ShapeList selectedlist);
}

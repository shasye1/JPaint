package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import view.interfaces.IUiModule;

import java.io.Serializable;

import main.CopyCommand;
import main.ICommand;
import main.ShapeList;

public class ApplicationState implements IApplicationState, Serializable {
    private static final long serialVersionUID = -5545483996576839007L;
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;

    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private StartAndEndPointMode activeStartAndEndPointMode;

    private ICommand command;
    private ShapeList selectedshapelist;
    private ShapeList shapelist;
    private ShapeList copiedshapelist;
    
    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();
    }
    
    @Override
    public void CopyCommand(ShapeList selectedlist) {
    	ICommand command = new CopyCommand(selectedlist);
    	command.run();
    	this.copiedshapelist = command.getList();
    }
    
    @Override
    public void PasteCommand(ShapeList shapelist,ShapeList copiedshapelist) {
    	ICommand command = new main.PasteCommand(shapelist, copiedshapelist);
    	command.run();
    }
    
	@Override
	public void UndoCommand() {
		ICommand command = new main.UndoCommand();
		command.run();
	}

	@Override
	public void RedoCommand() {
		ICommand command = new main.RedoCommand();
		command.run();
	}
    
	@Override
	public void DeleteCommand(ShapeList shapelist, ShapeList selectedlist) {
		ICommand command = new main.DeleteCommand(shapelist, selectedlist);
		command.run();
	}
	
    @Override
    public void setSelectedShapeList(ShapeList selectedshapelist) {
    	this.selectedshapelist = selectedshapelist;
    }
    
    @Override
    public ShapeList getSelectedShapeList() {
    	return selectedshapelist;
    }
    
    @Override
    public ShapeList getCopiedShapeList() {
    	return this.copiedshapelist;
    }
    
    @Override
    public void setShapeList(ShapeList shapelist) {
    	this.shapelist = shapelist;
    }
    @Override
    public ShapeList getShapeList() {
    	return shapelist;
    }

    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeStartAndEndPointMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public StartAndEndPointMode getActiveStartAndEndPointMode() {
        return activeStartAndEndPointMode;
    }

    private void setDefaults() {
        activeShapeType = ShapeType.ELLIPSE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeStartAndEndPointMode = StartAndEndPointMode.DRAW;
    }


}

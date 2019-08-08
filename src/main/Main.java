package main;
import java.util.ArrayList;
import java.util.List;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeColor;
import model.dialogs.DialogProvider;
import model.interfaces.IDialogProvider;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args){
        ShapeList shapelist = new ShapeList();
        PaintCanvas paintCanvas = new PaintCanvas();   
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
        ClickHandler a = new ClickHandler(shapelist,appState);
    	DrawShapeHandler drawshapehandler = new DrawShapeHandler(shapelist,paintCanvas);
    	shapelist.registerObserver(drawshapehandler);
        paintCanvas.addMouseListener(a);
    }
}

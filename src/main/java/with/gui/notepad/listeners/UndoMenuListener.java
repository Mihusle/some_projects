package with.gui.notepad.listeners;

import with.gui.notepad.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Created by MHSL on 05.02.2017.
 *
 * This class listens to changes of availability undo or redo options.
 */
public class UndoMenuListener implements MenuListener {
    
    private View view;
    private JMenuItem undoMenuItem, redoMenuItem;
    
    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }
    
    @Override
    public void menuSelected(MenuEvent e) {
        undoMenuItem.setEnabled(view.canUndo());
        redoMenuItem.setEnabled(view.canRedo());
    }
    
    @Override
    public void menuDeselected(MenuEvent e) {
        
    }
    
    @Override
    public void menuCanceled(MenuEvent e) {
        
    }
}

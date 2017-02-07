package with.gui.notepad.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 * Created by MHSL on 05.02.2017.
 *
 * This class always tries out an existence of edits which UndoManager can abolish.
 */
public class UndoListener implements UndoableEditListener {
    
    private UndoManager undoManager;
    
    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }
    
    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        undoManager.addEdit(e.getEdit());
    }
}

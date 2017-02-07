package with.gui.notepad.actions;

import with.gui.notepad.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by MHSL on 05.02.2017.
 */
public class UndoAction extends AbstractAction {
    
    private View view;
    
    public UndoAction(View view) {
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        view.undo();
    }
}

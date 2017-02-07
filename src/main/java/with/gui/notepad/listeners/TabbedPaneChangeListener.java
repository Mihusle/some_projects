package with.gui.notepad.listeners;

import with.gui.notepad.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by MHSL on 03.02.2017.
 *
 * This class listens to changes of tabbed pane.
 */
public class TabbedPaneChangeListener implements ChangeListener {
    
    private View view;
    
    public TabbedPaneChangeListener(View view) {
        this.view = view;
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        view.selectedTabChanged();
    }
}

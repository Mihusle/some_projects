package with.gui.notepad.listeners;

import with.gui.notepad.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by MHSL on 03.02.2017.
 *
 * This class listens to events with window.
 */
public class FrameListener extends WindowAdapter {
    
    private View view;
    
    public FrameListener(View view) {
        this.view = view;
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        view.exit();
    }
}

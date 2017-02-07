package with.gui.notepad.listeners;

import with.gui.notepad.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 * Created by MHSL on 05.02.2017.
 *
 * This class constantly tries out availability of points menu for font, color and etc.
 */
public class TextEditMenuListener implements MenuListener {
    
    private View view;
    
    public TextEditMenuListener(View view) {
        this.view = view;
    }
    
    @Override
    public void menuSelected(MenuEvent e) {
        JMenu menu = (JMenu) e.getSource();
        for (Component component : menu.getMenuComponents()) {
            component.setEnabled(view.isHtmlTabSelected());
        }
    }
    
    @Override
    public void menuDeselected(MenuEvent e) {
        
    }
    
    @Override
    public void menuCanceled(MenuEvent e) {
        
    }
}

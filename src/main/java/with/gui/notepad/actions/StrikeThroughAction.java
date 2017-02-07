package with.gui.notepad.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Created by MHSL on 05.02.2017.
 */
public class StrikeThroughAction extends StyledEditorKit.StyledTextAction {
    
    public StrikeThroughAction() {
        super(StyleConstants.StrikeThrough.toString());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JEditorPane editor = getEditor(e);
        if (editor != null) {
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setStrikeThrough(simpleAttributeSet, !StyleConstants.isStrikeThrough(mutableAttributeSet));
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}

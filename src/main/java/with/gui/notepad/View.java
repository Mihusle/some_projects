package with.gui.notepad;

import with.gui.notepad.listeners.FrameListener;
import with.gui.notepad.listeners.TabbedPaneChangeListener;
import with.gui.notepad.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MHSL on 03.02.2017.
 */
public class View extends JFrame implements ActionListener {
    
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);
    
    View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "New":
                controller.createNewDocument();
                break;
            case "Open":
                controller.openDocument();
                break;
            case "Save":
                controller.saveDocument();
                break;
            case "Save as...":
                controller.saveDocumentAs();
                break;
            case "Exit":
                exit();
                break;
            case "About":
                showAbout();
        }
    }
    
    void init() {
        initGui();
        addWindowListener(new FrameListener(this));
        setVisible(true);
    }
    
    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar, BorderLayout.NORTH);
        
    }
    
    private void initEditor() {
        htmlTextPane.setContentType("text/html");
        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));
        tabbedPane.addTab("Text", new JScrollPane(plainTextPane));
        tabbedPane.setSize(800, 600);
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }
    
    private void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }
    
    public void selectedTabChanged() {
        if (isHtmlTabSelected()) {
            controller.setPlainText(plainTextPane.getText());
        } else {
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }
    
    public boolean canUndo() {
        return undoManager.canUndo();
    }
    
    public boolean canRedo() {
        return undoManager.canRedo();
    }
    
    public void undo() {
        undoManager.undo();
    }
    
    public void redo() {
        undoManager.redo();
    }
    
    void resetUndo() {
        undoManager.discardAllEdits();
    }
    
    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }
    
    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }
    
    void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }
    
    public void showAbout() {
        JOptionPane.showMessageDialog(this, "About", "It's my stupid editor", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void exit() {
        controller.exit();
    }
    
    UndoListener getUndoListener() {
        return undoListener;
    }
    
    Controller getController() {
        return controller;
    }
    
    void setController(Controller controller) {
        this.controller = controller;
    }
}

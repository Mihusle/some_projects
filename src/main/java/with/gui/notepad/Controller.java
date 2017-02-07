package with.gui.notepad;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by MHSL on 03.02.2017.
 */
public class Controller {
    private View view;
    private HTMLDocument document; //model
    private File currentFile;
    
    Controller(View view) {
        this.view = view;
    }
    
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
    
    void init() {
        createNewDocument();
    }
    
    String getPlainText() {
        StringWriter writer = new StringWriter();
        try {
            new HTMLEditorKit().write(writer, document, 0, document.getLength());
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }
    
    void setPlainText(String text) {
        resetDocument();
        try (StringReader reader = new StringReader(text)) {
            new HTMLEditorKit().read(reader, document, 0);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }
    
    void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    
    void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("Stupid editor");
        view.resetUndo();
        currentFile = null;
    }
    
    void openDocument() {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HtmlFileFilter());
        int choice = chooser.showOpenDialog(view);
        if (choice == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try (FileReader reader = new FileReader(currentFile)) {
                new HTMLEditorKit().read(reader, document, 0);
                view.resetUndo();
            } catch (FileNotFoundException e) {
                ExceptionHandler.log(e);
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }
    
    void saveDocument() {
        view.selectHtmlTab();
        if (currentFile != null) {
            view.setTitle(currentFile.getName());
            try (FileWriter writer = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        } else {
            saveDocumentAs();
        }
    }
    
    void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HtmlFileFilter());
        int choice = chooser.showSaveDialog(view);
        if (choice == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileWriter writer = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }
    
    void exit() {
        System.exit(0);
    }
    
    HTMLDocument getDocument() {
        return document;
    }
}

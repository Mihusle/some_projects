package with.gui.notepad;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MHSL on 07.02.2017.
 */
public class HtmlFileFilter extends FileFilter {
    
    @Override
    public boolean accept(File f) {
        Pattern pattern = Pattern.compile(".*(?i:(\\.html)|(\\.htm))$");
        Matcher matcher = pattern.matcher(f.getAbsolutePath());
        return matcher.matches();
    }
    
    @Override
    public String getDescription() {
        return "html and htm files";
    }
}

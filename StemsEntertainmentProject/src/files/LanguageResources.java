package files;

import com.ui.LoginFrame;
import com.ui.MenuFrame;
import com.ui.SignupFrame;
import com.ui.WelcomeFrame;
import com.window.location.FrameEvents;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Popup;
import javax.swing.PopupFactory;

/**
 * @author Kgaugelo
 */
public final class LanguageResources
{
    private static final String LANGUAGE = "language";
    private static final FileProcessor fileProcessor = FileProcessor
            .createFile("preference");;
    
    private static final String ENGLISH  = "files/Language_en_US";
    private static final String SESOTHO  = "files/Language_nso_ZA";
    private static final String XHOSA    = "files/Language_xh_ZA";
    private static final String ZULU     = "files/Language_zu_ZA";
     
    public static String getENGLISH() {
        return ENGLISH;
    }

    public static String getSESOTHO() {
        return SESOTHO;
    }

    public static String getXHOSA() {
        return XHOSA;
    }

    public static String getZULU() {
        return ZULU;
    }
       
    private static void updateFrame(Object type, String file, String language)
    {
        if (type instanceof LoginFrame) 
        {
            LoginFrame login = (LoginFrame) type;
            login.updateLanguagePreferences(file, language);
        }
        else if (type instanceof SignupFrame) 
        {
            SignupFrame signup = (SignupFrame) type;
            signup.updateLanguagePreferences(file, language);
        }
        else 
        {
            MenuFrame menu = (MenuFrame) type;
            menu.updateLanguagePreferences(file, language);
        }
    }
     
    public static void setLanguageResourceFile(Object type, JComboBox choices)
    {
        fileProcessor.loadFile();
        boolean langKey = fileProcessor.getProperties().containsKey(LANGUAGE);
        String language = "";
        
        if (langKey == true) 
        {
            String path = fileProcessor.getProperties().get("file").toString();
            language = fileProcessor.getProperties().get("language").toString();            
            updateFrame(type, path, language);
        }
        else 
        {
            WelcomeFrame.setDefaultResourceBundle(fileProcessor);
            setLanguageResourceFile(type, choices);
        }
        choices.setSelectedItem(language);
    }
   
    public static void selectLanguage(JComboBox choiceList, int count, Object type, 
            JPanel container, JPanel outer, JFrame frame)
    {   
        int x = 578;
        int y = 345;
        
        PopupFactory factory = new PopupFactory();
        Popup popup = factory.getPopup(container, outer, x, y);
        
        String selectedLang = choiceList.getSelectedItem().toString();
    
        if (count > 2) 
        {
            new Timer().schedule(new TimerTask() 
            {
                @Override
                public void run() 
                {
                    String bundleName = locale(selectedLang);
                    
                    updateFrame(type, bundleName, selectedLang);
                    outer.setVisible(false);
                    frame.setEnabled(true);
                    popup.hide();
                }
            }, 3000); 
            
            FrameEvents.centerFrame(frame);
            outer.setVisible(true);
            frame.setEnabled(false);
            popup.show();
        }
    }
    
    public static void selectLanguage(JComboBox choiceList, int count, Object type, 
            JProgressBar bar, JFrame frame)
    {   
        String selectedLang = choiceList.getSelectedItem().toString();

        if (count > 2) 
        {
            new Timer().schedule(new TimerTask() 
            {
                @Override
                public void run() 
                {
                    String bundleName = locale(selectedLang);
                    
                    updateFrame(type, bundleName, selectedLang);                   
                    bar.setVisible(false);
                    frame.setEnabled(true);
                }
            }, 3000); 
            
            bar.setVisible(true);
            frame.setEnabled(false);     
        }
    }
    
    private static String locale(String selectedLang)
    {
        String bundle = "";
        
        switch (selectedLang) 
        {
            case "English (default)":
                bundle = ENGLISH;
                break;

            case "Sesotho":
                bundle = SESOTHO;
                break;

            case "Xhosa":
                bundle = XHOSA;
                break;

            case "Zulu":
                bundle = ZULU;
                break;
        }
        
        /* Store the user's preferences to the properties file */
        fileProcessor.getProperties().setProperty(LANGUAGE, selectedLang);
        fileProcessor.getProperties().setProperty("file", bundle);
        fileProcessor.saveFile();
        
        return bundle;
    }
    
    /**
     * @deprecated This method is creates unnecessary {@code String} objects. 
     *             Use the <code>convertCase</code> method for better performance
     * @see #convertCase(java.lang.String) 
     * 
     * @param username The name to capitalize
     * @return The converted username that meets the noun rules 
     *         for capitalizing names
     * 
     * The expected output based on the input string is as follows:
     * <blockquote><pre>
     *     String firstCase = kgaugelo.substring(0,1).toUppercase();
     *     String lastCase  = kgaugelo.substring(1).toLowercase();
     *     firstCase contains <b>K</b> 
     *     lastCase contains <b>gaugelo</b>
     * </pre></blockquote>
     */  
    @Deprecated
    public static String capitalize(String username) {
        String firstCase = username.substring(0, 1).toUpperCase();
        String lastCase = username.substring(1, username.length()).toLowerCase();
        return firstCase.concat(lastCase);
    }
    
    public static String convertCase(String username)
    {
        StringBuilder capitalize = new StringBuilder();
        return capitalize.append(username.substring(0, 1).toUpperCase())
                .append(username.substring(1).toLowerCase()).toString();
    }
}
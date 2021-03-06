package GUI.Controller.Universal;

import javax.swing.*;
import java.io.IOException;

public class SimpleDialogController {
    JFrame f;

    /**
     * Constructor
     * @throws IOException
     */
    public SimpleDialogController(){f = new JFrame();}

    /**
     * Opens a window to ask user to confirm deletion
     * @return true if OK is pressed, false if Cancel is pressed
     */
    public static boolean delete(){
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?",
                "Delete...?",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if(confirm == 0){
            return true;
        }
        else{
            return false;
        }
    }
}

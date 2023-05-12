import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class PrintBloc implements KeyEventDispatcher {

    //=> Sobreescrevendo o metodo dispatchKeyEvent da interface KeyEventDispatcher
    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_PRINTSCREEN) {
            String textinQualquer = "PrintScreen Bloqueado por questões de segurança!";
            StringSelection string = new StringSelection(textinQualquer);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(string, null);
        }
        return false;
    }

    public static void blockPrintsScreen() {
        PrintBloc blockPrint = new PrintBloc();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(blockPrint);
    }
}
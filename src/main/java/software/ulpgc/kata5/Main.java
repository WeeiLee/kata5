package software.ulpgc.kata5;

import software.ulpgc.kata5.control.ShowPokemonCommand;
import software.ulpgc.kata5.ui.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.put("search", new ShowPokemonCommand(
                mainFrame.getImageDisplay(),
                mainFrame.getInformationDisplay(),
                mainFrame.getDialog()
                )
        );
        mainFrame.setVisible(true);
    }
}

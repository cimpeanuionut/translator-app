package ro.ase.translatorApp.searchedHistory;

import ro.ase.translatorApp.userManagement.TipUser;

public class RoText extends SearchedText {

    public RoText(TipUser tipUser, String phrase) {
        super(tipUser, Language.RO, phrase);
        create();
    }

    @Override
    void create() {
        setPhrase("Ro: " + getPhrase());


    }
}

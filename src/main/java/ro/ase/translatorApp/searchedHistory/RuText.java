package ro.ase.translatorApp.searchedHistory;

import ro.ase.translatorApp.userManagement.TipUser;

public class RuText extends SearchedText {

    public RuText(TipUser tipUser, String phrase) {
        super(tipUser, Language.RU, phrase);
        create();
    }

    @Override
    void create() {
        setPhrase("RU: " + getPhrase());
    }
}

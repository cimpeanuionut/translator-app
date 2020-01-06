package ro.ase.translatorApp.searchedHistory;

import ro.ase.translatorApp.userManagement.TipUser;

public class DeText extends SearchedText {

    public DeText(TipUser tipUser, String phrase) {
        super(tipUser, Language.DE, phrase);
        create();
    }

    @Override
    void create() {
        setPhrase("Searched by (" + getTipUser() +"): " + getPhrase());

    }
}

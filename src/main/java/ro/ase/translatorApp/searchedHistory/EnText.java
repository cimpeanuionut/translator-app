package ro.ase.translatorApp.searchedHistory;

import ro.ase.translatorApp.userManagement.TipUser;

public class EnText extends SearchedText {

    public EnText(TipUser tipUser, String phrase) {
        super(tipUser, Language.EN, phrase);
    }

    @Override
    void create() {

    }
}

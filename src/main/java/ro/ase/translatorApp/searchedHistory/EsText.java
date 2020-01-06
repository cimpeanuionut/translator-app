package ro.ase.translatorApp.searchedHistory;

import ro.ase.translatorApp.userManagement.TipUser;

public class EsText extends SearchedText {

    public EsText(TipUser tipUser, String phrase) {
        super(tipUser, Language.ES, phrase);
        create();
    }

    @Override
    void create() {
        setPhrase("Es: " + getPhrase());


    }
}

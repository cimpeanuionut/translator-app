package ro.ase.translatorApp.searchedHistory;

import ro.ase.translatorApp.userManagement.TipUser;

public class FrText extends SearchedText {

    public FrText(TipUser tipUser, String phrase) {
        super(tipUser, Language.FR, phrase);
        create();
    }

    @Override
    void create() {
        setPhrase("FR: " + getPhrase());
    }
}

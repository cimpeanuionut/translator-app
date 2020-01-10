package ro.ase.translatorApp.searchedHistory;


import ro.ase.translatorApp.entities.nullObject.NullList;
import ro.ase.translatorApp.userManagement.TipUser;

public class OtherText extends SearchedText {

    public OtherText(TipUser tipUser, String phrase) {
        super(tipUser, new NullList().limba(), phrase);
        create();
    }



    @Override
    void create() {
        setPhrase("Other: " + getPhrase());
    }
}

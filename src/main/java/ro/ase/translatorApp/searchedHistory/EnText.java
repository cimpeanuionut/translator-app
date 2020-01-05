package ro.ase.translatorApp.searchedHistory;

import ro.ase.translatorApp.userManagement.TipUser;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EnText extends SearchedText {

    public EnText(TipUser tipUser, String phrase) {
        super(tipUser, Language.EN, phrase);
        create();
    }

    @Override
    void create() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        setPhrase("Searched on " + dateFormat.format(new Date()) + ": " + getPhrase());

    }
}

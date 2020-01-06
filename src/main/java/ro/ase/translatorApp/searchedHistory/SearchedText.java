package ro.ase.translatorApp.searchedHistory;

import ro.ase.translatorApp.userManagement.TipUser;

public abstract class SearchedText {
    private TipUser tipUser;
    private Language language;
    private String phrase;

    abstract void create();

    public SearchedText(TipUser tipUser, Language language, String phrase) {
        this.tipUser = tipUser;
        this.language = language;
        this.phrase = phrase;
    }

    public TipUser getTipUser() {
        return tipUser;
    }

    public void setTipUser(TipUser tipUser) {
        this.tipUser = tipUser;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}

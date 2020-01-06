package ro.ase.translatorApp.searchedHistory;

import ro.ase.translatorApp.userManagement.TipUser;

public class SearchedTextFactory {

    private SearchedTextFactory(){}

    public static SearchedText createText(TipUser tipUser, Language language, String phrase){
        SearchedText text = null;
        switch (tipUser){
            case USER: text = UserSearchedTextFactory.createSearchedText(language, phrase); break;
            case ADMIN: text = AdminSearchedTextFactory.createSearchedText(language, phrase); break;
            default: break;
        }
        return text;
    }
}

package ro.ase.translatorApp.searchedHistory;

import ro.ase.translatorApp.userManagement.TipUser;

public class AdminSearchedTextFactory {

   public static SearchedText createSearchedText(Language language, String phrase){
        SearchedText searchedText = null;
        switch (language){
            case DE: searchedText = new DeText(TipUser.ADMIN, phrase); break;
            case EN: searchedText = new EnText(TipUser.ADMIN, phrase); break;
            case FR: searchedText = new FrText(TipUser.ADMIN, phrase); break;
            case ES: searchedText = new EsText(TipUser.ADMIN, phrase); break;
            case RU: searchedText = new RuText(TipUser.ADMIN, phrase); break;
            default: break;
        }
        return searchedText;
    }
}

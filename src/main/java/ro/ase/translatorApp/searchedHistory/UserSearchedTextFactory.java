package ro.ase.translatorApp.searchedHistory;


import ro.ase.translatorApp.userManagement.TipUser;

public class UserSearchedTextFactory {

   public static SearchedText createSearchedText(Language language, String phrase){
        SearchedText searchedText = null;
        switch (language){
            case DE: searchedText = new DeText(TipUser.USER, phrase); break;
            case EN: searchedText = new EnText(TipUser.USER, phrase); break;
            case FR: searchedText = new FrText(TipUser.USER, phrase); break;
            case RO: searchedText = new RoText(TipUser.USER, phrase); break;
            default: break;
        }
        return searchedText;
    }
}

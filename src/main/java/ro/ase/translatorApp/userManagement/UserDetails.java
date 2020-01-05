package ro.ase.translatorApp.userManagement;

import ro.ase.translatorApp.searchedHistory.SearchedText;

import java.util.ArrayList;
import java.util.List;

public class UserDetails extends User {
    private List<SearchedText> istoricCautari;

    public UserDetails(String username, String password, TipUser rol) {
        super(username, password, rol);
        istoricCautari = new ArrayList<>();
    }

    public List<SearchedText> getIstoricCautari() {
        return istoricCautari;
    }

    public void addSearchText(SearchedText text){
        istoricCautari.add(text);
    }
}

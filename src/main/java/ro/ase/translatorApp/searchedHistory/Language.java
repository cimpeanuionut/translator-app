package ro.ase.translatorApp.searchedHistory;

import ro.ase.translatorApp.entities.nullObject.List;
import ro.ase.translatorApp.entities.nullObject.NonNullList;
import ro.ase.translatorApp.entities.nullObject.NullList;

public enum Language {
    EN, DE, ES, FR, RU;

    public static List contains(String s)
    {
        for(Language lang:values()) {
        	if (lang.name().equals(s)) {
        		return new NonNullList(lang);
        	}
        }      
        return new NullList();
    }

}

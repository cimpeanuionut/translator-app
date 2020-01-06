package ro.ase.translatorApp.searchedHistory;

public enum Language {
    EN, DE, ES, FR, RU;

    public static boolean contains(String s)
    {
        for(Language lang:values())
            if (lang.name().equals(s))
                return true;
        return false;
    }
}

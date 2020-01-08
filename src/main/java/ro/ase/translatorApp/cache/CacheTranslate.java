package ro.ase.translatorApp.cache;

public class CacheTranslate {
    private String word;
    private String flag;

    public CacheTranslate()
    {

    }
    public CacheTranslate(String word, String flag)
    {
        this.word = word;
        this.flag = flag;
    }
    public String GetWord()
    {
        return word;
    }
    public String GetFlag()
    {
        return flag;
    }
}

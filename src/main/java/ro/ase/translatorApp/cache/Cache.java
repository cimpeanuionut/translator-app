package ro.ase.translatorApp.cache;


import ro.ase.translatorApp.searchedHistory.Language;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static ro.ase.translatorApp.searchedHistory.Language.*;

public class Cache {


    private Scanner s;
    private final String filePath = "src/main/java/ro/ase/translatorApp/cache/Cache";
    private ArrayList<String> list;
    private Map<Integer,String> enMap = new HashMap<Integer, String>();
    private Map<Integer,String> deMap = new HashMap<Integer, String>();
    private Map<Integer,String> esMap = new HashMap<Integer, String>();
    private Map<Integer,String> frMap = new HashMap<Integer, String>();
    private Map<Integer,String> ruMap = new HashMap<Integer, String>();

    public void GetDataFromFile()
    {
        Scanner s = null;
        try {
            s = new Scanner(new File(filePath)).useDelimiter("\\s*]\\s*");
            list = new ArrayList<String>();
            while (s.hasNext()){
                list.add(s.next());
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }

        if(list.size() > 0)
        {
            int id = 0;
            String[] words;
            for (String item : list) {
               words = item.split("\\-");
               enMap.put(id, words[0]);
               deMap.put(id, words[1]);
               esMap.put(id, words[2]);
               frMap.put(id, words[3]);
               ruMap.put(id, words[4]);
                id++;
            }
        }
    }

    public boolean CacheTranslate(String word, String languageEntry, String languageExit) {
        int id = 0;

        switch (Language.valueOf(languageEntry.toUpperCase())) {
            case EN:
                for (Map.Entry<Integer, String> entry : enMap.entrySet())
                    if (entry.getValue().toUpperCase().equalsIgnoreCase(word.toUpperCase().trim()))
                        id = entry.getKey();
                break;
            case DE:
                for (Map.Entry<Integer, String> entry : deMap.entrySet())
                    if (entry.getValue().toUpperCase().equalsIgnoreCase(word.toUpperCase().trim()))
                        id = entry.getKey();
                break;
            case ES:
                for (Map.Entry<Integer, String> entry : esMap.entrySet())
                    if (entry.getValue().toUpperCase().equalsIgnoreCase(word.toUpperCase().trim()))
                        id = entry.getKey();
                break;
            case FR:
                for (Map.Entry<Integer, String> entry : frMap.entrySet())
                    if (entry.getValue().toUpperCase().equalsIgnoreCase(word.toUpperCase().trim()))
                        id = entry.getKey();
                break;
            case RU:
                for (Map.Entry<Integer, String> entry : ruMap.entrySet())
                    if (entry.getValue().toUpperCase().equalsIgnoreCase(word.toUpperCase().trim()))
                        id = entry.getKey();
                break;
            default:
                return false;
        }

        switch (Language.valueOf(languageExit.toUpperCase())) {
            case EN:
                for (Map.Entry<Integer, String> entry : enMap.entrySet())
                    if (entry.getKey().equals(id)) {
                        return true;
                    }
                break;
            case DE:
                for (Map.Entry<Integer, String> entry : deMap.entrySet())
                    if (entry.getKey().equals(id)) {
                        return true;
                    }
                break;
            case ES:
                for (Map.Entry<Integer, String> entry : esMap.entrySet())
                    if (entry.getKey().equals(id)) {
                        return true;
                    }
                break;
            case FR:
                for (Map.Entry<Integer, String> entry : frMap.entrySet())
                    if (entry.getKey().equals(id)) {
                        return true;
                    }
                break;
            case RU:
                for (Map.Entry<Integer, String> entry : ruMap.entrySet())
                    if (entry.getKey().equals(id)) {
                        return true;
                    }
                break;
            default:
                return false;
        }
        return false;
    }
}

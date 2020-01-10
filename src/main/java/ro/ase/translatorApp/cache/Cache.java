package ro.ase.translatorApp.cache;


import ro.ase.translatorApp.searchedHistory.Language;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cache {


    private Scanner s;
    private final String filePath = "src/main/java/ro/ase/translatorApp/cache/Cache";
    private ArrayList<String> list = null;
    private int listCount;
    private Map<Integer, CacheTranslate> enMap = new HashMap<Integer, CacheTranslate>();
    private Map<Integer, CacheTranslate> deMap = new HashMap<Integer, CacheTranslate>();
    private Map<Integer, CacheTranslate> esMap = new HashMap<Integer, CacheTranslate>();
    private Map<Integer, CacheTranslate> frMap = new HashMap<Integer, CacheTranslate>();
    private Map<Integer, CacheTranslate> ruMap = new HashMap<Integer, CacheTranslate>();
    private Map<Integer, CacheTranslate> other = new HashMap<Integer, CacheTranslate>();
    private void GetDataFromFile() {
        Scanner s = null;
        try {
            s = new Scanner(new File(filePath)).useDelimiter("\\s*]\\s*");
            list = new ArrayList<String>();
            while (s.hasNext()) {
                list.add(s.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
        listCount = list.size();
        if (list.size() > 0) {
            int id = 0;
            String[] words;
            for (String item : list) {
                words = item.split("/");
                if(Language.contains(words[2].toUpperCase()).limba() == null) {
                	other.put(id, new CacheTranslate(words[0], words[2] + '-' + words[3]));
                }else {
                	switch (Language.contains(words[2].toUpperCase()).limba()) {
                    case EN:
                        enMap.put(id, new CacheTranslate(words[0], words[2] + '-' + words[3]));
                        break;
                    case DE:
                        deMap.put(id, new CacheTranslate(words[0],words[2] + '-' + words[3]));
                        break;
                    case ES:
                        esMap.put(id, new CacheTranslate(words[0],words[2] + '-' + words[3]));
                        break;
                    case FR:
                        frMap.put(id, new CacheTranslate(words[0], words[2] + '-' + words[3]));
                        break;
                    case RU:
                        ruMap.put(id, new CacheTranslate(words[0], words[2] + '-' + words[3]));
                        break;
                    default: other.put(id, new CacheTranslate(words[0], words[2] + '-' + words[3]));
                    break;
                }
                }
                if(Language.contains(words[2].toUpperCase()).limba() == null) {
                	other.put(id, new CacheTranslate(words[1],words[2] + '-' + words[3]));
                }else {
                	switch (Language.contains(words[3].toUpperCase()).limba()) {
                    case EN:
                        enMap.put(id, new CacheTranslate(words[1],words[2] + '-' + words[3]));
                        break;
                    case DE:
                        deMap.put(id, new CacheTranslate(words[1],words[2] + '-' + words[3]));
                        break;
                    case ES:
                        esMap.put(id, new CacheTranslate(words[1],words[2] + '-' + words[3]));
                        break;
                    case FR:
                        frMap.put(id, new CacheTranslate(words[1],words[2] + '-' + words[3]));
                        break;
                    case RU:
                        ruMap.put(id, new CacheTranslate(words[1],words[2] + '-' + words[3]));
                        break;
                    default:
                        other.put(id, new CacheTranslate(words[1],words[2] + '-' + words[3]));
                        break;
                }
                }
                
                id++;
            }
        }
    }

    public String CacheTranslate(String word, String languageEntry, String languageExit) {
        if (list == null)
            GetDataFromFile();

        int id = -1;
        String s = languageEntry.toUpperCase() + '-' + languageExit.toUpperCase();
        if(Language.contains(languageEntry).limba() == null ) {
        	for (Map.Entry<Integer, CacheTranslate> entry : other.entrySet())
                id = entry.getKey();
        } else {
	        	switch (Language.contains(languageEntry).limba()) {
	            case EN:
	                for (Map.Entry<Integer, CacheTranslate> entry : enMap.entrySet())
	                    if (entry.getValue().GetWord().toUpperCase().equalsIgnoreCase(word.toUpperCase().trim()) &&
	                            entry.getValue().GetFlag().toUpperCase().equalsIgnoreCase(s))
	                        id = entry.getKey();
	                break;
	            case DE:
	                for (Map.Entry<Integer, CacheTranslate> entry : deMap.entrySet())
	                    if (entry.getValue().GetWord().toUpperCase().equalsIgnoreCase(word.toUpperCase().trim()) &&
	                            entry.getValue().GetFlag().toUpperCase().equalsIgnoreCase(s))
	                        id = entry.getKey();
	                break;
	            case ES:
	                for (Map.Entry<Integer, CacheTranslate> entry : esMap.entrySet())
	                    if (entry.getValue().GetWord().toUpperCase().equalsIgnoreCase(word.toUpperCase().trim()) &&
	                            entry.getValue().GetFlag().toUpperCase().equalsIgnoreCase(s))
	                        id = entry.getKey();
	                break;
	            case FR:
	                for (Map.Entry<Integer, CacheTranslate> entry : frMap.entrySet())
	                    if (entry.getValue().GetWord().toUpperCase().equalsIgnoreCase(word.toUpperCase().trim()) &&
	                            entry.getValue().GetFlag().toUpperCase().equalsIgnoreCase(s))
	                        id = entry.getKey();
	                break;
	            case RU:
	                for (Map.Entry<Integer, CacheTranslate> entry : ruMap.entrySet())
	                    if (entry.getValue().GetWord().toUpperCase().equalsIgnoreCase(word.toUpperCase().trim()) &&
	                            entry.getValue().GetFlag().toUpperCase().equalsIgnoreCase(s))
	                        id = entry.getKey();
	                break;
	            default:
	            	for (Map.Entry<Integer, CacheTranslate> entry : other.entrySet())
	                        id = entry.getKey();
	                break;
	        }
        }
        
        if(Language.contains(languageEntry).limba() == null ) {
        	for (Map.Entry<Integer, CacheTranslate> entry : other.entrySet())
                
                return entry.getValue().GetWord();
        } else {
        switch (Language.contains(languageEntry).limba()) {
            case EN:
                for (Map.Entry<Integer, CacheTranslate> entry : enMap.entrySet())
                    if (entry.getKey().equals(id))
                        return entry.getValue().GetWord();

                break;
            case DE:
                for (Map.Entry<Integer, CacheTranslate> entry : deMap.entrySet())
                    if (entry.getKey().equals(id))
                        return entry.getValue().GetWord();
                break;
            case ES:
                for (Map.Entry<Integer, CacheTranslate> entry : esMap.entrySet())
                    if (entry.getKey().equals(id))
                        return entry.getValue().GetWord();
                break;
            case FR:
                for (Map.Entry<Integer, CacheTranslate> entry : frMap.entrySet())
                    if (entry.getKey().equals(id))
                        return entry.getValue().GetWord();
                break;
            case RU:
                for (Map.Entry<Integer, CacheTranslate> entry : ruMap.entrySet())
                    if (entry.getKey().equals(id))
                        return entry.getValue().GetWord();
                break;
            default:
            	for (Map.Entry<Integer, CacheTranslate> entry : other.entrySet())
              
                        return entry.getValue().GetWord();
                break;
        }
        
    }
        return "";
    }

    public void AddNewWordsToCache(String inputWord, String inputLanguage, String outputWord, String outputLanguage) {
        String newLine = inputWord.trim() + '/' + outputWord.trim() + '/' + inputLanguage.trim() + '/' + outputLanguage.trim();
        list.add(newLine);
    }

    public void SaveDataToCache() {
        if(listCount == list.size())
            return;

        String tempFile = "src/main/java/ro/ase/translatorApp/cache/temp.txt";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        FileWriter fw = null;
        try {
            fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            for (String str : list) {
                pw.println(str + ']');
            }
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filePath);
            newFile.renameTo(dump);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

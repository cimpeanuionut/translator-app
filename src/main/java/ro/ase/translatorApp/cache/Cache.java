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
    private Map<Integer, String> enMap = new HashMap<Integer, String>();
    private Map<Integer, String> deMap = new HashMap<Integer, String>();
    private Map<Integer, String> esMap = new HashMap<Integer, String>();
    private Map<Integer, String> frMap = new HashMap<Integer, String>();
    private Map<Integer, String> ruMap = new HashMap<Integer, String>();

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
                words = item.split("\\-");
                switch (Language.valueOf(words[2].toUpperCase())) {
                    case EN:
                        enMap.put(id, words[0]);
                        break;
                    case DE:
                        deMap.put(id, words[0]);
                        break;
                    case ES:
                        esMap.put(id, words[0]);
                        break;
                    case FR:
                        frMap.put(id, words[0]);
                        break;
                    case RU:
                        ruMap.put(id, words[0]);
                        break;
                }
                switch (Language.valueOf(words[3].toUpperCase())) {
                    case EN:
                        enMap.put(id, words[1]);
                        break;
                    case DE:
                        deMap.put(id, words[1]);
                        break;
                    case ES:
                        esMap.put(id, words[1]);
                        break;
                    case FR:
                        frMap.put(id, words[1]);
                        break;
                    case RU:
                        ruMap.put(id, words[1]);
                        break;
                }
                id++;
            }
        }
    }

    public String CacheTranslate(String word, String languageEntry, String languageExit) {
        if (list == null)
            GetDataFromFile();

        int id = -1;
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
                return "";
        }

        switch (Language.valueOf(languageExit.toUpperCase())) {
            case EN:
                for (Map.Entry<Integer, String> entry : enMap.entrySet())
                    if (entry.getKey().equals(id)) {
                        return entry.getValue();
                    }
                break;
            case DE:
                for (Map.Entry<Integer, String> entry : deMap.entrySet())
                    if (entry.getKey().equals(id)) {
                        return entry.getValue();
                    }
                break;
            case ES:
                for (Map.Entry<Integer, String> entry : esMap.entrySet())
                    if (entry.getKey().equals(id)) {
                        return entry.getValue();
                    }
                break;
            case FR:
                for (Map.Entry<Integer, String> entry : frMap.entrySet())
                    if (entry.getKey().equals(id)) {
                        return entry.getValue();
                    }
                break;
            case RU:
                for (Map.Entry<Integer, String> entry : ruMap.entrySet())
                    if (entry.getKey().equals(id)) {
                        return entry.getValue();
                    }
                break;
            default:
                return "";
        }
        return "";
    }

    public void AddNewWordsToCache(String inputWord, String inputLanguage, String outputWord, String outputLanguage) {
        String newLine = inputWord.trim() + '-' + outputWord.trim() + '-' + inputLanguage.trim() + '-' + outputLanguage.trim();
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

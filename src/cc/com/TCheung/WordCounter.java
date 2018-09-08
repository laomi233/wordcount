package cc.com.TCheung;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {


    public static int CharacterSum(File file) throws IOException {
        int count_Char = 0;
        if(!file.exists())
        {
            count_Char = -1;
        }
        FileReader fr = new FileReader(file);
        while(fr.read()!=-1)
        {
            count_Char++;
        }
        return count_Char;

    }



}

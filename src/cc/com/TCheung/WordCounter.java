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

    public static int Rows_number(File file) throws IOException {
        int count_Row = 0;
        if(!file.exists())
        {
            count_Row = -1;
        }
        else
        {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String s = null;
            while((s=br.readLine())!=null)
            {
                count_Row++;
            }
        }
        return count_Row;
    }

    public static int word_cal(File file) throws IOException {
        int count_Word = 0;
        if(!file.exists())
        {
            count_Word = -1;
        }
        else
        {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String s = null;
            while((s=br.readLine())!=null)
            {
                String reg = "\\d+.\\d+|\\w+";
                Matcher mat = Pattern.compile(reg).matcher(s);
                while(mat.find())
                {
                    count_Word++;
                }

            }
        }
        return count_Word;
    }

    private static List<String> filepath;

    public static List<String> ScanFileInRecursion(File file)
    {

        if(!file.isDirectory())
        {
            System.out.println("非合法目录文件夹！请重新输入！");
        }
        else
        {
            File[] files = file.listFiles();
            for(int i=0;i<files.length;i++)
            {
                if(files[i].isDirectory())
                {
                    filepath.add(files[i].getAbsolutePath());
                    ScanFileInRecursion(files[i]);
                }
                else
                {
                    filepath.add(files[i].getAbsolutePath());
                }
            }

        }
        return filepath;
    }

    public static int isEmptyLine(File file) throws IOException {
        int count_EmptyLine = 0;
        if(!file.exists())
        {
            count_EmptyLine = -1;
        }
        else
        {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String s = null;
            while((s=br.readLine())!=null)
            {
                if(s.trim().length()<=1){
                    count_EmptyLine++;
                }
            }

        }
        return count_EmptyLine;
    }


}

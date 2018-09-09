package cc.com.TCheung.controller.controller;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class WordCounter {


    public static int CharacterSum(File file) throws IOException {
        int count_Char = 0;


        if(!file.exists())
        {

            count_Char = -1;
            return count_Char;
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


    public static List<String> filepath = new LinkedList<>();
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

                    ScanFileInRecursion(files[i]);
                }
                else
                {
                    System.out.println(files[i].getAbsolutePath());
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


    public static int isCodeLine(File file) throws IOException {
        int count_CodeLine = 0;
        if(!file.exists())
        {
            count_CodeLine = -1;
        }
        else {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String s = null;
            Pattern p = Pattern.compile("\\/\\/[^\\n]*|\\/\\*([^\\*^\\/]*|[\\*^\\/*]*|[^\\**\\/]*)*\\*+\\/");
            String tmp = null;
            StringBuffer sb = new StringBuffer();
            String target = null;
            while ((s = br.readLine()) != null) {
                s = s.trim();
                int flag = 0;
                int pos = 0;
                for (int i = 1; i < s.length(); i++) {
                    if ((i+1)<s.length()-1&&s.charAt(i) == '/' && (s.charAt(i + 1) == '/' || s.charAt(i + 1) == '*')) {
                        pos = i;

                        if(s.charAt(i)=='/'&&s.charAt(i+1)=='/')
                        {
                            sb.append(s,0,i);
                            sb.append("\n");
                        }
                        else if(s.charAt(i+1)=='*'&& !s.substring(i).contains("*/"))
                        {
                            String t = (String) s.subSequence(0, i);
                            sb.append(t);
                            sb.append("\n");
                            sb.append(s.substring(i));
                            sb.append("\n");
                        }
                        else if(s.charAt(i+1)=='*'&& s.substring(i).contains("*/"))
                        {
                            Matcher m = p.matcher(s);
                            tmp = m.replaceAll("");
                            sb.append(tmp);
                            sb.append("\n");
                            flag = 1;
                            break;
                        }
                        flag = 1;

                    }

                }
                if (flag == 0) {
                    if (s.length() > 1 && s.substring(0, 1).equals("*/")) {
                        //  System.out.println(s);

                        sb.append("*/");
                        sb.append("\n");
                        sb.append(s.substring(2));
                        sb.append("\n");
                    } else {
                        sb.append(s);
                        sb.append("\n");
//                Matcher mat = p.matcher(s);
//                target = mat.replaceAll("");
//                if(target.trim().length()>1)
//                {
//                    System.out.println(target);
//                    count_CodeLine++;
//                }
                    }

                }
            }
            br.close();
            target = sb.toString();
            // System.out.println(target);
            Matcher mat = p.matcher(target);
            String res = null;
            res = mat.replaceAll("");
            //System.out.println(res);
            BufferedReader context = new BufferedReader(new StringReader(res));
            while((tmp=context.readLine())!=null)
            {

                if(tmp.trim().length()>1)
                {
                    // System.out.println(tmp);
                    count_CodeLine++;
                }
            }

        }
        //System.out.println(count_CodeLine);
        return count_CodeLine;
    }

        public static int isAnnotationLine(File file) throws IOException {
            int count_Annotation = 0;
            if(!file.exists())
            {
                count_Annotation = -1;
            }
            else
            {
                count_Annotation = Rows_number(file) - isEmptyLine(file) - isCodeLine(file);
            }
            return count_Annotation;
        }

        public static List<Path> getRelateFiles(String filepath) throws IOException {
            FileFinder finder = new FileFinder(filepath);
            Files.walkFileTree(Paths.get(System.getProperty("user.dir")),finder);

            Collection<Path> Absolutematched = finder.getMatchedAbPaths();

//            for(Path path: Absolutematched)
//            {
//               // realpaths.add(path.toRealPath());
//                System.out.println(path);
//            }

            return (List<Path>) Absolutematched;
}

    public static void main(String[] args) throws Exception {
        System.out.println(getRelateFiles("h.txt"));
    }


}

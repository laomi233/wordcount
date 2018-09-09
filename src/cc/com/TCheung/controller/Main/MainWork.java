package cc.com.TCheung.controller.Main;

import cc.com.TCheung.controller.UI.NewJFrame;
import cc.com.TCheung.controller.controller.WordCounter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class MainWork {

    public static int total_char = 0;
    public static int total_word = 0;
    public static int total_line = 0;
    public static int total_empty = 0;
    public static int total_code = 0;
    public static int total_annotation = 0;

    public static boolean isCorrectPram(String s) {
        if (s.equals("-c") || s.equals("-w") || s.equals("-l") || s.equals("-s") || s.equals("-a") || s.equals("-x")) {
            return true;
        }
        return false;
    }

    public static boolean isClearName(String path) {
        if (path.contains("*") || path.contains("?")) {
            return false;
        }
        return true;
    }

    public static void work(Set<String> oper, String filename) throws IOException {
        WordCounter wc = new WordCounter();
        System.out.println(filename);
        Iterator it = oper.iterator();
        while (it.hasNext()) {
            String op = (String) it.next();
            if (filename != null) {
                // filename = filename.substring(1, filename.length() - 1);
                File file = new File(filename);

                //System.out.println(System.getProperty("user.dir")+"\\"+filename);
                if (op.equals("-c")) {
                    int char_sum = wc.CharacterSum(file);
                    if (char_sum == -1) {
                        char_sum = 0;
                        System.out.println("文件不存在");
                    } else {
                        total_char += char_sum;
                        System.out.println("字符数： " + wc.CharacterSum(file));
                    }

                } else if (op.equals("-w")) {
                    int word_sum = wc.word_cal(file);
                    if (word_sum == -1) {
                        word_sum = 0;
                        System.out.println("文件不存在");
                    } else {
                        System.out.println("单词数: " + word_sum);
                        total_word += word_sum;
                    }

                } else if (op.equals("-l")) {
                    int line_sum = wc.Rows_number(file);
                    if (line_sum == -1) {
                        line_sum = 0;
                        System.out.println("文件不存在");
                    } else {

                        System.out.println("总行数： " + wc.Rows_number(file));
                        total_line += line_sum;
                    }


                }  else if (op.equals("-a")) {
                    if (!file.exists()) {
                        System.out.println("文件不存在");
                    } else {
                        int isempty = wc.isEmptyLine(file);
                        int isCode = wc.isCodeLine(file);
                        int isAnno = wc.isAnnotationLine(file);
                        System.out.println("空行数： " + isempty);
                        System.out.println("代码行： " + isCode);
                        System.out.println("注释行： " + isAnno);
                        total_empty += isempty;
                        total_code += isCode;
                        total_annotation += isAnno;
                    }
                }
            }


        }

    }

    public static void WorkForFiles(Set<String> oper, String file) throws IOException {
        WordCounter wc = new WordCounter();
        total_char = 0;
        total_word = 0;
        total_line = 0;
        total_empty = 0;
        total_code = 0;
        total_annotation = 0;
        List<Path> files = wc.getRelateFiles(file);
        // Collection<> filename = wc.getRelateFiles(file);
//        for (Path path : files) {
//            System.out.println(path);
//        }
//        for(int i=0;i<filename.size();i++)
//        {
//            System.out.println(filename.get(i));
//        }
        System.out.println("---------------------------------");
        if (files.isEmpty()) {
            System.out.println("找不到相关文件！");
        } else {
            for (Path path : files) {
                work(oper, path.toString());
                //System.out.println(total_char);
            }
            System.out.println("---------------------------------");
            Iterator it = oper.iterator();
            while (it.hasNext()) {
                String target = it.next().toString();
                if (target.equals("-c")) {
                    System.out.println("总字符数： " + total_char);
                } else if (target.equals("-w")) {
                    System.out.println("总单词数： " + total_word);
                } else if (target.equals("-l")) {
                    System.out.println("总行数： " + total_line);
                } else if (target.equals("-a")) {
                    System.out.println("总空行数： " + total_empty);
                    System.out.println("总代码行数： " + total_code);
                    System.out.println("总注释行数： " + total_annotation);
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(args));
        WordCounter wc = new WordCounter();
        if (args == null) {
            System.out.println("请输入命令");
        } else {
            Set<String> operations = new HashSet<>();
            String filename = null;
            int isFile = 0;
            for (int i = 0; i < args.length; i++) {
                if (isCorrectPram(args[i])) {
                    if (isFile == 1) {
                        System.out.println("参数输入错误");
                        break;
                    } else {
                        operations.add(args[i]);
                    }
                } else {
                    filename = args[i];
                    isFile = 1;
                }
            }
            if ((filename == null && !operations.contains("-x")) || operations.isEmpty()) {
                System.out.println("参数输入错误");
            } else if (operations.contains("-x")) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new NewJFrame().setVisible(true);
                    }
                });
            } else if (operations.contains("-s")) {
                File file = new File(filename);
                if (!file.exists()) {
                    System.out.println("文件不存在");
                } else {
                    List<String> files = wc.ScanFileInRecursion(file);
                    for (int i = 0; i < files.size(); i++) {
                        System.out.println(files.get(i));
                        System.out.println("字符数： " + wc.CharacterSum(new File(files.get(i))));
                        System.out.println("单词数:  " + wc.word_cal(new File(files.get(i))));
                        System.out.println("总行数： " + wc.Rows_number(new File(files.get(i))));
                        System.out.println("空行数： " + wc.isEmptyLine(new File(files.get(i))));
                        System.out.println("代码行： " + wc.isCodeLine(new File(files.get(i))));
                        System.out.println("注释行： " + wc.isAnnotationLine(new File(files.get(i))));
                    }
                }
            }else {
                WorkForFiles(operations, filename);
            }
        }
    }
}

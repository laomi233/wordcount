//
//package cc.com.TCheung.controller.controller;
//
//import java.io.*;
//import java.lang.reflect.Array;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Collection;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//public class Backup {
//
//
//    public static int CharacterSum(File file) throws IOException {
//        int count_Char = 0;
//
//
//        if(!file.exists())
//        {
//
//            count_Char = -1;
//            return count_Char;
//        }
//        FileReader fr = new FileReader(file);
//        while(fr.read()!=-1)
//        {
//            count_Char++;
//        }
//        return count_Char;
//
//    }
//
//    public static int Rows_number(File file) throws IOException {
//        int count_Row = 0;
//        if(!file.exists())
//        {
//            count_Row = -1;
//        }
//        else
//        {
//            FileReader fr = new FileReader(file);
//            BufferedReader br = new BufferedReader(fr);
//
//            String s = null;
//            while((s=br.readLine())!=null)
//            {
//                count_Row++;
//            }
//        }
//        return count_Row;
//    }
//
//    public static int word_cal(File file) throws IOException {
//        int count_Word = 0;
//        if(!file.exists())
//        {
//            count_Word = -1;
//        }
//        else
//        {
//            FileReader fr = new FileReader(file);
//            BufferedReader br = new BufferedReader(fr);
//
//            String s = null;
//            while((s=br.readLine())!=null)
//            {
//                String reg = "\\d+.\\d+|\\w+";
//                Matcher mat = Pattern.compile(reg).matcher(s);
//                while(mat.find())
//                {
//                    count_Word++;
//                }
//
//            }
//        }
//        return count_Word;
//    }
//
//
//    public static List<String> filepath = new LinkedList<>();
//    public static List<String> ScanFileInRecursion(File file)
//    {
//
//        if(!file.isDirectory())
//        {
//            System.out.println("非合法目录文件夹！请重新输入！");
//        }
//        else
//        {
//            File[] files = file.listFiles();
//            for(int i=0;i<files.length;i++)
//            {
//                if(files[i].isDirectory())
//                {
//
//                    ScanFileInRecursion(files[i]);
//                }
//                else
//                {
//                    System.out.println(files[i].getAbsolutePath());
//                    filepath.add(files[i].getAbsolutePath());
//                }
//            }
//
//        }
//        return filepath;
//    }
//
//    public static int isEmptyLine(File file) throws IOException {
//        int count_EmptyLine = 0;
//        if(!file.exists())
//        {
//            count_EmptyLine = -1;
//        }
//        else
//        {
//
//            FileReader fr = new FileReader(file);
//            BufferedReader br = new BufferedReader(fr);
//            String s = null;
//            while((s=br.readLine())!=null)
//            {
//                if(s.trim().length()<=1){
//                    count_EmptyLine++;
//                }
//            }
//
//        }
//        return count_EmptyLine;
//    }
//
////    public static void main(String[] args) throws IOException {
////        while (true) {
////            Scanner in = new Scanner(System.in);
////            String a = in.nextLine();
////            // String b = in.next();
////            getRelateFiles(a);
////        }
//
//    //    }
//    public static int isCodeLine(File file) throws IOException {
//        int count_CodeLine = 0;
//        if(!file.exists())
//        {
//            count_CodeLine = -1;
//        }
//        else {
//            FileReader fr = new FileReader(file);
//            BufferedReader br = new BufferedReader(fr);
//            String s = null;
//            Pattern p = Pattern.compile("\\/\\/[^\\n]*|\\/\\*([^\\*^\\/]*|[\\*^\\/*]*|[^\\**\\/]*)*\\*+\\/");
//            String tmp = null;
//            StringBuffer sb = new StringBuffer();
//            String target = null;
//            while ((s = br.readLine()) != null) {
//                s = s.trim();
//                int flag = 0;
//                int pos = 0;
//                for (int i = 1; i < s.length(); i++) {
//                    pos = i;
//
//                    if(s.charAt(i)=='/'&&s.charAt(i+1)=='/')
//                    {
//                        sb.append(s,0,i);
//                        sb.append("\n");
//                    }
//                    else if(s.charAt(i+1)=='*'&& !s.substring(i).contains("*/"))
//                    {
//                        String t = (String) s.subSequence(0, i);
//                        sb.append(t);
//                        sb.append("\n");
//                        sb.append(s.substring(i));
//                        sb.append("\n");
//                    }
//                    else if(s.charAt(i+1)=='*'&& s.substring(i).contains("*/"))
//                    {
//                        Matcher m = p.matcher(s);
//                        tmp = m.replaceAll("");
//                        sb.append(tmp);
//                        sb.append("\n");
//                        flag = 1;
//                        break;
//                    }
//                    flag = 1;
//
//                }
//
//            }
//            if (flag == 0) {
//                if (s.length() > 1 && s.substring(0, 1).equals("*/")) {
//                    //  System.out.println(s);
//
//                    sb.append("*/");
//                    sb.append("\n");
//                    sb.append(s.substring(2));
//                    sb.append("\n");
//                } else {
//                    sb.append(s);
//                    sb.append("\n");
////                Matcher mat = p.matcher(s);
////                target = mat.replaceAll("");
////                if(target.trim().length()>1)
////                {
////                    System.out.println(target);
////                    count_CodeLine++;
////                }
//                }
//
//            }
//        }
//        br.close();
//        target = sb.toString();
//        // System.out.println(target);
//        Matcher mat = p.matcher(target);
//        String res = null;
//        res = mat.replaceAll("");
//        //System.out.println(res);
//        BufferedReader context = new BufferedReader(new StringReader(res));
//        while((tmp=context.readLine())!=null)
//        {
//
//            if(tmp.trim().length()>1)
//            {
//                // System.out.println(tmp);
//                count_CodeLine++;
//            }
//        }
//
//    }
//    //System.out.println(count_CodeLine);
//        return count_CodeLine;
//}
//
//    public static int isAnnotationLine(File file) throws IOException {
//        int count_Annotation = 0;
//        if(!file.exists())
//        {
//            count_Annotation = -1;
//        }
//        else
//        {
//            count_Annotation = Rows_number(file) - isEmptyLine(file) - isCodeLine(file);
//        }
//        return count_Annotation;
//    }
//
//    public static List<Path> getRelateFiles(String filepath) throws IOException {
//        FileFinder finder = new FileFinder(filepath);
//        Files.walkFileTree(Paths.get(System.getProperty("user.dir")),finder);
//
//        Collection<Path> Absolutematched = finder.getMatchedAbPaths();
//
////            for(Path path: Absolutematched)
////            {
////               // realpaths.add(path.toRealPath());
////                System.out.println(path);
////            }
//
//        return (List<Path>) Absolutematched;
//    }
//
//    public static void main(String[] args) throws Exception {
//        System.out.println(getRelateFiles("h.txt"));
//    }
//
//
//}


//
//package cc.com.TCheung.controller.UI;
//
//
//import javax.swing.*;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//
//import static cc.com.TCheung.controller.controller.WordCounter.*;
//
///**
// *
// * @author 45418
// */
//
//public class NewJFrame extends javax.swing.JFrame {
//
//
//    public NewJFrame() {
//        initComponents();
//    }
//
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">
//    private void initComponents() {
//
//        jFileChooser1 = new javax.swing.JFileChooser();
//        jPanel1 = new javax.swing.JPanel();
//        jPanel2 = new javax.swing.JPanel();
//        jLabel1 = new javax.swing.JLabel();
//        jButton1 = new javax.swing.JButton();
//        jScrollPane1 = new javax.swing.JScrollPane();
//        jTextArea1 = new javax.swing.JTextArea();
//        jPanel3 = new javax.swing.JPanel();
//        chara = new javax.swing.JLabel();
//        jLabel2 = new javax.swing.JLabel();
//        jLabel3 = new javax.swing.JLabel();
//        jLabel4 = new javax.swing.JLabel();
//        jLabel5 = new javax.swing.JLabel();
//        jLabel6 = new javax.swing.JLabel();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
//
//        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
//
//        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
//        jLabel1.setFont(new java.awt.Font("方正舒体", 0, 36)); // NOI18N
//        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel1.setText("  Word_Count");
//
//        jButton1.setIcon(new javax.swing.ImageIcon("F:\\wordcount\\src\\未标题-1.jpg")); // NOI18N
//        jButton1.setText("jButton1");
//        jButton1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                try {
//                    jButton1ActionPerformed(evt);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//
//        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
//        jPanel2.setLayout(jPanel2Layout);
//        jPanel2Layout.setHorizontalGroup(
//                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
//                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
//        );
//        jPanel2Layout.setVerticalGroup(
//                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel2Layout.createSequentialGroup()
//                                .addGap(77, 77, 77)
//                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addGap(18, 18, 18)
//                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//
//        jTextArea1.setColumns(20);
//        jTextArea1.setRows(5);
//        jScrollPane1.setViewportView(jTextArea1);
//
//        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
//
//        chara.setForeground(new java.awt.Color(255, 255, 255));
//        chara.setText("字符数：");
//
//        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel2.setText("单词数：");
//
//        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel3.setText("总行数：");
//
//        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel4.setText("空行数：");
//
//        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel5.setText("注释行：");
//
//        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel6.setText("代码行：");
//
//        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
//        jPanel3.setLayout(jPanel3Layout);
//        jPanel3Layout.setHorizontalGroup(
//                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel3Layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                                        .addComponent(chara, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
//                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//        jPanel3Layout.setVerticalGroup(
//                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel3Layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addComponent(chara)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(jLabel2)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(jLabel3)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(jLabel4)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(jLabel5)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addContainerGap(29, Short.MAX_VALUE))
//        );
//
//        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
//                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
//        );
//        jPanel1Layout.setVerticalGroup(
//                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//        );
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//
//        pack();
//    }// </editor-fold>
//
//    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException, IOException {
//        // TODO add your handling code here:
//        JFileChooser jfc=new JFileChooser();
//        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
//        jfc.showDialog(new JLabel(), "选择");
//        File file=jfc.getSelectedFile();
//        if(file.isDirectory()){
//            System.out.println("文件夹:"+file.getAbsolutePath());
//        }else if(file.isFile()){
//            System.out.println("文件:"+file.getAbsolutePath());
//        }
//        System.out.println(jfc.getSelectedFile().getName());
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        String s = null;
//        while((s=br.readLine())!=null)
//        {
//            jTextArea1.append(s+"\n");
//        }
//
//        br.close();
//        int char_count = CharacterSum(file);
//        int word_count = word_cal(file);
//        int line_cunt = Rows_number(file);
//        int empty_line = isEmptyLine(file);
//        int code_line = isCodeLine(file);
//        int annotate_line = isAnnotationLine(file);
//
//        if(char_count==-1||word_count==-1||line_cunt==-1||empty_line==-1||code_line==-1||annotate_line==-1)
//        {
//            chara.setText("字符数：0");
//            jLabel2.setText("单词数：0");
//            jLabel3.setText("总行数：0");
//            jLabel4.setText("空行数：0");
//            jLabel5.setText("注释行：0");
//            jLabel6.setText("代码行：0");
//        }
//        else{
//            chara.setText("字符数： "+char_count);
//            jLabel2.setText("单词数： "+word_count);
//            jLabel3.setText("总行数： "+line_cunt);
//            jLabel4.setText("空行数： "+empty_line);
//            jLabel5.setText("注释行： "+annotate_line);
//            jLabel6.setText("代码行： "+code_line);
//        }
//
//    }
//
//
//
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
////        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new NewJFrame().setVisible(true);
////            }
////        });
//    }
//
//    // Variables declaration - do not modify
//    private javax.swing.JLabel chara;
//    private javax.swing.JButton jButton1;
//    private javax.swing.JFileChooser jFileChooser1;
//    private javax.swing.JLabel jLabel1;
//    private javax.swing.JLabel jLabel2;
//    private javax.swing.JLabel jLabel3;
//    private javax.swing.JLabel jLabel4;
//    private javax.swing.JLabel jLabel5;
//    private javax.swing.JLabel jLabel6;
//    private javax.swing.JPanel jPanel1;
//    private javax.swing.JPanel jPanel2;
//    private javax.swing.JPanel jPanel3;
//    private javax.swing.JScrollPane jScrollPane1;
//    private javax.swing.JTextArea jTextArea1;
//    // End of variables declaration
//}
//
//
//package cc.com.TCheung.controller.Main;
//
//import cc.com.TCheung.controller.UI.NewJFrame;
//import cc.com.TCheung.controller.controller.WordCounter;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.util.*;
//
//public class MainWork {
//
//    public static int total_char = 0;
//    public static int total_word = 0;
//    public static int total_line = 0;
//    public static int total_empty = 0;
//    public static int total_code = 0;
//    public static int total_annotation = 0;
//
//    public static boolean isCorrectPram(String s) {
//        if (s.equals("-c") || s.equals("-w") || s.equals("-l") || s.equals("-s") || s.equals("-a") || s.equals("-x")) {
//            return true;
//        }
//        return false;
//    }
//
//    public static boolean isClearName(String path) {
//        if (path.contains("*") || path.contains("?")) {
//            return false;
//        }
//        return true;
//    }
//
//    public static void work(Set<String> oper, String filename) throws IOException {
//        WordCounter wc = new WordCounter();
//        System.out.println(filename);
//        Iterator it = oper.iterator();
//        while (it.hasNext()) {
//            String op = (String) it.next();
//            if (filename != null) {
//                // filename = filename.substring(1, filename.length() - 1);
//                File file = new File(filename);
//
//                //System.out.println(System.getProperty("user.dir")+"\\"+filename);
//                if (op.equals("-c")) {
//                    int char_sum = wc.CharacterSum(file);
//                    if (char_sum == -1) {
//                        char_sum = 0;
//                        System.out.println("文件不存在");
//                    } else {
//                        total_char += char_sum;
//                        System.out.println("字符数： " + wc.CharacterSum(file));
//                    }
//
//                } else if (op.equals("-w")) {
//                    int word_sum = wc.word_cal(file);
//                    if (word_sum == -1) {
//                        word_sum = 0;
//                        System.out.println("文件不存在");
//                    } else {
//                        System.out.println("单词数: " + word_sum);
//                        total_word += word_sum;
//                    }
//
//                } else if (op.equals("-l")) {
//                    int line_sum = wc.Rows_number(file);
//                    if (line_sum == -1) {
//                        line_sum = 0;
//                        System.out.println("文件不存在");
//                    } else {
//
//                        System.out.println("总行数： " + wc.Rows_number(file));
//                        total_line += line_sum;
//                    }
//
//
//                }  else if (op.equals("-a")) {
//                    if (!file.exists()) {
//                        System.out.println("文件不存在");
//                    } else {
//                        int isempty = wc.isEmptyLine(file);
//                        int isCode = wc.isCodeLine(file);
//                        int isAnno = wc.isAnnotationLine(file);
//                        System.out.println("空行数： " + isempty);
//                        System.out.println("代码行： " + isCode);
//                        System.out.println("注释行： " + isAnno);
//                        total_empty += isempty;
//                        total_code += isCode;
//                        total_annotation += isAnno;
//                    }
//                }
//            }
//
//
//        }
//
//    }
//
//    public static void WorkForFiles(Set<String> oper, String file) throws IOException {
//        WordCounter wc = new WordCounter();
//        total_char = 0;
//        total_word = 0;
//        total_line = 0;
//        total_empty = 0;
//        total_code = 0;
//        total_annotation = 0;
//        List<Path> files = wc.getRelateFiles(file);
//        // Collection<> filename = wc.getRelateFiles(file);
////        for (Path path : files) {
////            System.out.println(path);
////        }
////        for(int i=0;i<filename.size();i++)
////        {
////            System.out.println(filename.get(i));
////        }
//        System.out.println("---------------------------------");
//        if (files.isEmpty()) {
//            System.out.println("找不到相关文件！");
//        } else {
//            for (Path path : files) {
//                work(oper, path.toString());
//                //System.out.println(total_char);
//            }
//            System.out.println("---------------------------------");
//            Iterator it = oper.iterator();
//            while (it.hasNext()) {
//                String target = it.next().toString();
//                if (target.equals("-c")) {
//                    System.out.println("总字符数： " + total_char);
//                } else if (target.equals("-w")) {
//                    System.out.println("总单词数： " + total_word);
//                } else if (target.equals("-l")) {
//                    System.out.println("总行数： " + total_line);
//                } else if (target.equals("-a")) {
//                    System.out.println("总空行数： " + total_empty);
//                    System.out.println("总代码行数： " + total_code);
//                    System.out.println("总注释行数： " + total_annotation);
//                }
//            }
//
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.out.println(Arrays.toString(args));
//        WordCounter wc = new WordCounter();
//        if (args == null) {
//            System.out.println("请输入命令");
//        } else {
//            Set<String> operations = new HashSet<>();
//            String filename = null;
//            int isFile = 0;
//            for (int i = 0; i < args.length; i++) {
//                if (isCorrectPram(args[i])) {
//                    if (isFile == 1) {
//                        System.out.println("参数输入错误");
//                        break;
//                    } else {
//                        operations.add(args[i]);
//                    }
//                } else {
//                    filename = args[i];
//                    isFile = 1;
//                }
//            }
//            if ((filename == null && !operations.contains("-x")) || operations.isEmpty()) {
//                System.out.println("参数输入错误");
//            } else if (operations.contains("-x")) {
//                java.awt.EventQueue.invokeLater(new Runnable() {
//                    public void run() {
//                        new NewJFrame().setVisible(true);
//                    }
//                });
//            } else if (operations.contains("-s")) {
//                File file = new File(filename);
//                if (!file.exists()) {
//                    System.out.println("文件不存在");
//                } else {
//                    List<String> files = wc.ScanFileInRecursion(file);
//                    for (int i = 0; i < files.size(); i++) {
//                        System.out.println(files.get(i));
//                        System.out.println("字符数： " + wc.CharacterSum(new File(files.get(i))));
//                        System.out.println("单词数:  " + wc.word_cal(new File(files.get(i))));
//                        System.out.println("总行数： " + wc.Rows_number(new File(files.get(i))));
//                        System.out.println("空行数： " + wc.isEmptyLine(new File(files.get(i))));
//                        System.out.println("代码行： " + wc.isCodeLine(new File(files.get(i))));
//                        System.out.println("注释行： " + wc.isAnnotationLine(new File(files.get(i))));
//                    }
//                }
//            }else {
//                WorkForFiles(operations, filename);
//            }
//        }
//    }
//}

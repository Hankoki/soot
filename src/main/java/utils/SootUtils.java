package utils;

import soot.SootMethod;

import java.util.LinkedList;

public class SootUtils {
    public  static  LinkedList<String> excludeClassesList ;

    /**
     * Convert a dot file to a png file
     * @param dotFilePath the dot file path
     * @param outputFilePath the output png file path
     * @throws Exception if the conversion failed
     */
    public static void convertDotToPng(String dotFilePath, String outputFilePath) throws Exception{
        try {
            String dotPath = "D:\\APPdata\\Graphviz\\bin\\dot.exe"; //Graphviz software installed location
            String[] cmd = new String[]{dotPath, "-Tpng", dotFilePath, "-o", outputFilePath};
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    /**
     * Check if a method is excluded
     * @param method the method to check
     * @return true if the method is excluded, false otherwise
     */
    public static boolean isExcludedMethod(SootMethod method)
    {
        String declaringClassName = method.getDeclaringClass().getName();
        for(String s : excludeClassesList())
        {
            if(declaringClassName.startsWith(s))
                return true;
        }
        return false;
    }

    /**
     * Get the list of excluded classes
     * @return the list of excluded classes
     */
    public static LinkedList<String> excludeClassesList() {
        if (excludeClassesList == null) {
            excludeClassesList = new LinkedList<String>();
            //排除特定的类
            excludeClassesList.add("java.");
            excludeClassesList.add("sun.");
            excludeClassesList.add("com.sun.");
            excludeClassesList.add("javax.");
            excludeClassesList.add("jdk.");
        }
        return excludeClassesList;
    }


}

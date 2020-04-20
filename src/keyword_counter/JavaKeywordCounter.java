package keyword_counter;

import java.io.File;
import java.util.*;
import java.util.stream.Stream;

public class JavaKeywordCounter {

    private final List<File> files = new ArrayList<>();

    private static final String[] keywords = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"};

    public List<File> getFiles() {
        return files;
    }

    //even though the keywords array is not exposed to the client, I provide
    //a method that returns a deep copy for the user, so they can look up the keywords and play
    //with them without mutating the original list
    public String[] getKeywordsCopy() {
        return Arrays.stream(keywords).toArray(String[]::new);
    }

    public void addFileToList(String path) {
        File file = new File(path);
        files.add(file);
    }

    public void removeFileFromList(String path) {
        files.removeIf(f -> f.getAbsolutePath().equals(path));
    }

    public int countTotalOccurrences(List<File> files) throws Exception {
        int totalCount = 0;
        for (File f : files) {
            totalCount += this.countKeywordOccurrencesPerFile(f);
        }
        return totalCount;
    }

    public int countKeywordOccurrencesPerFile(File file) throws Exception {
        Scanner scanner = new Scanner(file);
        //sets are optimized to check for dulicates, and so also to check for "contains" query ops
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));

        int count = 0;
        while (scanner.hasNext()) {
            if (keywordSet.contains(scanner.next())) {
                count++;
            }
        }
        return count;
    }
}

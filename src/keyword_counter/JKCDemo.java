package keyword_counter;

public class JKCDemo {
    public static void main(String[] args) throws Exception {

        //jkc stores a reference to an object that has a list that can store files
        //the list of keywords that the class stores for its objects is not exposed
        //to the client. we could expose it if we wanted the client to be able to
        //modify it, for instance, into their own list etc.
        JavaKeywordCounter jkc = new JavaKeywordCounter();

        String path1 = "C:\\Users\\---\\IdeaProjects\\SmallEx2\\src" +
                "\\arraysLiang\\varArgs\\OccurrenceCounter5.java";

        String path2 = "C:\\Users\\---\\IdeaProjects\\SmallEx2\\src" +
                "\\arraysLiang\\AnalyzeNumbersVsAverage.java";

        String path3 = "C:\\Users\\---\\IdeaProjects\\SmallEx2\\src" +
                "\\arraysLiang\\App4PassByValueVsPassBySharing.java";

        //you can add files to jkc's list by passing their paths to this method
        jkc.addFileToList(path1);
        jkc.addFileToList(path2);
        jkc.addFileToList(path3);

        //... or remove files from jkc's list by passing a path to this method
        jkc.removeFileFromList("C:\\Users\\---\\IdeaProjects\\SmallEx2\\src" +
                "\\arraysLiang\\App4PassByValueVsPassBySharing.java");

        int totalCount = jkc.countTotalOccurrences(jkc.getFiles());

        System.out.println("Java keyword occurrences in files: " + totalCount);
    }
}

package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SearchNameRunnable implements Runnable {

    private final String fileName;
    private final String searchName;

    public SearchNameRunnable(String fileName, String searchName) {
        this.fileName = fileName;
        this.searchName = searchName;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();

        System.out.println(
            "Search File: " + fileName
            +"/Virtual Thread: " + thread.isVirtual()
            +"/Thread ID: " + thread.threadId()
        );

        int occurrence = 0;

        try (BufferedReader br = Files.newBufferedReader(Path.of(fileName))) {
            String content;
            int lineNumber = 0;

            while ((content = br.readLine()) != null) {
                lineNumber++;

                if (content.contains(searchName)) {
                    occurrence++;
                    System.out.println("[" + fileName + "]Linha" + lineNumber + " : " + content);
                }
            }

            System.out.println("Occurrence: " + occurrence);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR FILE: " + fileName);
        }
        
        
    }
}
package com.praveen.streams.predicate.bufferedreader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessFiles {

    public static String processFiles(BufferReaderProcessor bufferReaderProcessor) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\prave\\IdeaProjects\\Java-advanced\\src\\com\\praveen\\streams\\predicate\\bufferedreader\\ProcessFiles.java"));
        String processed = bufferReaderProcessor.process(bufferedReader);
        return processed;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Read 2 Lines");
        System.out.println(processFiles(br -> br.readLine() + "\n" +  br.readLine()));
        System.out.println("Read 1 Lines");
        System.out.println(processFiles(br -> br.readLine()));
    }

}

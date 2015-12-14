package com.general.creational.pattern;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Observable;

import org.apache.commons.lang3.StringUtils;

public class Reader extends Observable {

    private String currentWord;
    private String path;

    public Reader(String path) {

        this.path = path;
    }

    public void process() throws IOException {

        String text = new String(Files.readAllBytes(Paths.get(path)));
        final String[] words = StringUtils.split(text);
        for (String word : words) {
            currentWord = word;
            setChanged();
            notifyObservers(Status.IN_PROGRESS);
        }
        setChanged();
        notifyObservers(Status.END_OF_FILE);
    }

    public String getCurrentWord() {

        return currentWord;
    }

    public void setCurrentWord(String currentWord) {

        this.currentWord = currentWord;

    }
}

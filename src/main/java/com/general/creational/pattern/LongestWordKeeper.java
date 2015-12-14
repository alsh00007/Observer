package com.general.creational.pattern;

import java.util.Observable;
import java.util.Observer;

public class LongestWordKeeper implements Observer, Processor {

    private Reader reader;
    private String longestWord = "";

    public LongestWordKeeper(Reader reader) {

        this.reader = reader;
        reader.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        Status status = (Status) arg;

        if (Status.IN_PROGRESS.equals(status)) {
            process();
        } else if (Status.END_OF_FILE.equals(status)) {
            display();
        }
    }

    @Override
    public void display() {

        System.out.println("Longest word is " + this.longestWord);
    }

    @Override
    public void process() {

        if (reader.getCurrentWord().length() > longestWord.length()) {
            longestWord = reader.getCurrentWord();
        }
    }
}

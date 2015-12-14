package com.general.creational.pattern;

import java.util.Observable;
import java.util.Observer;

public class WordCounter implements Observer, Processor {

    private int totalWordCounter = 0;

    public WordCounter(Reader reader) {

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

        System.out.println("Total count of words: " + this.totalWordCounter);
    }

    @Override
    public void process() {

        totalWordCounter++;
    }
}

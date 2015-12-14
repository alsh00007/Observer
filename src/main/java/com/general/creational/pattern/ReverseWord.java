package com.general.creational.pattern;

import java.util.Observable;
import java.util.Observer;

public class ReverseWord implements Observer, Processor {

    private Reader reader;

    public ReverseWord(Reader reader) {

        this.reader = reader;
        reader.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        Status status = (Status) arg;
        if (Status.IN_PROGRESS.equals(status)) {
            process();
        }
    }

    @Override
    public void display() {

    }

    @Override
    public void process() {

        System.out.println("Revers word is: "
                + new StringBuffer(reader.getCurrentWord()).reverse().toString());
    }
}

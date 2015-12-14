package com.general.creational.pattern;

import java.util.Observable;
import java.util.Observer;

import org.apache.commons.lang3.StringUtils;

public class NumberCounter implements Observer, Processor {

    private int    amountNumberWord;

    private Reader reader;

    public NumberCounter(Reader reader) {

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

        System.out.println("Total count of strings with numbers: " + this.amountNumberWord);
    }

    @Override
    public void process() {

        if (StringUtils.isNumeric(reader.getCurrentWord())) {
            amountNumberWord++;
        }
    }
}

package com.general.creational.pattern;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


public class Cli {

    private String[] args = null;
    private Options options = new Options();

    public Cli(String[] args) {

        this.args = args;
        options.addOption("h", "help", false, "Print help");
        options.addOption("f", "file", true, "Path to file");
        options.addOption("n", "number", false, "Enable number counter");
        options.addOption("w", "word", false, "Enable word counter");
        options.addOption("l", "longest", false, "Enable longest word keeper");
        options.addOption("r", "reverse", false, "Enable Reverse word");

    }

    public Reader parse() {

        CommandLineParser parser = new BasicParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
            if (cmd.hasOption("h"))
                help();
            if (cmd.hasOption("f")) {
                final String fileName = cmd.getOptionValue("f");
                Reader reader = new Reader(fileName);

                if (cmd.hasOption("n")) {
                    reader.addObserver(new NumberCounter(reader));
                }

                if (cmd.hasOption("w")) {
                    reader.addObserver(new WordCounter(reader));
                }

                if (cmd.hasOption("l")) {
                    reader.addObserver(new LongestWordKeeper(reader));
                }

                if (cmd.hasOption("r")) {
                    reader.addObserver(new ReverseWord(reader));
                }

                return reader;
            } else {
                help();
            }

        } catch (ParseException e) {
            help();

        }
        return null;
    }

    private void help() {

        HelpFormatter formater = new HelpFormatter();
        formater.printHelp("Main", options);

    }

}

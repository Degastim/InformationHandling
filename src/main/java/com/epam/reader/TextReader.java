package com.epam.reader;

import com.epam.exception.ReaderException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class TextReader {
    private static final Logger logger = LogManager.getLogger();
    private static final String DEFAULT_PATH = "data/text.txt";

    public String readText(String filepath) throws ReaderException {
        Path path = Path.of(filepath);
        String text = "";
        if (!Files.exists(path)) {
            path=Path.of(DEFAULT_PATH);
        }
        try {
            text=Files.readString(path);
            logger.log(Level.INFO,"Reading the text successfully");
        } catch (IOException e) {
            logger.log(Level.ERROR,"Reading the text failed");
            throw new ReaderException();
        }
        return text;
    }
}

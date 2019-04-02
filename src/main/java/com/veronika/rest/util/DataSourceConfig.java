package com.veronika.rest.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class DataSourceConfig {
    private final String inputFilePath;
    private final String outputFilePath;

    public static DataSourceConfig readFromFile(String filename) throws IOException {
        try (InputStream inputStream = new FileInputStream(filename)) {
            Properties prop = new Properties();
            prop.load(inputStream);
            return new DataSourceConfig(Objects.requireNonNull(prop.getProperty("inputFilePath")),
                    Objects.requireNonNull(prop.getProperty("outputFilePath")));
        }
    }

    public DataSourceConfig(String inputFilePath,
                            String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }
}

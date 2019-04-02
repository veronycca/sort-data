package com.veronika.sort.sorters;

import com.veronika.sort.util.DataSourceConfig;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSorter {
    private static final String CONF_FILE_PATH = "/home/veronika/IdeaProjects/sort-data/file/config.properties";

    public void sortFileData() throws IOException {
        final DataSourceConfig dataSourceConfig = DataSourceConfig.readFromFile(CONF_FILE_PATH);

        List<String> sortedFileData = getsSortedFileData(dataSourceConfig);
        insertSortedDataIntoFile(sortedFileData, dataSourceConfig);
    }

    private List<String> getsSortedFileData(DataSourceConfig dataSourceConfig) throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(dataSourceConfig.getInputFilePath()))) {
            String line = bufferedReader.readLine();
            List<String> result = Arrays.asList(line.split("\\s*,\\s*"));
            Collections.sort(result);
            return result;
        }
    }

    private void insertSortedDataIntoFile(List<String> data, DataSourceConfig dataSourceConfig) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(dataSourceConfig.getOutputFilePath()))) {
            bufferedWriter.write(String.join(", ", data));
        }
    }
}

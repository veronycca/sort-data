package com.veronika.sort.controllers;

import com.veronika.sort.sorters.DataSorter;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class DataSortController {
    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public @ResponseBody String sortDataFromFile() throws IOException {
        final DataSorter dataSorter = new DataSorter();
        dataSorter.sortFileData();
        return "SUCCESSFULLY SORTED";
    }
}

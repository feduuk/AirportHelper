package com.fedya.airportHelper.reader;

import com.fedya.airportHelper.Main;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class FileScanner{

    public Scanner getScanner(String file) throws FileNotFoundException {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(file);
        if(inputStream == null) throw new FileNotFoundException(file + " is missing!");
        else return new Scanner(inputStream);
    }
}

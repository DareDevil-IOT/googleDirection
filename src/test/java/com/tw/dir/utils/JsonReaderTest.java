package com.tw.dir.utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;

public class JsonReaderTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void parse() throws Exception {
        JsonReader jsonReader = new JsonReader();
        thrown.expect(FileNotFoundException.class);
        jsonReader.read("wrong_path/sample.json");

    }

}
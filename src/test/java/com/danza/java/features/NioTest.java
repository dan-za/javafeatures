package com.danza.java.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioTest {

    private Path pathToHelloWorld;
    private Path pathToHelloMoon;

    @BeforeEach
    void beforeEach() throws URISyntaxException {
        pathToHelloWorld = Paths.get(ClassLoader.getSystemResource("hello_world.txt").toURI());
        pathToHelloMoon = Paths.get(ClassLoader.getSystemResource("hello_moon.txt").toURI());
    }

    @Test
    void exists() {
        Assertions.assertTrue(Files.exists(pathToHelloWorld));
        Assertions.assertTrue(Files.exists(pathToHelloMoon));
    }

    @Test
    void readLines() throws IOException {

        var lines = Files.lines(pathToHelloWorld, StandardCharsets.UTF_8);
        var result = lines.toList();

        Assertions.assertEquals(2, result.size());
        var iterator = result.iterator();
        Assertions.assertEquals("Hello", iterator.next());
        Assertions.assertEquals("World", iterator.next());
    }

    @Test
    void readAllLines() throws IOException {

        var result = Files.readAllLines(pathToHelloWorld, StandardCharsets.UTF_8);

        Assertions.assertEquals(2, result.size());
        var iterator = result.iterator();
        Assertions.assertEquals("Hello", iterator.next());
        Assertions.assertEquals("World", iterator.next());
    }

    @Test
    void writeAndRead() throws IOException {

        var tempFile = Files.createTempFile("created_file", ".txt");
        
        Assertions.assertTrue(Files.exists(tempFile));
        Assertions.assertTrue(Files.isWritable(tempFile));

        var expectedContent = "Hello!";
        Files.writeString(tempFile, expectedContent);

        var actualContent = Files.readString(tempFile);
        Assertions.assertEquals(expectedContent, actualContent);
    }

    /**
     * @since Java 12
     */
    @Test
    void mismatch() throws IOException {

        var mismatch = Files.mismatch(pathToHelloWorld, pathToHelloMoon);
        Assertions.assertEquals(6, mismatch);

        var noMismatch = Files.mismatch(pathToHelloWorld, pathToHelloWorld);
        Assertions.assertEquals(-1, noMismatch);
    }

}

package ch17.sec04.exam04;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Path path = Paths.get(StreamExample.class.getResource("data.txt").toURI());
        Stream<String> lines = Files.lines(path, Charset.defaultCharset());
        lines.forEach(line -> System.out.println(line));
        lines.close();
    }
}

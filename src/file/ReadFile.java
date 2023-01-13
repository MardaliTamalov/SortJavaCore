package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {
    public void start() throws IOException {
        Files.write(Path.of("file3"), Stream.concat( //объединяет 2 стримма
                        Files.readAllLines(Path.of("file1")).stream(),//преобразовывает в стрим
                        Files.readAllLines(Path.of("file2")).stream())//readAllLines читает построчно отдельным элементом
                        .filter(x->x.matches("\\d+"))  //оставляет в стриме только цифры
                .map(Integer::parseInt)  //преобразовывает в int
                .sorted()   //сортирует
                .map(Object::toString) //преобразовывает в String
                .toList(), StandardOpenOption.CREATE);  //преобразовывает в коллекцию лист и перезаписывает в файл
    }
    public ReadFile() throws IOException {
    }
}

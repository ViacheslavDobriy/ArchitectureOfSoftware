package Seminar4;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class Sample1 {
    public static void main(String[] args) {

    }
}

class ReaderService implements Readable{

    private ArrayList<String> lines;

    public Collection<String> readText(File file) {

        //ПРЕДУСЛОВИЕ
        if(!file.exists())
            throw new RuntimeException("File is not found");
        if (file.length() > 5000) {
            throw new RuntimeException("Size of file is too big");
        }

        // ОСНОВНЫЕ ИНСТРУКЦИИ
        //.....
        try {
            lines = new ArrayList<>();
        }
        catch (Exception e) {

        }
        lines = new ArrayList<>();

        //ИНВАРИАНТ
        validateResult(lines);

        lines.clear();
        //.....


        //ПОСТУСЛОВИЕ
        if (lines == null)
            throw new RuntimeException("Error");
        return lines;
    }
    private void validateResult(Collection<String> lines) {
        if(lines.size()==0) {
            throw new RuntimeException("File is empty");
        }
    }

    @Override
    public Collection<String> readTextFile(File file) {
        return null;
    }
}

interface Readable{
    /**
     * Позволяет считывать строки из текстового файла
     * @param file файл
     * @throws RuntimeException исключение при работе с файлами
     * @return коллекция строк
     */
    Collection<String> readTextFile(File file);
}

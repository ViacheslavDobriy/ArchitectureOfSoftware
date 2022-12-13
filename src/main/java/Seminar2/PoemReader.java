package Seminar2;

import java.util.ArrayList;
import java.util.Scanner;

public class PoemReader extends LogReader{

    private String data;

    public PoemReader(String data) {
        this.data = data;
    }

    public PoemReader() {

    }

    @Override
    public void setDatasource(Object data) {
        this.data = data.toString();
    }

    @Override
    public Object getDataSource() {
        return null;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        Scanner scanner = new Scanner(data);
        ArrayList<String> logEntry = new ArrayList<>();
        int counter = 0;
        while(scanner.hasNextLine()){

            if(counter >= position) {
                position = counter;
                String line = scanner.nextLine();
                logEntry.add(line);
            }
            else {
                scanner.nextLine();
            }
            counter++;

        }
        return logEntry;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }
}

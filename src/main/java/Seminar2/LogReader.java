package Seminar2;

import java.util.ArrayList;
import java.util.Objects;

abstract public class LogReader {
    /**
     * Это и есть шаблонный метод - наш каркас.
     */
    private Integer currentPosition = 0;

    public Integer getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }

    public abstract void setDatasource(Object data);

    public abstract Object getDataSource();

    public Iterable<LogEntry> readLogEntry() {
        ArrayList<LogEntry> logList = new ArrayList<>();

        for (String s: readEntries(currentPosition)) {
            logList.add(parseLogEntry(s));
        }

        return logList;
    }

    protected abstract Iterable<String> readEntries(Integer position);

    protected abstract LogEntry parseLogEntry(String stringEntry);
}

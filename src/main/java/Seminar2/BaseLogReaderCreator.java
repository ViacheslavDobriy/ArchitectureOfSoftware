package Seminar2;

abstract public class BaseLogReaderCreator {

    public LogReader createLogReader(LogType logType) {
        LogReader logReader = createLogReaderInstance(logType);
        // TODO: исполним базовые/подготовительные алгоритмы ...
        logReader.setCurrentPosition(20);

        return logReader;
    }
    /**
     * Фабричный метод, может создавать экземпляры типа LogReader
     * @return
     */
    protected abstract LogReader createLogReaderInstance(LogType logType);
}

package Seminar2;

public class ConcreteReaderCreator extends BaseLogReaderCreator{
    @Override
    protected LogReader createLogReaderInstance(LogType logType) {
        return switch (logType) {
            case POEM -> new PoemReader();
            case TEXT -> new TextFileReader();
            case DATABASE -> new DataBaseReader();
            case SYSTEM -> new OperationSystemLogEventReader();
        };
    }
}

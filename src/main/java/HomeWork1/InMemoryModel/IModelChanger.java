package HomeWork1.InMemoryModel;

public interface IModelChanger {
    public default void notifyChange(IModelChanger sender) {

    }
}

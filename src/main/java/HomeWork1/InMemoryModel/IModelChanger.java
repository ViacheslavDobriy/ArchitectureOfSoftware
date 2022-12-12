package HomeWork1.InMemoryModel;

public interface IModelChanger {
    void RegisterModelChanger(ModelChangedObserver o);
    void RemoveModelChanger(ModelChangedObserver o);
    void NotifyChange();
}

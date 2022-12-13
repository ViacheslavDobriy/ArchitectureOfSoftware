package HomeWork1.InMemoryModel;

import HomeWork1.ModelElements.Camera;
import HomeWork1.ModelElements.Flash;
import HomeWork1.ModelElements.PoligonalModel;
import HomeWork1.ModelElements.Scene;

import java.util.ArrayList;
import java.util.Collection;

public class ModelStore implements IModelChanger, ModelChangedObserver {
    public PoligonalModel models;
    public Scene scenes;
    public Flash flashes;
    public Camera cameras;
    private Collection<ModelChangedObserver> changeObservers = new ArrayList<>();

    //TODO: Доработать

    @Override
    public void RegisterModelChanger(ModelChangedObserver o) {

    }

    @Override
    public void RemoveModelChanger(ModelChangedObserver o) {

    }

    @Override
    public void NotifyChange() {

    }

    @Override
    public void ApplyUpdateModel() {

    }
}

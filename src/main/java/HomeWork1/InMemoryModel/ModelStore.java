package HomeWork1.InMemoryModel;

import HomeWork1.ModelElements.Camera;
import HomeWork1.ModelElements.Flash;
import HomeWork1.ModelElements.PoligonalModel;
import HomeWork1.ModelElements.Scene;

public class ModelStore implements IModelChanger, IModelChangedObserver{
    public PoligonalModel models;
    public Scene scenes;
    public Flash flashes;
    public Camera cameras;
    private IModelChangedObserver changeObservers;

    public Scene getScenes(int id) {
        return new Scene();
    }

    public void notifyChange(IModelChanger sender) {
        System.out.println("notifyChange()");
    }

}

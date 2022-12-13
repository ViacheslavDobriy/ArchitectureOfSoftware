package HomeWork1.ModelElements;

import java.lang.reflect.Type;
import java.util.Collection;

public class Scene {

    private int id;
    private Collection<PoligonalModel> models;
    private Collection<Flash> flashes;
    private Collection<Camera> cameras;

    public void addModel(PoligonalModel model) {
        this.models.add(model);
    }

    public void addFlash(Flash flash) {
        this.flashes.add(flash);
    }

    public void addCamera(Camera camera) {
        this.cameras.add(camera);
    }

    public Collection<PoligonalModel> getModels() {
        return models;
    }

    public Collection<Flash> getFlashes() {
        return flashes;
    }

    public Collection<Camera> getCameras() {
        return cameras;
    }

    public Type method1(Type type) {
        return new Type() {
            @Override
            public String getTypeName() {
                return Type.super.getTypeName();
            }
        };
    }

    public Type method2(Type type1, Type type2) {
        return new Type() {
            @Override
            public String getTypeName() {
                return Type.super.getTypeName();
            }
        };
    }

}

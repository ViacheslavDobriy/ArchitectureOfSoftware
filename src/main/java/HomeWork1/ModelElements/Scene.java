package HomeWork1.ModelElements;

import java.lang.reflect.Type;

public class Scene {
    public int id;
    public PoligonalModel models;
    public Flash flashes;

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

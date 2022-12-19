package Seminar4;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;

/**
 * Модуль завода
 */
public class Factory {
    public static void main(String[] args) {
        FactoryProvider factoryProvider = new FactoryProvider();
        DealerProvider dealerProvider = new DealerProvider(factoryProvider);

       // ComponentInfo component = dealerProvider.checkComponent(900003);
        //System.out.println(component);
    }
}

/**
 * Информация о детали
 */
class ComponentInfo{
    private int id;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ComponentInfo(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ComponentInfo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}


class ComponentDetails{

    private String description;

    public ComponentDetails(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
/**
 * Завод по производству деталей
 */
class FactoryProvider {
    private ArrayList<ComponentInfo> components = new ArrayList<>();

    {
        for (int i = 0; i < 10; i++) {
            components.add(new ComponentInfo(900000 + i, String.format("component description %d", 900000 + i)));
        }
        for (int i = 0; i < 5; i++) {
            components.add(new ComponentInfo(1000 + i, String.format("component description %d", 100 + i)));
        }
    }

    public ComponentInfo getComponentInfo(int id) {

        //ПРЕДУСЛОВИЕ
        if(id <= 0) {
            throw new RuntimeException("Incorrect number of detail");
        }
        if (String.valueOf(id).length() < 6) {
            throw new RuntimeException("Incorrect number of detail. Detail exists but this detail is too old");
        }

        ComponentInfo serchComponent = null;
        for(ComponentInfo component : components) {
            if (component.getId() == id) {
                serchComponent = component;
                break;
            }
        }

        //ПОСТУСЛОВИЕ
        if(serchComponent == null) {
            throw new RuntimeException("Detail is not found");
        }

        return serchComponent;
    }
}

/**
 * Дилер
 */
class DealerProvider {

    private final FactoryProvider factoryProvider;

    DealerProvider(FactoryProvider factoryProvider){
        this.factoryProvider = factoryProvider;
    }

    public ComponentDetails checkComponent(int id){

        //ПРЕДУСЛОВИЕ

        //РЕАЛИЗАЦИЯ МЕТОДА
        // TODO: в рамках контрактного программирования мы не проверяем ПЕРЕДАВАЕМЫЕ (в другой модуль) данные
//        if (id < 0 || String.valueOf(id).length() < 6) {
//            throw new RuntimeException("Incorrect number of component");
//        }
        ComponentInfo componentInfo = factoryProvider.getComponentInfo(id);
        //......
        ComponentDetails componentDetails = new ComponentDetails(componentInfo.getDescription());
        //.....
        //ПОСТУСЛОВИЕ

        if(componentDetails ==null) {
            throw new RuntimeException("Data was not found");
        }
        return componentDetails;
    }

}

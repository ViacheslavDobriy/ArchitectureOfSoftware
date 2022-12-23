package Seminar5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

/**
 * TODO: ДОМАШНЕЕ ЗАДАНИЕ -> Сформировать формальную UML-диаграмму по текущей задаче.
 *
 * ГОРИЗОНТАЛЬНЫЕ УРОВНИ И ВЕРТИКАЛЬНЫЕ СРЕЗЫ.
 * Необходимо разделить на горизонтальные уровни "Редактор 3D графики".
 * Один пользователь. Программа работает на одном компьютере без выхода в сеть.
 *
 * Что видит пользователь, как взаимодействует? (Панель загрузки, блок редактирования, блок просмотра).
 * Какие задачи можно делать - функции системы? (Загрузить 3D модель, рассмотреть 3D модель, создать новую,
 * редактировать вершины, текстуры, сделать рендер, сохранить рендер).
 * Какие и где хранятся данные? (файлы 3D моделей, рендеры, анимация ..., в файловой системе компьютера).
 *
 * Предложить варианты связывания всех уровней - сценарии испотльзования, 3-4 сценария.
 * Сквозная функция - создать новую 3D модель, сделать рендер для печати на принтере.
 */
public class Sample1 {
    public static void main(String[] args) {
        Editor3D editor3D = new Editor3D();
        Scanner scanner = new Scanner(System.in);
        boolean f = true;
        while(f) {
            System.out.println("*** MY 3D EDITOR ***");
            System.out.println("====================");
            System.out.println("1. Open project");
            System.out.println("2. Save project");
            System.out.println("3. Show settings");
            System.out.println("4. Show all models");
            System.out.println("5. Show all textures");
            System.out.println("6. Run render all models");
            System.out.println("7. Run render of model");
            System.out.println("0. EXIT");
            System.out.println("Please, insert your choice");
            if(scanner.hasNextInt()){
                int no = scanner.nextInt();
                scanner.nextLine();
                switch (no){
                    case 0:
                        System.out.println("Exit");
                        f = false;
                        break;
                    case 1:
                        System.out.println("Insert name of the project file");
                        String fileName = scanner.nextLine();
                        editor3D.openProject(fileName);
                        System.out.println("Project is opened successfully");
                        break;
                    case 3:
                        editor3D.showProjectSettings();
                        break;
                    case 4:
                        editor3D.printAllModels();
                        break;
                    case 5:
                        editor3D.printAllTextures();
                        break;
                    case 6:
                        editor3D.renderAll();
                        break;
                    case 7:
                        System.out.println("Insert number of model");
                        if(scanner.hasNextInt()){
                            int modelNo = scanner.nextInt();
                            scanner.nextLine();
                            editor3D.renderModel(modelNo);
                        }
                        else {
                            System.out.println("Number of model was inserted illegal");
                        }
                        break;
                    default:
                        System.out.println("Insert correct menu");
                }
            }
            else{
                System.out.println("Insert legal choice");
                scanner.nextLine();
            }
        }
    }
}

class Editor3D implements UserInterfaceLayout{

    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;
    private DatabaseAccess databaseAccess;
    private Database database;

    private void checkProjectFile(){
        if(projectFile == null) {
            throw new RuntimeException("File of project was not found");
        }
    }

    @Override
    public void openProject(String filename) {
        this.projectFile = new ProjectFile(filename);
        this.database = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabaseAccess(database);
        this.businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccess);
    }

    @Override
    public void showProjectSettings() {
        checkProjectFile();
        System.out.println("*** Project v1 ***");
        System.out.println("******************");
        System.out.printf("fileName: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %s\n", projectFile.getSetting3());
        System.out.println("******************");
    }

    @Override
    public void saveProject() {

    }

    @Override
    public void printAllModels() {
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        for (int i = 0; i < models.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(models.get(i));
            for (Texture texture: models.get(i).getTextures()) {
                System.out.printf("\t%s\n", texture);
            }
        }
    }

    @Override
    public void printAllTextures() {
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>)businessLogicalLayer.getAllTextures();
        for (int i = 0; i < textures.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll() {
        checkProjectFile();

        System.out.println("Wait..");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Operation is done for %d ms.\n", endTime);
    }

    @Override
    public void renderModel(int i) {
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        if(i < 0 || i > models.size() - 1){
            throw new RuntimeException("Number of model is not found!");
        }
        System.out.println("Wait..");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderingModel(models.get(i));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Operation is done for %d ms.\n", endTime);
    }
}

/**
 * User Interface Layout
 */
interface UserInterfaceLayout{

    void openProject(String filename);
    void showProjectSettings();
    void saveProject();
    void printAllModels();
    void printAllTextures();
    void renderAll();
    void renderModel(int i);

}
/**
 * Business Logical Layer
 * Описываю реализацию конкретных функций приложения
 */
class EditorBusinessLogicalLayer implements BusinessLogicalLayer{

    private DatabaseAccess databaseAccess;
    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess){
        this.databaseAccess = databaseAccess;
    }
    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderingModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model: getAllModels()){
            processRender(model);
        }
    }
    private Random random = new Random();
    private void processRender(Model3D model) {
        try{
            Thread.sleep(2500 - random.nextInt(2000));
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
/**
 * Business Logical Layer
 */
interface BusinessLogicalLayer{

    Collection<Model3D> getAllModels();
    Collection<Texture> getAllTextures();
    void renderingModel(Model3D model);
    void renderAllModels();


}

/**
 * Data Access Layer
 */
class EditorDatabaseAccess implements DatabaseAccess {

    private final Database editorDatabase;

    public EditorDatabaseAccess(Database editorDatabase){
        this.editorDatabase = editorDatabase;
    }

    @Override
    public void addEntity(Entity entity) {
        editorDatabase.getAll().add(entity);
    }

    @Override
    public void removeEntity(Entity entity) {
        editorDatabase.getAll().remove(entity);
    }

    /**
     * Получить список всех текстур
     * @return
     */
    @Override
    public Collection<Texture> getAllTextures() {
        Collection<Texture> textures = new ArrayList<>();
        for (Entity entity: editorDatabase.getAll()){
            if(entity instanceof Texture) {
                textures.add((Texture) entity);
            }
        }
        return textures;
    }

    /**
     * Получить список всех моделей
     * @return
     */
    @Override
    public Collection<Model3D> getAllModels() {
        Collection<Model3D> models = new ArrayList<>();
        for (Entity entity: editorDatabase.getAll()){
            if(entity instanceof Model3D) {
                models.add((Model3D) entity);
            }
        }
        return models;
    }
}
/**
 * Data Access Layer
 */
interface DatabaseAccess {

    void addEntity(Entity entity);
    void removeEntity(Entity entity);
    Collection<Texture> getAllTextures();
    Collection<Model3D> getAllModels();
}
/**
 * База данных всех сущностей проекта (Database Layer)
 */
class EditorDatabase implements Database{

    private final ProjectFile projectFile;
    private Collection<Entity> entities;
    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;

    }
    @Override
    public void load() {
        //TODO: Загрузка всех сущностей проекта (модели, текстуры)
    }

    @Override
    public void save() {
        //TODO: Сохранение всех сущностей проекта в источник (файл)
    }

    @Override
    public Collection<Entity> getAll() {
        if (entities == null) {
            entities = new ArrayList<>();

            int modelCount = 10 - random.nextInt(6);
            for (int i = 0; i < modelCount; i++) {
                generateModelAndTextures();
            }
        }
        return entities;
    }
    private Random random = new Random();
    private void generateModelAndTextures(){
        Model3D model = new Model3D();
        int textureCount = random.nextInt(3);
        for (int i = 0; i < textureCount; i++) {
            Texture texture = new Texture();
            model.getTextures().add(texture);
            entities.add(texture);
        }
        entities.add(model);
    }
}
/**
 * Database Layer
 */
interface Database{

    void load();
    void save();
    Collection<Entity> getAll();
}
/**
 * 3D Модель
 */
class Model3D implements Entity{

    private static int counter = 10000;
    private int id;
    private Collection<Texture> textures = new ArrayList<>();

    public int getId() {
        return id;
    }

    public Collection<Texture> getTextures() {
        return textures;
    }

    {
        this.id = ++this.counter;
    }

    @Override
    public String toString() {
        return "Model3D{" +
                "id=" + id +
                '}';
    }
}

/**
 * Textures
 */
class Texture implements Entity{
    private static int counter = 50000;

    @Override
    public int getId() {
        return 0;
    }
}

/**
 * Сущность
 */
interface Entity{
    int getId();
}

/**
 * Файл проекта
 */
class ProjectFile{

    private String fileName;

    private int setting1;
    private String setting2;
    private boolean setting3;

    public int getSetting1() {
        return setting1;
    }

    public void setSetting1(int setting1) {
        this.setting1 = setting1;
    }

    public String getSetting2() {
        return setting2;
    }

    public void setSetting2(String setting2) {
        this.setting2 = setting2;
    }

    public boolean getSetting3() {
        return setting3;
    }

    public void setSetting3(boolean setting3) {
        this.setting3 = setting3;
    }

    public String getFileName() {
        return fileName;
    }

    public ProjectFile(String fileName){
        this.fileName = fileName;
        init();
    }

    private void init(){

    }
}
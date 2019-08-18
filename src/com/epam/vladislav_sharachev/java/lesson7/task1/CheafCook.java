package com.epam.vladislav_sharachev.java.lesson7.task1;

import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.MethodInfo;
import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.Search;
import com.epam.vladislav_sharachev.java.lesson7.task1.Spices.PutSpice;
import com.epam.vladislav_sharachev.java.lesson7.task1.Vegetables.Salad;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class CheafCook {
    Product[] foods;

    public CheafCook(Product[] foods) {
        this.foods = foods;
    }

    public static void v1() { //***********************************
        try {
          for (Method method : ToCook.class
                    .getClassLoader()
                    .loadClass(("com.epam.vladislav_sharachev.java.lesson7.task1.CheafCook"))
                    .getMethods())
                if (method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        for (Annotation annot : method.getDeclaredAnnotations()) {
                            System.out.println("Аннотация в методе " + method.getName() + " "
                                    + annot.toString());
                        }
                        MethodInfo methodAnno = method
                                .getAnnotation(MethodInfo.class);
                        if (methodAnno.revision() == 1) {
                            System.out.println("Метод с ревизией номер 1 = " + method.getName());
                        } else if (methodAnno.revision() == 2) {
                            System.out.println("Метод с ревизией номер 2 = " + method.getName());
                        }

                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    } //*********************************************************

    public  void v2( ) throws NoSuchFieldException {
        Class<?> productClass = Product.class;
        Annotation[] annos = productClass.getAnnotations();

        Field nameField = productClass.getDeclaredField("title");
        Annotation[] fieldAnnos = nameField.getAnnotations();
        for (Annotation ann : fieldAnnos) {
            System.out.println(ann.annotationType().getSimpleName());
        }
    }


    public void v3 () throws NoSuchFieldException, IllegalAccessException {

    }



    public  void process(Class<?> objectClass) throws IllegalAccessException {
        objectClass = CheafCook.class.getClass();
        Annotation[] annotations;
        Field[] fields = objectClass.getFields();
        for (Field f : fields) {
            annotations = f.getAnnotations();
            for (Annotation a : annotations) {
                if (a.annotationType().getSimpleName().equals(Search.class.getSimpleName())) {
                    Search ann = (Search) a;
                    if (f.getInt(CheafCook.class) > ann.max()) {
                        System.out.println(String.format("Warning...", f.getName(), f.getInt(CheafCook.class), ann.max()));
                    } else if (f.getInt(CheafCook.class) < ann.min()) {
                        System.out.println(String.format("Warning...", f.getName(), f.getInt(CheafCook.class), ann.min()));
                    }

                }
            }
        }
        process(objectClass);
    }















  /*  public void go(Object object) throws NoSuchFieldException {
        Class<?> cheafCookClass = Product.class;
        Annotation[] annos = cheafCookClass.getAnnotations();

        Field nameField = cheafCookClass.getDeclaredField("title");
        Annotation[] fieldAnnos = nameField.getAnnotations();

        for (Annotation ann : fieldAnnos) {
            if (ann.annotationType().getSimpleName().equals(ForStrings.class.getSimpleName())) {

            }

            System.out.println(ann.annotationType().getSimpleName());
        }
        for (Annotation ann : annos) {
            if (a.annotationType().getSimpleName().equals(Search.class.getSimpleName())) {
                Search ann = (Search) a;
                if (f.getInt(object) > ann.searchMax()) {
                    System.out.println(String.format("Warning...", f.getName(), f.getInt(object), ann.searchMax()));
                } else if (f.getInt(object) < ann.searchMin()) {
                    System.out.println(String.format("Warning...", f.getName(), f.getInt(object), ann.searchMin()));
                }
            System.out.println(ann.annotationType().getSimpleName());
        }
    } */



    String shouldAlwaysBeProcessed() {
        return "This always be processed";
    }

    public void shouldNotBeProcessed() {
        throw new RuntimeException("This should never be processed");
    }

    @MethodInfo(date = "17 aug 2019", comments = "Mission Complete", revision = 2)
    public void getSorting() { //сортировка

        Arrays.sort(foods);
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].getCalories() + " ккал - " + foods[i].getTitle());
        }
    }

    public void getMyEat() { //еда в холодильнике
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].getTitle());
        }
    }
@MethodInfo(date = "17 aug 2019", comments = "for Main Method")
public void getSum() { //сумма каллорий в пище
    @Search(min = 0, max = 2)
        int sum = 3;
        for (int i = 0; i < foods.length; ++i) {
            sum = sum + foods[i].getCalories();
        }
        System.out.println("Общая каллорийность продуктов: " + sum + " ккал");
    }

    public void getFind() { //поиск по диапазону по каллорий

        while (true) {
            int searchMin = getSort();

            int searchMax = getSort();

            for (int i = 0; i < foods.length; i++) {

                if (foods[i].getCalories() >= searchMin && foods[i].getCalories() <= searchMax)

                    System.out.println(+i + " " + foods[i].getTitle() + " - "

                            + foods[i].getCalories() + " ккал.");

            }

            if (searchMin > searchMax) {

                System.out.println("Первое число должно быть меньше второго");

            } else break;

        }

    }

    Scanner searchScanner = new Scanner(System.in);

    public int getSort() { //ввод для поиска по диапазону

        System.out.println("Введите диапазон");

        int sort;

        if (searchScanner.hasNextInt()) {

            sort = searchScanner.nextInt();

        } else {

            System.out.println("Введите только числовое значение.");

            searchScanner.next();

            sort = getSort();

        }

        return sort;

    }

public void getQuest() { //меню цикла
        System.out.println("[1] - что в холодильнике " +
                "[2] - приготовить салат " +
                "[3] - приготовить суп " +
                "[4] - каллорийность продуктов в супе " +
                "[5] - сортировать овощи для салата по каллорийности " +
                "[6] - найти по диапазону каллорийности " +
                "[0] - выйти из игры");
    }

    public void outputSaladInfo(Salad toSalad) { //добавить овощи в салат
        toSalad.salad();
    }

    public void outputPutSpiceInfo(PutSpice toPutSpice) { //добавить специи в суп/салат

        toPutSpice.putSpice();
    }

    public void soupIsReady() { //сообщение о готовности
        System.out.println("Суп готов");
    }

    public void saladIsReady() { //сообщение о готовности
        System.out.println("Салат готов");
    }

    public void soupCook() { // добавить овощи в суп
        for (Product product : foods) {
            product.soup();
        }


    }


}
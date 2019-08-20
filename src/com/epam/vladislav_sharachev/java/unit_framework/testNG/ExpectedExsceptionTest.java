package src.com.epam.vladislav_sharachev.java.unit_framework.testNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExpectedExsceptionTest { //параметризированный тест

    private boolean isExcExs = true; //здесь появление исключения - нормально и это тест в этом случае - пройден

    @Parameters("param2")
    @Test(invocationCount = 5) //столько раз запускается тест
    public void test2(@Optional("Не наша переменная") String param) {
        System.out.println("ID current Thread = " + Thread.currentThread().getId());
    }

    @Test (expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Ошибочка", enabled = false) //ожидаемый экзепшн
    public void test() {
        System.out.println("ID current Thread = " + Thread.currentThread().getId());
        if (isExcExs) {
            throw new RuntimeException("Ошибочка");
        }
    }
}

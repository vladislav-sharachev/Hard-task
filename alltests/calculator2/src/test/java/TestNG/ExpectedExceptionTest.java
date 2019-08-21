package TestNG;

import org.testng.annotations.Test;

public class ExpectedExceptionTest {
    private boolean isExcExs = true; //здесь появление исключения - нормально и это тест в этом случае - пройден

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Ошибочка") //ожидаемый экзепшн
    public void test() {
        System.out.println("ID current Thread = " + Thread.currentThread().getId());
        if (isExcExs) {
            throw new RuntimeException("Ошибочка");
        }
    }
}
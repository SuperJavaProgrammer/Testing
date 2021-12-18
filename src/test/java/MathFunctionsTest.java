import org.junit.*;

import static org.junit.Assert.*;

public class MathFunctionsTest {
    private MathFunctions math;
    private MathFunctions math2;

    @BeforeClass //метод будет выполнятся в начале всех тестов и до @Before
    public static void beforeClass() {
        System.out.println("beforeClass start");
    }

    @Before //указывает на то, что метод будет выполнятся перед каждым тестируемым методом @Test
    public void before() {
        System.out.println("before start");
        math = new MathFunctions();
        math2 = math;
    }

    @After //указывает на то что метод будет выполнятся после каждого тестируемого метода @Test
    public void after() {
        System.out.println("after start");
        math = null;
    }

    @AfterClass //указывает на то, что метод будет выполнятся после всех тестов и после @After
    public static void afterClass() {
        System.out.println("afterClass start");
    }

    @Test //определяет что метод является тестовым
    public void calls() {
        assertEquals(0, math.getCalls()); //Проверяет, что два значения совпадают. Для массивов проверяются ссылки
        math.factorial(1);
        assertNotEquals(0, math.getCalls()); //Проверяет, что два значения не совпадают
        assertSame(math, math2); //Проверяет, что обе переменные относятся к одному объекту
        assertNotSame(math, new MathFunctions()); //Проверяет, что обе переменные относятся к разным объектам
        assertNotNull("Error message if Null", math.plus(7, 3)); //Проверяет, что объект не является пустым null
    }

    @Test(timeout=100) //указывает, что тестируемый метод не должен занимать больше чем 100 миллисекунд
    public void factorial() {
        assertTrue(math.factorial(5) == 120); //Проверяет, что логическое условие истинно
        assertFalse(math.factorial(1) == 2); //Проверяет, что логическое условие ложно
    }

    @Test(expected = IllegalArgumentException.class) //указывает на то, что в данном тестовом методе вы преднамеренно ожидается Exception
    public void factorialNegative() {
        math.factorial(-1);
    }

    @Ignore //говорит, что метод будет проигнорирован в момент проведения тестирования
    @Test
    public void todo() {
        assertTrue(math.plus(1, 1) == 3);
        fail("Что-то пошло не так"); //Генерирует исключение AssertionError - добавляем туда, куда не должен дойти ход выполнения программы
    }

}

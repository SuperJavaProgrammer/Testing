class MathFunctions {
    private int calls;

    int getCalls() {
        return calls;
    }

    long factorial(int number) {
        calls++;
        if (number < 0) throw new IllegalArgumentException();
        var result = 1;
        if (number > 1) {
            for (int i = 1; i <= number; i++)
                result = result * i;
        }
        return result;
    }

    long plus(int num1, int num2) {
        calls++;
        return num1 + num2;
    }

}

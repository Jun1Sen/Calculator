public enum Operations {

    Addition("+"),
    Substraction("-"),
    Multiplication("*"),
    Division("/");


    private final String value;

    private Operations(String value) {
        this.value = value;
    }

    public static Operations valueOfString(String value) {
        for (Operations operation : Operations.values()) {
            if (operation.value.equals(value)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Неизвестный оператор: " + value);
    }


}

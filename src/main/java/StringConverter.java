public class StringConverter {

    private static String inputString;

    public static String getInputString() {
        return inputString;
    }

    public String convertString(String input) {
        inputString = input;
        StringBuilder converted = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (i % 2 == 0) {
                converted.append(Character.toUpperCase(currentChar));
            } else {
                converted.append(Character.toLowerCase(currentChar));
            }
        }

        return converted.toString();
    }
}

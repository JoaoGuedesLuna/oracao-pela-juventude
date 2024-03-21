package main.java.dev.guedes.oracaopelajuventude.util;

/**
 * @author João Guedes
 */
public class TextFormatter {

    public static String centralizeText(String text, int columns) {
        String formattedText;
        int spaceBefore = (columns - text.length()) / 2;
        int spaceAfter = columns - (spaceBefore + text.length());
        formattedText = String.format("%" + (spaceBefore + text.length()) + "s", text);
        formattedText = String.format("%-" + (formattedText.length() + spaceAfter) + "s", formattedText);
        return formattedText;
    }

    public static String[] wrapText(String text, int columns) {
        StringBuilder formattedText = new StringBuilder();
        String[] lines;
        StringBuilder line = new StringBuilder();
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (!line.isEmpty()) {
                if (line.length() + word.length() + 1 <= columns) {
                    line.append(" ");
                }
                else{
                    formattedText.append(line).append("\n");
                    line = new StringBuilder();
                }
            }
            line.append(word);
            lines = TextFormatter.wrapLine(line.toString(), columns);
            for (int i = 0; i < lines.length-1; i++) {
                formattedText.append(lines[i]).append('\n');
            }
            line = new StringBuilder();
            line.append(lines[lines.length-1]);
        }
        formattedText.append(line);
        return formattedText.toString().split("\n");
    }

    private static String[] wrapLine(String line, int columns) {
        if (columns <= 0) {
            throw new IllegalArgumentException("Columns must be greater than zero.");
        }
        if (line.length() == columns) {
            return line.split("\n");
        }
        StringBuilder formattedText = new StringBuilder();
        int endIndex;
        for (int beginIndex = 0; beginIndex < line.length(); beginIndex += columns) {
            endIndex = Math.min(line.length(), beginIndex + columns);
            formattedText.append(line, beginIndex, endIndex).append("\n");
        }
        return formattedText.toString().split("\n");
    }

}

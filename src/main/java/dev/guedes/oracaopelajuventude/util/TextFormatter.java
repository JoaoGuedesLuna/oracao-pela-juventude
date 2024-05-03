package main.java.dev.guedes.oracaopelajuventude.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class that contains methods for formatting, for example, centering a text.
 *
 * @author João Guedes
 */
public class TextFormatter {

    /**
     * Returns a text centered based on the number of columns.
     *
     * @param text Text.
     *
     * @param columns Number of columns.
     *
     * @return Returns a text centered based on the number of columns.
     */
    public static String centralizeText(String text, int columns) {
        if (text.length() >= columns) {
            return text;
        }
        final String BLANK_SPACE = " ";
        int blankSpaceNumbers = columns - text.length();
        String spaceAfter = BLANK_SPACE.repeat(blankSpaceNumbers / 2);
        String spaceBefore = BLANK_SPACE.repeat(blankSpaceNumbers - spaceAfter.length());
        return spaceBefore + text + spaceAfter;
    }

    /**
     * Breaking the text into specific lines based on the number of columns.
     *
     * @param text Text.
     *
     * @param columns Number of columns.
     *
     * @return Returns an array of strings. Each position in the array is a line break.
     */
    public static String[] wrapText(String text, int columns) {
        List<String> wrappedText = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (!line.isEmpty()) {
                if (line.length() + word.length() + 1 <= columns) {
                    line.append(" ");
                }
                else{
                    wrappedText.add(line.toString());
                    line = new StringBuilder();
                }
            }
            line.append(word);
            if (line.length() > columns) {
                String[] wrappedLine = TextFormatter.wrapLine(line.toString(), columns);
                wrappedText.addAll(Arrays.asList(wrappedLine).subList(0, wrappedLine.length - 1));
                line = new StringBuilder();
                line.append(wrappedLine[wrappedLine.length-1]);
            }
        }
        if (!line.isEmpty()) {
            wrappedText.add(line.toString());
        }
        return wrappedText.toArray(new String[0]);
    }

    /**
     * Breaking a word into specific lines based on the number of columns.
     *
     * @param line Text line.
     *
     * @param columns Number of columns.
     *
     * @return Returns an array of strings. Each position in the array is a line break.
     */
    private static String[] wrapLine(String line, int columns) {
        if (columns <= 0) {
            throw new IllegalArgumentException("Columns must be greater than zero.");
        }
        if (line.length() == columns) {
            return new String[] {line};
        }
        List<String> wrappedLines = new ArrayList<>();
        int beginIndex = 0, endIndex;
        while (beginIndex < line.length()) {
            endIndex = Math.min(line.length(), beginIndex + columns);
            wrappedLines.add(line.substring(beginIndex, endIndex));
            beginIndex += columns;
        }
        return wrappedLines.toArray(new String[0]);
    }

}

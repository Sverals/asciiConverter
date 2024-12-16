package com.github.sevveras.view;

import java.util.ArrayList;

public class ImageViewer {
    public static void printAsciiImage(ArrayList<String> imageArray, int width) {
        int charactersInLine = 0;
        StringBuilder sb = new StringBuilder();
        for (String currentCharacter : imageArray) {
            if (charactersInLine >= width) {
                sb.append(System.lineSeparator());
                charactersInLine = 0;
            }
            sb.append(currentCharacter);
            sb.append(currentCharacter);
            sb.append(currentCharacter);
            charactersInLine++;
        }
        System.out.println(sb);
    }
}

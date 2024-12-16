package com.github.sevveras.controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ImageProcessor {

    public static final String ASCII_CHARACTERS = "`^\\\",:;Il!i~+_-?][}{1)(|\\\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";
    public static final int MAX_BRIGHTNESS = 255;

    public static BufferedImage loadImage(String path) {
        BufferedImage image = null;
        try {
           image = ImageIO.read(new File(path));
           //image.getScaledInstance(500, 200, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return image;
    }

    public static ArrayList<String> convertBrightToAscii(int[] brightnessArray) {
        HashMap<Integer, String> asciiMap = splitStringByCharacter(ASCII_CHARACTERS);
        ArrayList<String> asciiList = new ArrayList<>();
        for (int currentBrightness : brightnessArray) {
            double asciiBrightness = ((double) currentBrightness / MAX_BRIGHTNESS) * asciiMap.size();
            double decimalPartOfAsciiBrightness = -asciiBrightness - ((int) asciiBrightness);
            int asciiKey;
            if (decimalPartOfAsciiBrightness > 0.5) {
                asciiKey = (int) Math.ceil(asciiBrightness);
            } else {
                asciiKey = (int) Math.floor(asciiBrightness);
            }
            asciiList.add(asciiMap.get(asciiKey));
        }
        return asciiList;
    }

    public static HashMap<Integer, String> splitStringByCharacter(String string) {
        HashMap<Integer, String> characterMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            characterMap.put(i, string.substring(i, i + 1));
        }
        return characterMap;
    }
}

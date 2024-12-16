package com.github.sevveras.model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class ImageContainer {

    private BufferedImage image;
    private int[] pixelBrightnessArray;

    public ImageContainer(BufferedImage image) {
        this.image = image;
        this.pixelBrightnessArray = this.generateBrightnessArray();
    }

    private int[] generateBrightnessArray() {
        int[] maskedArray = this.image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
        int[] brightnessArray = new int[maskedArray.length];
        for (int i = 0; i < maskedArray.length; i++) {
            Color c = new Color(maskedArray[i]);
            int red = c.getRed();
            int green = c.getGreen();
            int blue = c.getBlue();
            brightnessArray[i] = (red + green + blue) / 3;
        }
        return brightnessArray;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int[] getPixelBrightnessArray() {
        return pixelBrightnessArray;
    }
}

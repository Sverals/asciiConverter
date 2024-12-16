package com.github.sevveras;

import com.github.sevveras.controller.ImageProcessor;
import com.github.sevveras.model.ImageContainer;
import com.github.sevveras.view.ImageViewer;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //ImageContainer catPicture = new ImageContainer(ImageProcessor.loadImage("C:/Users/matts/Desktop/ascii/kitten-4611189_640.jpg"));
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter path of image: ");
        String path = scan.nextLine();
        System.out.println("Press Enter To Print");
        String filler = scan.nextLine();
        ImageContainer catPicture = new ImageContainer(ImageProcessor.loadImage(path));
        var asciArray = ImageProcessor.convertBrightToAscii(catPicture.getPixelBrightnessArray());
        ImageViewer.printAsciiImage(asciArray, catPicture.getImage().getWidth());
    }
}
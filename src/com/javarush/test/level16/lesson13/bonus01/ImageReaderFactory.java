package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;


/**
 * Created by DNS on 07.10.2015.
 */
public class ImageReaderFactory {

    public static ImageReader getReader(ImageTypes a) {
        try {
            if (a.equals(ImageTypes.JPG)) {
                return new JpgReader();
            }

        if (a.equals(ImageTypes.BMP)) {
            return new BmpReader();
        }
        if (a.equals(ImageTypes.PNG)) {
            return new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        }catch(NullPointerException e){
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}

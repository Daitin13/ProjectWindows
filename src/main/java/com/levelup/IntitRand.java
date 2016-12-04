package com.levelup;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Daitin on 27.11.2016.
 */
public class IntitRand {
    public static void init(Object object) throws IllegalAccessException{
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field:fields) {
            if(field.isAnnotationPresent(Rand.class)){
                Rand rand = field.getAnnotation(Rand.class);
                field.setAccessible(true);
                Random random = new Random();
                int r = random.nextInt(rand.to()+1) + rand.from();
                field.set(object,r);
            }
        }

    }
}

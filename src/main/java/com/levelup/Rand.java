package com.levelup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Daitin on 27.11.2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Rand {
    int from()default 0;
    int to()default 100;

}

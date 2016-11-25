package com.levelup.Core.Hz;

import lombok.Data;

/**
 * Created by Daitin on 19.11.2016.
 */
public @Data
class Profile {
    private int idProfile;
    private String producer = "";
    private String description = "";
    private String unit;
    private double price;

}

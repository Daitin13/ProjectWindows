package com.levelup.Hz;

import lombok.Data;

/**
 * Created by Daitin on 19.11.2016.
 */
public
@Data
class Furniture {
    private int idFurniture;
    private String producer = "";
    private String unit;
    private double price;
}

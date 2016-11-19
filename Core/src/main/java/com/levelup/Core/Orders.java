package com.levelup.Core;

import lombok.Data;

/**
 * Created by Daitin on 19.11.2016.
 */
public @Data
class Orders {
    private int idOrde;
    private int idClients;
    private String annotetion ;
    private int idProfile;
    private int idGlass;
    private int idFurniture;
    private int idOther;
    private double priceOrder;
}

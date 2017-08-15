package com.mtrading.Building;

/**
 * Created by aleksandr.neguritsa on 8/9/2017.
 */
public class Tile {

        private Double packPrice;
        private Double tileLength;
        private Double tileWidth;
        private Integer amountInPack;

    public Tile(Double packPrice, Double tileLength, Double tileWidth,  Integer amountInPack) {
        this.packPrice = packPrice;
        this.tileLength = tileLength;
        this.tileWidth = tileWidth;
        this.amountInPack = amountInPack;
    }

    public Double getPackPrice() { return packPrice; }
    public Double getTileLength() { return tileLength; }
    public Double getTileWidth() { return tileWidth; }
    public Integer getAmountInPack() { return amountInPack; }


}




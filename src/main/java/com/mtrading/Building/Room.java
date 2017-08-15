package com.mtrading.Building;

/**
 * Created by aleksandr.neguritsa on 8/9/2017.
 */
public class Room {

    private String name;
    private Double width;
    private Double length;
    private Double height;

    public Room (String name, Double width, Double length, Double height) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public String getName() {
        return name;
    }
    public Double getWidth() {
        return width;
    }
    public Double getLength() {
        return length;
    }
    public Double getHeight() {
        return height;
    }

    }

//}

//
//    Double bathWidth = 3.8;
//    Double bathLength = 2.5;
//    Double bathHeight = 3.5;
//
//    Double bathWallsSquare = (bathWidth * bathHeight * 2) + (bathLength * bathHeight * 2);
//    Double bathFloorCellingSquare = (bathWidth*bathLength*2);
//    Double bathSquare = bathWallsSquare+bathFloorCellingSquare;
//
//    public Double getBathSquare() {
//        return bathSquare;
//    }
//}
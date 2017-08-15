package com.mtrading.Building;

/**
 * Created by aleksandr.neguritsa on 8/9/2017.
 */
public class TileCalculation {


    private void tileAmountCalculation(Tile tile, Room room) throws Exception {
        Thread.sleep(1000);

        Double tilesOnWidth = room.getWidth() / tile.getTileWidth();
        Double tilesOnLength = room.getLength() / tile.getTileWidth();
        Double tilesOnHeight = room.getHeight() / tile.getTileLength();
        Boolean restWidthReusable = false;
        Boolean restLengthReusable = false;
        Boolean restHeightReusable = false;

        if (tilesOnWidth % 1 == 0){

            System.out.println(
                    String.format(
                            "%s целых плиток нужно для одного ряда в ширину без остатков.",
                            tilesOnWidth
                    )
            );
        }
        else{

            Double tileWidthAmount =  Math.floor(tilesOnWidth);
            Double restWidthAmount = room.getWidth()-(tileWidthAmount*tile.getTileWidth());

                if(restWidthAmount <= (tile.getTileWidth()/2)){
                    restWidthReusable = true;
                }

            System.out.println(
                    String.format(
                            "%s целых плиток нужно для одного ряда в ширину с остатком в %ы плитки.",
                            tileWidthAmount,
                            restWidthAmount
                    )

            );

        }

        if (tilesOnLength % 1 == 0){

            System.out.println(
                    String.format(
                            "%s целых плиток нужно для одного ряда в длинну без остатков.",
                            tilesOnLength
                    )
            );
        }
        else{

            Double tileLengthAmount =  Math.floor(tilesOnLength);
            Double restLengthAmount = room.getLength()-(tileLengthAmount*tile.getTileWidth());

                if(restLengthAmount <= (tile.getTileWidth()/2)){
                    restLengthReusable = true;
                }

            System.out.println(
                    String.format(
                            "%s целых плиток нужно для одного ряда в длинну с остатком в %ы плитки.",
                            tileLengthAmount,
                            restLengthAmount
                    )
            );

        }

        if (tilesOnHeight % 1 == 0){

            System.out.println(
                    String.format(
                            "%s целых плиток нужно для одной колонки в высоту без остатков.",
                            tilesOnHeight
                    )
            );
        }
        else{

            Double tileHeightAmount =  Math.floor(tilesOnHeight);
            Double restHeightAmount = room.getHeight()-(tileHeightAmount*tile.getTileLength());

                if(restHeightAmount <= (tile.getTileWidth()/2)){
                    restHeightReusable = true;
                }

            System.out.println(
                    String.format(
                            "%s целых плиток нужно для одной колонки в высоту с остатком в %ы плитки.",
                            tileHeightAmount,
                            restHeightAmount
                    )
            );

        }



    }
}


//        System.out.print(String.format("% рубля будет стоить плитка для ванной комнаты площадью '%s' и цене плитки '%s' за квадратный метр.", finalPrice, Bath.getBathSquare(), Tile.getOneTileMeterPrice()))





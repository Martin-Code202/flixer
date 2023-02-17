package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
public class ABTestConfig {
    private Cell cellEnum;
    @SerializedName("cell")
    private int cellInt = 1;
    @SerializedName("isExplicit")
    private boolean isExplicit;
    @SerializedName("isFallback")
    private boolean isFallback;

    public enum Cell {
        CELL_1(1),
        CELL_2(2),
        CELL_3(3),
        CELL_4(4),
        CELL_5(5),
        CELL_6(6),
        CELL_7(7),
        CELL_8(8),
        CELL_9(9),
        CELL_10(10),
        CELL_11(11),
        CELL_12(12),
        CELL_13(13),
        CELL_14(14),
        CELL_15(15);
        
        private final int cellId;

        public int getCellId() {
            return this.cellId;
        }

        private Cell(int i) {
            this.cellId = i;
        }

        public static Cell fromInt(int i) {
            Cell[] values = values();
            for (Cell cell : values) {
                if (cell.cellId == i) {
                    return cell;
                }
            }
            return null;
        }
    }

    public Cell getCell() {
        if (this.cellEnum == null) {
            this.cellEnum = Cell.fromInt(this.cellInt);
        }
        return this.cellEnum;
    }

    public boolean isExplicit() {
        return this.isExplicit;
    }

    public boolean isFallback() {
        return this.isFallback;
    }
}

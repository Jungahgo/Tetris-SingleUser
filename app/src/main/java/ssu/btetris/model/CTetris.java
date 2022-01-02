package ssu.btetris.model;

public class CTetris extends Tetris {
    public static Matrix[][] setOfCBlockObjects;
    private Matrix currCBlk;

    public static void init(int[][][][] setOfBlockArrays) throws Exception {
        Tetris.nBlockTypes = setOfBlockArrays.length;
        Tetris.nBlockDegrees = setOfBlockArrays[0].length;
        setOfCBlockObjects = Tetris.createSetOfBlocks(setOfBlockArrays);
        for(int y = 0; y < Tetris.nBlockTypes; y++){
            for(int x = 0; x < Tetris.nBlockDegrees; x++){
                setOfBlockArrays[y][x] = binaryA(setOfBlockArrays[y][x]);
            }
        }
        Tetris.init(setOfBlockArrays);
    }

    public CTetris(int cy, int cx) throws Exception {
        super(cy, cx);
    }

    public static int[][] binaryA(int[][] array){
        int dy = array.length;
        int dx = array[0].length;
        for (int y=0; y < dy; y++) {
            for (int x = 0; x < dx; x++) {
                if (array[y][x] != 0){
                    array[y][x] = 1;
                }
            }
        }
        return array;
    }

    public Matrix binaryM(Matrix m){
        int array[][] = m.get_array();

        array = binaryA(array);

        Matrix r = null;
        try {
            r = new Matrix(array);
        } catch (MatrixException e) {
            e.printStackTrace();
        }
        return r;
    }

    public TetrisState accept(char key) throws Exception {
        Matrix tempi = new Matrix(iScreen), tempo = new Matrix(oScreen);

        iScreen = binaryM(iScreen);
        oScreen = binaryM(oScreen);

        if(state == TetrisState.NewBlock){
            tempo = deleteCFullLines(tempo, oScreen, currBlk, top, iScreenDy, iScreenDx, Tetris.iScreenDw);
            tempi.paste(tempo, 0, 0);
        }

        state = super.accept(key);

        iScreen = tempi;
        oScreen = tempo;

        currCBlk = setOfCBlockObjects[idxBlockType][idxBlockDegree];

        Matrix tempBlk = iScreen.clip(top, left, top+currCBlk.get_dy(), left+currCBlk.get_dx());
        tempBlk = tempBlk.add(currCBlk);

        oScreen.paste(iScreen, 0, 0);
        oScreen.paste(tempBlk, top, left);
        return state;
    }

    private Matrix deleteCFullLines(Matrix Cscreen, Matrix screen, Matrix blk, int top, int dy, int dx, int dw) throws Exception {
        Matrix line, zero, temp;
        if (blk == null) return Cscreen; // called right after the game starts!!
        int cy, y, nDeleted = 0,nScanned = blk.get_dy();
        if (top + blk.get_dy() - 1 >= dy)
            nScanned -= (top + blk.get_dy() - dy);
        zero = new Matrix(1, dx);
        for (y = nScanned - 1; y >= 0 ; y--) {
            cy = top + y + nDeleted;
            line = screen.clip(cy, 0, cy + 1, screen.get_dx());
            if (line.sum() == screen.get_dx()) {
                temp = screen.clip(0, 0, cy, screen.get_dx());
                screen.paste(temp, 1, 0);
                screen.paste(zero, 0, dw);

                temp = Cscreen.clip(0, 0, cy, Cscreen.get_dx());
                Cscreen.paste(temp, 1, 0);
                Cscreen.paste(zero, 0, dw);

                nDeleted++;
            }
        }
        return Cscreen;
    }
}
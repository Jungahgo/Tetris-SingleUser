package ssu.btetris.singleuser;

import ssu.btetris.model.Matrix;
import ssu.btetris.model.Tetris;

public class TetrisModel { // derived from TestMain.java in Lecture 5
    private Tetris board;
    public Matrix getBlock(char type) { return board.setOfBlockObjects[type - '0'][0]; }
    public Matrix getScreen() { return board.get_oScreen(); }
    public TetrisModel(int dy, int dx) throws Exception {
        Tetris.init(setOfBlockArrays);
        board = new Tetris(dy, dx);
    }
    public Tetris.TetrisState accept(char ch) throws Exception { return board.accept(ch); }
    private int[][][][] setOfBlockArrays = { // [7][4][?][?]
            {
                    {
                            { 0, 0, 1, 0 },
                            { 0, 0, 1, 0 },
                            { 0, 0, 1, 0 },
                            { 0, 0, 1, 0 },
                    },
                    {
                            { 0, 0, 0, 0 },
                            { 1, 1, 1, 1 },
                            { 0, 0, 0, 0 },
                            { 0, 0, 0, 0 }
                    },
                    {
                            { 0, 0, 1, 0 },
                            { 0, 0, 1, 0 },
                            { 0, 0, 1, 0 },
                            { 0, 0, 1, 0 },
                    },
                    {
                            { 0, 0, 0, 0 },
                            { 1, 1, 1, 1 },
                            { 0, 0, 0, 0 },
                            { 0, 0, 0, 0 }
                    }
            },
            {
                    {
                            { 1, 0, 0 },
                            { 1, 1, 1 },
                            { 0, 0, 0 }
                    },
                    {
                            { 0, 1, 1 },
                            { 0, 1, 0 },
                            { 0, 1, 0 }
                    },
                    {
                            { 0, 0, 0 },
                            { 1, 1, 1 },
                            { 0, 0, 1 }
                    },
                    {
                            { 0, 1, 0 },
                            { 0, 1, 0 },
                            { 1, 1, 0 }
                    }
            },
            {
                    {
                            { 0, 0, 1 },
                            { 1, 1, 1 },
                            { 0, 0, 0 }
                    },
                    {
                            { 0, 1, 0 },
                            { 0, 1, 0 },
                            { 0, 1, 1 }
                    },
                    {
                            { 0, 0, 0 },
                            { 1, 1, 1 },
                            { 1, 0, 0 }
                    },
                    {
                            { 1, 1, 0 },
                            { 0, 1, 0 },
                            { 0, 1, 0 }
                    }
            },
            {
                    {
                            { 0, 1, 0 },
                            { 1, 1, 1 },
                            { 0, 0, 0 }
                    },
                    {
                            { 0, 1, 0 },
                            { 0, 1, 1 },
                            { 0, 1, 0 }
                    },
                    {
                            { 0, 0, 0 },
                            { 1, 1, 1 },
                            { 0, 1, 0 }
                    },
                    {
                            { 0, 1, 0 },
                            { 1, 1, 0 },
                            { 0, 1, 0 }
                    }
            },
            {
                    {
                            { 0, 1, 0 },
                            { 1, 1, 0 },
                            { 1, 0, 0 }
                    },
                    {
                            { 1, 1, 0 },
                            { 0, 1, 1 },
                            { 0, 0, 0 }
                    },
                    {
                            { 0, 1, 0 },
                            { 1, 1, 0 },
                            { 1, 0, 0 }
                    },
                    {
                            { 1, 1, 0 },
                            { 0, 1, 1 },
                            { 0, 0, 0 }
                    }
            },
            {
                    {
                            { 0, 1, 0 },
                            { 0, 1, 1 },
                            { 0, 0, 1 }
                    },
                    {
                            { 0, 1, 1 },
                            { 1, 1, 0 },
                            { 0, 0, 0 }
                    },
                    {
                            { 0, 1, 0 },
                            { 0, 1, 1 },
                            { 0, 0, 1 }
                    },
                    {
                            { 0, 1, 1 },
                            { 1, 1, 0 },
                            { 0, 0, 0 }
                    }
            },
            {
                    {
                            { 1, 1 },
                            { 1, 1 }
                    },
                    {
                            { 1, 1 },
                            { 1, 1 }
                    },
                    {
                            { 1, 1 },
                            { 1, 1 }
                    },
                    {
                            { 1, 1 },
                            { 1, 1 }
                    }
            }
    }; // end of arrayBlock
}


package solver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sudoku.SolutionStep;
import sudoku.Sudoku2;

import javax.print.attribute.standard.MediaSize;

import static org.junit.jupiter.api.Assertions.*;
import static sudoku.SolutionType.*;

class SimpleSolverTest {

    @Test
    @DisplayName("findAllFullHouses finds a full house in a nearly complete row")
    void findAllFullHousesFindsFullHouse() {
        Sudoku2 sudoku = new Sudoku2();
        // Fill row 0 with 1-8, leave cell 8 empty
        for (int i = 0; i < 8; i++) {
            sudoku.setCell(i, i + 1);
        }
        SudokuStepFinder sudokuStepFinder = new SudokuStepFinder(true);
        sudokuStepFinder.setSudoku(sudoku);
        SolutionStep step = sudokuStepFinder.getStep( FULL_HOUSE);
        assertEquals(FULL_HOUSE, step.getType());
        assertEquals(8, step.getIndices().get(0));
        assertEquals(9, step.getValues().get(0));
    }

    @Test
    @DisplayName("findAllFullHouses finds a full house in a nearly complete row")
    void findAllFullHousesFindsFullHouseAll() {
        Sudoku2 sudoku = new Sudoku2();
        // Fill row 0 with 1-8, leave cell 8 empty
        for (int i = 0; i < 8; i++) {
            sudoku.setCell(i, i + 1);
        }
        SudokuStepFinder sudokuStepFinder = new SudokuStepFinder(false);
        sudokuStepFinder.setSudoku(sudoku);
        SolutionStep step = sudokuStepFinder.getStep( FULL_HOUSE);
        assertEquals(FULL_HOUSE, step.getType());
        assertEquals(8, step.getIndices().get(0));
        assertEquals(9, step.getValues().get(0));
    }

    @Test
    @DisplayName("find full house")
    void findAllNakedSinglesFindsNakedSingle() {
        Sudoku2 sudoku = new Sudoku2();
        String input = """
                       *-----------------------------------------------------------------------------*
                       | 1       2       3       | 4       0       6       | 7       8       9       |
                       | 0       0       0       | 0       0       0       | 0       0       0       |
                       | 0       0       0       | 0       0       0       | 0       0       0       |
                       |-------------------------+-------------------------+-------------------------|
                       | 0       0       0       | 0       0       0       | 0       0       0       |
                       | 0       0       0       | 0       0       0       | 0       0       0       |
                       | 0       0       0       | 0       0       0       | 0       0       0       |
                       |-------------------------+-------------------------+-------------------------|
                       | 0       0       0       | 0       0       0       | 0       0       0       |
                       | 0       0       0       | 0       0       0       | 0       0       0       |
                       | 0       0       0       | 0       0       0       | 0       0       0       |
                       *-----------------------------------------------------------------------------*
                       """;
        sudoku.setSudoku(input, true);
        SudokuStepFinder sudokuStepFinder = new SudokuStepFinder(false);
        sudokuStepFinder.setSudoku(sudoku);
        SolutionStep step = sudokuStepFinder.getStep( FULL_HOUSE);
        assertEquals(FULL_HOUSE, step.getType());
        assertEquals(4, step.getIndices().get(0));
        assertEquals(5, step.getValues().get(0));
    }

    @Test
    void testNakedPair() {
        String input = "400000938032094100095300240370609004529001673604703090957008300003900400240030709";
        Sudoku2 sudoku = new Sudoku2();
        sudoku.setSudoku(input, true);
        SudokuStepFinder sudokuStepFinder = new SudokuStepFinder(false);
        sudokuStepFinder.setSudoku(sudoku);
        SolutionStep step = sudokuStepFinder.getStep(NAKED_PAIR);
        assertEquals(NAKED_PAIR, step.getType());
    }
}
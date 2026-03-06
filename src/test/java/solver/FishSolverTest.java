package solver;

import org.junit.jupiter.api.Test;
import sudoku.SolutionStep;
import sudoku.Sudoku2;

import static org.junit.jupiter.api.Assertions.*;
import static sudoku.SolutionType.NAKED_PAIR;
import static sudoku.SolutionType.X_WING;

class FishSolverTest {
    @Test
    void testXWing() {
        String puzzle = """
                        *--------------------------------------------------*
                        | 1   378 37   | 23478 278  23478  | 5   6    9    |
                        | 4   9   2    | 37    5    6      | 1   37   8    |
                        | 378 5   6    | 1     78   9      | 2   4    37   |
                        |--------------+-------------------+---------------|
                        | 357 37  9    | 6     4    27     | 8   25   1    |
                        | 57  6   4    | 2789  1    278    | 379 25   37   |
                        | 2   1   8    | 79    3    5      | 6   79   4    |
                        |--------------+-------------------+---------------|
                        | 378 4   37   | 5     2789 2378   | 379 1    6    |
                        | 9   378 5    | 378   6    1      | 4   378  2    |
                        | 6   2   1    | 3478  789  3478   | 379 3789 5    |
                        *--------------------------------------------------*
                        """;
        Sudoku2 sudoku = new Sudoku2();
        sudoku.setSudoku(puzzle, true);
        SudokuStepFinder sudokuStepFinder = new SudokuStepFinder(false);
        sudokuStepFinder.setSudoku(sudoku);
        SolutionStep step = sudokuStepFinder.getStep( X_WING);
        assertEquals(X_WING, step.getType());
    }

    @Test
    void testXWing_byAll() {
        String puzzle = """
                        *--------------------------------------------------*
                        | 1   378 37   | 23478 278  23478  | 5   6    9    |
                        | 4   9   2    | 37    5    6      | 1   37   8    |
                        | 378 5   6    | 1     78   9      | 2   4    37   |
                        |--------------+-------------------+---------------|
                        | 357 37  9    | 6     4    27     | 8   25   1    |
                        | 57  6   4    | 2789  1    278    | 379 25   37   |
                        | 2   1   8    | 79    3    5      | 6   79   4    |
                        |--------------+-------------------+---------------|
                        | 378 4   37   | 5     2789 2378   | 379 1    6    |
                        | 9   378 5    | 378   6    1      | 4   378  2    |
                        | 6   2   1    | 3478  789  3478   | 379 3789 5    |
                        *--------------------------------------------------*
                        """;
        Sudoku2 sudoku = new Sudoku2();
        sudoku.setSudoku(puzzle, true);
        SudokuStepFinder sudokuStepFinder = new SudokuStepFinder(false);
        sudokuStepFinder.setSudoku(sudoku);
        sudokuStepFinder.getStep(X_WING); // triggers initialization of internal data structures
        FishSolver solver = new FishSolver(sudokuStepFinder);
        SolutionStep step = solver.getStep(X_WING);
        assertEquals(X_WING, step.getType());
    }

}
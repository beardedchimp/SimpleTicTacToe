package tictactoe;

import java.util.Scanner;
import java.lang.Math;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] grid = new char[5][5];

        String result = "";

        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                grid[i][j] = ' ';
            }
        }
        createGrid(grid);
        while(true) {
            playerTurn(scanner, grid, 'X');
            result = determineWinner(grid);
            if (!"Game not finished".equals(result)) {
                break;
            }
            playerTurn(scanner, grid, 'O');
            result = determineWinner(grid);
            if (!"Game not finished".equals(result)) {
                break;
            }
        }



        System.out.println(result);

    }

    public static void createGrid(char[][] grid) {
        System.out.println("-" + "-" + "-" + "-" + "-" + "-" + "-" + "-" + "-");
        System.out.println("| " + grid[1][1] + " " + grid[1][2] + " " + grid[1][3] + " |");
        System.out.println("| " + grid[2][1] + " " + grid[2][2] + " " + grid[2][3] + " |");
        System.out.println("| " + grid[3][1] + " " + grid[3][2] + " " + grid[3][3] + " |");
        System.out.println("-" + "-" + "-" + "-" + "-" + "-" + "-" + "-" + "-");
    }

    public static String determineWinner(char[][] grid) {
        int numX = 0;
        int numO = 0;
        int count = 0;
        boolean emptyCells = false;
        boolean winX = false;
        boolean winO = false;



        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                char currentPlayer = grid[i][j];
                if (currentPlayer == 'X') {
                    numX++;
                } else if (currentPlayer == 'O') {
                    numO++;
                } else {
                    emptyCells = true;
                }
                switch (count) {
                    case 0:
                        if (currentPlayer == grid[1][2] && currentPlayer == grid[1][3] ||
                                currentPlayer == grid[2][1] && currentPlayer == grid[3][1] ||
                                currentPlayer == grid[2][2] && currentPlayer == grid[3][3]) {
                            if (currentPlayer == 'X') {
                                winX = true;
                            } else if (currentPlayer == 'O') {
                                winO = true;
                            }
                        }
                        break;
                    case 1:
                        if (currentPlayer == grid[1][1] && currentPlayer == grid[1][3] ||
                                currentPlayer == grid[2][2] && currentPlayer == grid[3][2]) {
                            if (currentPlayer == 'X') {
                                winX = true;
                            } else if (currentPlayer == 'O') {
                                winO = true;
                            }
                        }
                        break;
                    case 2:
                        if (currentPlayer == grid[1][2] && currentPlayer == grid[1][1] ||
                                currentPlayer == grid[2][3] && currentPlayer == grid[3][3] ||
                                currentPlayer == grid[2][2] && currentPlayer == grid[3][1]) {
                            if (currentPlayer == 'X') {
                                winX = true;
                            } else if (currentPlayer == 'O') {
                                winO = true;
                            }
                        }
                        break;
                    case 3:
                        if (currentPlayer == grid[1][1] && currentPlayer == grid[3][1] ||
                                currentPlayer == grid[2][2] && currentPlayer == grid[2][3]) {
                            if (currentPlayer == 'X') {
                                winX = true;
                            } else if (currentPlayer == 'O') {
                                winO = true;
                            }
                        }
                        break;
                    case 4:
                        if (currentPlayer == grid[1][2] && currentPlayer == grid[3][2] ||
                                currentPlayer == grid[2][1] && currentPlayer == grid[2][3] ||
                                currentPlayer == grid[1][1] && currentPlayer == grid[3][3] ||
                                currentPlayer == grid[1][3] && currentPlayer == grid[3][1]) {
                            if (currentPlayer == 'X') {
                                winX = true;
                            } else if (currentPlayer == 'O') {
                                winO = true;
                            }
                        }
                        break;
                    case 5:
                        if (currentPlayer == grid[1][3] && currentPlayer == grid[3][3] ||
                                currentPlayer == grid[2][2] && currentPlayer == grid[2][1]) {
                            if (currentPlayer == 'X') {
                                winX = true;
                            } else if (currentPlayer == 'O') {
                                winO = true;
                            }
                        }
                        break;
                    case 6:
                        if (currentPlayer == grid[1][1] && currentPlayer == grid[2][1] ||
                                currentPlayer == grid[3][2] && currentPlayer == grid[3][3] ||
                                currentPlayer == grid[2][2] && currentPlayer == grid[1][3]) {
                            if (currentPlayer == 'X') {
                                winX = true;
                            } else if (currentPlayer == 'O') {
                                winO = true;
                            }
                        }
                        break;
                    case 7:
                        if (currentPlayer == grid[3][1] && currentPlayer == grid[3][3] ||
                                currentPlayer == grid[2][2] && currentPlayer == grid[1][2]) {
                            if (currentPlayer == 'X') {
                                winX = true;
                            } else if (currentPlayer == 'O') {
                                winO = true;
                            }
                        }
                        break;
                    case 8:
                        if (currentPlayer == grid[1][1] && currentPlayer == grid[2][2] ||
                                currentPlayer == grid[3][2] && currentPlayer == grid[3][1] ||
                                currentPlayer == grid[2][3] && currentPlayer == grid[1][3]) {
                            if (currentPlayer == 'X') {
                                winX = true;
                            } else if (currentPlayer == 'O') {
                                winO = true;
                            }
                        }
                        break;
                } //end switch
                count++;
            } //end inner for loop
        } //end outer for loop

        if (Math.abs(numX - numO) >= 2) {
            return "Impossible";
        }

        if (winX && winO) {
            return "Impossible";
        } else if (winX) {
            return "X wins";
        } else if (winO) {
            return "O wins";
        } else if (!emptyCells) {
            return "Draw";
        } else {
            return "Game not finished";
        }

    }

    public static void playerTurn(Scanner s, char[][] grid, char playerRef) {
        boolean valid = false;
        while(!valid) {
            System.out.println("Enter the coordinates:\t");
            String rowInput = s.next();
            String colInput = s.next();
            try {
                int xPos = parseInt(rowInput);
                int yPos = parseInt(colInput);

                if (xPos > 3 || xPos < 1 || yPos > 3 || yPos < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (grid[xPos][yPos] == 'X' || grid[xPos][yPos] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    grid[xPos][yPos] = playerRef;
                    createGrid(grid);
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
}


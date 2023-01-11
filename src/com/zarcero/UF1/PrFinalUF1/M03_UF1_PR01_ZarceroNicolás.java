package com.zarcero.UF1.PrFinalUF1;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class M03_UF1_PR01_ZarceroNicolás {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int xMoves = 0, oMoves = 0, option = 0, xVictories = 0, oVictories = 0, draws = 0, chars = 0, boardSize = 3;
        boolean isInt = false;
        char[][] arr = new char[boardSize][boardSize];
        String[][] players = new String[10][5];
        char player1Char = 'X', player2Char = 'O';

        final String BLACK = "\033[40m";
        final String WHITE_TEXT = "\033[37m";
        final String RED = "\033[41m";
        final String GREEN = "\033[42m";
        final String YELLOW = "\033[43m";
        final String BLUE = "\033[44m";
        final String PURPLE = "\033[45m";
        final String CYAN = "\033[46m";
        final String WHITE = "\033[47m";
        final String RESET = "\u001B[0m";

        do {
            do {
                System.out.println("Que quieres hacer?\n\t" +
                                    CYAN + WHITE_TEXT + ">"  + RESET + " 1. Jugar 1vs1\n\t" +
                                    GREEN + WHITE_TEXT + ">" + RESET + " 2. Jugar contra la máquina\n\t" +
                                    YELLOW + WHITE_TEXT + ">" + RESET + " 3. Estadísticas\n\t" +
                                    PURPLE + ">" + RESET + " 4 .Información\n\t" +
                                    BLUE + ">" + RESET + " 5. Cambiar tamaño del tablero (tamaño predeterminado 3x3)\n\t" +
                                    RED + ">" + RESET + " 6. Salir\n\t"
                );
                isInt = scanner.hasNextInt();

                if (isInt) {
                    option = scanner.nextInt();
                } else {
                    scanner.next();
                }
            } while (!isInt);

            isInt = false;

            /* Rellenar array */

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = '_';
                }
            }

            switch (option) {
                case 1:
                    /* Jugar 1vs1 */
                    System.out.println("\nJugar 1vs1");

                    do {
                        System.out.println("Carácter del jugador 1: ");
                        player1Char = scanner.next().charAt(0);

                        if (player1Char == '_') {
                            System.out.println("No puedes usar el carácter '_'");
                        } else {
                            break;
                        }
                    } while (true);

                    do {
                        do {
                            System.out.println("Carácter del jugador 2: ");
                            player2Char = scanner.next().charAt(0);

                            if (player2Char == '_') {
                                System.out.println("No puedes usar el carácter '_'");
                            } else {
                                break;
                            }
                        } while (true);

                        if (player1Char == player2Char) {
                            System.out.println("El carácter del jugador 2 no puede ser igual al del jugador 1");
                        }
                    } while (player2Char == player1Char);

                    System.out.println("Nombre del Jugador 1 (" + player1Char + "): ");
                    String player1 = scanner.next();
                    System.out.println("Nombre del Jugador 2 (" + player2Char + "): ");
                    String player2 = scanner.next();
                    boolean player1Exists = false, player2Exists = false;

                    for (int i = 0; i < players.length; i++) {
                        if (Objects.equals(players[i][0], player1)) {
                            player1Exists = true;
                            break;
                        }
                    }

                    for (int i = 0; i < players.length; i++) {
                        if (Objects.equals(players[i][0], player2)) {
                            player2Exists = true;
                            break;
                        }
                    }

                    if (!player1Exists) {
                        for (int i = 0; i < players.length; i++) {
                            if (players[i][0] == null) {
                                players[i][0] = player1;
                                players[i][1] = "0";
                                players[i][2] = "0";
                                players[i][3] = "0";
                                players[i][4] = "0";
                                break;
                            }
                        }
                    }

                    if (!player2Exists) {
                        for (int i = 0; i < players.length; i++) {
                            if (players[i][0] == null) {
                                players[i][0] = player2;
                                players[i][1] = "0";
                                players[i][2] = "0";
                                players[i][3] = "0";
                                players[i][4] = "0";
                                break;
                            }
                        }
                    }

                    xMoves = 0;
                    oMoves = 0;
                    xVictories = 0;
                    oVictories = 0;
                    draws = 0;

                    /* Mostrar la tabla */

                    System.out.print("-");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print("--");
                    }
                    System.out.println("--");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print("| ");
                        for (int j = 0; j < arr[i].length; j++) {
                            System.out.print(arr[i][j] + " ");
                        }
                        System.out.print("|");
                        System.out.println();
                    }
                    System.out.print("-");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print("--");
                    }
                    System.out.println("--");
                    scanner.nextLine();

                    while (true) {
                        int nextMoveRow = 0, nextMoveCol = 0;

                        boolean isIntRow = false, isIntCol = false;

                        do {
                            System.out.print("Introduzca las coordenadas de la casilla a marcar (fila columna): ");
                            isIntRow = scanner.hasNextInt();

                            if (isIntRow) {
                                nextMoveRow = scanner.nextInt();
                                isIntCol = scanner.hasNextInt();
                                if (isIntCol) {
                                    nextMoveCol = scanner.nextInt();
                                } else {
                                    System.out.println("Introduce dos números enteros como coordenadas");
                                }
                            } else {
                                System.out.println("Introduce dos números enteros como coordenadas");
                            }
                            scanner.nextLine();
                        } while (!isIntRow || !isIntCol);

                        if (nextMoveCol > arr.length || nextMoveRow > arr.length) {
                            System.out.println("Coordenadas incorrectas");
                        } else {
                            if (arr[nextMoveRow - 1][nextMoveCol - 1] == '_') {
                                if (xMoves == 0 || xMoves == oMoves) {
                                    arr[nextMoveRow - 1][nextMoveCol - 1] = player1Char;
                                    xMoves++;
                                } else if (xMoves > oMoves) {
                                    arr[nextMoveRow - 1][nextMoveCol - 1] = player2Char;
                                    oMoves++;
                                }

                                /* Mostrar la tabla */

                                System.out.print("-");
                                for (int i = 0; i < arr.length; i++) {
                                    System.out.print("--");
                                }
                                System.out.println("--");
                                for (int i = 0; i < arr.length; i++) {
                                    System.out.print("| ");
                                    for (int j = 0; j < arr[i].length; j++) {
                                        System.out.print(arr[i][j] + " ");
                                    }
                                    System.out.print("|");
                                    System.out.println();
                                }
                                System.out.print("-");
                                for (int i = 0; i < arr.length; i++) {
                                    System.out.print("--");
                                }
                                System.out.println("--");

                                /* Conteo de huecos */

                                chars = 0;
                                for (int i = 0; i < arr.length; i++) {
                                    for (int j = 0; j < arr[i].length; j++) {
                                        if (arr[i][j] == '_') {
                                            chars++;
                                        }
                                    }
                                }

                                int blankChars = chars;

                                boolean xWins = false;
                                boolean oWins = false;

                                int chCount = 0;
                                boolean centerPieceX = false, centerPieceO = false;

                                /* Comprobar quien tiene el centro */

                                if (arr[arr.length / 2][arr.length / 2] == player1Char) {
                                    centerPieceX = true;
                                } else if (arr[arr.length / 2][arr.length / 2] == player2Char) {
                                    centerPieceO = true;
                                }

                                /* Comprobar si X gana */

                                /* Comprobar si X gana horizontalmente */

                                for (int i = 0; i < arr.length; i++) {
                                    for (int j = 0; j < arr[i].length; j++) {
                                        if (arr[i][j] == player1Char) {
                                            chCount++;
                                        } else {
                                            chCount = 0;
                                        }
                                    }
                                    if (chCount == arr.length) {
                                        xWins = true;
                                        break;
                                    }
                                    chCount = 0;
                                }

                                /* Comprobar si X gana verticalmente */

                                if (!xWins) {
                                    for (int i = 0; i < arr.length; i++) {
                                        for (int j = 0; j < arr[i].length; j++) {
                                            if (arr[j][i] == player1Char) {
                                                chCount++;
                                            } else {
                                                chCount = 0;
                                            }
                                        }
                                        if (chCount == arr.length) {
                                            xWins = true;
                                            break;
                                        }
                                        chCount = 0;
                                    }
                                }

                                /* Comprobar si X gana diagonalmente */

                                if (!xWins) {
                                    if (centerPieceX) {
                                        for (int i = 0; i < arr.length; i++) {
                                            if (arr[i][i] == player1Char) {
                                                chCount++;
                                            } else {
                                                chCount = 0;
                                            }
                                        }
                                        if (chCount == arr.length) {
                                            xWins = true;
                                        }
                                    }
                                }

                                if (!xWins) {
                                    if (centerPieceX) {
                                        for (int i = 0; i < arr.length; i++) {
                                            if (arr[i][arr.length - 1 - i] == player1Char) {
                                                chCount++;
                                            } else {
                                                chCount = 0;
                                            }
                                        }
                                        if (chCount == arr.length) {
                                            xWins = true;
                                        }
                                    }
                                }

                                if (!xWins) {

                                    /* Comprobar si O gana */

                                    chCount = 0;

                                    /* Comprobar si O gana horizontalmente */

                                    for (int i = 0; i < arr.length; i++) {
                                        for (int j = 0; j < arr[i].length; j++) {
                                            if (arr[i][j] == player2Char) {
                                                chCount++;
                                            } else {
                                                chCount = 0;
                                            }
                                        }
                                        if (chCount == arr.length) {
                                            oWins = true;
                                            break;
                                        }
                                        chCount = 0;
                                    }

                                    /* Comprobar si O gana verticalmente */

                                    if (!oWins) {
                                        for (int i = 0; i < arr.length; i++) {
                                            for (int j = 0; j < arr.length; j++) {
                                                if (arr[j][i] == player2Char) {
                                                    chCount++;
                                                } else {
                                                    chCount = 0;
                                                }
                                            }
                                            if (chCount == arr.length) {
                                                oWins = true;
                                                break;
                                            }
                                            chCount = 0;
                                        }
                                    }

                                    /* Comprobar si O gana diagonalmente */

                                    if (!oWins) {
                                        if (centerPieceO) {
                                            for (int i = 0; i < arr.length; i++) {
                                                if (arr[i][i] == player2Char) {
                                                    chCount++;
                                                } else {
                                                    chCount = 0;
                                                }
                                            }
                                            if (chCount == arr.length) {
                                                oWins = true;
                                            }
                                        }
                                    }

                                    if (!oWins) {
                                        if (centerPieceO) {
                                            for (int i = 0; i < arr.length; i++) {
                                                if (arr[i][arr.length - 1 - i] == player2Char) {
                                                    chCount++;
                                                } else {
                                                    chCount = 0;
                                                }
                                            }
                                            if (chCount == arr.length) {
                                                oWins = true;
                                            }
                                        }
                                    }
                                }

                                /* Mostrar ganador */

                                if (xWins) {
                                    System.out.println(player1Char + " gana (" + player1 + ")");
                                    xVictories++;
                                } else if (oWins) {
                                    System.out.println(player2Char + " gana (" + player2 + ")");
                                    oVictories++;
                                }

                                if (!oWins && !xWins) {
                                    if (blankChars <= 0) {
                                        System.out.println("Empate");
                                        draws++;
                                    }
                                }

                                for (int i = 0; i < players.length; i++) {
                                    if (Objects.equals(players[i][0], player1)) {
                                        players[i][1] = String.valueOf(xVictories + Integer.parseInt(players[i][1]));
                                        players[i][2] = String.valueOf(oVictories + Integer.parseInt(players[i][2]));
                                        players[i][3] = String.valueOf(draws + Integer.parseInt(players[i][3]));
                                        players[i][4] = String.valueOf(Integer.parseInt(players[i][1]) + Integer.parseInt(players[i][2]) + Integer.parseInt(players[i][3]));
                                    }
                                }

                                for (int i = 0; i < players.length; i++) {
                                    if (Objects.equals(players[i][0], player2)) {
                                        players[i][1] = String.valueOf(oVictories + Integer.parseInt(players[i][1]));
                                        players[i][2] = String.valueOf(xVictories + Integer.parseInt(players[i][2]));
                                        players[i][3] = String.valueOf(draws + Integer.parseInt(players[i][3]));
                                        players[i][4] = String.valueOf(Integer.parseInt(players[i][1]) + Integer.parseInt(players[i][2]) + Integer.parseInt(players[i][3]));
                                    }
                                }

                                if (xWins || oWins || blankChars <= 0) {
                                    break;
                                }
                            } else {
                                System.out.println("Casilla ocupada");
                            }
                        }
                    }
                    System.out.println();
                    break;
                case 2:
                    /* Jugar contra la máquina */
                    System.out.println("\nJugar contra la máquina");
                    do {
                        System.out.println("Carácter del jugador 1: ");
                        player1Char = scanner.next().charAt(0);

                        if (player1Char == '_') {
                            System.out.println("No se puede usar el carácter '_'");
                        } else {
                            break;
                        }

                    } while (true);

                    player2Char = 'O';
                    if (player1Char == 'O') {
                        player2Char = 'X';
                    }
                    System.out.println("Nombre del Jugador 1 (" + player1Char + "): ");
                    String playerAAI = scanner.next(); // playerAgainstArtifficialIntelligence

                    boolean playerAAIExists = false;

                    for (int i = 0; i < players.length; i++) {
                        if (Objects.equals(players[i][0], playerAAI)) {
                            playerAAIExists = true;
                            break;
                        }
                    }

                    if (!playerAAIExists) {
                        for (int i = 0; i < players.length; i++) {
                            if (players[i][0] == null) {
                                players[i][0] = playerAAI;
                                players[i][1] = "0";
                                players[i][2] = "0";
                                players[i][3] = "0";
                                players[i][4] = "0";
                                break;
                            }
                        }
                    }

                    xMoves = 0;
                    oMoves = 0;
                    xVictories = 0;
                    oVictories = 0;
                    draws = 0;
                    Random random = new Random();

                    System.out.print("-");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print("--");
                    }
                    System.out.println("--");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print("| ");
                        for (int j = 0; j < arr[i].length; j++) {
                            System.out.print(arr[i][j] + " ");
                        }
                        System.out.print("|");
                        System.out.println();
                    }
                    System.out.print("-");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print("--");
                    }
                    System.out.println("--");
                    scanner.nextLine();

                    while (true) {
                        int nextMoveRow = 0, nextMoveCol = 0;
                        int randomRow = random.nextInt(arr.length);
                        int randomCol = random.nextInt(arr.length);
                        boolean bloqueo = false, ganar = false;

                        boolean isIntRow = false, isIntCol = false;

                        if (xMoves == 0 || xMoves == oMoves) {
                            do {
                                System.out.print("Introduzca las coordenadas de la casilla a marcar (fila columna): ");
                                isIntRow = scanner.hasNextInt();

                                if (isIntRow) {
                                    nextMoveRow = scanner.nextInt();
                                    isIntCol = scanner.hasNextInt();
                                    if (isIntCol) {
                                        nextMoveCol = scanner.nextInt();
                                    } else {
                                        System.out.println("Introduce dos números enteros como coordenadas");
                                    }
                                } else {
                                    System.out.println("Introduce dos números enteros como coordenadas");
                                }
                                scanner.nextLine();
                            } while (!isIntRow || !isIntCol);
                        }

                        if (nextMoveCol > arr.length || nextMoveRow > arr.length) {
                            System.out.println("Coordenadas incorrectas");
                        } else {
                            if (xMoves == 0 || xMoves == oMoves) {
                                if (arr[nextMoveRow - 1][nextMoveCol - 1] == '_') {
                                    arr[nextMoveRow - 1][nextMoveCol - 1] = player1Char;
                                    xMoves++;
                                } else {
                                    System.out.println("Casilla ocupada");
                                }
                            } else if (xMoves > oMoves) {
                                /* Elegir centro si esta vacio */
                                if (arr[arr.length / 2][arr.length / 2] == '_') {
                                    arr[arr.length / 2][arr.length / 2] = player2Char;
                                } else {

                                    /* Mirar si se puede ganar horizontalmente */

                                    if (!ganar) {
                                        for (int i = 0; i < arr.length; i++) {
                                            if (ganar) {
                                                break;
                                            }
                                            int oCount = 0;
                                            for (int j = 0; j < arr[i].length; j++) {
                                                if (arr[i][j] == player2Char) {
                                                    oCount++;
                                                }
                                            }
                                            if (oCount == arr.length - 1) {
                                                for (int j = 0; j < arr[i].length; j++) {
                                                    if (arr[i][j] == '_') {
                                                        arr[i][j] = player2Char;
                                                        ganar = true;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    /* Mirar si se puede ganar verticalmente */

                                    if (!ganar) {
                                        for (int i = 0; i < arr.length; i++) {
                                            if (ganar) {
                                                break;
                                            }
                                            int oCount = 0;
                                            for (int j = 0; j < arr[i].length; j++) {
                                                if (arr[j][i] == player2Char) {
                                                    oCount++;
                                                }
                                            }
                                            if (oCount == arr.length - 1) {
                                                for (int j = 0; j < arr[i].length; j++) {
                                                    if (arr[j][i] == '_') {
                                                        arr[j][i] = player2Char;
                                                        ganar = true;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    /* Mirar si se puede ganar diagonalmente */

                                    int chCount = 0;
                                    boolean canWin = false;

                                    if (!ganar) {
                                        if (arr[arr.length / 2][arr.length / 2] == player2Char) {
                                            for (int i = 0; i < arr.length; i++) {
                                                if (arr[i][i] == player1Char) {
                                                    canWin = false;
                                                    break;
                                                }
                                            }

                                            for (int i = 0; i < arr.length; i++) {
                                                if (arr[i][arr.length - 1 - i] == player1Char) {
                                                    canWin = false;
                                                    break;
                                                }
                                            }

                                            if (!canWin) {
                                                for (int i = 0; i < arr.length; i++) {
                                                    if (arr[i][i] == player2Char) {
                                                        chCount++;
                                                    } else {
                                                        chCount = 0;
                                                    }
                                                }

                                                if (chCount == arr.length - 1) {
                                                    for (int i = 0; i < arr.length; i++) {
                                                        if (arr[i][i] == '_') {
                                                            arr[i][i] = player2Char;
                                                            canWin = true;
                                                            ganar = true;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }

                                            chCount = 0;

                                            if (!canWin) {
                                                for (int i = 0; i < arr.length; i++) {
                                                    if (arr[i][arr.length - 1 - i] == player2Char) {
                                                        chCount++;
                                                    } else {
                                                        chCount = 0;
                                                    }
                                                }

                                                if (chCount == arr.length - 1) {
                                                    for (int i = 0; i < arr.length; i++) {
                                                        if (arr[i][arr.length - 1 - i] == '_') {
                                                            arr[i][arr.length - 1 - i] = player2Char;
                                                            ganar = true;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    if (chCount == arr.length) {
                                        ganar = true;
                                    }

                                    /* Si no se puede ganar en este turno, mirar si se puede bloquear */

                                    if (!ganar) {
                                        /* Mirar si se puede bloquear horizontalmente */

                                        if (!bloqueo) {
                                            for (int i = 0; i < arr.length; i++) {
                                                if (bloqueo) {
                                                    break;
                                                }
                                                int xCount = 0;
                                                for (int j = 0; j < arr[i].length; j++) {
                                                    if (arr[i][j] == player1Char) {
                                                        xCount++;
                                                    }
                                                }
                                                if (xCount == arr.length - 1) {
                                                    for (int j = 0; j < arr[i].length; j++) {
                                                        if (arr[i][j] == '_') {
                                                            arr[i][j] = player2Char;
                                                            bloqueo = true;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                        /* Mirar si se puede bloquear verticalmente */

                                        if (!bloqueo) {
                                            for (int i = 0; i < arr.length; i++) {
                                                if (bloqueo) {
                                                    break;
                                                }
                                                int xCount = 0;
                                                for (int j = 0; j < arr[i].length; j++) {
                                                    if (arr[j][i] == player1Char) {
                                                        xCount++;
                                                    }
                                                }
                                                if (xCount == arr.length - 1) {
                                                    for (int j = 0; j < arr[i].length; j++) {
                                                        if (arr[j][i] == '_') {
                                                            arr[j][i] = player2Char;
                                                            bloqueo = true;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                        /* Mirar si se puede bloquear diagonalmente */

                                        if (!bloqueo) {
                                            int chCountX = 0;

                                            if (arr[arr.length / 2][arr.length / 2] == player1Char) {
                                                for (int i = 0; i < arr.length; i++) {
                                                    if (arr[i][i] == player1Char) {
                                                        chCountX++;
                                                    }
                                                }

                                                if (chCountX == arr.length - 1) {
                                                    for (int i = 0; i < arr.length; i++) {
                                                        if (arr[i][i] == '_') {
                                                            arr[i][i] = player2Char;
                                                            bloqueo = true;
                                                            break;
                                                        }
                                                    }
                                                }

                                                chCountX = 0;

                                                if (!bloqueo) {
                                                    for (int i = 0; i < arr.length; i++) {
                                                        if (arr[i][arr.length - 1 - i] == player1Char) {
                                                            chCountX++;
                                                        }
                                                    }

                                                    if (chCountX == arr.length) {
                                                        for (int i = 0; i < arr.length; i++) {
                                                            if (arr[i][arr.length - 1 - i] == '_') {
                                                                arr[i][arr.length - 1 - i] = player2Char;
                                                                bloqueo = true;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }

                                                chCountX = 0;
                                            }
                                        }
                                    }

                                    /* Si O no puede ganar y X no va a ganar, elegir una casilla aleatoria */

                                    if (!ganar && !bloqueo) {
                                        while (arr[randomRow][randomCol] != '_') {
                                            randomRow = random.nextInt(arr.length);
                                            randomCol = random.nextInt(arr.length);
                                        }
                                        arr[randomRow][randomCol] = player2Char;
                                    }
                                }

                                /* Incrementar el numero de movimientos de O */
                                oMoves++;
                            }

                            /* Mostrar la tabla */

                            System.out.print("-");
                            for (int i = 0; i < arr.length; i++) {
                                System.out.print("--");
                            }
                            System.out.println("--");
                            for (int i = 0; i < arr.length; i++) {
                                System.out.print("| ");
                                for (int j = 0; j < arr[i].length; j++) {
                                    System.out.print(arr[i][j] + " ");
                                }
                                System.out.print("|");
                                System.out.println();
                            }
                            System.out.print("-");
                            for (int i = 0; i < arr.length; i++) {
                                System.out.print("--");
                            }
                            System.out.println("--");

                            /* Conteo de huecos */

                            chars = 0;
                            for (int i = 0; i < arr.length; i++) {
                                for (int j = 0; j < arr[i].length; j++) {
                                    if (arr[i][j] == '_') {
                                        chars++;
                                    }
                                }
                            }

                            int blankChars = chars;

                            boolean xWins = false;
                            boolean oWins = false;

                            int chCount = 0;
                            boolean centerPieceX = false, centerPieceO = false;

                            /* Comprobar quien tiene el centro */

                            if (arr[arr.length / 2][arr.length / 2] == player1Char) {
                                centerPieceX = true;
                            } else if (arr[arr.length / 2][arr.length / 2] == player2Char) {
                                centerPieceO = true;
                            }

                            /* Comprobar si X gana */

                            /* Comprobar si X gana horizontalmente */

                            for (int i = 0; i < arr.length; i++) {
                                for (int j = 0; j < arr[i].length; j++) {
                                    if (arr[i][j] == player1Char) {
                                        chCount++;
                                    } else {
                                        chCount = 0;
                                    }
                                }
                                if (chCount == arr.length) {
                                    xWins = true;
                                    break;
                                }
                                chCount = 0;
                            }

                            /* Comprobar si X gana verticalmente */

                            if (!xWins) {
                                for (int i = 0; i < arr.length; i++) {
                                    for (int j = 0; j < arr[i].length; j++) {
                                        if (arr[j][i] == player1Char) {
                                            chCount++;
                                        } else {
                                            chCount = 0;
                                        }
                                    }
                                    if (chCount == arr.length) {
                                        xWins = true;
                                        break;
                                    }
                                    chCount = 0;
                                }
                            }

                            /* Comprobar si X gana diagonalmente */

                            if (!xWins) {
                                if (centerPieceX) {
                                    for (int i = 0; i < arr.length; i++) {
                                        if (arr[i][i] == player1Char) {
                                            chCount++;
                                        } else {
                                            chCount = 0;
                                        }
                                    }
                                    if (chCount == arr.length) {
                                        xWins = true;
                                    }
                                }
                            }

                            if (!xWins) {
                                if (centerPieceX) {
                                    for (int i = 0; i < arr.length; i++) {
                                        if (arr[i][arr.length - 1 - i] == player1Char) {
                                            chCount++;
                                        } else {
                                            chCount = 0;
                                        }
                                    }
                                    if (chCount == arr.length) {
                                        xWins = true;
                                    }
                                }
                            }

                            if (!xWins) {

                                /* Comprobar si O gana */

                                chCount = 0;

                                /* Comprobar si O gana horizontalmente */

                                for (int i = 0; i < arr.length; i++) {
                                    for (int j = 0; j < arr[i].length; j++) {
                                        if (arr[i][j] == player2Char) {
                                            chCount++;
                                        } else {
                                            chCount = 0;
                                        }
                                    }
                                    if (chCount == arr.length) {
                                        oWins = true;
                                        break;
                                    }
                                    chCount = 0;
                                }

                                /* Comprobar si O gana verticalmente */

                                if (!oWins) {
                                    for (int i = 0; i < arr.length; i++) {
                                        for (int j = 0; j < arr.length; j++) {
                                            if (arr[j][i] == player2Char) {
                                                chCount++;
                                            } else {
                                                chCount = 0;
                                            }
                                        }
                                        if (chCount == arr.length) {
                                            oWins = true;
                                            break;
                                        }
                                        chCount = 0;
                                    }
                                }

                                /* Comprobar si O gana diagonalmente */

                                if (!oWins) {
                                    if (centerPieceO) {
                                        for (int i = 0; i < arr.length; i++) {
                                            if (arr[i][i] == player2Char) {
                                                chCount++;
                                            } else {
                                                chCount = 0;
                                            }
                                        }
                                        if (chCount == arr.length) {
                                            oWins = true;
                                        }
                                    }
                                }

                                if (!oWins) {
                                    if (centerPieceO) {
                                        for (int i = 0; i < arr.length; i++) {
                                            if (arr[i][arr.length - 1 - i] == player2Char) {
                                                chCount++;
                                            } else {
                                                chCount = 0;
                                            }
                                        }
                                        if (chCount == arr.length) {
                                            oWins = true;
                                        }
                                    }
                                }
                            }

                            /* Mostrar ganador */

                            if (xWins) {
                                System.out.println(player1Char + " gana (" + playerAAI + ")");
                                xVictories++;
                            } else if (oWins) {
                                System.out.println(player2Char + " gana (Máquina)");
                                oVictories++;
                            }

                            if (!oWins && !xWins) {
                                if (blankChars <= 0) {
                                    System.out.println("Empate");
                                    draws++;
                                }
                            }

                            for (int i = 0; i < players.length; i++) {
                                if (Objects.equals(players[i][0], playerAAI)) {
                                    players[i][1] = String.valueOf(xVictories + Integer.parseInt(players[i][1]));
                                    players[i][2] = String.valueOf(oVictories + Integer.parseInt(players[i][2]));
                                    players[i][3] = String.valueOf(draws + Integer.parseInt(players[i][3]));
                                    players[i][4] = String.valueOf(Integer.parseInt(players[i][1]) + Integer.parseInt(players[i][2]) + Integer.parseInt(players[i][3]));
                                }
                            }

                            if (xWins || oWins || blankChars <= 0) {
                                break;
                            }
                        }
                    }
                    System.out.println();
                    break;
                case 3:
                    /* Estadisticas */
                    System.out.format("%-20s%-20s%-20s%-20s%-20s%n", "Nombre", "Victorias", "Derrotas", "Empates", "Partidas jugadas");
                    for (int i = 0; i < players.length; i++) {
                        for (int j = 0; j < players.length; j++) {
                            if (players[j][0] != null && players[i][0] != null) {
                                if (Integer.parseInt(players[j][1]) < Integer.parseInt(players[i][1])) {
                                    String[] temp = players[i];
                                    players[i] = players[j];
                                    players[j] = temp;
                                }
                            }
                        }
                    }
                    for (int i = 0; i < players.length; i++) {
                        for (int j = 0; j < players[i].length; j++) {
                            if (players[i][j] != null) {
                                System.out.format("%-20s", players[i][j]);
                            }
                        }
                        if (players[i][0] != null) {
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    /* Informacion */
                    System.out.println("\nInformación\n");
                    option = 0;

                    do {
                        System.out.println("¿Que información quieres ver?");
                        System.out.println("1. Cómo jugar 1vs1");
                        System.out.println("2. Cómo funciona el juego contra la máquina");
                        System.out.println("3. Volver al menú principal");

                        isInt = scanner.hasNextInt();

                        if (isInt) {
                            option = scanner.nextInt();
                        } else {
                            System.out.println("Opción incorrecta");
                        }

                        scanner.nextLine();

                    } while (!isInt);

                    switch (option) {
                        case 1:
                            System.out.println("\nJuego 1vs1");
                            System.out.println("----------");
                            System.out.println("El juego consiste en que dos jugadores se enfrentan en una partida de tres en raya.");
                            System.out.println("El jugador que consiga colocar tres fichas en línea (horizontal, vertical o diagonal) gana la partida.");
                            System.out.println("Enfrentaos en un juego clásico de tres en raya por turnos (primeramente X y seguidamente O).");
                            System.out.println("----------");
                            System.out.println();
                            break;
                        case 2:
                            System.out.println("\nJuego contra la máquina");
                            System.out.println("----------");
                            System.out.println("El juego consiste en que un jugador se enfrenta a la máquina en una partida de tres en raya.");
                            System.out.println("El jugador que consiga colocar tres fichas en línea (horizontal, vertical o diagonal) gana la partida.");
                            System.out.println("Enfréntate a la máquina en un juego clásico de tres en raya por turnos (primeramente X y seguidamente O).");
                            System.out.println("----------");
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("\nVolviendo al menú principal");
                            System.out.println();
                            break;
                    }

                    break;
                case 5:
                    /* Elegir tamaño del tablero */
                    isInt = false;

                    do {
                        System.out.print("\nTamaño del tablero (num impar): ");
                        isInt = scanner.hasNextInt();

                        if (isInt) {
                            boardSize = scanner.nextInt();
                            if (boardSize % 2 == 0) {
                                System.out.println("El tamaño del tablero debe ser impar");
                                isInt = false;
                            }
                        } else {
                            System.out.println("Opción incorrecta");
                        }
                    } while (!isInt);

                    arr = new char[boardSize][boardSize];
                    break;
                case 6:
                    /* Salir */
                    System.out.println("\nGracias por jugar");
                    System.out.println("Saliendo...");
                    System.out.println();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (option != 6);
    }
}
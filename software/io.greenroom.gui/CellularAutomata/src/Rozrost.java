

import java.util.Random;


public class Rozrost {
    MainPanel mainPanel;
    boolean period = false;

    Rozrost(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    void moore(int tabx[][]) {
        int tab[][] = new int[mainPanel.s][mainPanel.s];
        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                tab[i][j] = tabx[i][j];
            }
        }


        for (int i = 1; i < mainPanel.s - 1; i++) {
            for (int j = 1; j < mainPanel.s - 1; j++) {
                if (tab[i][j] != 0) {
                    if (tab[i][j] == 0) tabx[i - 1][j - 1] = tab[i][j];
                    if (tab[i + 1][j] == 0) tabx[i - 1][j] = tab[i][j];
                    if (tab[i][j - 1] == 0) tabx[i - 1][j + 1] = tab[i][j];

                    if (tab[i - 1][j] == 0) tabx[i + 1][j - 1] = tab[i][j];
                    if (tab[i - 1][j] == 0) tabx[i + 1][j] = tab[i][j];
                    if (tab[i][j + 1] == 0) tabx[i + 1][j + 1] = tab[i][j];

                    if (tab[i][j + 1] == 0) tabx[i][j - 1] = tab[i][j];
                    //if(tab[i][j-1]==0)tabx[i][j+1]=tab[i][j];
                }
            }
        }
    }

    void growth_reg(int tabx[][]) {
        int tab[][] = new int[mainPanel.s][mainPanel.s];
        int reg = 20;
        Random gencolor = new Random();
        for (int i = reg; i < mainPanel.s; i = i + reg) {
            for (int j = reg; j < mainPanel.s; j = j + reg) {
                tab[i][j] = gencolor.nextInt(6) + 1;
            }
        }


        for (int i = 1; i < mainPanel.s - 1; i = i + reg) {
            for (int j = 1; j < mainPanel.s - 1; j = j + reg) {
                if (tab[i][j] != 0) {
                    if (tab[i][j] == 0) tabx[i - 1][j - 1] = tab[i][j];
                    if (tab[i + 1][j] == 0) tabx[i - 1][j] = tab[i][j];
                    if (tab[i][j - 1] == 0) tabx[i - 1][j + 1] = tab[i][j];

                    if (tab[i - 1][j] == 0) tabx[i + 1][j - 1] = tab[i][j];
                    if (tab[i - 1][j] == 0) tabx[i + 1][j] = tab[i][j];
                    if (tab[i][j + 1] == 0) tabx[i + 1][j + 1] = tab[i][j];

                    if (tab[i][j + 1] == 0) tabx[i][j - 1] = tab[i][j];
                    //if(tab[i][j-1]==0)tabx[i][j+1]=tab[i][j];
                }
            }
        }
    }


    void vonNeumann(int tabx[][]) {
        int tab[][] = new int[mainPanel.s][mainPanel.s];
        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                tab[i][j] = tabx[i][j];
            }
        }

        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                if (tab[i][j] != 0 && i > 0 && j > 0 && i < mainPanel.s - 1 && j < mainPanel.s - 1) {
                    if (tab[i - 1][j] == 0) tabx[i - 1][j] = tab[i][j];
                    if (tab[i + 1][j] == 0) tabx[i + 1][j] = tab[i][j];
                    if (tab[i][j - 1] == 0) tabx[i][j - 1] = tab[i][j];
                    if (tab[i][j + 1] == 0) tabx[i][j + 1] = tab[i][j];
                }

                if (period == true) {
                    if (i == 0) {
                        if (tab[0][j] != 0) if (tabx[mainPanel.s - 1][j] == 0) tabx[mainPanel.s - 1][j] = tab[0][j];
                        if (tab[mainPanel.s - 1][j] != 0)
                            if (tabx[mainPanel.s - 2][j] == 0) tabx[mainPanel.s - 2][j] = tab[mainPanel.s - 1][j];
                    }
                    if (j == 0) {
                        if (tab[i][0] != 0) if (tabx[i][mainPanel.s - 1] == 0) tabx[i][mainPanel.s - 1] = tab[i][0];
                        if (tab[i][mainPanel.s - 1] != 0)
                            if (tabx[i][mainPanel.s - 2] == 0) tabx[i][mainPanel.s - 2] = tab[i][mainPanel.s - 1];
                    }
                    if (i == mainPanel.s - 1) {
                        if (tab[mainPanel.s - 1][j] != 0) if (tabx[0][j] == 0) tabx[0][j] = tab[mainPanel.s - 1][j];
                        if (tab[0][j] != 0) if (tabx[1][j] == 0) tabx[1][j] = tab[0][j];
                    }

                    if (j == mainPanel.s - 1) {
                        if (tab[i][mainPanel.s - 1] != 0) if (tabx[i][0] == 0) tabx[i][0] = tab[i][mainPanel.s - 1];
                        if (tab[i][0] != 0) if (tabx[i][1] == 0) tabx[i][1] = tab[i][0];
                    }
                }


            }
        }
    }


    void pentleft(int tabx[][]) {
        int tab[][] = new int[mainPanel.s][mainPanel.s];
        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                tab[i][j] = tabx[i][j];
            }
        }

        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                if (tab[i][j] != 0 && i > 0 && j > 0 && i < mainPanel.s - 1 && j < mainPanel.s - 1) {
                    if (tab[i - 1][j - 1] == 0) tabx[i - 1][j - 1] = tab[i][j];
                    if (tab[i - 1][j] == 0) tabx[i - 1][j] = tab[i][j];
                    if (tab[i + 1][j - 1] == 0) tabx[i + 1][j - 1] = tab[i][j];
                    if (tab[i + 1][j] == 0) tabx[i + 1][j] = tab[i][j];
                    if (tab[i][j - 1] == 0) tabx[i][j - 1] = tab[i][j];

                }
                if (period == true) {
                    if (i == 0) {
                        if (tab[0][j] != 0) if (tabx[mainPanel.s - 1][j] == 0) tabx[mainPanel.s - 1][j] = tab[0][j];
                        if (tab[mainPanel.s - 1][j] != 0)
                            if (tabx[mainPanel.s - 2][j] == 0) tabx[mainPanel.s - 2][j] = tab[mainPanel.s - 1][j];
                    }
                    if (j == 0) {
                        if (tab[i][0] != 0) if (tabx[i][mainPanel.s - 1] == 0) tabx[i][mainPanel.s - 1] = tab[i][0];
                        if (tab[i][mainPanel.s - 1] != 0)
                            if (tabx[i][mainPanel.s - 2] == 0) tabx[i][mainPanel.s - 2] = tab[i][mainPanel.s - 1];
                    }
                    if (i == mainPanel.s - 1) {
                        if (tab[mainPanel.s - 1][j] != 0) if (tabx[0][j] == 0) tabx[0][j] = tab[mainPanel.s - 1][j];
                        if (tab[0][j] != 0) if (tabx[1][j] == 0) tabx[1][j] = tab[0][j];
                    }

                    if (j == mainPanel.s - 1) {
                        if (tab[i][mainPanel.s - 1] != 0) if (tabx[i][0] == 0) tabx[i][0] = tab[i][mainPanel.s - 1];
                        if (tab[i][0] != 0) if (tabx[i][1] == 0) tabx[i][1] = tab[i][0];
                    }
                }
            }
        }
    }


    void pentright(int tabx[][]) {
        int tab[][] = new int[mainPanel.s][mainPanel.s];
        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                tab[i][j] = tabx[i][j];
            }
        }

        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                if (tab[i][j] != 0 && i > 0 && j > 0 && i < mainPanel.s - 1 && j < mainPanel.s - 1) {
                    if (tab[i - 1][j] == 0) tabx[i - 1][j] = tab[i][j];
                    if (tab[i - 1][j + 1] == 0) tabx[i - 1][j + 1] = tab[i][j];
                    if (tab[i + 1][j] == 0) tabx[i + 1][j] = tab[i][j];
                    if (tab[i + 1][j + 1] == 0) tabx[i + 1][j + 1] = tab[i][j];
                    if (tab[i][j + 1] == 0) tabx[i][j + 1] = tab[i][j];
                }
                if (period == true) {
                    if (i == 0) {
                        if (tab[0][j] != 0) if (tabx[mainPanel.s - 1][j] == 0) tabx[mainPanel.s - 1][j] = tab[0][j];
                        if (tab[mainPanel.s - 1][j] != 0)
                            if (tabx[mainPanel.s - 2][j] == 0) tabx[mainPanel.s - 2][j] = tab[mainPanel.s - 1][j];
                    }
                    if (j == 0) {
                        if (tab[i][0] != 0) if (tabx[i][mainPanel.s - 1] == 0) tabx[i][mainPanel.s - 1] = tab[i][0];
                        if (tab[i][mainPanel.s - 1] != 0)
                            if (tabx[i][mainPanel.s - 2] == 0) tabx[i][mainPanel.s - 2] = tab[i][mainPanel.s - 1];
                    }
                    if (i == mainPanel.s - 1) {
                        if (tab[mainPanel.s - 1][j] != 0) if (tabx[0][j] == 0) tabx[0][j] = tab[mainPanel.s - 1][j];
                        if (tab[0][j] != 0) if (tabx[1][j] == 0) tabx[1][j] = tab[0][j];
                    }

                    if (j == mainPanel.s - 1) {
                        if (tab[i][mainPanel.s - 1] != 0) if (tabx[i][0] == 0) tabx[i][0] = tab[i][mainPanel.s - 1];
                        if (tab[i][0] != 0) if (tabx[i][1] == 0) tabx[i][1] = tab[i][0];
                    }
                }
            }
        }
    }


    void pentup(int tabx[][]) {
        int tab[][] = new int[mainPanel.s][mainPanel.s];
        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                tab[i][j] = tabx[i][j];
            }
        }

        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                if (tab[i][j] != 0 && i > 0 && j > 0 && i < mainPanel.s - 1 && j < mainPanel.s - 1) {
                    if (tab[i - 1][j - 1] == 0) tabx[i - 1][j - 1] = tab[i][j];
                    if (tab[i - 1][j] == 0) tabx[i - 1][j] = tab[i][j];
                    if (tab[i - 1][j + 1] == 0) tabx[i - 1][j + 1] = tab[i][j];
                    if (tab[i][j - 1] == 0) tabx[i][j - 1] = tab[i][j];
                    if (tab[i][j + 1] == 0) tabx[i][j + 1] = tab[i][j];
                }
                if (period == true) {
                    if (i == 0) {
                        if (tab[0][j] != 0) if (tabx[mainPanel.s - 1][j] == 0) tabx[mainPanel.s - 1][j] = tab[0][j];
                        if (tab[mainPanel.s - 1][j] != 0)
                            if (tabx[mainPanel.s - 2][j] == 0) tabx[mainPanel.s - 2][j] = tab[mainPanel.s - 1][j];
                    }
                    if (j == 0) {
                        if (tab[i][0] != 0) if (tabx[i][mainPanel.s - 1] == 0) tabx[i][mainPanel.s - 1] = tab[i][0];
                        if (tab[i][mainPanel.s - 1] != 0)
                            if (tabx[i][mainPanel.s - 2] == 0) tabx[i][mainPanel.s - 2] = tab[i][mainPanel.s - 1];
                    }
                    if (i == mainPanel.s - 1) {
                        if (tab[mainPanel.s - 1][j] != 0) if (tabx[0][j] == 0) tabx[0][j] = tab[mainPanel.s - 1][j];
                        if (tab[0][j] != 0) if (tabx[1][j] == 0) tabx[1][j] = tab[0][j];
                    }

                    if (j == mainPanel.s - 1) {
                        if (tab[i][mainPanel.s - 1] != 0) if (tabx[i][0] == 0) tabx[i][0] = tab[i][mainPanel.s - 1];
                        if (tab[i][0] != 0) if (tabx[i][1] == 0) tabx[i][1] = tab[i][0];
                    }
                }
            }
        }
    }


    void pentdown(int tabx[][]) {
        int tab[][] = new int[mainPanel.s][mainPanel.s];
        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                tab[i][j] = tabx[i][j];
            }
        }

        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                if (tab[i][j] != 0 && i > 0 && j > 0 && i < mainPanel.s - 1 && j < mainPanel.s - 1) {
                    if (tab[i + 1][j - 1] == 0) tabx[i + 1][j - 1] = tab[i][j];
                    if (tab[i + 1][j] == 0) tabx[i + 1][j] = tab[i][j];
                    if (tab[i + 1][j + 1] == 0) tabx[i + 1][j + 1] = tab[i][j];
                    if (tab[i][j - 1] == 0) tabx[i][j - 1] = tab[i][j];
                    if (tab[i][j + 1] == 0) tabx[i][j + 1] = tab[i][j];
                }
                if (period == true) {
                    if (i == 0) {
                        if (tab[0][j] != 0) if (tabx[mainPanel.s - 1][j] == 0) tabx[mainPanel.s - 1][j] = tab[0][j];
                        if (tab[mainPanel.s - 1][j] != 0)
                            if (tabx[mainPanel.s - 2][j] == 0) tabx[mainPanel.s - 2][j] = tab[mainPanel.s - 1][j];
                    }
                    if (j == 0) {
                        if (tab[i][0] != 0) if (tabx[i][mainPanel.s - 1] == 0) tabx[i][mainPanel.s - 1] = tab[i][0];
                        if (tab[i][mainPanel.s - 1] != 0)
                            if (tabx[i][mainPanel.s - 2] == 0) tabx[i][mainPanel.s - 2] = tab[i][mainPanel.s - 1];
                    }
                    if (i == mainPanel.s - 1) {
                        if (tab[mainPanel.s - 1][j] != 0) if (tabx[0][j] == 0) tabx[0][j] = tab[mainPanel.s - 1][j];
                        if (tab[0][j] != 0) if (tabx[1][j] == 0) tabx[1][j] = tab[0][j];
                    }

                    if (j == mainPanel.s - 1) {
                        if (tab[i][mainPanel.s - 1] != 0) if (tabx[i][0] == 0) tabx[i][0] = tab[i][mainPanel.s - 1];
                        if (tab[i][0] != 0) if (tabx[i][1] == 0) tabx[i][1] = tab[i][0];
                    }
                }
            }
        }
    }


    void hexright(int tabx[][]) {
        int tab[][] = new int[mainPanel.s][mainPanel.s];
        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                tab[i][j] = tabx[i][j];
            }
        }

        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                if (tab[i][j] != 0 && i > 0 && j > 0 && i < mainPanel.s - 1 && j < mainPanel.s - 1) {
                    if (tab[i - 1][j] == 0) tabx[i - 1][j] = tab[i][j];
                    if (tab[i - 1][j + 1] == 0) tabx[i - 1][j + 1] = tab[i][j];
                    if (tab[i + 1][j - 1] == 0) tabx[i + 1][j - 1] = tab[i][j];
                    if (tab[i + 1][j] == 0) tabx[i + 1][j] = tab[i][j];
                    if (tab[i][j - 1] == 0) tabx[i][j - 1] = tab[i][j];
                    if (tab[i][j + 1] == 0) tabx[i][j + 1] = tab[i][j];
                }
                if (period == true) {
                    if (i == 0) {
                        if (tab[0][j] != 0) if (tabx[mainPanel.s - 1][j] == 0) tabx[mainPanel.s - 1][j] = tab[0][j];
                        if (tab[mainPanel.s - 1][j] != 0)
                            if (tabx[mainPanel.s - 2][j] == 0) tabx[mainPanel.s - 2][j] = tab[mainPanel.s - 1][j];
                    }
                    if (j == 0) {
                        if (tab[i][0] != 0) if (tabx[i][mainPanel.s - 1] == 0) tabx[i][mainPanel.s - 1] = tab[i][0];
                        if (tab[i][mainPanel.s - 1] != 0)
                            if (tabx[i][mainPanel.s - 2] == 0) tabx[i][mainPanel.s - 2] = tab[i][mainPanel.s - 1];
                    }
                    if (i == mainPanel.s - 1) {
                        if (tab[mainPanel.s - 1][j] != 0) if (tabx[0][j] == 0) tabx[0][j] = tab[mainPanel.s - 1][j];
                        if (tab[0][j] != 0) if (tabx[1][j] == 0) tabx[1][j] = tab[0][j];
                    }

                    if (j == mainPanel.s - 1) {
                        if (tab[i][mainPanel.s - 1] != 0) if (tabx[i][0] == 0) tabx[i][0] = tab[i][mainPanel.s - 1];
                        if (tab[i][0] != 0) if (tabx[i][1] == 0) tabx[i][1] = tab[i][0];
                    }
                }
            }
        }
    }


    void hexleft(int tabx[][]) {
        int tab[][] = new int[mainPanel.s][mainPanel.s];
        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                tab[i][j] = tabx[i][j];
            }
        }

        for (int i = 1; i < mainPanel.s - 1; i++) {
            for (int j = 1; j < mainPanel.s - 1; j++) {
                if (tab[i][j] != 0 && i > 0 && j > 0 && i < mainPanel.s - 1 && j < mainPanel.s - 1) {
                    if (tab[i - 1][j - 1] == 0) tabx[i - 1][j - 1] = tab[i][j];
                    if (tab[i - 1][j] == 0) tabx[i - 1][j] = tab[i][j];
                    if (tab[i + 1][j] == 0) tabx[i + 1][j] = tab[i][j];
                    if (tab[i + 1][j + 1] == 0) tabx[i + 1][j + 1] = tab[i][j];
                    if (tab[i][j - 1] == 0) tabx[i][j - 1] = tab[i][j];
                    if (tab[i][j + 1] == 0) tabx[i][j + 1] = tab[i][j];
                }
                if (period == true) {
                    if (i == 0) {
                        if (tab[0][j] != 0) if (tabx[mainPanel.s - 1][j] == 0) tabx[mainPanel.s - 1][j] = tab[0][j];
                        if (tab[mainPanel.s - 1][j] != 0)
                            if (tabx[mainPanel.s - 2][j] == 0) tabx[mainPanel.s - 2][j] = tab[mainPanel.s - 1][j];
                    }
                    if (j == 0) {
                        if (tab[i][0] != 0) if (tabx[i][mainPanel.s - 1] == 0) tabx[i][mainPanel.s - 1] = tab[i][0];
                        if (tab[i][mainPanel.s - 1] != 0)
                            if (tabx[i][mainPanel.s - 2] == 0) tabx[i][mainPanel.s - 2] = tab[i][mainPanel.s - 1];
                    }
                    if (i == mainPanel.s - 1) {
                        if (tab[mainPanel.s - 1][j] != 0) if (tabx[0][j] == 0) tabx[0][j] = tab[mainPanel.s - 1][j];
                        if (tab[0][j] != 0) if (tabx[1][j] == 0) tabx[1][j] = tab[0][j];
                    }

                    if (j == mainPanel.s - 1) {
                        if (tab[i][mainPanel.s - 1] != 0) if (tabx[i][0] == 0) tabx[i][0] = tab[i][mainPanel.s - 1];
                        if (tab[i][0] != 0) if (tabx[i][1] == 0) tabx[i][1] = tab[i][0];
                    }
                }
            }
        }
    }


    void periodmoore(int tabx[][]) {
        int tab[][] = new int[mainPanel.s][mainPanel.s];
        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                tab[i][j] = tabx[i][j];
            }
        }


        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                if (tab[i][j] != 0 && i > 0 && j > 0 && i < mainPanel.s - 1 && j < mainPanel.s - 1) {
                    if (tab[i - 1][j - 1] == 0) tabx[i - 1][j - 1] = tab[i][j];
                    if (tab[i - 1][j] == 0) tabx[i - 1][j] = tab[i][j];
                    if (tab[i - 1][j + 1] == 0) tabx[i - 1][j + 1] = tab[i][j];

                    if (tab[i + 1][j - 1] == 0) tabx[i + 1][j - 1] = tab[i][j];
                    if (tab[i + 1][j] == 0) tabx[i + 1][j] = tab[i][j];
                    if (tab[i + 1][j + 1] == 0) tabx[i + 1][j + 1] = tab[i][j];

                    if (tab[i][j - 1] == 0) tabx[i][j - 1] = tab[i][j];
                    if (tab[i][j + 1] == 0) tabx[i][j + 1] = tab[i][j];
                }
                if (period == true) {
                    if (i == 0) {
                        if (tab[0][j] != 0) if (tabx[mainPanel.s - 1][j] == 0) tabx[mainPanel.s - 1][j] = tab[0][j];
                        if (tab[mainPanel.s - 1][j] != 0)
                            if (tabx[mainPanel.s - 2][j] == 0) tabx[mainPanel.s - 2][j] = tab[mainPanel.s - 1][j];
                    }
                    if (j == 0) {
                        if (tab[i][0] != 0) if (tabx[i][mainPanel.s - 1] == 0) tabx[i][mainPanel.s - 1] = tab[i][0];
                        if (tab[i][mainPanel.s - 1] != 0)
                            if (tabx[i][mainPanel.s - 2] == 0) tabx[i][mainPanel.s - 2] = tab[i][mainPanel.s - 1];
                    }
                    if (i == mainPanel.s - 1) {
                        if (tab[mainPanel.s - 1][j] != 0) if (tabx[0][j] == 0) tabx[0][j] = tab[mainPanel.s - 1][j];
                        if (tab[0][j] != 0) if (tabx[1][j] == 0) tabx[1][j] = tab[0][j];
                    }

                    if (j == mainPanel.s - 1) {
                        if (tab[i][mainPanel.s - 1] != 0) if (tabx[i][0] == 0) tabx[i][0] = tab[i][mainPanel.s - 1];
                        if (tab[i][0] != 0) if (tabx[i][1] == 0) tabx[i][1] = tab[i][0];
                    }
                }

            }
        }
    }


    void homogenous_distribution(int tabx[][]) {


        int tab[][] = new int[mainPanel.s][mainPanel.s];
        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                tab[i][j] = tabx[i][j];
            }
        }

        // int imax = (int) (j*i-0.5);

        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                if (tab[i][j] != 0 && i > 0 && j > 0 && i < mainPanel.s - 1 && j < mainPanel.s - 1) {
                    if (tab[i - 1][j - 1] == 0) tabx[i - 1][j - 1] = tab[i][j];
                    if (tab[i - 1][j] == 0) tabx[i - 1][j] = tab[i][j];
                    if (tab[i - 1][j + 1] == 0) tabx[i - 1][j + 1] = tab[i][j];

                    if (tab[i + 1][j - 1] == 0) tabx[i + 1][j - 1] = tab[i][j];
                    if (tab[i + 1][j] == 0) tabx[i + 1][j] = tab[i][j];
                    if (tab[i + 1][j + 1] == 0) tabx[i + 1][j + 1] = tab[i][j];

                    if (tab[i][j - 1] == 0) tabx[i][j - 1] = tab[i][j];
                    if (tab[i][j + 1] == 0) tabx[i][j + 1] = tab[i][j];
                }
                if (period == true) {
                    if (i == 0) {
                        if (tab[0][j] != 0) if (tabx[mainPanel.s - 1][j] == 0) tabx[mainPanel.s - 1][j] = tab[0][j];
                        if (tab[mainPanel.s - 1][j] != 0)
                            if (tabx[mainPanel.s - 2][j] == 0) tabx[mainPanel.s - 2][j] = tab[mainPanel.s - 1][j];
                    }
                    if (j == 0) {
                        if (tab[i][0] != 0) if (tabx[i][mainPanel.s - 1] == 0) tabx[i][mainPanel.s - 1] = tab[i][0];
                        if (tab[i][mainPanel.s - 1] != 0)
                            if (tabx[i][mainPanel.s - 2] == 0) tabx[i][mainPanel.s - 2] = tab[i][mainPanel.s - 1];
                    }
                    if (i == mainPanel.s - 1) {
                        if (tab[mainPanel.s - 1][j] != 0) if (tabx[0][j] == 0) tabx[0][j] = tab[mainPanel.s - 1][j];
                        if (tab[0][j] != 0) if (tabx[1][j] == 0) tabx[1][j] = tab[0][j];
                    }

                    if (j == mainPanel.s - 1) {
                        if (tab[i][mainPanel.s - 1] != 0) if (tabx[i][0] == 0) tabx[i][0] = tab[i][mainPanel.s - 1];
                        if (tab[i][0] != 0) if (tabx[i][1] == 0) tabx[i][1] = tab[i][0];
                    }
                }

            }
        }

    }

    void heterogenous_distribution(int tabx[][]) {


        int tab[][] = new int[mainPanel.s][mainPanel.s];
        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                tab[i][j] = tabx[i][j];
            }
        }

        // int imax = (int) (j*i-0.5);

        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                if (tab[i][j] != 0 && i > 0 && j > 0 && i < mainPanel.s - 1 && j < mainPanel.s - 1) {
                    if (tab[i - 1][j - 1] == 0) tabx[i - 1][j - 1] = tab[i][j];
                    if (tab[i - 1][j] == 0) tabx[i - 1][j] = tab[i][j];
                    if (tab[i - 1][j + 1] == 0) tabx[i - 1][j + 1] = tab[i][j];

                    if (tab[i + 1][j - 1] == 0) tabx[i + 1][j - 1] = tab[i][j];
                    if (tab[i + 1][j] == 0) tabx[i + 1][j] = tab[i][j];
                    if (tab[i + 1][j + 1] == 0) tabx[i + 1][j + 1] = tab[i][j];

                    if (tab[i][j - 1] == 0) tabx[i][j - 1] = tab[i][j];
                    if (tab[i][j + 1] == 0) tabx[i][j + 1] = tab[i][j];
                }
                if (period == true) {
                    if (i == 0) {
                        if (tab[0][j] != 0) if (tabx[mainPanel.s - 1][j] == 0) tabx[mainPanel.s - 1][j] = tab[0][j];
                        if (tab[mainPanel.s - 1][j] != 0)
                            if (tabx[mainPanel.s - 2][j] == 0) tabx[mainPanel.s - 2][j] = tab[mainPanel.s - 1][j];
                    }
                    if (j == 0) {
                        if (tab[i][0] != 0) if (tabx[i][mainPanel.s - 1] == 0) tabx[i][mainPanel.s - 1] = tab[i][0];
                        if (tab[i][mainPanel.s - 1] != 0)
                            if (tabx[i][mainPanel.s - 2] == 0) tabx[i][mainPanel.s - 2] = tab[i][mainPanel.s - 1];
                    }
                    if (i == mainPanel.s - 1) {
                        if (tab[mainPanel.s - 1][j] != 0) if (tabx[0][j] == 0) tabx[0][j] = tab[mainPanel.s - 1][j];
                        if (tab[0][j] != 0) if (tabx[1][j] == 0) tabx[1][j] = tab[0][j];
                    }

                    if (j == mainPanel.s - 1) {
                        if (tab[i][mainPanel.s - 1] != 0) if (tabx[i][0] == 0) tabx[i][0] = tab[i][mainPanel.s - 1];
                        if (tab[i][0] != 0) if (tabx[i][1] == 0) tabx[i][1] = tab[i][0];
                    }
                }

            }
        }

    }

    void grains_amount(int tabx[][]) {


        int tab[][] = new int[mainPanel.s][mainPanel.s];
        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                tab[i][j] = tabx[i][j];
            }
        }

        // int imax = (int) (j*i-0.5);

        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                if (tab[i][j] != 0 && i > 0 && j > 0 && i < mainPanel.s - 1 && j < mainPanel.s - 1) {
                    if (tab[i - 1][j - 1] == 0) tabx[i - 1][j - 1] = tab[i][j];
                    if (tab[i - 1][j] == 0) tabx[i - 1][j] = tab[i][j];
                    if (tab[i - 1][j + 1] == 0) tabx[i - 1][j + 1] = tab[i][j];

                    if (tab[i + 1][j - 1] == 0) tabx[i + 1][j - 1] = tab[i][j];
                    if (tab[i + 1][j] == 0) tabx[i + 1][j] = tab[i][j];
                    if (tab[i + 1][j + 1] == 0) tabx[i + 1][j + 1] = tab[i][j];

                    if (tab[i][j - 1] == 0) tabx[i][j - 1] = tab[i][j];
                    if (tab[i][j + 1] == 0) tabx[i][j + 1] = tab[i][j];
                }
                if (period == true) {
                    if (i == 0) {
                        if (tab[0][j] != 0) if (tabx[mainPanel.s - 1][j] == 0) tabx[mainPanel.s - 1][j] = tab[0][j];
                        if (tab[mainPanel.s - 1][j] != 0)
                            if (tabx[mainPanel.s - 2][j] == 0) tabx[mainPanel.s - 2][j] = tab[mainPanel.s - 1][j];
                    }
                    if (j == 0) {
                        if (tab[i][0] != 0) if (tabx[i][mainPanel.s - 1] == 0) tabx[i][mainPanel.s - 1] = tab[i][0];
                        if (tab[i][mainPanel.s - 1] != 0)
                            if (tabx[i][mainPanel.s - 2] == 0) tabx[i][mainPanel.s - 2] = tab[i][mainPanel.s - 1];
                    }
                    if (i == mainPanel.s - 1) {
                        if (tab[mainPanel.s - 1][j] != 0) if (tabx[0][j] == 0) tabx[0][j] = tab[mainPanel.s - 1][j];
                        if (tab[0][j] != 0) if (tabx[1][j] == 0) tabx[1][j] = tab[0][j];
                    }

                    if (j == mainPanel.s - 1) {
                        if (tab[i][mainPanel.s - 1] != 0) if (tabx[i][0] == 0) tabx[i][0] = tab[i][mainPanel.s - 1];
                        if (tab[i][0] != 0) if (tabx[i][1] == 0) tabx[i][1] = tab[i][0];
                    }
                }

            }
        }

    }


}
	
	
	
	
	
	
	



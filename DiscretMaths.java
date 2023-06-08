public class DiscretMaths {

    public double[][] matrizTransp(double[][] matriz) {
        int fi = matriz.length;
        int col = matriz[0].length;

        double[][] transp = new double[col][fi];

        for (int i = 0; i < fi; i++) {
            for (int j = 0; j < col; j++) {
                transp[j][i] = matriz[i][j];
            }
        }
        return transp;
    }

    public double[][] multiMatrices(double[][] mat1, double[][] mat2) {
        int fi1 = mat1.length;
        int col1 = mat1[0].length;
        int col2 = mat2[0].length;

        double[][] resul = new double[fi1][col2];

        for (int i = 0; i < fi1; i++) {
            for (int j = 0; j < col2; j++) {
                double suma = 0;
                for (int k = 0; k < col1; k++) {
                    suma += mat1[i][k] * mat2[k][j];
                }
                resul[i][j] = suma;
            }
        }

        return resul;
    }

    public double[][] inversa(double[][] matriz) {
        int n = matriz.length;
        double[][] identidad = new double[n][n];
        double[][] aumen = new double[n][2 * n];


        for (int i = 0; i < n; i++) {
            identidad[i][i] = 1;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aumen[i][j] = matriz[i][j];
                aumen[i][j + n] = identidad[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            double pivote = aumen[i][i];
            for (int j = 0; j < 2 * n; j++) {
                aumen[i][j] /= pivote;
            }
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = aumen[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        aumen[k][j] -= factor * aumen[i][j];
                    }
                }
            }
        }


        double[][] inver = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = n; j < 2 * n; j++) {
                inver[i][j - n] = aumen[i][j];
            }
        }

        return inver;
    }

    public double[] multiMatVec(double[][] matriz, double[] vec) {
        int fi = matriz.length;
        int col = matriz[0].length;

        double[] resul = new double[fi];

        for (int i = 0; i < fi; i++) {
            double sum = 0;
            for (int j = 0; j < col; j++) {
                sum += matriz[i][j] * vec[j];
            }
            resul[i] = sum;
        }

        return resul;
    }
}

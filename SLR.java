import java.util.Scanner;

public class SLR {
    DataSet dataSet = new DataSet();
    DiscretMaths discretMaths = new DiscretMaths();
    Scanner lec = new Scanner(System.in);
    public void print() {
        System.out.println("Imprimir x:");
        double[][] x = dataSet.getX();
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + "   ");
            }
            System.out.println();
            System.out.println();
        }

       double[][] transpuesta = discretMaths.matrizTransp(x);

       /* System.out.println("Transpuesta:");
        for (int i = 0; i < transpuesta.length; i++) {
            for (int j = 0; j < transpuesta[i].length; j++) {
                System.out.print(transpuesta[i][j] + "   ");
            }
            System.out.println();
            System.out.println();
        }*/

        double[] y = dataSet.getY();
        double[] resulTemp = discretMaths.multiMatVec(transpuesta, y);
        double[][] multi = discretMaths.multiMatrices(transpuesta, x);
        double[][] inversa = discretMaths.inversa(multi);
        double[] resultado = discretMaths.multiMatVec(inversa, resulTemp);

       /* System.out.println("Matriz Inversa:");
        for (int i = 0; i < inversa.length; i++) {
            for (int j = 0; j < inversa[i].length; j++) {
                System.out.print(inversa[i][j] + "   ");
            }
            System.out.println();
            System.out.println();
        }
*/
        System.out.println("Valores de beta:");
        for (int i = 0; i < resultado.length; i++) {
            System.out.println("b" + i + ": " + resultado[i]);
        }
        int z;
        System.out.println("la funcion es "+resultado[0]+resultado[1]+"* x^1 "+resultado[2]+"* x^2 "+resultado[3]+"* x^3");
        System.out.println(" prediccion para Machine Efficiency ");
        for (int i=0;i<5;i++){
        System.out.println("ingrese el valor para la prediccion");
        z=lec.nextInt();
        double efi;
        efi=resultado[0]+(resultado[1]*z)+(resultado[2]*Math.pow(z, 2))+(resultado[3]*Math.pow(z, 3));
        System.out.println("la eficiencia es de: "+ efi);
    }}
}
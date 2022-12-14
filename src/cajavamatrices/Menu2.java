/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajavamatrices;


import java.util.Scanner;
/**
 *
 * @author Taina Goncalves 2021294
 * @author Helder Camara 2021341
 * GitHub: https://github.com/tainaguim/FinalCA.git
 */

public class Menu2 {

    //Attributes
    /*
    This class follows the same patterns from class Menu, the only difference is that
    this one deals with 3 equations and not 2.
     */
    private Scanner r = new Scanner(System.in); // Scanner created to ask the user to input the equations

    private int eqS[] = {0, 0, 0, 0, 0, 0, 0, 0, 0}; // This array stores all the coeficients from all three equations.
    private int eTot[] = {0, 0, 0}; // This array stores all the constants .
    private String var, var1, var2, var3; // Variables used along the code.

    //Getters and Setters
    public int[] getEqS() {
        return eqS;
    }

    public void setEqS(int[] eqS) {
        this.eqS = eqS;
    }

    public int[] geteTot() {
        return eTot;
    }

    public void seteTot(int[] eTot) {
        this.eTot = eTot;
    }

    public String getVar1() {
        return var1;
    }

    public String getVar2() {
        return var2;
    }

    public String getVar3() {
        return var3;
    }
    
    //Main Method

    public void Menu2() {

        try {
            System.out.println("Please type your first equation ( example : -x+3y-10z=15) : ");

            //Same patters from class Menu
            /*
        Get equations typed, remove the spaces, transform all in lowercase, and get rid of variables and "="sign.
        With that done I store just the numbers we are going to work with.
             */
            var1 = r.nextLine().toLowerCase().replaceAll(" ", "").trim();
            var = var1;
            var = var.replaceAll("x", ",");
            var = var.replaceAll("y", ",");
            var = var.replaceAll("z", ",");
            var = var.replaceAll("=", ",");

            String[] e = var.split(",");

            if (e[0].equals("")) {
                e[0] = e[0] + 1;
            } else if (e[0].equals("-") || e[0].equals("+")) {

                e[0] = e[0] + 1;
            }
            this.eqS[0] = Integer.parseInt(e[0]);

            if (e[1].equals("")) {
                e[1] = e[1] + 1;
            } else if (e[1].equals("-") || e[1].equals("+")) {

                e[1] = e[1] + 1;
            }
            this.eqS[1] = Integer.parseInt(e[1]);

            if (e[2].equals("")) {
                e[2] = e[2] + 1;
            } else if (e[2].equals("-") || e[2].equals("+")) {

                e[2] = e[2] + 1;
            }
            this.eqS[2] = Integer.parseInt(e[2]);
            this.eTot[0] = Integer.parseInt(e[4]);


            System.out.println("Please type your second equation ( example : x+3y-10z=15) : ");
            var2 = r.nextLine();
            var2 = var2.toLowerCase().replaceAll(" ", "").trim();
            var = var2;
            var = var.replaceAll("x", ",");
            var = var.replaceAll("y", ",");
            var = var.replaceAll("z", ",");
            var = var.replaceAll("=", ",");

            String[] f = var.split(",");

            if (f[0].equals("")) {
                f[0] = f[0] + 1;
            } else if (f[0].equals("-") || f[0].equals("+")) {

                f[0] = f[0] + 1;
            }

            this.eqS[3] = Integer.parseInt(f[0]);

            if (f[1].equals("")) {
                f[1] = f[1] + 1;
            } else if (f[1].equals("-") || f[1].equals("+")) {

                f[1] = f[1] + 1;
            }
            this.eqS[4] = Integer.parseInt(f[1]);

            if (f[2].equals("")) {
                f[2] = f[2] + 1;
            } else if (f[2].equals("-") || f[2].equals("+")) {

                f[2] = f[2] + 1;
            }

            this.eqS[5] = Integer.parseInt(f[2]);
            this.eTot[1] = Integer.parseInt(f[4]);

            System.out.println("Please type your third equation ( example : -x+3y-10z=15) : ");
            var3 =r.nextLine();
            var3 = var3.toLowerCase().replaceAll(" ", "").trim();
            var = var3;
            var = var.replaceAll("x", ",");
            var = var.replaceAll("y", ",");
            var = var.replaceAll("z", ",");
            var = var.replaceAll("=", ",");

            String[] g = var.split(",");

            if (g[0].equals("")) {
                g[0] = g[0] + 1;
            } else if (g[0].equals("-") || g[0].equals("+")) {

                g[0] = g[0] + 1;
            }
            this.eqS[6] = Integer.parseInt(g[0]);

            if (g[1].equals("")) {
                g[1] = g[1] + 1;
            } else if (g[1].equals("-") || g[1].equals("+")) {

                g[1] = g[1] + 1;
            }
            this.eqS[7] = Integer.parseInt(g[1]);

            if (g[2].equals("")) {
                g[2] = g[2] + 1;
            } else if (g[2].equals("-") || g[2].equals("+")) {

                g[2] = g[2] + 1;
            }

            this.eqS[8] = Integer.parseInt(g[2]);
            this.eTot[2] = Integer.parseInt(g[4]);

        } catch (Exception e) {
            System.out.println("The equation typed is incorrect! Please Try again!");
            Menu2();
        }
    }

}

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

public class Menu {
    
    //Attributes
    private Scanner r = new Scanner(System.in);
    private int eqS[] = {0, 0, 0, 0};
    private int eTot[] = {0, 0};
    private String var, var1, var2;
    
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

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    public void Menu() {

        System.out.println("Please type your first equation, it has to follow this structure = '2x+3y=10' : ");
        try {

            // Asking the user to input first equation and transforming it to lowercase
            var1 = r.nextLine();
            var1 = var1.toLowerCase().trim();

            //Replacing all spaces.
            var1 = var1.replaceAll(" ", "");

            /*
            This our logic for getting each number from equation:
            First I replace the variables x,y and the sign = for ",".
            Doing that I can later split my string by "," and get all the numbers I need.
             */
            var = var1;
            var = var.replaceAll("x", ",");
            var = var.replaceAll("y", ",");
            var = var.replaceAll("=", ",");

            // Created a String Array that will receive all the parts split from the equation typed.
            String[] e = var.split(",");

            //This condition will add up the sign "+" or "-" plus the number 1 in case the user types x or y without a coeficient.
            if (e[0].equals("")) {
                e[0] = e[0] + 1;
            } else if (e[0].equals("-") || e[0].equals("+")) {

                e[0] = e[0] + 1;
            }

            //Receiving X value:
            this.eqS[0] = Integer.parseInt(e[0]);

            //This condition will add up the sign "+" or "-" plus the number 1 in case the user types x or y without a coeficient.
            if (e[1].equals("")) {
                e[1] = e[1] + 1;
            } else if (e[1].equals("-") || e[1].equals("+")) {

                e[1] = e[1] + 1;
            }

            //Receiving Y value:
            this.eqS[1] = Integer.parseInt(e[1]);

            //Setting the constant with the rest of my split ( everything after "=".):
            this.eTot[0] = Integer.parseInt(e[3]);

            // Same logic from above but now for second equation.
            System.out.println("Please type your second equation, it has to follow this structure = '2x+3y=10' : ");
            var2 = r.nextLine().toLowerCase().trim();
            var2 = var2.replaceAll(" ", "");
            var = var2;
            var = var.replaceAll("x", ",");
            var = var.replaceAll("y", ",");
            var = var.replaceAll("=", ",");

            String[] f = var.split(",");

            if (f[0].equals("")) {
                f[0] = f[0] + 1;
            } else if (f[0].equals("-") || f[0].equals("+")) {

                f[0] = f[0] + 1;
            }

            this.eqS[2] = Integer.parseInt(f[0]);

            if (f[1].equals("")) {
                f[1] = f[1] + 1;
            } else if (f[1].equals("-") || f[1].equals("+")) {

                f[1] = f[1] + 1;
            }

            this.eqS[3] = Integer.parseInt(f[1]);

            this.eTot[1] = Integer.parseInt(f[3]);


        } catch (Exception e) {
            //In case the user type some unsuported format, the program will show an Error message and ask the user to start the process again.
            System.out.println("Invalid Equation! Please try again:");
            Menu();
        }

    }

}


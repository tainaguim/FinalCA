/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajavamatrices;

/**
 *
 * @author Taina Goncalves 2021294
 * @author Helder Camara 2021341
 * GitHub: https://github.com/tainaguim/FinalCA.git
 */

public class Matrix3x3 implements Matrix3x3Interface {

    //We have to create an object from the class where we treat the equations typed.
    Menu2 m3 = new Menu2();

    //Attributes
    private int[] coFactors = {0, 0, 0, 0, 0, 0, 0, 0, 0}; // This one stores all my cofactors, 9 positions.
    private String[] coefS = {"", "", "", "", "", "", "", "", ""};
    /* This is need in order to work
                                                            with my Matrix A as a String and show all the positive and negative signs.*/
    private String[] var = {"x", "y", "z"}; // All equations variables.
    private String eq1, eq2, eq3; // All the three Equations typed by the user.
    private int det; // Det|A|
    private float det1; // 1/Det|A| 
    private float x, y, z; // Variables used along with the code
    private float x_res, y_res, z_res; // 

    /*Constructor
    It will run the main methos from my Menu2 class which is where the user types all three equations
     */
    public Matrix3x3() {

        m3.Menu2();
    }

    //Getters and Setters
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public Menu2 getM3() {
        return m3;
    }

    public void setM3(Menu2 m3) {
        this.m3 = m3;
    }

    public int[] getCoFactors() {
        return coFactors;
    }

    public void setCoFactors(int[] coFactors) {
        this.coFactors = coFactors;
    }

    public String[] getCoefS() {
        return coefS;
    }

    public void setCoefS(String[] coefS) {
        this.coefS = coefS;
    }

    public String[] getVar() {
        return var;
    }

    public void setVar(String[] var) {
        this.var = var;
    }

    public int getDet() {
        return det;
    }

    public void setDet(int det) {
        this.det = det;
    }

    public float getDet1() {
        return det1;
    }

    public void setDet1(float det1) {
        this.det1 = det1;
    }

    public float getX_res() {
        return x_res;
    }

    public void setX_res(float x_res) {
        this.x_res = x_res;
    }

    public float getY_res() {
        return y_res;
    }

    public void setY_res(float y_res) {
        this.y_res = y_res;
    }

    public float getZ_res() {
        return z_res;
    }

    public void setZ_res(float z_res) {
        this.z_res = z_res;
    }

    public String getEq1() {
        return eq1;
    }

    public void setEq1(String eq1) {
        this.eq1 = eq1;
    }

    public String getEq2() {
        return eq2;
    }

    public void setEq2(String eq2) {
        this.eq2 = eq2;
    }

    public String getEq3() {
        return eq3;
    }

    public void setEq3(String eq3) {
        this.eq3 = eq3;
    }

    //Methods
    // Our main objective was to output step by step on our calculation showing everything to the user.
    // That is way our code got a bit bigger than expected. We have to work with many Strings and Structures.
    @Override
    public void readLEq() {

        System.out.println("============ Equations with three variables. ===================");

        //Read Equation 1
        String eq1 = "";

        //Conditions used to convert my integers to string and either add the sign "+" or keep the negative sign.
        if (m3.getEqS()[0] < 0) {
            eq1 = eq1 + String.valueOf(m3.getEqS()[0]) + this.getVar()[0] + " ";
            this.coefS[0] = String.valueOf(m3.getEqS()[0]);
        } else {
            eq1 = "+" + eq1 + String.valueOf(m3.getEqS()[0] + this.getVar()[0]) + " ";
            this.coefS[0] = "+" + String.valueOf(m3.getEqS()[0]);
        }

        if (m3.getEqS()[1] < 0) {
            eq1 = eq1 + String.valueOf(m3.getEqS()[1]) + this.getVar()[1] + " ";
            this.coefS[1] = String.valueOf(m3.getEqS()[1]);
        } else {
            eq1 = " " + eq1 + "+" + String.valueOf(m3.getEqS()[1] + this.getVar()[1]) + " ";
            this.coefS[1] = "+" + String.valueOf(m3.getEqS()[1]);
        }

        if (m3.getEqS()[2] < 0) {
            eq1 = eq1 + String.valueOf(m3.getEqS()[2]) + this.getVar()[2] + " ";
            this.coefS[2] = String.valueOf(m3.getEqS()[2]);
        } else {
            eq1 = " " + eq1 + "+" + String.valueOf(m3.getEqS()[2] + this.getVar()[2]) + " ";
            this.coefS[2] = "+" + String.valueOf(m3.getEqS()[2]);
        }

        System.out.println(eq1 + " = " + m3.geteTot()[0]);

        //Read Equation 2
        String eq2 = "";

        //Conditions used to convert my integers to string and either add the sign "+" or keep the negative sign.
        if (m3.getEqS()[3] < 0) {
            eq2 = eq2 + String.valueOf(m3.getEqS()[3]) + this.getVar()[0] + " ";
            this.coefS[3] = String.valueOf(m3.getEqS()[3]);
        } else {
            eq2 = "+" + eq2 + String.valueOf(m3.getEqS()[3] + this.getVar()[0]) + " ";
            this.coefS[3] = "+" + String.valueOf(m3.getEqS()[3]);
        }

        if (m3.getEqS()[4] < 0) {
            eq2 = eq2 + String.valueOf(m3.getEqS()[4]) + this.getVar()[1] + " ";
            this.coefS[4] = String.valueOf(m3.getEqS()[4]);
        } else {
            eq2 = " " + eq2 + "+" + String.valueOf(m3.getEqS()[4] + this.getVar()[1]) + " ";
            this.coefS[4] = "+" + String.valueOf(m3.getEqS()[4]);
        }

        if (m3.getEqS()[5] < 0) {
            eq2 = eq2 + String.valueOf(m3.getEqS()[5]) + this.getVar()[2] + " ";
            this.coefS[5] = String.valueOf(m3.getEqS()[5]);
        } else {
            eq2 = " " + eq2 + "+" + String.valueOf(m3.getEqS()[5] + this.getVar()[2]) + " ";
            this.coefS[5] = "+" + String.valueOf(m3.getEqS()[5]);
        }

        System.out.println(eq2 + " = " + m3.geteTot()[1]);

        //Read Equation 3
        String eq3 = "";
        //Conditions used to convert my integers to string and either add the sign "+" or keep the negative sign.
        if (m3.getEqS()[6] < 0) {
            eq3 = eq3 + String.valueOf(m3.getEqS()[6]) + this.getVar()[0] + " ";
            this.coefS[6] = String.valueOf(m3.getEqS()[6]);
        } else {
            eq3 = "+" + eq3 + String.valueOf(m3.getEqS()[6] + this.getVar()[0]) + " ";
            this.coefS[6] = "+" + String.valueOf(m3.getEqS()[6]);
        }

        if (m3.getEqS()[7] < 0) {
            eq3 = eq3 + String.valueOf(m3.getEqS()[7]) + this.getVar()[1] + " ";
            this.coefS[7] = String.valueOf(m3.getEqS()[7]);
        } else {
            eq3 = " " + eq3 + "+" + String.valueOf(m3.getEqS()[7] + this.getVar()[1]) + " ";
            this.coefS[7] = "+" + String.valueOf(m3.getEqS()[7]);
        }

        if (m3.getEqS()[8] < 0) {
            eq3 = eq3 + String.valueOf(m3.getEqS()[8]) + this.getVar()[2] + " ";
            this.coefS[8] = String.valueOf(m3.getEqS()[8]);
        } else {
            eq3 = " " + eq3 + "+" + String.valueOf(m3.getEqS()[8] + this.getVar()[2]) + " ";
            this.coefS[8] = "+" + String.valueOf(m3.getEqS()[8]);

            System.out.println(eq3 + " = " + m3.geteTot()[2]);

            System.out.println("===============================================================");

            //calling the following methods:
            findA();
            findX();
            findB();
            find3x3Determinant();
        }

    }

    @Override
    public void find3x3Determinant() {

        System.out.println("Determinant Formula");
        //We show the calculations step by step and the formula used is being shown below:
        System.out.println("a.e.i + b.f.g + c.d.h -(c.e.g + a.f.h + b.d.i )");
        System.out.println("================================================");
        System.out.println("Determinant A");
        System.out.println("det|A|=(" + m3.getEqS()[0] + "*" + m3.getEqS()[4] + "*" + m3.getEqS()[8] + "+"
                + m3.getEqS()[1] + "*" + m3.getEqS()[5] + "*" + m3.getEqS()[6] + "+"
                + m3.getEqS()[2] + "*" + m3.getEqS()[3] + "*" + m3.getEqS()[7] + ")-("
                + m3.getEqS()[2] + "*" + m3.getEqS()[4] + "*" + m3.getEqS()[6] + "+"
                + m3.getEqS()[0] + "*" + m3.getEqS()[5] + "*" + m3.getEqS()[7] + "+"
                + m3.getEqS()[1] + "*" + m3.getEqS()[3] + "*" + m3.getEqS()[8] + ")");

        System.out.println("det|A|=(" + m3.getEqS()[0] * m3.getEqS()[4] * m3.getEqS()[8] + "+"
                + m3.getEqS()[1] * m3.getEqS()[5] * m3.getEqS()[6] + "+"
                + m3.getEqS()[2] * m3.getEqS()[3] * m3.getEqS()[7] + ")-"
                + "(" + m3.getEqS()[2] * m3.getEqS()[4] * m3.getEqS()[6] + "+"
                + m3.getEqS()[0] * m3.getEqS()[5] * m3.getEqS()[7] + "+"
                + m3.getEqS()[1] * m3.getEqS()[3] * m3.getEqS()[8] + ")");

        System.out.print("det|A|=" + ((m3.getEqS()[0] * m3.getEqS()[4] * m3.getEqS()[8]) + (m3.getEqS()[1] * m3.getEqS()[5] * m3.getEqS()[6]) + (m3.getEqS()[2] * m3.getEqS()[3] * m3.getEqS()[7])) + "-(");
        System.out.println(((m3.getEqS()[2] * m3.getEqS()[4] * m3.getEqS()[6]) + (m3.getEqS()[0] * m3.getEqS()[5] * m3.getEqS()[7]) + (m3.getEqS()[1] * m3.getEqS()[3] * m3.getEqS()[8])) + ")");
        System.out.println("det|A|=" + (((m3.getEqS()[0] * m3.getEqS()[4] * m3.getEqS()[8]) + (m3.getEqS()[1] * m3.getEqS()[5] * m3.getEqS()[6]) + (m3.getEqS()[2] * m3.getEqS()[3] * m3.getEqS()[7])) - ((m3.getEqS()[2] * m3.getEqS()[4] * m3.getEqS()[6]) + (m3.getEqS()[0] * m3.getEqS()[5] * m3.getEqS()[7]) + (m3.getEqS()[1] * m3.getEqS()[3] * m3.getEqS()[8]))));

        //Storing my determinant
        this.setDet((((m3.getEqS()[0] * m3.getEqS()[4] * m3.getEqS()[8]) + (m3.getEqS()[1] * m3.getEqS()[5] * m3.getEqS()[6]) + (m3.getEqS()[2] * m3.getEqS()[3] * m3.getEqS()[7])) - ((m3.getEqS()[2] * m3.getEqS()[4] * m3.getEqS()[6]) + (m3.getEqS()[0] * m3.getEqS()[5] * m3.getEqS()[7]) + (m3.getEqS()[1] * m3.getEqS()[3] * m3.getEqS()[8]))));


        //Calling the following methods:
        coFactors();

    }

    @Override
    public void findA() {
        //This method only prints information:
        System.out.println("Matrix A  ");
        System.out.println("| " + this.coefS[0] + " " + this.coefS[1] + " " + this.coefS[2] + " |");
        System.out.println("| " + this.coefS[3] + " " + this.coefS[4] + " " + this.coefS[5] + " |");
        System.out.println("| " + this.coefS[6] + " " + this.coefS[7] + " " + this.coefS[8] + " |");

    }

    @Override
    public void findX() {
        //This method only prints information:
        System.out.println("Matrix X  ");
        System.out.println("| " + this.getVar()[0] + " |");
        System.out.println("| " + this.getVar()[1] + " |");
        System.out.println("| " + this.getVar()[2] + " |");

    }

    @Override
    public void findB() {
        //This method only prints information:
        System.out.println("Matrix B  ");
        System.out.println("| " + m3.geteTot()[0] + " |");
        System.out.println("| " + m3.geteTot()[1] + " |");
        System.out.println("| " + m3.geteTot()[2] + " |");
    }

    @Override
    public void coFactors() {
        //This is a very big code as it requires many strings in order for it to be explained and structured. (Integers do not show the positive sign.)
        //All the steps are showed to user when running this method.
        System.out.println("======================== CoFactors of A ======================================");
        System.out.println("Representation:");
        System.out.print(" + | " + "e f" + " |");
        System.out.print(" - | " + "d f" + " |");
        System.out.print(" + | " + "d e" + " |   = ");

        System.out.print(" + | " + this.coefS[4] + " " + this.coefS[5] + " |");
        System.out.print(" - | " + this.coefS[3] + " " + this.coefS[5] + " |");
        System.out.println(" + | " + this.coefS[3] + " " + this.coefS[4] + " |   ");

        System.out.print("   | " + "h i" + " |");
        System.out.print("   | " + "g i" + " |");
        System.out.print("   | " + "g h" + " |");

        System.out.print("        | " + this.coefS[7] + " " + this.coefS[8] + " |");
        System.out.print("   | " + this.coefS[6] + " " + this.coefS[8] + " |");
        System.out.println("   | " + this.coefS[6] + " " + this.coefS[7] + " |   ");

        System.out.println("");

        System.out.print(" - | " + "b c" + " |");
        System.out.print(" + | " + "a c" + " |");
        System.out.print(" - | " + "a b" + " |   =");

        System.out.print("  - | " + this.coefS[1] + " " + this.coefS[2] + " |");
        System.out.print(" + | " + this.coefS[0] + " " + this.coefS[2] + " |");
        System.out.println(" - | " + this.coefS[0] + " " + this.coefS[1] + " |   ");

        System.out.print("   | " + "h i" + " |");
        System.out.print("   | " + "g i" + " |");
        System.out.print("   | " + "g h" + " |");

        System.out.print("        | " + this.coefS[7] + " " + this.coefS[8] + " |");
        System.out.print("   | " + this.coefS[6] + " " + this.coefS[8] + " |");
        System.out.println("   | " + this.coefS[6] + " " + this.coefS[7] + " |   ");

        System.out.println("");

        System.out.print(" + | " + "b c" + " |");
        System.out.print(" - | " + "a c" + " |");
        System.out.print(" + | " + "a b" + " |   =");

        System.out.print("  + | " + this.coefS[1] + " " + this.coefS[2] + " |");
        System.out.print(" - | " + this.coefS[0] + " " + this.coefS[2] + " |");
        System.out.println(" + | " + this.coefS[0] + " " + this.coefS[1] + " |   ");

        System.out.print("   | " + "e f" + " |");
        System.out.print("   | " + "d f" + " |");
        System.out.print("   | " + "d e" + " |");

        System.out.print("        | " + this.coefS[4] + " " + this.coefS[7] + " |");
        System.out.print("   | " + this.coefS[3] + " " + this.coefS[5] + " |");
        System.out.println("   | " + this.coefS[3] + " " + this.coefS[4] + " |   ");

        System.out.println(" -------------------------------------------------------------------------------------------------------------------------------------------------- ");

        System.out.print(" + | " + this.coefS[4] + " * " + this.coefS[8] + "- (" + this.coefS[5] + " * " + this.coefS[7] + " ) | ");
        System.out.print(" - | " + this.coefS[3] + " * " + this.coefS[8] + "- (" + this.coefS[5] + " * " + this.coefS[6] + " ) |");
        System.out.print(" + | " + this.coefS[3] + " * " + this.coefS[7] + "- (" + this.coefS[4] + " * " + this.coefS[6] + " ) | = ");

        System.out.print(" + | " + (m3.getEqS()[4] * m3.getEqS()[8]) + " - (" + (m3.getEqS()[5] * m3.getEqS()[7]) + " ) | ");
        System.out.print(" - | " + (m3.getEqS()[3] * m3.getEqS()[8]) + " - (" + (m3.getEqS()[5] * m3.getEqS()[6]) + " ) | ");
        System.out.print(" + | " + (m3.getEqS()[3] * m3.getEqS()[7]) + " - (" + (m3.getEqS()[4] * m3.getEqS()[6]) + " ) | ");
        System.out.println("");

        System.out.print(" - | " + this.coefS[1] + " * " + this.coefS[8] + "- (" + this.coefS[2] + " * " + this.coefS[7] + " ) |");
        System.out.print("  + | " + this.coefS[0] + " * " + this.coefS[8] + "- (" + this.coefS[2] + " * " + this.coefS[6] + " ) |");
        System.out.print(" - | " + this.coefS[0] + " * " + this.coefS[7] + "- (" + this.coefS[1] + " * " + this.coefS[6] + " ) |");

        System.out.print("    - | " + (m3.getEqS()[1] * m3.getEqS()[8]) + " - (" + (m3.getEqS()[2] * m3.getEqS()[7]) + " ) | ");
        System.out.print(" + | " + (m3.getEqS()[0] * m3.getEqS()[8]) + " - (" + (m3.getEqS()[2] * m3.getEqS()[6]) + " ) | ");
        System.out.println(" - | " + (m3.getEqS()[0] * m3.getEqS()[7]) + " - (" + (m3.getEqS()[1] * m3.getEqS()[6]) + " ) | ");

        System.out.print(" + | " + this.coefS[1] + " * " + this.coefS[5] + "- (" + this.coefS[2] + " * " + this.coefS[4] + " ) | ");
        System.out.print(" - | " + this.coefS[0] + " * " + this.coefS[5] + "- (" + this.coefS[2] + " * " + this.coefS[3] + " ) |");
        System.out.print(" + | " + this.coefS[0] + " * " + this.coefS[4] + "- (" + this.coefS[1] + " * " + this.coefS[3] + " ) |   ");

        System.out.print(" + | " + (m3.getEqS()[1] * m3.getEqS()[5]) + " - (" + (m3.getEqS()[2] * m3.getEqS()[4]) + " ) | ");
        System.out.print(" - | " + (m3.getEqS()[0] * m3.getEqS()[5]) + " - (" + (m3.getEqS()[2] * m3.getEqS()[3]) + " ) | ");
        System.out.println(" + | " + (m3.getEqS()[0] * m3.getEqS()[4]) + " - (" + (m3.getEqS()[1] * m3.getEqS()[3]) + " ) | ");

        System.out.println(" -------------------------------------------------------------------------------------------------------------------------------------------------- ");

        //COFACTORS ROW 1
        System.out.print(" | +( " + ((m3.getEqS()[4] * m3.getEqS()[8]) - (m3.getEqS()[5] * m3.getEqS()[7])) + " )");
        System.out.print(" -( " + ((m3.getEqS()[3] * m3.getEqS()[8]) - (m3.getEqS()[5] * m3.getEqS()[6])) + " )");
        System.out.print(" +( " + ((m3.getEqS()[3] * m3.getEqS()[7]) - (m3.getEqS()[4] * m3.getEqS()[6])) + " ) |");

        //Setting Cofactors Array`s positions
        this.coFactors[0] = ((m3.getEqS()[4] * m3.getEqS()[8]) - (m3.getEqS()[5] * m3.getEqS()[7]));
        this.coFactors[1] = ((m3.getEqS()[3] * m3.getEqS()[8]) - (m3.getEqS()[5] * m3.getEqS()[6])) * -1;
        this.coFactors[2] = ((m3.getEqS()[3] * m3.getEqS()[7]) - (m3.getEqS()[4] * m3.getEqS()[6]));

        System.out.print("       | " + this.getCoFactors()[0]);
        System.out.print("  " + this.getCoFactors()[1]);
        System.out.print("  " + this.getCoFactors()[2] + " |");

        System.out.println("");

        //COFACTORS ROW 2
        System.out.print(" | -( " + ((m3.getEqS()[1] * m3.getEqS()[8]) - (m3.getEqS()[2] * m3.getEqS()[7])) + " )");
        System.out.print(" +( " + ((m3.getEqS()[0] * m3.getEqS()[8]) - (m3.getEqS()[2] * m3.getEqS()[6])) + " )");
        System.out.print(" -( " + ((m3.getEqS()[0] * m3.getEqS()[7]) - (m3.getEqS()[1] * m3.getEqS()[6])) + " ) |   =  ");

        //Setting Cofactors Array`s positions
        this.coFactors[3] = (((m3.getEqS()[1] * m3.getEqS()[8]) - (m3.getEqS()[2] * m3.getEqS()[7])) * -1);
        this.coFactors[4] = (((m3.getEqS()[0] * m3.getEqS()[8]) - (m3.getEqS()[2] * m3.getEqS()[6])));
        this.coFactors[5] = (((m3.getEqS()[0] * m3.getEqS()[7]) - (m3.getEqS()[1] * m3.getEqS()[6])) * -1);

        System.out.print("  | " + this.getCoFactors()[3]);
        System.out.print("  " + this.getCoFactors()[4]);
        System.out.println("  " + this.getCoFactors()[5] + "   |");

        // COFACTORS ROW 3
        System.out.print(" | +( " + ((m3.getEqS()[1] * m3.getEqS()[5]) - (m3.getEqS()[2] * m3.getEqS()[4])) + " )");
        System.out.print(" -( " + ((m3.getEqS()[0] * m3.getEqS()[5]) - (m3.getEqS()[2] * m3.getEqS()[3])) + " )");
        System.out.print(" +( " + ((m3.getEqS()[0] * m3.getEqS()[4]) - (m3.getEqS()[1] * m3.getEqS()[3])) + " ) |");

        //Setting Cofactors Array`s positions
        this.coFactors[6] = (((m3.getEqS()[1] * m3.getEqS()[5]) - (m3.getEqS()[2] * m3.getEqS()[4])));
        this.coFactors[7] = (((m3.getEqS()[0] * m3.getEqS()[5]) - (m3.getEqS()[2] * m3.getEqS()[3])) * -1);
        this.coFactors[8] = (((m3.getEqS()[0] * m3.getEqS()[4]) - (m3.getEqS()[1] * m3.getEqS()[3])));

        System.out.print("          | " + this.getCoFactors()[6]);
        System.out.print("  " + this.getCoFactors()[7]);
        System.out.println("  " + this.getCoFactors()[8] + "    |");

        //Calling the following methods:
        transposeA();

    }

    @Override
    public void transposeA() {

        //This method transpose the matrix cofactors of A
        //Colums are now Rows and Rows are no Columns.
        System.out.println("\n=================== Tranposing CoFactors of A =============================\n");

        System.out.print("                | " + this.getCoFactors()[0] + " " + this.getCoFactors()[1] + " " + this.getCoFactors()[2] + "   |");
        System.out.println("                                | " + this.getCoFactors()[0] + " " + this.getCoFactors()[3] + " " + this.getCoFactors()[6] + "   |");
        System.out.print("CoFactors(A) = ");
        System.out.print(" | " + this.getCoFactors()[3] + " " + this.getCoFactors()[4] + " " + this.getCoFactors()[5] + "   | = ");
        System.out.print("    Transpose CoFactors(A) = ");
        System.out.println("  | " + this.getCoFactors()[1] + " " + this.getCoFactors()[4] + " " + this.getCoFactors()[7] + "   |");
        System.out.print("                | " + this.getCoFactors()[6] + " " + this.getCoFactors()[7] + " " + this.getCoFactors()[8] + "   |");
        System.out.println("                                   | " + this.getCoFactors()[2] + " " + this.getCoFactors()[5] + " " + this.getCoFactors()[8] + "   |");

        //Calling the following methods:
        readFinalResult();
    }

    @Override
    public void readFinalResult() {

        //This method continues the calculations and not only show the user the final values of X,Y and Z , but also store them in attributes.
        System.out.println("");
        System.out.println("===================================== Final Result ======================================================");
        System.out.println("");
        System.out.println("Formula : 1/det|A| *( Transpose Cofactor(A)  * B)\n");
        System.out.print("        |" + this.getCoFactors()[0] + " " + this.getCoFactors()[3] + " " + this.getCoFactors()[6] + " |");
        System.out.println("    | " + m3.geteTot()[0] + " |");
        System.out.print("1/" + this.getDet() + " * ");
        System.out.print(" |" + this.getCoFactors()[1] + " " + this.getCoFactors()[4] + " " + this.getCoFactors()[7] + " |  *");
        System.out.println("  | " + m3.geteTot()[1] + " |");

        System.out.print("        |" + this.getCoFactors()[2] + " " + this.getCoFactors()[5] + " " + this.getCoFactors()[8] + " |");
        System.out.println("     | " + m3.geteTot()[2] + " |\n");

        System.out.print("1/" + this.getDet() + " * ");
        System.out.println("|" + (this.getCoFactors()[0] * m3.geteTot()[0]) + " + (" + (this.getCoFactors()[3] * m3.geteTot()[1]) + ") + (" + (this.getCoFactors()[6] * m3.geteTot()[2]) + ") |");
        System.out.println("       |" + (this.getCoFactors()[1] * m3.geteTot()[0]) + " + (" + (this.getCoFactors()[4] * m3.geteTot()[1]) + ") + (" + (this.getCoFactors()[7] * m3.geteTot()[2]) + ") |");
        System.out.println("       |" + (this.getCoFactors()[2] * m3.geteTot()[0]) + " + (" + (this.getCoFactors()[5] * m3.geteTot()[1]) + ") + (" + (this.getCoFactors()[8] * m3.geteTot()[2]) + ") |");

        System.out.print("\n1/" + this.getDet() + " * ");

        //Setting the values of X,Y and Z before the multiplication by the det|A|.
        this.setX((this.getCoFactors()[0] * m3.geteTot()[0]) + (this.getCoFactors()[3] * m3.geteTot()[1]) + (this.getCoFactors()[6] * m3.geteTot()[2]));
        this.setY(((this.getCoFactors()[1] * m3.geteTot()[0]) + (this.getCoFactors()[4] * m3.geteTot()[1]) + (this.getCoFactors()[7] * m3.geteTot()[2])));
        this.setZ(((this.getCoFactors()[2] * m3.geteTot()[0]) + (this.getCoFactors()[5] * m3.geteTot()[1]) + (this.getCoFactors()[8] * m3.geteTot()[2])));

        //Setting 1/Determinant|A| and using it
        this.setDet1(((1f) / (this.getDet())));
        System.out.print("|" + this.getX() + " |");
        System.out.println("        X = | " + (((this.getDet1()) * (this.getX()))) + "   |");
        System.out.print("       |" + (this.getY()) + " |   = ");
        System.out.println("  Y = | " + ((this.getDet1()) * (this.getY())) + "   |");
        System.out.print("       |" + this.getZ() + " |");
        System.out.println("        Z = | " + ((this.getDet1()) * (this.getZ())) + "   |");

        //Setting the values of X,Y and Z after the multiplication by the det|A|.
        this.setX_res(((this.getDet1()) * (this.getX())));
        this.setY_res(((this.getDet1()) * (this.getY())));
        this.setZ_res(((this.getDet1()) * (this.getZ())));

        //Calling the following methods:
        storeEquationsTyped();

    }

    @Override
    public void storeEquationsTyped() {
        //This method only sets the equations typed by the user. It will later be used and sent to the database
        this.setEq1(m3.getVar1());
        this.setEq2(m3.getVar2());
        this.setEq3(m3.getVar3());
    }

}

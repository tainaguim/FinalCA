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
public class Matrix2by2 implements Matrix2by2Interface {
    
    //Instantiation of my class menu which is responsible for receiving and 
    //treating the equations typed by the user.
    Menu m = new Menu();

    //Attributes
    private String[] coefS = {"", "", "", ""}; // This attribute was created in order to store each position from my equatios as a String
    private String[] var = {"x", "y"};  // Atribute created just for showing X and Y as string
    private int det; // This attribute stores the determinant of matrix A
    private float det1; //This attribute stores 1 / whatever the attribute det value is. 
    private String eq1, eq2; // Attribute created in order to store the equations typed by the users.
    private float x_res, y_res; // Final values for X and Y once the calculation is completed

    //Constructor
    /**
     * This constructor will run my initial method every time an object of this
     * class is created/instantiated
     */
    public Matrix2by2() {
        
        // My constructor will run this object first which will ask the users for inputs.
        m.Menu();

    }

    // Getters and Setters
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

    //Methods
    // Our main objective was to output step by step on our calculation showing everything to the user.
    // That is way our code got a bit bigger than expected. We have to work with many Strings and Structures.
    @Override

    public void readLEq() {

        String eq1 = "";
        String eq2 = "";

        System.out.println("============ Equations with two variables. ===================");

        //Conditions used to convert my integers to string and either add the sign "+" or keep the negative sign.
        if (m.getEqS()[0] < 0) {
            eq1 = eq1 + String.valueOf(m.getEqS()[0]) + this.getVar()[0] + " ";
            this.coefS[0] = String.valueOf(m.getEqS()[0]);
        } else {
            eq1 = "+" + eq1 + String.valueOf(m.getEqS()[0] + this.getVar()[0]) + " ";
            this.coefS[0] = "+" + String.valueOf(m.getEqS()[0]);
        }

        if (m.getEqS()[1] < 0) {
            eq1 = eq1 + String.valueOf(m.getEqS()[1]) + this.getVar()[1] + " ";
            this.coefS[1] = String.valueOf(m.getEqS()[1]);
        } else {
            eq1 = " " + eq1 + "+" + String.valueOf(m.getEqS()[1] + this.getVar()[1]) + " ";
            this.coefS[1] = "+" + String.valueOf(m.getEqS()[1]);
        }

        //Printing second equation typed.
        System.out.println(eq1 + " = " + m.geteTot()[0]);

        //Conditions used to convert my integers to string and either add the sign "+" or keep the negative sign.
        if (m.getEqS()[2] < 0) {
            eq2 = eq2 + String.valueOf(m.getEqS()[2]) + this.getVar()[0] + " ";
            this.coefS[2] = String.valueOf(m.getEqS()[2]);
        } else {
            eq2 = "+" + eq2 + String.valueOf(m.getEqS()[2] + this.getVar()[0]) + " ";
            this.coefS[2] = "+" + String.valueOf(m.getEqS()[2]);
        }

        if (m.getEqS()[3] < 0) {
            eq2 = eq2 + String.valueOf(m.getEqS()[3]) + this.getVar()[1] + " ";
            this.coefS[3] = String.valueOf(m.getEqS()[3]);
        } else {
            eq2 = " " + eq2 + "+" + String.valueOf(m.getEqS()[3] + this.getVar()[1]) + " ";
            this.coefS[3] = "+" + String.valueOf(m.getEqS()[3]);
        }
        //Printing second equation typed.
        System.out.println(eq2 + " = " + m.geteTot()[1]);

        System.out.println("===============================================================");
        //calling the following methods:
        findA();
        findX();
        findB();
        find2x2Determinant();
    }

    @Override
    public void find2x2Determinant() {

        System.out.println("================================================");
        System.out.println("Determinant Formula");
        System.out.println("a.d - c.b");
        System.out.println("================================================");
        System.out.println("Determinant A");
        // This method is responsible for calculating the Determinant of A by using getter and setters to calculate all the necessary positions 
        // in my arrays.
        System.out.println("det|A|= " + m.getEqS()[0] + " * " + m.getEqS()[3] + " -( " + m.getEqS()[1] + " * " + m.getEqS()[2] + ")");
        System.out.println("det|A|= " + m.getEqS()[0] * m.getEqS()[3] + "- (" + m.getEqS()[1] * m.getEqS()[2] + ")");
        System.out.print("det|A|= ");
        System.out.println(m.getEqS()[0] * m.getEqS()[3] + (m.getEqS()[1] * m.getEqS()[2]) * -1);
        this.setDet(m.getEqS()[0] * m.getEqS()[3] + (m.getEqS()[1] * m.getEqS()[2]) * -1);
        System.out.println("=================================================");

        //calling the following method:
        findInverseA();

    }

    @Override
    //This method only prints out .
    public void findA() {
        System.out.println("Matrix A  ");
        System.out.println("| " + m.getEqS()[0] + " " + m.getEqS()[1] + " |");
        System.out.println("| " + m.getEqS()[2] + " " + m.getEqS()[3] + " |");

    }

    @Override
    //This method only prints out .
    public void findX() {
        System.out.println("Matrix X  ");
        System.out.println("| " + this.getVar()[0] + " |");
        System.out.println("| " + this.getVar()[1] + " |");
    }

    @Override
    //This method only prints out .
    public void findB() {
        System.out.println("Matrix B  ");
        System.out.println("| " + m.geteTot()[0] + " |");
        System.out.println("| " + m.geteTot()[1] + " |");
    }

    @Override
    public void findInverseA() {
        // This code only shows the user what the Inverse of A looks like 
        System.out.println("Inverse of A");
        System.out.print("|  d -b |  ");

        //Conditions used to convert my integers to string and either add the sign "+" or keep the negative sign.
        if (m.getEqS()[3] < 1) {
            this.coefS[3] = String.valueOf(m.getEqS()[3]);

        } else {
            this.coefS[3] = "+" + String.valueOf(m.getEqS()[3]);
        }

        if ((m.getEqS()[1] * -1) < 0) {
            this.coefS[1] = String.valueOf(m.getEqS()[1] * -1);

        } else {
            this.coefS[1] = "+" + String.valueOf(m.getEqS()[1] * -1);
        }

        System.out.println(" | " + this.getCoefS()[3] + " " + this.getCoefS()[1] + " |");

        System.out.print("| -c  a | = ");

        if (m.getEqS()[0] < 1) {
            this.coefS[0] = String.valueOf(m.getEqS()[0]);

        } else {
            this.coefS[0] = "+" + String.valueOf(m.getEqS()[0]);
        }

        if ((m.getEqS()[2] * -1) < 0) {
            this.coefS[2] = String.valueOf(m.getEqS()[2] * -1);

        } else {
            this.coefS[2] = "+" + String.valueOf(m.getEqS()[2] * -1);
        }

        System.out.println("| " + this.getCoefS()[2] + " " + this.getCoefS()[0] + " |");
        System.out.println("");

        //calling the following method:
        readFinalResult();
    }

    @Override
    public void readFinalResult() {

        //This method is a little bit confusing, but it is just because we worked with many strings and visual structures.
        //This code will not only make calculations but show the user the most important and final step of the calculation.
        System.out.println("=============== Final Result formula. ======================");
        System.out.println("X = ( A^-1 . B ). 1/det|A| ");
        System.out.println("");
        System.out.print("X = ");
        System.out.print(" | " + this.getCoefS()[3] + " " + this.getCoefS()[1] + " |");
        System.out.print("   | " + m.geteTot()[0] + " |");
        System.out.print("   | " + this.getCoefS()[3] + "" + m.geteTot()[0] + "+(" + this.getCoefS()[1] + "" + m.geteTot()[1] + ")|");
        System.out.println("  | " + (m.getEqS()[3] * m.geteTot()[0] + Integer.parseInt(this.getCoefS()[1]) * m.geteTot()[1]) + " |");
        System.out.print("     ");
        System.out.print("| " + this.getCoefS()[2] + " " + this.getCoefS()[0] + " |");
        System.out.print(" . ");
        System.out.print("| " + m.geteTot()[1] + " |");
        System.out.print(" = ");
        System.out.print("| " + this.getCoefS()[2] + "" + m.geteTot()[0] + "+(" + this.getCoefS()[0] + "" + m.geteTot()[1] + ")|");
        System.out.print(" =");
        System.out.println("| " + (Integer.parseInt(this.getCoefS()[2]) * m.geteTot()[0] + Integer.parseInt(this.getCoefS()[0]) * m.geteTot()[1]) + "  |");
        System.out.println("------------------------------------------------------------------");
        System.out.print("X = | " + (m.getEqS()[3] * m.geteTot()[0] + Integer.parseInt(this.getCoefS()[1]) * m.geteTot()[1]) + " |");
        System.out.print("     1 /" + this.getDet());
        
        // 1/det|A|
        this.det1 = 1.00f / this.getDet();
        
        System.out.println("   X |" + (this.det1 * (m.getEqS()[3] * m.geteTot()[0] + Integer.parseInt(this.getCoefS()[1]) * m.geteTot()[1])) + " |");
        System.out.print("    | " + (Integer.parseInt(this.getCoefS()[2]) * m.geteTot()[0] + Integer.parseInt(this.getCoefS()[0]) * m.geteTot()[1]) + "  |");
        System.out.print(" . ");
        System.out.print("      = ");
        System.out.println("   Y |" + (this.det1 * (Integer.parseInt(this.getCoefS()[2]) * m.geteTot()[0] + Integer.parseInt(this.getCoefS()[0]) * m.geteTot()[1])) + " |");
        
        //Setting my final values of X and Y into my attributes:
        this.setX_res((this.det1 * (m.getEqS()[3] * m.geteTot()[0] + Integer.parseInt(this.getCoefS()[1]) * m.geteTot()[1])));
        this.setY_res((this.det1 * ((Integer.parseInt(this.getCoefS()[2]) * (m.geteTot()[0]) + (Integer.parseInt(this.getCoefS()[0]) * m.geteTot()[1])))));

        //calling the following method:
        storeEquationsTyped();

    }

    @Override
    public void storeEquationsTyped() {
        // This method only stores the equations type 
        //previously in attributes which will be later sent to DB along with other attributes.
        this.setEq1(m.getVar1());
        this.setEq2(m.getVar2());

    }

}

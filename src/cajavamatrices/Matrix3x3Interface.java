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

public interface Matrix3x3Interface {

    /**
     * This method will only print out the equations typed by the user which can
     * be used later as a reference in case he forgets what he typed. This is my
     * initial method and it will call the following method when finished.
     */
    public abstract void readLEq();

    /**
     * This method will calculate the 3x3 matrix det|A|. Formula used: (a.e.i +
     * b.f.g + c.d.h ) - (c.e.g + a.f.h + b.d.i) Each variable mentioned in my
     * formula refers to one position in my Matrix.
     */
    public abstract void find3x3Determinant();

    /**
     * Method used only to prints out the Matrix A. That is one of the reasons
     * why we have created an array to store numbers as Strings. Wanted to keep
     * positive and negative signs.
     */
    public abstract void findA();

    /**
     * Method used only to prints out the Matrix X. That is one of the reasons
     * why we have created an array to store numbers as Strings. Wanted to keep
     * positive and negative signs.
     */
    public abstract void findX();

    /**
     * Method used only to prints out the Matrix B. That is one of the reasons
     * why we have created an array to store numbers as Strings. Wanted to keep
     * positive and negative signs.
     */
    public abstract void findB();

    /**
     * This method calculates step by step all the cofactors of Matrix A it is a
     * big code and requires many lines of codes as we have shown step by step
     * and tried to structure it visually.
     */
    public abstract void coFactors();

    /**
     * This is the transposition of the matrix Cofactors of A . This step is
     * necessary in order to get to the final result.
     */
    public abstract void transposeA();

    /**
     * Method used to show the user the final results of X,Y and Z. 
     * Formula used :
     * (1 / det|A|)* (cofactorsofA Transposed * B).
     */
    public abstract void readFinalResult();

    /**
     * Method used simply to be storing the variables typed in attributes which
     * can be accessed by other classes or methods
     */
    public abstract void storeEquationsTyped();

}


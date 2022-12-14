/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import cajavamatrices.Matrix2by2;
import cajavamatrices.Matrix3x3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author Taina Goncalves 2021294
 * @author Helder Camara 2021341
 * GitHub: https://github.com/tainaguim/FinalCA.git
 */

public class DbInteraction {

    //Attributes 
    private String name, lastname, username, password, eq1, eq2, eq3;
    private int id, type, equations;
    private float det, x, y, z;

    //Constructor
    public DbInteraction() throws Exception {
        //This constructor will call the first method from this class and that method will call the others 
        signInOut();

    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getEquations() {
        return equations;
    }

    public void setEquations(int equations) {
        this.equations = equations;
    }

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

    public float getDet() {
        return det;
    }

    public void setDet(float det) {
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

    public String getEq3() {
        return eq3;
    }

    public void setEq3(String eq3) {
        this.eq3 = eq3;
    }

    // Instantiating object Scanner and creating a new Scanner Object
    Scanner s = new Scanner(System.in);

    /**
     * Method used simply to get connection with my database.
     */
    public Connection getConnection() throws Exception {

        try {

            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/ca_database";
            String username = "root";
            String password = "root";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);

            return conn;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

    }

    /**
     * This is the first Menu in this program, it is where everything begins.
     */
    public void signInOut() throws Exception {

        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Please select one of the following options :");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1) Sign-in if you are already a user.");
        System.out.println("2) Sign-up if you create a new user.");
        System.out.println("3) Exit.");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

        String sign = s.next();
        //This condition is used to check if the option chosen by the user is valid and avoid the program to crash
        if (!sign.matches("[0-9]+")) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Not a valid option!");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");

            //If this program returns an Error message it restarts the moethod by calling it again.
            signInOut();

        } else {
            // If the user choose one of the correction options, it will lea him to a different method dependind on his choice.
            switch (Integer.parseInt(sign)) {
                case 1:

                    userValidator();
                    break;

                case 2:
                    userCreation();
                    break;

                case 3:
                    break;

                default:

                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Not a valid option!");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    signInOut();
            }
        }

    }

    /**
     * This is the user creation. It has connection with our Database. This is
     * where the user starts the registration.
     */
    public void userCreation() throws Exception {
        try {

            //New Name
            System.out.println("User Registration:");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Please type your name:");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            String name = s.next();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Would you like to confirm the name " + name + "? Type 1 if you want to continue and 0 if you want to cancel:");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");

            String cancel = s.next();

            if (!cancel.matches("[0-9]+")) {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Not a valid option!");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                signInOut();

            } else {
                //This switch is used all the way through registration with the same pattern.
                //It gives the user the option to cancel the proccess and go back to the Main menu.
                switch (Integer.parseInt(cancel)) {
                    case 0:

                        signInOut();
                        break;
                    case 1:
                        //In case of confirmation it stores the users Name in an attribute and calls the next method.
                        this.setName(name);
                        newLastName();
                        break;
                    default:
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Not a valid option!");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        signInOut();
                }
            }

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    /**
     * This the Last Name creation. It has connection with our Database. For
     * every option available during the registration, the program will ask the
     * user if he wants to confirm the option previously typed by him or cancel
     * it.
     */
    public void newLastName() throws Exception {
        try {
            //New Last Name ---- follows the same model as the method userCreation commented above.
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Please type your last name:");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            String lastName = s.next();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Would you like to confirm the last name " + lastName + "? Type 1 if you want to continue and 0 if you want to cancel:");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            String cancel = s.next();
            if (!cancel.matches("[0-9]+")) {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Not a valid option!");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                signInOut();
            } else {

                switch (Integer.parseInt(cancel)) {
                    case 0:
                        signInOut();

                        break;
                    case 1:
                        //If confirmed set the last name and go to the next method.
                        this.setLastname(lastName);
                        newUserName();
                        break;
                    default:
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Not a valid option!");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

                }
            }

        } catch (Exception e) {
        }

    }

    /**
     * This is the username creation. It has connection with our Database. For
     * every option available during the registration, the program will ask the
     * user if he wants to confirm the option previously typed by him or cancel
     * it. If the username chosen already exist, it wont let the user choose it
     * and will let him know.
     */
    public void newUserName() throws Exception {

        try {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Please type your username (this username will be used as your log-in.):");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            String username = s.next();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Would you like to confirm the username " + username + "? Type 1 if you want to continue and 0 if you want to cancel:");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            String cancel = s.next();
            if (!cancel.matches("[0-9]+")) {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Not a valid option!");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                signInOut();
            } else {
                switch (Integer.parseInt(cancel)) {
                    case 0:
                        signInOut();
                        break;
                    case 1:
                        //Sets the username in a attribute.
                        this.setUsername(username);
                        //Calls this method to check if the username already exists in the Database.
                        alreadyAUser(username);
                        //Calls the method Password to proceed with the registration case the username is new.
                        newPassword();

                        break;
                    default:
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Not a valid option!");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        signInOut();
                }
            }
        } catch (Exception e) {
        }

    }

    /**
     * This the password creation. It has connection with our Database. For
     * every option available during the registration, the program will ask the
     * user if he wants to confirm the option previously typed by him or cancel
     * it.
     */
    public void newPassword() throws Exception {

        try {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Please type your new password :");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            String password = s.next();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Would you like to confirm the password " + password + "? Type 1 if you want to continue and 0 if you want to cancel:");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            String cancel = s.next();
            if (!cancel.matches("[0-9]+")) {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Not a valid option!");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                signInOut();
            } else {
                switch (Integer.parseInt(cancel)) {
                    case 0:
                        signInOut();
                        break;
                    case 1:
                        //Stores the password chosen in an attribute.
                        this.setPassword(password);
                        /*Sets the usertype : For every new user, the user type is set up as 2- Regular user. 
                        Only Admins can make a Regular User become an Admin.
                         */
                        this.setType(2);

                        /*After the user confirms the last step of the registration. All the information stored will be sent to the database.
                        this update has to be done at the very last step as we do not want to fill the database with any info in case user cancels
                        the registration.
                         */
                        insertIntoUser();
                        break;
                    default:
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Not a valid option!");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

                }
            }
        } catch (Exception e) {
        }

    }

    /**
     * This method uses the SQL command INSERT INTO to add new user`s
     * information to our database. It has connection with our Database. This
     * method depends on the other registration methods.
     */
    public void insertIntoUser() throws Exception {

        try {

            Connection con = getConnection();
            String query = "INSERT INTO users(user_name,user_last_name,user_username,user_password,user_type,user_status )" + "values (?,?,?,?,?,'" + 1 + "')";
            PreparedStatement insert = con.prepareStatement(query);
            insert.setString(1, this.getName());
            insert.setString(2, this.getLastname());
            insert.setString(3, this.getUsername());
            insert.setString(4, this.getPassword());
            insert.setInt(5, this.getType());
            insert.executeUpdate();

            con.close();
            insert.close();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Registration Completed!");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            signInOut();
        }
    }

    /**
     * This is the Menu for the Admins. It has no connection with our Database.
     * This menu has more options than the one that Regular Users can access.
     */
    public void menuAdmin() throws Exception {

        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Admin Menu");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Please type one of the options below:");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1) Visualize, Modify or Delete user`s information: ");
        System.out.println("2) Solve Equations: ");
        System.out.println("3) See equation`s log: ");
        System.out.println("4) Exit: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        String option = s.next();

        if (!option.matches("[0-9]+")) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Not a valid option!");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            menuAdmin();
        } else {
            switch (Integer.parseInt(option)) {
                //This is a menu that will lead the Admin through the option chosen by calling other methods.
                case 1:
                    allUsers();

                    break;

                case 2:
                    solveEquations();
                    break;

                case 3:
                    getLog();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Not a valid option!");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    menuAdmin();
            }
        }
    }

    /**
     * This is the Menu for the Regular Users. It has no connection with our
     * Database. This menu has limited access.
     */
    public void menuUser() throws Exception {

        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("User Menu");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1) Modify own profile: ");
        System.out.println("2) Solve Equations: ");
        System.out.println("3) Exit: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        String option = s.next();
        if (!option.matches("[0-9]+")) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Not a valid option!");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            menuUser();
        } else {

            switch (Integer.parseInt(option)) {
                //This switch will guide the Regular User through the option chosen .
                case 1:
                    modifyOwnUser(this.getUsername());
                    break;
                case 2:
                    solveEquations();
                    break;

                case 3:
                    signInOut();
                    break;
                default:
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Not a valid option!");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            }

        }

    }

    /**
     * This method uses the SQL Query : SELECT to return information from the
     * Database. It has connection with our Database. This method returns a list
     * with all users in our DB. This method also act as a Menu giving you
     * options to modify the user`s information.
     */
    public void allUsers() throws Exception {

        try {

            Connection con = getConnection();
            PreparedStatement select = con.prepareStatement("SELECT user_id,user_name FROM users WHERE user_status='" + 1 + "'");
            ResultSet result = select.executeQuery();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ID| Name:");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            while (result.next()) {
                // Only the user id (PK) and name are returned.
                System.out.println(result.getString("user_id") + " | " + result.getString("user_name"));

            }

            con.close();
            select.close();
            result.close();

            // Menu that leads to the user`s modification.
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Would you like to modify any user?");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("1) Type 1 for user modification :");
            System.out.println("2) Type 2 for deleting a user :");
            System.out.println("3) Type 3 to cancel this operation :");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");

            String option = s.next();

            if (!option.matches("[0-9]+")) {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Not a valid option!");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                allUsers();
            } else {

                switch (Integer.parseInt(option)) {
                    case 1:
                        /*After seeing a list with all users and their respective IDs,
                        the admin has to type the ID related to the user he wants to change.
                         */
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Type the ID for the user you want to modify:");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        String id = s.next();

                        if (!id.matches("[0-9]+")) {
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Not a valid option!");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            allUsers();
                        } else {
                            idCheck(Integer.parseInt(id));
                            modifyAllUsers(Integer.parseInt(id));
                        }

                        break;

                    case 2:

                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Type the ID for the user you want to delete:");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        String deleteId = s.next();

                        if (!deleteId.matches("[0-9]+")) {
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Not a valid option!");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            allUsers();
                        } else {
                            idCheck(Integer.parseInt(deleteId));
                            deleteUser(Integer.parseInt(deleteId));
                        }

                        break;

                    case 3:
                        goBackAdmin();
                        break;
                    default:
                        goBackAdmin();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method goes back to Admin`s Menu. It has no connection with the
     * Database.
     */
    public void goBackAdmin() throws Exception {

        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("What Would you like to do next?");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Type 1 to go back to the Admin`s Menu:");
        System.out.println("Type 2 to go back to Login Menu:");
        System.out.println("Type 3 to Exit:");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

        String option = s.next();

        if (!option.matches("[0-9]+")) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Not a valid option!");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            goBackAdmin();

        } else {

            switch (Integer.parseInt(option)) {
                case 1:
                    // Confirming if the Admin type is equals to 1.
                    if (this.getType() == 1) {
                        menuAdmin();
                    } else {
                        menuUser();
                    }
                    break;

                case 2:
                    signInOut();
                    break;

                case 3:

                    break;

                default:
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Invalid Option! Please Try again");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    goBackAdmin();
            }
        }
    }

    /**
     * This method goes back to the User`s Menu. It has no connection with the
     * Database.
     */
    public void goBackUser() throws Exception {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("What Would you like to do next?");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Type 1 to go back to User`s Menu:");
        System.out.println("Type 2 to go back to Login Menu:");
        System.out.println("Type 3 to Exit:");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

        String option = s.next();

        if (!option.matches("[0-9]+")) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Not a valid option!");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            goBackUser();
        } else {
            switch (Integer.parseInt(option)) {
                case 1:
                    menuUser();
                    break;

                case 2:
                    signInOut();
                    break;

                case 3:

                    break;

                default:
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Invalid Option! Please Try again");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    goBackUser();

            }
        }
    }

    /**
     * This method is called whenever an user choose to solve equations.. It has
     * no connection to the DB yet.
     */
    public void solveEquations() throws Exception {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Solve Simultaneous Equations:");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("1) Please type 1 if you want to solve Simultaneous Equations with 2 equations:");
        System.out.println("2) Please type 2 if you want to solve Simultaneous Equations with 3 equations:");
        System.out.println("3) Please type 3 if you want to go back to the Main Menu:");
        System.out.println("4) Please type 4 if you want to go back to Login Menu:");
        System.out.println("5) Please type 5 to Exit the program:");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

        String option = s.next();

        if (!option.matches("[0-9]+")) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Not a valid option!");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            solveEquations();
        } else {

            switch (Integer.parseInt(option)) {
                case 1:
                    /*In case the user decides to solve 2 simultaneous equations:
                    *An object of my Matrix 2x2 class is created.
                     */
                    Matrix2by2 m1 = new Matrix2by2();
                    //First method runs and it is responsible for calling other methods within the class.
                    m1.readLEq();
                    //I set all the information I need to be sent to our Database and create a log.
                    this.setEq1(m1.getEq1());
                    this.setEq2(m1.getEq2());
                    //In 2 simultaneous equations, there is not a third one therefore, it is set as "N/A".
                    this.setEq3("N/A");
                    this.setDet(m1.getDet());
                    this.setX(m1.getX_res());
                    this.setY(m1.getY_res());
                    //Calls the comand that sends it to the DB.
                    eq2ToDb();

                    if (this.getType() == 1) {
                        goBackAdmin();
                    } else {
                        goBackUser();
                    }

                    break;

                case 2:
                    /*In case the user decides to solve 3 simultaneous equations:
                    *An object of my Matrix 3x3 class is created.
                     */
                    Matrix3x3 m2 = new Matrix3x3();
                    //First method runs and it is responsible for calling other methods within the class.
                    m2.readLEq();
                    //I set all the information I need to be sent to our Database and create a log.
                    this.setEq1(m2.getEq1());
                    this.setEq2(m2.getEq2());
                    this.setEq3(m2.getEq3());
                    this.setDet(m2.getDet1());
                    this.setX(m2.getX_res());
                    this.setY(m2.getY_res());
                    this.setZ(m2.getZ_res());
                    //Calls the comand that sends it to the DB.
                    eq3ToDb();

                    if (this.getType() == 1) {
                        goBackAdmin();
                    } else {
                        goBackUser();
                    }

                    break;

                case 3:
                    if (this.getType() == 1) {
                        goBackAdmin();
                    } else {
                        goBackUser();
                    }
                    break;

                case 4:
                    signInOut();
                    break;

                case 5:

                    break;
                default:
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Option is not valid.");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    solveEquations();

            }
        }
    }

    /**
     * This method uses the SQL command INSERT INTO to add all the 2x2
     * equation`s information to our database. It has connection with our
     * Database. It also sends the username that was type when the user logged
     * into our program.
     */
    public void eq2ToDb() throws Exception {

        try {

            Connection con = getConnection();
            PreparedStatement insert = con.prepareStatement("INSERT INTO equations(username,equation1,equation2,equation3,eq_det,eq_x,eq_y)" + "values (?,?,?,?,?,?,?) ");
            insert.setString(1, this.getUsername());
            insert.setString(2, this.getEq1());
            insert.setString(3, this.getEq2());
            insert.setString(4, this.getEq3());
            insert.setFloat(5, this.getDet());
            insert.setFloat(6, this.getX());
            insert.setFloat(7, this.getY());
            insert.executeUpdate();

        } catch (Exception e) {

            System.out.println(e);
        }

    }

    /**
     * This method uses the SQL command INSERT INTO to add all the 3x3
     * equation`s information to our database. It has connection with our
     * Database. It also sends the username that was type when the user logged
     * into our program.
     */
    public void eq3ToDb() throws Exception {

        try {

            Connection con = getConnection();
            PreparedStatement insert = con.prepareStatement("INSERT INTO equations(username,equation1,equation2,equation3,eq_det,eq_x,eq_y,eq_z)" + "values (?,?,?,?,?,?,?,?) ");
            insert.setString(1, this.getUsername());
            insert.setString(2, this.getEq1());
            insert.setString(3, this.getEq2());
            insert.setString(4, this.getEq3());
            insert.setFloat(5, this.getDet());
            insert.setFloat(6, this.getX());
            insert.setFloat(7, this.getY());
            insert.setFloat(8, this.getZ());
            insert.executeUpdate();

            con.close();
            insert.close();

        } catch (Exception e) {

            System.out.println(e);
        }

    }

    /**
     * This method uses the SQL command SELECT to show a log of all simultaneous
     * equations solved. It has connection with our Database.
     */
    public void getLog() throws Exception {

        try {

            Connection con = getConnection();
            PreparedStatement select = con.prepareStatement("SELECT username,equation1,equation2,equation3,eq_det,eq_x,eq_y,eq_z FROM equations");
            ResultSet result = select.executeQuery();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Equation`s Log");

            while (result.next()) {

                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("User:" + result.getString("username"));
                System.out.println("First Equation Typed: " + result.getString("equation1"));
                System.out.println("Second Equation Typed: " + result.getString("equation2"));
                System.out.println("Third Equation Typed: " + result.getString("equation3"));
                System.out.println("Determinant: " + result.getString("eq_det"));
                System.out.println("X :" + result.getString("eq_x"));
                System.out.println("Y :" + result.getString("eq_y"));
                System.out.println("Z :" + result.getString("eq_z"));
            }

            con.close();
            select.close();
            result.close();

            goBackAdmin();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method uses the SQL command SELECT to validate if an user exits in
     * our Database. It has connection with our Database.
     */
    public void userValidator() throws Exception {

        try {

            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT user_type FROM users WHERE user_username=? AND user_password=?");

            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Please type your username: ");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            //First i asks the user to log in by typing his username and password.
            this.setUsername(s.next().toLowerCase());
            stmt.setString(1, this.getUsername());

            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Now, please type your password: ");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            this.setPassword(s.next());
            stmt.setString(2, this.getPassword());
            //Then I access my Database and try to find any data with the username and password typed previously.
            ResultSet result = stmt.executeQuery();
            //If my research returns anything, it means that the username and password exist and match. 
            if (result.next()) {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Username and Password matching!");
                //When username and password match, we get the usr type (Admin or Regular user) and send then to their respective menu.
                this.setType(Integer.parseInt(result.getString("user_type")));
                switch (Integer.parseInt(result.getString("user_type"))) {
                    case 1:
                        menuAdmin();
                        break;
                    case 2:
                        menuUser();
                        break;

                    default:

                }

            } else {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Either your username or password are incorrect!");
                signInOut();
            }

            con.close();
            stmt.close();
            result.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method uses the SQL command SELECT to validate if a username is
     * already in our Database. It has connection with our Database. This method
     * is used while creating a new user.
     */
    public void alreadyAUser(String username) throws Exception {
        try {

            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT user_type FROM users WHERE user_username=?");
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                //Case the user tries to create a new username that already exists , this message will be returned.
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Username already taken!");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                userCreation();

            }
            con.close();
            stmt.close();
        } catch (Exception e) {
        }

    }

    /**
     * This method uses the SQL command SELECT to validate if a username is
     * already in our Database. It has connection with our Database. This method
     * is used while modifying a user.
     */
    public void alreadyAUser2(String username) throws Exception {
        try {

            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT user_type,user_id FROM users WHERE user_username=?");
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Username already taken!");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                modifyAllUsers(result.getInt("user_id"));

            }
            con.close();
            stmt.close();
        } catch (Exception e) {
        }

    }

    /**
     * This method uses the SQL command SELECT to get information from users in our DB.
     * It has connection with our Database.
     * This method calls other update methods below depending on what user wants to change.
     */
    public void modifyAllUsers(int user_id) throws Exception {
        try {

            Connection con = getConnection();
            PreparedStatement select = con.prepareStatement("SELECT user_name,user_username,user_type,user_status FROM users WHERE user_id = ?");
            select.setInt(1, user_id);
            ResultSet result = select.executeQuery();

            while (result.next()) {

                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("What information would you like to change ?");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Please type the number related to the options below:");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("1) Name:");
                System.out.println("2) Last Name:");
                System.out.println("3) Username:");
                System.out.println("4) Password:");
                System.out.println("5) User Type (Admin or Regular user):");
                System.out.println("6) User Status (Enabled or Disabled):");
                System.out.println("7) Back to Admin Menu:");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");

                String option = s.next();

                if (!option.matches("[0-9]+")) {
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Not a valid option!");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    modifyAllUsers(user_id);
                } else {

                    switch (Integer.parseInt(option)) {
                        case 1:
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Please type the new Name for " + result.getString("user_name") + ".");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            String name = s.next();
                            updateName(name, result.getString("user_username"));
                            break;
                        case 2:
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Please type the new Last Name for " + result.getString("user_name") + ".");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            String lastName = s.next();
                            updateLastName(lastName, result.getString("user_username"));

                            break;
                        case 3:
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Please type the new Username for " + result.getString("user_name") + ".");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            String username = s.next();
                            updateUsername(username, result.getString("user_name"));

                            break;
                        case 4:
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Please type the new Password for " + result.getString("user_name") + ".");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            String password = s.next();
                            updatePassword(password, result.getString("user_username"));

                            break;
                        case 5:
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Please type the new Type for " + result.getString("user_name") + ".");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("1) Admin.");
                            System.out.println("2) Regular User.");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            String uType = s.next();

                            if (!uType.matches("[0-9]+")) {
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("Not a valid option!");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                modifyAllUsers(user_id);
                            } else {

                                switch (Integer.parseInt(uType)) {
                                    case 1:
                                        updateUserType(Integer.parseInt(uType), result.getString("user_username"));
                                        break;
                                    case 2:
                                        updateUserType(Integer.parseInt(uType), result.getString("user_username"));
                                        break;
                                    default:
                                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                        System.out.println("Not a valid option!");
                                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                        modifyAllUsers(user_id);
                                }

                            }

                        case 6:
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Please type the new Status for " + result.getString("user_name") + ".");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("1) Enabled.");
                            System.out.println("2) Disabled.");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            String status = s.next();

                            if (!status.matches("[0-9]+")) {
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("Not a valid option!");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                modifyAllUsers(user_id);
                            } else {

                                switch (Integer.parseInt(status)) {
                                    case 1:

                                        enableUser(user_id);
                                        modifyAllUsers(user_id);
                                        break;
                                    case 2:
                                        deleteUser(user_id);
                                        modifyAllUsers(user_id);
                                        break;
                                    default:
                                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                        System.out.println("Not a valid option!");
                                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                        modifyAllUsers(user_id);
                                }
                            }

                        case 7:
                            menuAdmin();
                            break;
                        default:
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Not a valid option!");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            modifyAllUsers(user_id);
                    }
                }

            }

        } catch (Exception e) {
        }
    }

    public void modifyOwnUser(String username) throws Exception {
        try {

            Connection con = getConnection();
            PreparedStatement select = con.prepareStatement("SELECT user_id,user_name,user_username FROM users WHERE user_username = ?");
            select.setString(1, username);
            ResultSet result = select.executeQuery();

            while (result.next()) {

                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("What information from " + result.getString("user_name") + " would you like to change ?");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Please type the number related to the options below:");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("1) Name:");
                System.out.println("2) Last Name:");
                System.out.println("3) Username:");
                System.out.println("4) Password:");
                System.out.println("5) Back to User Menu:");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");

                String option = s.next();

                if (!option.matches("[0-9]+")) {
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Not a valid option!");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    modifyOwnUser(this.getUsername());
                } else {

                    switch (Integer.parseInt(option)) {
                        case 1:
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Please type the new Name for " + result.getString("user_name") + ".");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            String name = s.next();
                            updateName(name, result.getString("user_username"));
                            break;
                        case 2:
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Please type the new Last Name for " + result.getString("user_name") + ".");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            String lastName = s.next();
                            updateLastName(lastName, result.getString("user_username"));

                            break;
                        case 3:
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Please type the new Username for " + result.getString("user_name") + ".");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            String nusername = s.next();
                            updateUsername(nusername, result.getString("user_name"));

                            break;
                        case 4:
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Please type the new Password for " + result.getString("user_name") + ".");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            String password = s.next();
                            updatePassword(password, result.getString("user_username"));

                            break;

                        case 5:
                            menuUser();
                            break;
                        default:
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Not a valid option!");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            modifyOwnUser(username);
                    }
                }

            }

            con.close();
            select.close();
            result.close();
        } catch (Exception e) {
        }
    }

    /**
     * This method uses the SQL command UPDATE to modify the user`s name in our
     * Database. It has connection with our Database. This method is used while
     * modifying a user.
     */
    public void updateName(String name, String username) throws Exception {

        try {

            Connection con = getConnection();
            PreparedStatement update = con.prepareStatement("UPDATE users SET user_name = ? WHERE user_username = ?");
            update.setString(1, name);
            update.setString(2, username);
            update.executeUpdate();
            con.close();
            if (this.getType() == 1) {
                goBackAdmin();
            } else {
                goBackUser();
            }

        } catch (Exception e) {
        }

    }

    /**
     * This method uses the SQL command UPDATE to modify the user`s last name in
     * our Database. It has connection with our Database. This method is used
     * while modifying a user.
     */
    public void updateLastName(String lastName, String username) throws Exception {

        try {

            Connection con = getConnection();
            PreparedStatement update = con.prepareStatement("UPDATE users SET user_last_name = ? WHERE user_username = ?");
            update.setString(1, lastName);
            update.setString(2, username);
            update.executeUpdate();
            con.close();
            if (this.getType() == 1) {
                goBackAdmin();
            } else {
                goBackUser();
            }

        } catch (Exception e) {
        }

    }

    /**
     * This method uses the SQL command UPDATE to modify the user`s username in
     * our Database. It has connection with our Database. This method is used
     * while modifying a user.
     */
    public void updateUsername(String username, String name) throws Exception {

        try {
            //First checks if the username already exists in our Database.
            alreadyAUser2(username);

            Connection con = getConnection();
            PreparedStatement update = con.prepareStatement("UPDATE users SET user_username = ? WHERE user_name = ?");
            update.setString(1, username);
            update.setString(2, name);
            update.executeUpdate();
            con.close();
            if (this.getType() == 1) {
                goBackAdmin();
            } else {
                goBackUser();
            }

        } catch (Exception e) {
        }

    }

    /**
     * This method uses the SQL command UPDATE to modify the user`s password in
     * our Database. It has connection with our Database. This method is used
     * while modifying a user.
     */
    public void updatePassword(String password, String username) throws Exception {

        try {

            Connection con = getConnection();
            PreparedStatement update = con.prepareStatement("UPDATE users SET user_password = ? WHERE user_username = ?");
            update.setString(1, password);
            update.setString(2, username);
            update.executeUpdate();
            con.close();
            if (this.getType() == 1) {
                goBackAdmin();
            } else {
                goBackUser();
            }

        } catch (Exception e) {
        }

    }

    /**
     * This method uses the SQL command UPDATE to modify the user`s type in our
     * Database 1 for Admin 2 for Regular User. It has connection with our
     * Database. This method is used while modifying a user.
     */
    public void updateUserType(int uType, String username) throws Exception {

        try {

            Connection con = getConnection();
            PreparedStatement update = con.prepareStatement("UPDATE users SET user_type = ? WHERE user_username = ?");
            update.setInt(1, uType);
            update.setString(2, username);
            update.executeUpdate();
            con.close();
            goBackAdmin();

        } catch (Exception e) {
        }

    }

    /**
     * This method uses the SQL command UPDATE to modify the user`s status in
     * our Database, 2 for Disabled. It has connection with our Database. This
     * method is used while modifying a user.
     */
    public void deleteUser(int deleteid) throws Exception {

        try {

            Connection con = getConnection();
            PreparedStatement update = con.prepareStatement("UPDATE users SET user_status = ? WHERE user_id = ?");
            update.setInt(1, 2);
            update.setInt(2, deleteid);
            update.executeUpdate();
            con.close();
            goBackAdmin();

        } catch (Exception e) {
        }

    }

    /**
     * This method uses the SQL command UPDATE to modify the user`s status in
     * our Database 1 for Enabled. It has connection with our Database. This
     * method is used while modifying a user.
     */
    public void enableUser(int enableid) throws Exception {

        try {

            Connection con = getConnection();
            PreparedStatement update = con.prepareStatement("UPDATE users SET user_status = '" + 1 + "' WHERE user_id = ?");

            update.setInt(1, enableid);
            update.executeUpdate();
            con.close();
            goBackAdmin();

        } catch (Exception e) {
        }

    }

    /**
        * This method uses the SQL command SELECT to get the user`s id in
     * our Database.It has connection with our
     * Database. This method is used while modifying a user.
     */
    public void idCheck(int id) throws Exception {

        try {
            Connection con = getConnection();
            PreparedStatement update = con.prepareStatement("SELECT user_name FROM users WHERE user_id = '" + id + "' AND user_status = '" + 1 + "'");
            ResultSet result = update.executeQuery();

            if (!result.next()) {
                System.out.println("Not a valid ID!");
            }
            con.close();
            update.close();

        } catch (Exception e) {
        }
    }

}

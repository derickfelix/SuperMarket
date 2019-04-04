/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.derickfelix.bankapplication.views.operations;

import Test.TestUtils;
import com.github.derickfelix.bankapplication.controllers.CustomerController;
import com.github.derickfelix.bankapplication.controllers.UserController;
import com.github.derickfelix.bankapplication.models.Customer;
import com.github.derickfelix.bankapplication.views.Main;
import java.util.ArrayList;
import javax.swing.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JT
 */
public class RegisterCustomerTest {
    
    public RegisterCustomerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        CustomerController cc = CustomerController.getInstance();
        int prevSize = cc.getCustomers().size();
        //Add manually
            //Login
        UserController.getInstance().login("0000", "secret");
            //Initiate frame
        RegisterCustomer rc = new RegisterCustomer(new Main(), true);
        assertNotNull(rc);
            //Find JComponent by name set in RegisterCustomer.java
        //rc.setVisible(true);
        JTextField txtName = (JTextField) TestUtils.getChildNamed(rc, "jtfName");
        JTextField txtAddress = (JTextField) TestUtils.getChildNamed(rc, "jtfAddress");
        JComboBox<String> cmbAccount = (JComboBox<String>) TestUtils.getChildNamed(rc, "cmbAcc");
        JRadioButton radioFemale = (JRadioButton) TestUtils.getChildNamed(rc, "jrbFemale");
        JRadioButton radioMale = (JRadioButton) TestUtils.getChildNamed(rc, "jrbMale");
        JComboBox<String> cmbDay = (JComboBox<String>) TestUtils.getChildNamed(rc, "cDay");
        JComboBox<String> cmbMonth = (JComboBox<String>) TestUtils.getChildNamed(rc, "cMonth");
        JComboBox<String> cmbYear = (JComboBox<String>) TestUtils.getChildNamed(rc, "cYear");
        JPasswordField txtPassword = (JPasswordField) TestUtils.getChildNamed(rc, "jpfPassword");
        JButton btnRegister = (JButton) TestUtils.getChildNamed(rc, "btnReg");
            //Check NULL of JComponent
        assertNotNull("Cannot access JTextField component (jtfName)", txtName);
        assertNotNull("Cannot access JTextField component (jtfAddress)", txtAddress);
        assertNotNull("Cannot access JComboBox component (cmbAcc)", cmbAccount);
        assertNotNull("Cannot access JRadioButton component (jrbFemale)", radioFemale);
        assertNotNull("Cannot access JRadioButton component (jrbMale)", radioMale);
        assertNotNull("Cannot access JComboBox component (cDay)", cmbDay);
        assertNotNull("Cannot access JComboBox component (cMonth)", cmbMonth);
        assertNotNull("Cannot access JComboBox component (cYear)", cmbYear);
        assertNotNull("Cannot access JPasswordField component (jpfPassword)", txtPassword);
        assertNotNull("Cannot access JButton component (btnReg)", btnRegister);
            //Declare data
        String name = "TANG";
        String address = "9 JALAN 17";
        String password = "12345678";
            //Set data
        txtName.setText(name);
        txtAddress.setText(address);
        cmbAccount.setSelectedIndex(1);
        radioFemale.setSelected(true);
        //radioMale.setSelected(true);
        cmbDay.setSelectedIndex(1);
        cmbMonth.setSelectedIndex(1);
        cmbYear.setSelectedIndex(1);
        txtPassword.setText(password);
            //Post string to text field (for JTextField only)
        txtName.postActionEvent();
        txtAddress.postActionEvent();
        txtPassword.postActionEvent();
            //Click button
        btnRegister.doClick();
            //Check record exist or not
        int currSize = cc.getCustomers().size();
        boolean regSuccess = false;
        //If customer record size added 1
        if (currSize - prevSize == 1) {
            regSuccess = true;
        }
        //If false, prompt message
        assertTrue("Register Failed", regSuccess);
    }
    
}

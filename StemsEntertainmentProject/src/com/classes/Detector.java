/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classes;

/**
 *
 * @author Manase
 */
public class Detector
{
    private final String idNumber;
    private final String password;

    public Detector(String idNumber, String password) {
        this.idNumber = idNumber;
        this.password = password;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Detector{" + "idNumber=" + idNumber + ", password=" 
                + password + '}';
    }
}
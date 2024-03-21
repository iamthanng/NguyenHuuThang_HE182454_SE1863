/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.NormalizeText;

/**
 *
 * @author admin
 */
public class Main {

    private final static NormalizeText nt = new NormalizeText();
    
    public static void main(String[] args) {
        nt.normalizeText();
    }
}


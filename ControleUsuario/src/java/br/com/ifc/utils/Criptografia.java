/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Como utilizar este método: Criptografia.criprografar(senha)
 *
 * @author fabricio
 */
public class Criptografia {

public static String criptografar(String senhaOriginal) throws Exception {
    MessageDigest md = MessageDigest.getInstance("MD5");
    BigInteger hash = new BigInteger(1, md.digest(senhaOriginal.getBytes()));
    return String.format("%32x", hash);
}    

}

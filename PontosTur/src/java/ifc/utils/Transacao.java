/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.utils;

import java.sql.Connection;

public interface Transacao {

    public Connection getConnection() throws Exception;

    public void begin() throws Exception;

    public void commit() throws Exception;

    public void rollback() throws Exception;

}

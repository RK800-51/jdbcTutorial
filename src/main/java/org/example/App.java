package org.example;


import org.example.businesslogic.Util;

import java.sql.SQLException;

public class App
{
    public static void main( String[] args ) throws SQLException {
        Util util = new Util();
        util.getConnection();
    }
}

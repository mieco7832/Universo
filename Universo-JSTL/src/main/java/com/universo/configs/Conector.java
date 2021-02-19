package com.universo.configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conector {

    private Connection connection;

    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/universo?useSSL=false", "root", "root");
        } catch (Exception e) {
            System.out.println("Hubo un error al intentar conectarse a la base de datos, posibles causas: ");
            e.printStackTrace();
        }
    }

    public void desconectar() {
        try {
            if (this.connection != null) {
                if (!this.connection.isClosed()) {
                    this.connection.close();
                }
            }
        } catch (Exception e) {
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}

package com.universo.configs;

public class TestConnection {

    public static void main(String[] args) {
        Conector cn = new Conector();
        try {
            cn.conectar();
            System.out.println("Conexión Realizada.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cn.desconectar();
        }
    }

}

package com.universo.repository;

import com.universo.configs.Conector;
import com.universo.models.Galaxia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GalaxiaRepository extends Conector {

    PreparedStatement ps;
    ResultSet rs;
    String query;

    public void create(Galaxia c) {
        try {
            this.conectar();
            query = "INSERT INTO galaxia(nombre,img,descripcion) VALUES(?,?,?)";
            ps = this.getConnection().prepareStatement(query);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getImg());
            ps.setString(3, c.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
    }

    public List<Galaxia> get() {
        List<Galaxia> list = new ArrayList<>();
        try {
            this.conectar();
            query = "SELECT id_galaxia, nombre, img, descripcion FROM galaxia";
            ps = this.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Galaxia g = new Galaxia();
                g.setId_galaxia(rs.getInt("id_galaxia"));
                g.setNombre(rs.getString("nombre"));
                g.setImg(rs.getString("img"));
                g.setDescripcion(rs.getString("descripcion"));
                list.add(g);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
        return list;
    }

    public void update(Galaxia u) {
        try {
            this.conectar();
            query = "UPDATE galaxia SET nombre = ?, img = ?, descripcion = ? WHERE id_galaxia = ?";
            ps = this.getConnection().prepareStatement(query);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getImg());
            ps.setString(3, u.getDescripcion());
            ps.setInt(4, u.getId_galaxia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }

    }

    public void delete(int id) {
        try {
            this.conectar();
            query = "DELETE FROM galaxia WHERE id_galaxia = ?";
            ps = this.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
    }

    public Galaxia getById(int id) {
        Galaxia g = new Galaxia();
        try {
            this.conectar();
            query = "SELECT id_galaxia, nombre, img, descripcion FROM galaxia WHERE id_galaxia = ?";
            ps = this.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                g.setId_galaxia(rs.getInt("id_galaxia"));
                g.setNombre(rs.getString("nombre"));
                g.setImg(rs.getString("img"));
                g.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
        return g;
    }
}

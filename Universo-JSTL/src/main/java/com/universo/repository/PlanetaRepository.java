package com.universo.repository;

import com.universo.configs.Conector;
import com.universo.models.Galaxia;
import com.universo.models.Planeta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlanetaRepository extends Conector {

    PreparedStatement ps;
    ResultSet rs;
    String query;

    public void create(Planeta c) {
        try {
            this.conectar();
            query = "INSERT INTO planeta(nombre_planeta, masa, numero,img, galaxia, descripcion) VALUES(?,?,?,?,?,?)";
            ps = this.getConnection().prepareStatement(query);
            ps.setString(1, c.getNombre_planeta());
            ps.setString(2, c.getMasa());
            ps.setInt(3, c.getNumero());
            ps.setString(4, c.getImg());
            ps.setInt(5, c.getGalaxia().getId_galaxia());
            ps.setString(6, c.getDescription());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
    }

    public List<Planeta> get(int id) {
        List<Planeta> list = new ArrayList<>();
        try {
            this.conectar();
            query = "SELECT id_planeta, nombre_planeta, masa,img, numero, galaxia, descripcion FROM planeta WHERE galaxia = ?";
            ps = this.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Planeta p = new Planeta();
                Galaxia g = new Galaxia();
                p.setId_planeta(rs.getInt("id_planeta"));
                p.setNombre_planeta(rs.getString("nombre_planeta"));
                p.setMasa(rs.getString("masa"));
                p.setNumero(rs.getInt("numero"));
                p.setImg(rs.getString("img"));
                g.setId_galaxia(rs.getInt("galaxia"));
                p.setGalaxia(g);
                p.setDescription(rs.getString("descripcion"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
        return list;
    }

    public void update(Planeta u) {
        try {
            this.conectar();
            query = "UPDATE planeta SET  nombre_planeta = ?, masa = ?, numero = ?, img = ?, galaxia = ?, descripcion = ? WHERE id_planeta = ?";
            ps = this.getConnection().prepareStatement(query);
            ps.setString(1, u.getNombre_planeta());
            ps.setString(2, u.getMasa());
            ps.setInt(3, u.getNumero());
            ps.setString(4, u.getImg());
            ps.setInt(5, u.getGalaxia().getId_galaxia());
            ps.setString(6, u.getDescription());
            ps.setInt(7, u.getId_planeta());
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
            query = "DELETE FROM planeta WHERE id_planeta = ?";
            ps = this.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
    }

    public Planeta getById(int id) {
        Planeta p = new Planeta();
        try {
            this.conectar();
            query = "SELECT id_planeta, nombre_planeta, masa, numero, img, galaxia, descripcion FROM planeta WHERE id_planeta = ?";
            ps = this.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Galaxia g = new Galaxia();
                p.setId_planeta(rs.getInt("id_planeta"));
                p.setNombre_planeta(rs.getString("nombre_planeta"));
                p.setMasa(rs.getString("masa"));
                p.setNumero(rs.getInt("numero"));
                p.setImg(rs.getString("img"));
                g.setId_galaxia(rs.getInt("galaxia"));
                p.setGalaxia(g);
                p.setDescription(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
        return p;
    }
    
    
}

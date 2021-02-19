package com.universo.domain;

import com.universo.entity.Espacio;
import com.universo.models.Galaxia;
import com.universo.models.Planeta;
import com.universo.repository.*;
import java.util.ArrayList;
import java.util.List;

public class Domain {

    GalaxiaRepository galaxiaRepository = new GalaxiaRepository();
    PlanetaRepository planetaRepository = new PlanetaRepository();

    public List<Espacio> getGalaxias() {
        List<Espacio> list = new ArrayList<>();
        try {
            galaxiaRepository.get().forEach((g) -> {
                list.add(new Espacio(g.getId_galaxia(), g.getNombre(), g.getDescripcion(), g.getImg()));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void createGalaxia(String nombre, String descripcion, String url) {
        try {
            Galaxia c = new Galaxia();
            c.setNombre(nombre);
            c.setDescripcion(descripcion);
            c.setImg(url);
            galaxiaRepository.create(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Espacio getGalaxia(int id) {
        Espacio es = null;
        try {
            Galaxia g = galaxiaRepository.getById(id);
            es = new Espacio(g.getId_galaxia(), g.getNombre(), g.getDescripcion(), g.getImg());
        } catch (Exception e) {
        }
        return es;
    }

    public void updateGalaxia(String id, String nombre, String descripcion, String url) {
        try {
            Galaxia g = galaxiaRepository.getById(Integer.parseInt(id));
            g.setNombre(nombre);
            g.setDescripcion(descripcion);
            g.setImg(url);
            galaxiaRepository.update(g);
        } catch (Exception e) {
        }
    }

    public void removeGalaxia(int id) {
        try {
            galaxiaRepository.delete(id);
        } catch (Exception e) {
        }
    }

    public List<Espacio> getPlanetas(int id) {
        List<Espacio> list = new ArrayList<>();
        try {
            planetaRepository.get(id).forEach((p) -> {
                list.add(new Espacio(p.getId_planeta(), p.getNombre_planeta(), p.getMasa(), p.getNumero(), p.getDescription(), p.getImg()));
            });
        } catch (Exception e) {
        }
        return list;
    }

    public void createPlaneta(String nombre, String masa, String numero, String descripcion, String url, String id) {
        Planeta p = new Planeta();
        Galaxia g = galaxiaRepository.getById(Integer.parseInt(id));
        try {
            p.setNombre_planeta(nombre);
            p.setMasa(masa);
            p.setNumero(Integer.parseInt(numero));
            p.setDescription(descripcion);
            p.setImg(url);
            p.setGalaxia(g);
            planetaRepository.create(p);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Espacio getPlaneta(int id) {
        Espacio es = null;
        try {
            Planeta p = planetaRepository.getById(id);
            es = new Espacio(p.getId_planeta(), p.getNombre_planeta(), p.getMasa(), p.getGalaxia().getId_galaxia(), p.getDescription(), p.getImg());
        } catch (Exception e) {
        }
        return es;
    }

    public void updatePlaneta(String nombre, String masa, String numero, String descripcion, String url, String id, String galaxia) {
        try {
            Galaxia g = galaxiaRepository.getById(Integer.parseInt(galaxia));
            Planeta p = planetaRepository.getById(Integer.parseInt(id));
            p.setGalaxia(g);
            p.setNombre_planeta(nombre);
            p.setMasa(masa);
            p.setNumero(Integer.parseInt(numero));
            p.setDescription(descripcion);
            p.setImg(url);
            planetaRepository.update(p);
        } catch (Exception e) {
        }
    }

    public void removePlaneta(int id) {
        try {
            planetaRepository.delete(id);
        } catch (Exception e) {
        }
    }

}

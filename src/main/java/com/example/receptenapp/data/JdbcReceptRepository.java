package com.example.receptenapp.data;


import com.example.receptenapp.Ingredient;
import com.example.receptenapp.Recept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class JdbcReceptRepository implements ReceptRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcReceptRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Recept> findAll() {
        Iterable<Recept> recepten = jdbc.query("select r.id, r.naam, r.bereidingstijd, r.bereiding, r.kosten, r.persoon, i.id as ingredient_id, i.naam as ingredient, i.type from Ingredient as i, Recept as r, Recept_Ingredienten as ri where ri.recept = r.id and ri.ingredient = i.id",
                this::mapRowToIngredient);
        List<Recept> frecepten = new ArrayList<Recept>();
        for (Recept r : recepten) {
            Recept frecept = new Recept();
            List<Ingredient> ingredienten = new ArrayList<Ingredient>();
            for (Recept n : recepten) {
                if (r.getId() == n.getId() && r != n && r.getIngredienten().get(0).getId() != n.getIngredienten().get(0).getId()) {
                    ingredienten.add(new Ingredient(r.getIngredienten().get(0).getId(), r.getIngredienten().get(0).getNaam(), r.getIngredienten().get(0).getType()));
                    System.out.println("r == n" + r.getIngredienten() + n.getIngredienten());
                }
            }
            frecept.setIngredienten(ingredienten);
            frecepten.add(frecept);
            ingredienten = new ArrayList<Ingredient>();
        }

        return frecepten;
    }

    @Override
    public Recept findOne(int id) {
        return jdbc.queryForObject("select r.id, r.naam, r.bereidingstijd, r.bereiding, r.kosten, r.persoon, i.id as ingredient_id, i.naam as ingredient, i.type from Ingredient as i, Recept as r, Recept_Ingredienten as ri where ri.recept = r.id and ri.ingredient = i.id and ri.recept=?", this::mapRowToIngredient, id);
    }

    private Recept mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        //Array result = rs.getArray(1);
        //System.out.println("mapRowToIngredient " + result);
        rs.getString("ingredient");
        List<Ingredient> ingredienten = new ArrayList<Ingredient>();
        ingredienten.add(new Ingredient(rs.getInt("ingredient_id"), rs.getString("ingredient"), Ingredient.Type.valueOf(rs.getString("type"))));
        Recept recept = new Recept(rs.getInt("id"), rs.getString("naam"), rs.getInt("bereidingstijd"), rs.getString("bereiding"), rs.getInt("kosten"), rs.getString("persoon"));
        recept.setIngredienten(ingredienten);
        return recept;
    }

    @Override
    public Recept save(Recept recept) {
        jdbc.update("insert into Recept(id, naam, bereidingstijd, bereiding, kosten, persoon) values (?,?,?,?,?,?,?)", recept.getId(), recept.getNaam(), recept.getBereiding(), recept.getKosten(), recept.getPersoon());
        return recept;
    }

    private void saveIngredientToRecept(
            Ingredient ingredient, long receptId) {
        jdbc.update("insert into Recept_Ingredienten (recept, ingredient)" +
                "values(?,?)", receptId, ingredient.getId());
    }
}

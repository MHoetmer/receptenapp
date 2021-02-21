package com.example.receptenapp.data;

import com.example.receptenapp.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbc.query("select id, naam, type from Ingredient",
                this::mapRowToIngredient);
    }

    @Override
    public Ingredient findOne(int id) {
        return jdbc.queryForObject("select id, naam, type from Ingredient where id=?", this::mapRowToIngredient, id);
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(rs.getInt("id"), rs.getString("naam"), Ingredient.Type.valueOf(rs.getString("type")));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbc.update("insert into Ingredient(id, naam, type) values (?,?,?)", ingredient.getId(), ingredient.getNaam(), ingredient.getType().toString());
        return ingredient;
    }
}

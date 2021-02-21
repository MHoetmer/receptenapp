package com.example.receptenapp.data;


import com.example.receptenapp.Recept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class JdbcReceptRepository implements ReceptRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcReceptRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Recept> findAll() {
        return jdbc.query("select id, naam, bereidingstijd, bereiding, kosten, persoon from Recept",
                this::mapRowToIngredient);
    }

    @Override
    public Recept findOne(int id) {
        return jdbc.queryForObject("select id, naam, bereidingstijd, bereiding, kosten, persoon from Recept where id=?", this::mapRowToIngredient, id);
    }

    private Recept mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Recept(rs.getInt("id"), rs.getString("naam"), rs.getInt("bereidingstijd"), rs.getString("bereiding"), rs.getInt("kosten"), rs.getString("persoon"));
    }

    @Override
    public Recept save(Recept recept) {
        jdbc.update("insert into Recept(id, naam, bereidingstijd, bereiding, kosten, persoon) values (?,?,?,?,?,?,?)", recept.getId(), recept.getNaam(), recept.getBereiding(), recept.getKosten(), recept.getPersoon());
        return recept;
    }
}

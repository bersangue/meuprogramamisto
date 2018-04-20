package com.example.gilsonbarbosa.meuprogramamisto.daoum.dao;

import android.content.ContentValues;
import android.content.Context;


import com.example.gilsonbarbosa.meuprogramamisto.daoum.domain.Pessoa;

import java.util.ArrayList;

public class DaoPessoa {
    private Context context;
    private DaoAdapter banco;

    public DaoPessoa(Context context) {
        this.context = context;
        //instanciamos o DaoAdapter (Dao mãe)
        banco = new DaoAdapter(context);
    }

    public long insert(Pessoa pessoa) {
        /*
         * Este método é um pouco mais trabalhado porém, nos retorna o id do
         * utlimo registro. Este processo soluciona quando temos que inserir
         * dados em chaves estrangeiras em outras tabelas...
         */
        ContentValues values = new ContentValues();
        values.put("nome", pessoa.getNome());
        values.put("email", pessoa.getEmail());
        values.put("telefone", pessoa.getTelefone());
      //  values.put("endereco", pessoa.getEndereco());
      //  values.put("cidade", pessoa.getCidade());
        values.put("sexo", pessoa.getSexo());


        long result = banco.queryInsertLastId("pessoa", values);

        return result;
    }

    //Método de alteração
    public boolean update(Pessoa pessoa) {
        Object[] args = {
                pessoa.getNome(),
                pessoa.getEmail(),
                pessoa.getTelefone(),
               // pessoa.getEndereco(),
              //  pessoa.getCidade(),
                pessoa.getSexo(),
                pessoa.getId()


        };

        boolean result = banco.queryExecute(
                "UPDATE pessoa SET " +
                        "nome = ?, " +
                        "email = ?, " +
                        "telefone = ?," +
                       // "endereco = ?," +
                      //  "cidade = ?," +
                        "sexo = ? " +
                        "WHERE id = ?;", args);

        return result;
    }

    //Método de exclusão
    public boolean delete(long id) {
        Object[] args = {id};
        boolean result = banco.queryExecute("DELETE FROM pessoa WHERE id = ?", args);

        return result;
    }

    //Método de consulta geral
    public ArrayList<Pessoa> getTodos() {
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        ObjetoBanco ob = banco.queryConsulta("SELECT * FROM pessoa ORDER BY nome ASC", null);

        if (ob != null) {
            for (int i = 0; i < ob.size(); i++) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(ob.getLong(i, "id"));
                pessoa.setNome(ob.getString(i, "nome"));
                pessoa.setEmail(ob.getString(i, "email"));
                pessoa.setTelefone(ob.getString(i, "telefone"));
               // pessoa.setEndereco(ob.getString(i, "endereco"));
             //   pessoa.setCidade(ob.getString(i, "cidade"));
                pessoa.setSexo(ob.getString(i, "sexo"));


                pessoas.add(pessoa);
            }
        }

        return pessoas;
    }

    //Método de consulta especifica
    public Pessoa getPessoa(long id) {
        String[] args = {String.valueOf(id)};
        ObjetoBanco ob = banco.queryConsulta("SELECT * FROM pessoa WHERE id = ?", args);

        Pessoa pessoa = null;
        if (ob != null) {
            pessoa = new Pessoa();
            pessoa.setId(ob.getLong(0, "id"));
            pessoa.setNome(ob.getString(0, "nome"));
            pessoa.setEmail(ob.getString(0, "email"));
            pessoa.setTelefone(ob.getString(0, "telefone"));
           // pessoa.setEndereco(ob.getString( 0,"endereco"));
           // pessoa.setCidade(ob.getString(0, "cidade"));
            pessoa.setSexo(ob.getString(0, "sexo"));

        }

        return pessoa;
    }
}

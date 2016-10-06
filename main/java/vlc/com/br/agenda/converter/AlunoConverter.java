package vlc.com.br.agenda.converter;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.List;

import vlc.com.br.agenda.modelo.Aluno;

/**
 * Created by Valeria on 30/09/2016.
 */
public class AlunoConverter {
    public String converteParaJSON(List<Aluno> alunos) {
        JSONStringer js = new JSONStringer();

        try {
            js.object().key("list").array().object().key("aluno").array();

            for (Aluno aluno : alunos) {
                js.object();
                js.key("nome").value(aluno.getNome());
                js.key("nota").value(aluno.getNota());
                js.endObject();
            }
            js.endArray().endObject().endArray().endObject();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return js.toString();
    }
}
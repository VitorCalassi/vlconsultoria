package vlc.com.br.agenda;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import vlc.com.br.agenda.converter.AlunoConverter;
import vlc.com.br.agenda.dao.AlunoDAO;
import vlc.com.br.agenda.modelo.Aluno;

/**
 * Created by Valeria on 30/09/2016.
 */
public class EnviaAlunosTask extends AsyncTask<Void, Void, String> {
    private  Context context;
    private  ProgressDialog dialog;

    public EnviaAlunosTask(Context context) {
        this.context = context;

    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Aguarde", "Enviando alunos...", true, true);
    }    
    
    @Override
    protected String doInBackground(Void[] params) {

        AlunoDAO dao = new AlunoDAO(context);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();

        AlunoConverter conversor = new AlunoConverter();
        String json = conversor.converteParaJSON(alunos);

        WebClient client = new WebClient();
        String resposta = client.post(json);

        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        dialog.dismiss();
        Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();

    }
}
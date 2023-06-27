package com.br.controledecombustivel_entraga2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class UsuarioActivity extends AppCompatActivity {

    private ListView listUsuario;
    private  ArrayList<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        listUsuario = findViewById(R.id.listUsuario);
        listUsuario.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {

                Usuario usuario = (Usuario) listUsuario.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(),
                        getString(R.string.usuario) + usuario.getNome() + getString(R.string.foi_selecionado),
                        Toast.LENGTH_SHORT).show();
            }
        });
        popularLista();
    }

    private void popularLista() {
        String[] nomes = getResources().getStringArray(R.array.nomes);
        int[] tipo_combustivel = getResources().getIntArray(R.array.tipo_combustivel);
        int[] tipo_veiculo = getResources().getIntArray(R.array.tipo_veiculo);
        String[] preco_combustivel = getResources().getStringArray(R.array.preco_combustivel);
        String[] distancia = getResources().getStringArray(R.array.distancia);
        String[] km_litro = getResources().getStringArray(R.array.km_litros);


        usuarios = new ArrayList<>();

        Usuario usuario;

        float precoCombus;
        float dist;
        float kmlitros;

        TipoCombustivel[] tipoCombustivels = TipoCombustivel.values();
        TipoVeiculo[] tipoVeiculos = TipoVeiculo.values();



        for(int cont = 0; cont < nomes.length;cont++){
            usuario = new Usuario(nomes[cont]);

            usuario.setTipoCombustivel(tipoCombustivels[tipo_combustivel[cont]]);

            usuario.setTipoVeiculo(tipoVeiculos[tipo_veiculo[cont]]);

            precoCombus = Float.parseFloat(preco_combustivel[cont]);
            usuario.setPrecoCombustivel(precoCombus);

            dist = Float.parseFloat(distancia[cont]);
            usuario.setDistancia(dist);

            kmlitros = Float.parseFloat(km_litro[cont]);
            usuario.setKmLitro(kmlitros);

            usuarios.add(usuario);
        }

       UsuarioAdpater usuarioAdpater = new UsuarioAdpater(this,usuarios);

        listUsuario.setAdapter(usuarioAdpater);
    }
}
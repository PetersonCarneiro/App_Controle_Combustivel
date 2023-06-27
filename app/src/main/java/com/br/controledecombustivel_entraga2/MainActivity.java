package com.br.controledecombustivel_entraga2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private CheckBox cbGasolina, cbAlcool, cbFlex, cbDiesel;

    private RadioGroup radioGroupTipoVeiculo;

    private Spinner spinnerMarca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextName);

        cbGasolina = findViewById(R.id.checkBoxGasolina);
        cbAlcool = findViewById(R.id.checkBoxAlcool);
        cbFlex = findViewById(R.id.checkBoxFlex);
        cbDiesel = findViewById(R.id.checkBoxDiesel);

        radioGroupTipoVeiculo = findViewById(R.id.radioGroupTipoVeiculo);

        spinnerMarca = findViewById(R.id.spinnerMarca);

        marcas();
    }


    public void apagar(View view) {
        editTextNome.setText(null);

        cbGasolina.setChecked(false);
        cbAlcool.setChecked(false);
        cbFlex.setChecked(false);
        cbDiesel.setChecked(false);

        radioGroupTipoVeiculo.clearCheck();

    }

    public void enviar(View view){
        Intent intent = new Intent(this,UsuarioActivity.class);
        selecionados();
        startActivity(intent);
    }

    public void selecionados() {

        String mesagem = "";


        if (cbGasolina.isChecked()) {
            mesagem += getString(R.string.gasolina);
        }
        if (cbAlcool.isChecked()) {
            mesagem += getString(R.string.alcool);
        }
        if (cbFlex.isChecked()) {
            mesagem += getString(R.string.flex);
        }
        if (cbDiesel.isChecked()) {
            mesagem += getString(R.string.diesel);
        }
        if (mesagem.equals("")) {
            mesagem = getString(R.string.nenhuma_op_selecionada);
        } else {
            mesagem = getString(R.string.foram_selecionadas);
        }
        Toast.makeText(this, mesagem, Toast.LENGTH_SHORT).show();

        String mesagem3 = "";

        int botãoSelecionado = radioGroupTipoVeiculo.getCheckedRadioButtonId();
        if (botãoSelecionado == R.id.radioButtonCarro) {
            mesagem3 = getString(R.string.carro) +
                    getString(R.string.carro_selecionado);
        } else {
            if (botãoSelecionado == R.id.radioButtonMoto) {
                mesagem3 = getString(R.string.carro) +
                        getString(R.string.carro_selecionado);
            } else {
                mesagem3 = getString(R.string.selecione_um_tipo_de_veiculo);
            }
        }
        Toast.makeText(this, mesagem3, Toast.LENGTH_SHORT).show();


    }

    public void marcas() {
        ArrayList<String> list = new ArrayList<>();

        list.add(getString(R.string.fiat));
        list.add(getString(R.string.chevrolet));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        spinnerMarca.setAdapter(adapter);
    }

    public void Abrisobre(View view){
        Intent intent = new Intent(this, SobreActivity.class);

        startActivity(intent);
    }

}
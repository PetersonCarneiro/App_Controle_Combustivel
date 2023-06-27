package com.br.controledecombustivel_entraga2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class UsuarioAdpater extends BaseAdapter {

    private Context context;
    private List<Usuario> usuario;
    private  NumberFormat numberFormat;


    private static class UsuarioHolder{
        public TextView textViewValorNome;
        public TextView textViewValorT_Combustivel;
        public TextView textViewValorT_Veiculo;
        public TextView textViewValorPrecoCombustivel;
        public TextView textViewValorDistancia;
        public TextView textViewValorkmLitro;

    }

    public UsuarioAdpater(Context context, List<Usuario> pessoas) {
        this.context = context;
        this.usuario = pessoas;

        numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
    }


    @Override
    public int getCount() {
        return usuario.size();
    }

    @Override
    public Object getItem(int position) {
        return usuario.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        UsuarioHolder holder;

        if(view == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_usuario,viewGroup,false);

            holder = new UsuarioHolder();

            holder.textViewValorNome = view.findViewById(R.id.editTextNome);
            holder.textViewValorT_Veiculo = view.findViewById(R.id.editTextTipoVeiculo);
            holder.textViewValorT_Combustivel = view.findViewById(R.id.editTextCombustivel);
            holder.textViewValorPrecoCombustivel = view.findViewById(R.id.editTextprecoCombustivel);
            holder.textViewValorDistancia = view.findViewById(R.id.editTextDistancia);
            holder.textViewValorkmLitro = view.findViewById(R.id.editTextKmLitro);

            view.setTag(holder);
        }else{
            holder = (UsuarioHolder) view.getTag();
        }

        holder.textViewValorNome.setText(usuario.get(position).getNome());

        switch (TipoCombustivel.values()[usuario.get(position).getTipoCombustivel()]){
            case Gasolina:
                holder.textViewValorT_Combustivel.setText(R.string.gasolina);
                break;
            case Alcool:
                holder.textViewValorT_Combustivel.setText(R.string.alcool);
                break;
            case Diesel:
                holder.textViewValorT_Combustivel.setText(R.string.diesel);
                break;
        }

        switch (TipoVeiculo.values()[usuario.get(position).getTipoVeiculo()]){
            case Carro:
                holder.textViewValorT_Veiculo.setText(R.string.carro);
                break;
            case Moto:
                holder.textViewValorT_Veiculo.setText(R.string.moto);
                break;
            case Van:
                holder.textViewValorT_Veiculo.setText(R.string.van);
                break;
            case Onibus:
                holder.textViewValorT_Veiculo.setText(R.string.onibus);
                break;
            case Caminhao:
                holder.textViewValorT_Veiculo.setText(R.string.caminh_o);
                break;
        }

        String precoCombusFormatado = numberFormat.format(usuario.get(position).getPrecoCombustivel());
        holder.textViewValorPrecoCombustivel.setText(precoCombusFormatado);

        String distancia = String.valueOf(usuario.get(position).getDistancia());
        holder.textViewValorDistancia.setText(distancia);

        String  kmlitro = String.valueOf(usuario.get(position).getKmLitro());
        holder.textViewValorkmLitro.setText(kmlitro);




        return view;
    }
}

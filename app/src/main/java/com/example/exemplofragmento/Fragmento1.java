package com.example.exemplofragmento;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

// Repositório com exemplo de Fragmentos estáticos

public class Fragmento1 extends Fragment {
    private Button BotaoA;
    private Button BotaoB;
    private Button BotaoC;
    private Button BotaoD;
    private TextView textoA;
    private View V;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o layout para este fragmento
        // Recupera uma "View v" para acessar as propriedades e métodos do fragmento
        V = inflater.inflate(R.layout.fragmento1, container, false);



        BotaoA = (Button) V.findViewById(R.id.buttonA);
        BotaoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("prints", "botao A");
                DialogFragment fragmentoData = new FragmentoDatePicker();
                fragmentoData.show(getParentFragmentManager(), "datePicker");

            }
        });

        BotaoB = (Button) V.findViewById(R.id.buttonB);
        BotaoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("prints", "botao B");
                DialogFragment fragmentoTime = new FragmentoTimePicker();
                fragmentoTime.show(getParentFragmentManager(), "timePicker");
                
            }
        });



        textoA = (TextView) V.findViewById(R.id.editTextDescription);
        textoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("prints", "texto A");
                TextView txt = (TextView) Fragmento2.frgto2.findViewById(R.id.texto_frg2);



            }
        });

        BotaoC = (Button) V.findViewById(R.id.buttonC);
        BotaoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("prints", "botao C");
                TextView txt = (TextView) Fragmento2.frgto2.findViewById(R.id.texto_frg2);
                if (txt != null) txt.setText(
                        String.valueOf(textoA.getText())
                );
            }
        });

        return V;
    }
}
package com.example.exemplofragmento;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class Fragmento2 extends Fragment {

    @SuppressLint("StaticFieldLeak")
    static  View frgto2;
    TarefaDB mCompromissoDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o layout para este fragmento
        frgto2 = inflater.inflate(R.layout.fragmento2, container, false);
        // Retorna uma "View frgto2" para acessar as propriedades e métodos do fragmento a partir da Activity pai

        Button botao4 = frgto2.findViewById(R.id.buttonA);
        botao4.setOnClickListener(view -> {
            TextView txt = Fragmento2.frgto2.findViewById(R.id.texto_frg2);
            txt.setText("");
            Date currentDate = new Date();

            String timeZoneID = "America/Sao_Paulo";
            TimeZone timeZone = TimeZone.getTimeZone(timeZoneID);

            @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
            sdf.setTimeZone(timeZone);
            String formattedDate = sdf.format(currentDate);

            txt.setTextColor(Color.BLACK);
            txt.setText(formattedDate);

            if (mCompromissoDB == null){
                mCompromissoDB = new TarefaDB(requireActivity().getBaseContext());
            }

            Cursor cursor = mCompromissoDB.queryTarefa(null, null);
            if (cursor != null) {
                if (cursor.getCount() == 0) {
                    Log.i("MSGS", "Nenhum resultado");
                }
                try {
                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()) {
                        @SuppressLint("Range") String data = cursor.getString(cursor.getColumnIndex(TarefaDBSchema.CompromissosTbl.Cols.DATA));
                        @SuppressLint("Range") String hora = cursor.getString(cursor.getColumnIndex(TarefaDBSchema.CompromissosTbl.Cols.HORA));
                        @SuppressLint("Range") String descricao = cursor.getString(cursor.getColumnIndex(TarefaDBSchema.CompromissosTbl.Cols.DESCRICAO));

                        if (data.equals(formattedDate)){
                            txt.append("\n" + hora + " - " + descricao);
                        }
                        cursor.moveToNext();
                    }
                } finally {
                    cursor.close();
                }
            } else {
                Log.i("MSGS", "cursor nulo!");
            }
        });

        Button botao5 = frgto2.findViewById(R.id.buttonB);
        botao5.setOnClickListener(view -> {
            DialogFragment fragmentoOtherData = new FragmentoOtherDate();
            fragmentoOtherData.show(getParentFragmentManager(), "datePicker");

        });
        return frgto2; //inflater.inflate(R.layout.fragmento2, container, false);
    }
}
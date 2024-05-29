package com.example.exemplofragmento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.NonNull;


public class TarefaDB {

    private final SQLiteDatabase mDatabase;

    public TarefaDB(@NonNull Context contexto) {
        Context mContext = contexto.getApplicationContext();
        mDatabase = new TarefaDBHelper(mContext).getWritableDatabase();
    }

    @NonNull
    private static ContentValues getValoresConteudo(String data, String time, String description) {
        ContentValues valores = new ContentValues();

        // pares chave-valor: nomes das colunas - valores
        valores.put(TarefaDBSchema.CompromissosTbl.Cols.DATA, data);
        valores.put(TarefaDBSchema.CompromissosTbl.Cols.HORA, time);
        valores.put(TarefaDBSchema.CompromissosTbl.Cols.DESCRICAO, description);
        return valores;
    }

    public void addComprimisso(String data, String time, String description) {
        ContentValues valores = getValoresConteudo(data, time, description);
        mDatabase.insert(TarefaDBSchema.CompromissosTbl.NOME, null, valores);
    }

    public Cursor queryTarefa(String clausulaWhere, String[] argsWhere){
        return mDatabase.query(TarefaDBSchema.CompromissosTbl.NOME,
                null,  // pega todas as colunas
                clausulaWhere,
                argsWhere,
                null, // não há group by
                null, // não há having
                null  // não há order by
        );
    }
}
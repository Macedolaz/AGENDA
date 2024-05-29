package com.example.exemplofragmento;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

public class TarefaDBHelper extends SQLiteOpenHelper{

    private static final int VERSAO = 1;

    private static final String NOME_DATABASE = "Tarefa.db";

    public TarefaDBHelper(Context context){
        super(context, NOME_DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        String query =  "CREATE TABLE "+ TarefaDBSchema.CompromissosTbl.NOME+ "("+
                "_id integer PRIMARY KEY autoincrement,"+
                TarefaDBSchema.CompromissosTbl.Cols.DATA + ","+
                TarefaDBSchema.CompromissosTbl.Cols.HORA + ","+
                TarefaDBSchema.CompromissosTbl.Cols.DESCRICAO + ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int versaoAntiga, int novaVersao) {
        // Política de upgrade é simplesmente descartar o conteúdo e começar novamente
        db.execSQL("DROP TABLE IF EXISTS " + TarefaDBSchema.CompromissosTbl.NOME);
        onCreate(db);
    }


}
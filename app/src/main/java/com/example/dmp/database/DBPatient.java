package com.example.dmp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dmp.User.User;

public class DBPatient {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "user.db";

    private static final String TABLE_USER = "table_user";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_PRENOM = "Prénom";
    private static final int NUM_COL_PRENOM = 1;
    private static final String COL_NOM = "Nom";
    private static final int NUM_COL_NOM = 2;
    private static final String COL_PASSWORD = "Password";
    private static final int NUM_COL_PASSWORD = 3;
    private static final String COL_CPS = "CPS";
    private static final int NUM_COL_CPS = 4;

    private SQLiteDatabase bdd;

    private DBUser dbUser;

    public DBPatient(Context context){
        //On crée la BDD et sa table
        dbUser = new DBUser(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = dbUser.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }


    public long insertUser(User user){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();

        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_PRENOM, user.getPrenom());
        values.put(COL_NOM, user.getNom());
        values.put(COL_PASSWORD, user.getPassword());
        values.put(COL_CPS, user.getCPS());

        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_USER, null, values);
    }


    public User getUserFromDB(String titre){

        Cursor c = bdd.query(TABLE_USER, new String[] {COL_ID, COL_PRENOM, COL_NOM}, COL_NOM + " LIKE \"" + titre +"\"", null, null, null, null);
        return cursorToUser(c);
    }

    //Cette méthode permet de convertir un cursor en un livre
    private User cursorToUser(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();

        User user = new User();

        user.setId(c.getInt(NUM_COL_ID));
        user.setPrenom(c.getString(NUM_COL_PRENOM));
        user.setNom(c.getString(NUM_COL_NOM));

        c.close();


        return user;
    }
}

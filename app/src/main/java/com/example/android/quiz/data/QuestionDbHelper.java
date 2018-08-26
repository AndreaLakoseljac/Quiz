package com.example.android.quiz.data;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.quiz.R;

public class QuestionDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "kviz_pitanja.db";

    Resources r = Resources.getSystem();

    public QuestionDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " + QuestionContract.QuestionEntry.TABLE_NAME +
                "(" + QuestionContract.QuestionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionContract.QuestionEntry.COLUMN_QUESTION_TEXT + " TEXT NOT NULL, " +
                QuestionContract.QuestionEntry.COLUMN_ANSWER_1 + " TEXT NOT NULL, " +
                QuestionContract.QuestionEntry.COLUMN_ANSWER_2 + " TEXT NOT NULL, " +
                QuestionContract.QuestionEntry.COLUMN_ANSWER_3 + " TEXT NOT NULL, " +
                QuestionContract.QuestionEntry.COLUMN_ANSWER_4 + " TEXT NOT NULL, " +
                QuestionContract.QuestionEntry.COLUMN_ANSWER + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Afektivnostilistički postupak koji živi upravo od svog otpora prema takozvanom ustaljenom, pravilnom, gramatičkom redu riječi naziva se', " +
                "'polisindeton', 'anafora', 'inverzija', 'metafora', 'inverzija');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'U kojem stoljeću stvaraju Eshil, Sofoklo i Euripid?', " +
                "'u 5. st. pr. Kr.', 'u 1. st.', 'u 5. st.', 'u 8. st. pr. Kr.', 'u 5. st. pr. Kr.');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'U kojim je stihovima ženska ljepota opisana na petrarkistički način?', 'Kad najpri ja tvoje vidih zlate kose i oči, gospoje, ke srca zanose,', 'mnogi miris više slasti dijeli od daha što iz moje drage bije.', " +
                "'A ostriže mrca vlase i crvima ize iz usti,', 'O ženo opasna, o čarobne klime, kako snijeg tvoj voljet i stud grobne zime', 'Kad najpri ja tvoje vidih zlate kose i oči, gospoje, ke srca zanose,');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Tko je autor stihova o slatkoj slobodi?', " +
                "'Ivan Bunić Vučić', 'Ivan Gundulić', 'Junije Palmotić', 'Ignjat Đurđević', 'Ivan Gundulić');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Koje je djelo napisano u razdoblju prosvjetiteljstva?', " +
                "'Putositnice', 'Dubravka', 'Satir iliti divlji čovik', 'Smrt Smail-age Čengića', 'Putositnice');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Koji je društveno-politički događaj bitno uvjetovao rasplamsavanje ekspresionizma?', " +
                "'Bachov apsolutizam', 'spaljivanje mađarske zastave u Zagrebu 1905.', 'Prvi svjetski rat', 'gospodarska kriza 1929. do 1933.', 'Prvi svjetski rat');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Koji je književni časopis izlazio od 1952. do 1958. godine?', " +
                "'Krugovi', 'Razlog', 'Vijavica', 'Plamen', 'Krugovi');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Čija je nasilna smrt opisana u Ljetopisu popa Dukljanina?', " +
                "'kneza Branimira', 'kneza Domagoja', 'kralja Tomislava', 'kralja Zvonimira', 'kralja Zvonimira');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Kojom je vrstom stiha napisana Eneida?', " +
                "'epskim desetercem', 'aleksandrincem', 'heksametrom', 'dvostruko rimovanim dvanaestercem', 'dvostruko rimovanim dvanaestercem');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Što znači novela iz naslova Držićeva djela Novela od Stanca?', " +
                "'susret', 'šala', 'prikazanje', 'ples', 'šala');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'U kojemu je od sljedećih primjera upotrijebljena simploka?', 'mi zalud zidamo toranj do neba, mi zalud skidamo Boga sa neba,', 'Čime iskren razum koji zdravo sudi, čemu polet duše i srce koje sniva,', " +
                "'svjetlo koje gledam urliče slovo koje pišem urliče', 'Donesi, donesi odluku odluku što preču.', 'svjetlo koje gledam urliče slovo koje pišem urliče');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Za koju komediju autor kaže da je sva ukradena iz njekoga libra, starijeg neg je staros?', " +
                "'za Dunda Maroja', 'za Novelu od Stanca', 'za Tirenu', 'za Skup', 'za Skup');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'U kojemu su književnome razdoblju djelovali francuski parnasovci?', " +
                "'u realizmu', 'u modernizmu', 'u klasicizmu', 'u antici', 'u modernizmu');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Tko je bio urednik časopisa Vijavica?', " +
                "'Miroslav Krleža', 'August Šenoa', 'Antun Gustav Matoš', 'Antun Branko Šimić', 'Antun Branko Šimić');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Tko je napisao novelu Ubojstva u ulici Morque, koja se danas smatra prototipom detektivske priče?', " +
                "'Sir Arthur Conan Doyle', 'Edgar Allan Poe', 'Guy de Maupassant', 'Victor Hugo', 'Edgar Allan Poe');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Tko čeka Godota?', " +
                "'Pele i Vava', 'Vava i Jim', 'Gogi i Didi', 'Sid i Nana', 'Gogi i Didi');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Kako se zove kojeg jaše Don Quijote?', " +
                "'Marengo', 'Bukefal', 'Rocinante', 'Fobos', 'Rocinante');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Kako se zove glavni junak romana Zločin i kazna?', " +
                "'Dostojevski', 'Bolkonski', 'Raskoljnikov', 'Isajev', 'Raskoljnikov');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Muž glavne junakinje romana Gospođa Bovary, Charles Bovary, po zanimanju je', " +
                "'glumac', 'odvjetnik', 'načelnik', 'liječnik', 'liječnik');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Koliko sinova je imala Ana Karenjina?', '1', '2', '3', '4', '1');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Tko je napisao djelo Tri sestre?', " +
                "'Puškin', 'Dostojevski', 'Čehov', 'Ibsen', 'Čehov');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Tko je napisao djelo Evgenij Onjegin?', " +
                "'Ljermontov', 'Gorki', 'Puškin', 'Čehov', 'Puškin');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Kako je poginula Ana Karenjina?', " +
                "'prirodnom smrću', 'bacila se pod vlak', 'popila je otrov', 'ustrijelila se', 'bacila se pod vlak');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Gdje je pokopan otac hrvatske književnosti – Marko Marulić?', " +
                "'u crkvi sv. Franje Asiškog u Splitu', 'u Saloni', 'u splitskoj katedrali Sv. Duje, pored glavnog oltara', 'na Marjanu u Splitu', 'u crkvi sv. Franje Asiškog u Splitu');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'U Zlatnoj ulici u Pragu osim Kafke, koji je živio na broju 22, živio je i češki književnik i nobelovac', " +
                "'Karel Čapek', 'Jaroslav Seifert', 'Bohumil Hrabal', 'Eduard Bass', 'Jaroslav Seifert');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Koji pisac nije nosio bradu ni brkove?', " +
                "'Marcel Proust', 'Ernest Hemingway', 'Fernando Pessoa', 'Albert Camus', 'Albert Camus');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Hrvatski ilustrator Tomislav Torjanac ilustrirao je knjigu po kojoj je snimljen (i u mnogim kategorijama Oskarom nagrađen) film', " +
                "'Starac i more', 'Pijev život', 'Antuntun', 'Crni labud', 'Pijev život');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Sergej Jesenjin svoju je posljednju pjesmu napisao krvlju, a onda', " +
                "'iskrvario na smrt', 'upucao se u glavu', 'objesio se', 'bacio se pod vlak', 'objesio se');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Kako se zove prva kajkavska tiskana knjiga?', " +
                "'Decretum', 'Postilla', 'Arijanskoga mora sirena', 'Prvi otca našeg Adama greh', 'Decretum');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES(" +
                "'Kakvim se koineom služe hrvatski renesansni pisci na dalmatinskoj obali?', " +
                "'štokavsko-čakavskim', 'čakavsko-kajkavskim', 'kajkavsko-štokavskim', 'kajkavsko-čakavsko-štokavskim', 'štokavsko-čakavskim');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { }
}

package serive.algeria.chifacom;

import android.content.Context;
import android.content.SharedPreferences;

public class DoctorPrefManager {



    private  static  DoctorPrefManager mInstance ;
    private  static Context mCtx ;

    //client

    private static final String SHARED_PREF_NAME = "myshared";
    private  static final String KEY_USERNAME ="username";
    private  static final String KEY_FIRSTNAME ="userfirstname";
    private  static final String KEY_LASTNAME ="userlastname";
    private  static final String KEY_ID ="userid";
    private static  final String KEY_PERIOD = "created_at";

    //debtor
//    private  static final String KEY_Current ="current";
//    private  static final String KEY_FIRSTNAME_DEBTOR="userfirstnameDebtor";
//    private  static final String KEY_LASTNAME_DEBTOR ="userlastnameDebtor";
//    private  static final String KEY_ID_DEBTOR ="useridDebtor";




    private DoctorPrefManager(Context context){

        mCtx = context;
    }

    public static synchronized  DoctorPrefManager getInstance(Context context){
        if (mInstance == null){
            mInstance = new DoctorPrefManager(context);
        }
        return mInstance;
    }

    public boolean userLogin(int id , String username ,String firstname , String lastname,String period){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_ID,id);
        editor.putString(KEY_USERNAME,username);
        editor.putString(KEY_FIRSTNAME,firstname);
        editor.putString(KEY_LASTNAME,lastname);
        editor.putString(KEY_PERIOD,period);
//         editor.putInt(KEY_ID_DEBTOR,idD);
//         editor.putInt(KEY_Current,currentD);
//         editor.putString(KEY_FIRSTNAME_DEBTOR,firstnameD);
//         editor.putString(KEY_LASTNAME_DEBTOR,lastnameD);


        editor.apply();
        return  true ;
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_USERNAME,null) !=null){
            return true;
        }
        return  false ;

    }

    public boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }


    public String  getAdminFirstName (){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_FIRSTNAME,null);

    }
    public String  getAdminLastName(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_LASTNAME,null);


    }
    public String  getAdminCreatedAt(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PERIOD,null);


    }

}

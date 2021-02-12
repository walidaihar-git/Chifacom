package serive.algeria.chifacom.register;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import serive.algeria.chifacom.ConstantsAddress;
import serive.algeria.chifacom.IonBackPressed;
import serive.algeria.chifacom.R;

import static serive.algeria.chifacom.ConstantsAddress.wilayas;


public class FifthStepFragment extends Fragment implements IonBackPressed{

    LatLng sydney ;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {

            //googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            if(location== null) {
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 4));
            }else {
                if (baladiyaSelected){
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 16));
                }else {
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10));
                }
            }

        }
    };

    private String location = null ;
    Geocoder geocoder;
    private List<Address> addressList = null;
    private boolean baladiyaClicable = false;
    private boolean baladiyaSelected = false;
    private String title_wilaya = "";
    private String title_baladiya = "";

    private TextView wilaya, baladiya;
    private EditText address;



    private ArrayList<String[]> baladias = new ArrayList<String[]>();
    private int anInt=-1;


    private AppCompatButton nextStep ;
    private Bundle bundle ;
    private TextView back ;

    private FrameLayout frameLayout ;
    public FifthStepFragment() {
        // Required empty public constructor
    }


    public static FifthStepFragment newInstance() {
        FifthStepFragment fragment = new FifthStepFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapFragment);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fifth_step, container, false);
        bundle = this.getArguments();

        sydney = new LatLng(31.081249, 3.427809); // ALGERIA LATLNG
        geocoder = new Geocoder(getActivity());
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapFragment);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }

        frameLayout = view.findViewById(R.id.fragment_container);
        address = view.findViewById(R.id.address);
        wilaya = view.findViewById(R.id.state);
        baladiya = view.findViewById(R.id.province);


      /*  ViewGroup.LayoutParams params =  frameLayout.getLayoutParams();
        params.height = 1300 ;
        frameLayout.setLayoutParams(params);*/

        wilaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baladiya.setText("stat");
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Choisissez votre wilaya !")
                        .setCancelable(true)
                        .setSingleChoiceItems(wilayas, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (which >= 0) {
                                    title_wilaya = "" + Arrays.asList(wilayas).get(which);
                                    anInt = which;
                                    baladiyaClicable = true;
                                    if (anInt >= 0) {
                            if(baladiyaSelected){baladiyaSelected=false;}

                            wilaya.setText(title_wilaya);
                            location ="Algeria, "+ title_wilaya;
                            dialog.dismiss();
                            try {
                                addressList = geocoder.getFromLocationName(location,1);
                                sydney = new LatLng(addressList.get(0).getLatitude(),addressList.get(0).getLongitude());
                                mapFragment.getMapAsync(callback);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                                }
                            }
                        }
                        });
                builder.create().show();
            }
        });

        addBaladias();

        baladiya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (baladiyaClicable) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Choisissez votre baladiya !")
                            .setCancelable(true)
                            .setSingleChoiceItems(baladias.get(anInt), -1, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (which >= 0) {
                                        title_baladiya = "" + Arrays.asList(baladias.get(anInt)).get(which);
                                    }
                                    baladiya.setText(title_baladiya);
                                    baladiyaSelected=true;
                                    location= location+", "+title_baladiya;
                                    dialog.dismiss();
                                    try {
                                        addressList = geocoder.getFromLocationName(location,1);
                                        sydney = new LatLng(addressList.get(0).getLatitude(),addressList.get(0).getLongitude());
                                        mapFragment.getMapAsync(callback);

                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                            }
                                        }, 1800);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    location= title_wilaya;
                                }
                            });
                    builder.create().show();
                } else {
                    Toast.makeText(getActivity(), "mettez la wilaya", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back = view.findViewById(R.id.backtosixth);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SixthStepFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                TextView txt =  getActivity().findViewById(R.id.step); txt.setText("Etap 6/7");
                TextView txt2 = getActivity().findViewById(R.id.stepLabel); txt2.setText("Specialite et mail electronique");
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
                getActivity().findViewById(R.id.step7).setBackgroundColor(getResources().getColor(R.color.darkGray));
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        nextStep = view.findViewById(R.id.nextStep5);
        nextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Fragment fragment = new SixthStepFragment();
//
//                fragment.setArguments(bundle);
//                getFragmentManager().beginTransaction()
//                        .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
//                        .replace(R.id.fragment_container, fragment)
//                        .addToBackStack(null)
//                        .commit();
//                getActivity().findViewById(R.id.step4).setBackgroundColor(getResources().getColor(R.color.blueBack));



            }
        });

        return view;
    }

    @Override
    public boolean onBackPressed() {

        if (true) {
            //action not popBackStack
            Fragment fragment = new SecurityStepFragment();

            fragment.setArguments(bundle);

            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            getActivity().findViewById(R.id.step3).setBackgroundColor(getResources().getColor(R.color.darkGray));

            return true;
        } else {
            return false;
        }
    }




    private void addBaladias() {
        baladias.add(ConstantsAddress.commune_Adrar);
        baladias.add(ConstantsAddress.commune_Chlef);
        baladias.add(ConstantsAddress.commune_Laghouat);
        baladias.add(ConstantsAddress.commune_Oum_El_Bouaghi);
        baladias.add(ConstantsAddress.commune_Batna);
        baladias.add(ConstantsAddress.f524commune_Bjaia);
        baladias.add(ConstantsAddress.commune_Biskra);
        baladias.add(ConstantsAddress.f523commune_Bchar);
        baladias.add(ConstantsAddress.commune_Blida);
        baladias.add(ConstantsAddress.commune_Bouira);
        baladias.add(ConstantsAddress.commune_Tamanrasset);
        baladias.add(ConstantsAddress.f527commune_Tbessa);
        baladias.add(ConstantsAddress.cummute_tlemcen);
        baladias.add(ConstantsAddress.commune_Tiaret);
        baladias.add(ConstantsAddress.commune_Tizi_Ouzou);
        baladias.add(ConstantsAddress.commune_Alger);
        baladias.add(ConstantsAddress.commune_Djelfa);
        baladias.add(ConstantsAddress.commune_Jijel);
        baladias.add(ConstantsAddress.commune_Setif);
        baladias.add(ConstantsAddress.commune_Saida);
        baladias.add(ConstantsAddress.commune_Skikda);
        baladias.add(ConstantsAddress.f526commune_Sidi_Bel_Abs);
        baladias.add(ConstantsAddress.commune_Annaba);
        baladias.add(ConstantsAddress.commune_Guelma);
        baladias.add(ConstantsAddress.commune_Constantine);
        baladias.add(ConstantsAddress.f525commune_Mda);
        baladias.add(ConstantsAddress.commune_Mostaganem);
        baladias.add(ConstantsAddress.commune_Msila);
        baladias.add(ConstantsAddress.commune_Mascara);
        baladias.add(ConstantsAddress.commune_Ourgla);
        baladias.add(ConstantsAddress.commune_Oran);
        baladias.add(ConstantsAddress.commune_El_Bayadh);
        baladias.add(ConstantsAddress.commune_Illizi);
        baladias.add(ConstantsAddress.commune_Bordj_Bou_Arreridj);
        baladias.add(ConstantsAddress.f522commune_Boumerds);
        baladias.add(ConstantsAddress.commune_El_Taref);
        baladias.add(ConstantsAddress.commune_Tindouf);
        baladias.add(ConstantsAddress.commune_Tssemsilt);
        baladias.add(ConstantsAddress.commune_El_Oued);
        baladias.add(ConstantsAddress.commune_Khenchela);
        baladias.add(ConstantsAddress.commune_Ahras);
        baladias.add(ConstantsAddress.commune_Tipaza);
        baladias.add(ConstantsAddress.commune_Mila);
        baladias.add(ConstantsAddress.commune_Ain_Defla);
        baladias.add(ConstantsAddress.commune_Naama);
        baladias.add(ConstantsAddress.commune_Ain_Tmouchent);
        baladias.add(ConstantsAddress.commune_Ghardaia);
        baladias.add(ConstantsAddress.commune_Relizane);

    }
}
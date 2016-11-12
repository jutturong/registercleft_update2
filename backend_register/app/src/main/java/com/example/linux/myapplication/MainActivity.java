package com.example.linux.myapplication;

import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends TabActivity {

    TabHost mTabHost;

    ContextMenu menu;

    public String url = "http://kkucleft.kku.ac.th/app_admin/index.php/welcome/json_backend1";
    public String url2="http://kkucleft.kku.ac.th/app_admin/index.php/welcome/json_province_backend";

    // Google Map
    private GoogleMap googleMap;

    // Latitude & Longitude
    private Double Latitude  = 13.844205;
    private Double Longitude  = 100.598856;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setContentView(R.layout.activity_tab);

        // Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }





        /*  autocomplete  */
        final List<String> arrList = new ArrayList<String>();

        final AutoCompleteTextView autocomplete1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        autoname(arrList, autocomplete1);


        final AutoCompleteTextView autocomplete2 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        autoprovince(arrList, autocomplete2);


        //startScan();


        /*  tab host */
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost = getTabHost();

        mTabHost.addTab(mTabHost.newTabSpec("tab_test1").setIndicator("DATA").setContent(R.id.tab1));
        mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("SEARCH").setContent(R.id.tab2));
        mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("MAP").setContent(R.id.tab3));

        mTabHost.setCurrentTab(0);






        final ListView listview1 = (ListView) findViewById(R.id.listview1);

        final AlertDialog.Builder viewDetail = new AlertDialog.Builder(this);


        final Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    JSONArray data = new JSONArray(getJSONUrl(url));

                    // Toast.makeText(MainActivity.this,String.valueOf(  data.length()  ),Toast.LENGTH_SHORT).show();


                    final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
                    HashMap<String, String> map;


                    for (int i = 0; i < data.length(); i++) {

                        JSONObject c = data.getJSONObject(i);

                        map = new HashMap<String, String>();
                        map.put("name", c.getString("name"));
                        map.put("lastname", c.getString("lastname"));
                        map.put("id_card", c.getString("id_card"));
                        map.put("id_sex", c.getString("id_sex"));

                        map.put("PROVINCE_NAME", c.getString("PROVINCE_NAME"));

                        map.put("telephone", c.getString("telephone"));


                        map.put("birthdate", c.getString("birthdate"));


                        map.put("address", c.getString("address"));


                        map.put("diagnosis", c.getString("diagnosis"));


                        map.put("detail_diagnosis", c.getString("detail_diagnosis"));


                        map.put("info_name", c.getString("info_name"));


                        map.put("informative_lastname", c.getString("informative_lastname"));


                        map.put("informative_tel", c.getString("informative_tel"));


                        map.put("sex_content", c.getString("sex_content"));


                        map.put("fullname", c.getString("name") + "   " + c.getString("lastname"));


                        MyArrList.add(map);

                        //  Toast.makeText(MainActivity.this,String.valueOf(  c.getString("name") ),Toast.LENGTH_SHORT).show();

                    }


                    SimpleAdapter sAdap;
                    sAdap = new SimpleAdapter(MainActivity.this, MyArrList, R.layout.activity_column,
                            new String[]{"name", "lastname", "PROVINCE_NAME"}, new int[]{R.id.Col_name, R.id.Col_lastname, R.id.Col_PROVINCE_NAME});

                    listview1.setAdapter(sAdap);


                    final AlertDialog.Builder viewDetail = new AlertDialog.Builder(MainActivity.this);


                    listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> myAdapter, View myView,
                                                int position, long mylng) {

                            String sMemberID = MyArrList.get(position).get("id_card")
                                    .toString();
                            String stelephone = MyArrList.get(position).get("telephone")
                                    .toString();
                            String id_sex = MyArrList.get(position).get("id_sex")
                                    .toString();

                            String birthdate = MyArrList.get(position).get("birthdate")
                                    .toString();

                            String address = MyArrList.get(position).get("address")
                                    .toString();


                            String PROVINCE_NAME = MyArrList.get(position).get("PROVINCE_NAME")
                                    .toString();


                            String diagnosis = MyArrList.get(position).get("diagnosis")
                                    .toString();


                            String detail_diagnosis = MyArrList.get(position).get("detail_diagnosis")
                                    .toString();


                            String info_name = MyArrList.get(position).get("info_name")
                                    .toString();

                            String informative_lastname = MyArrList.get(position).get("informative_lastname")
                                    .toString();

                            final String informative_tel = MyArrList.get(position).get("informative_tel")
                                    .toString();


                            String sex_content = MyArrList.get(position).get("sex_content")
                                    .toString();


                            // viewDetail.setIcon(android.R.drawable.btn_star_big_on);
                            viewDetail.setIcon(android.R.drawable.btn_plus);
                            viewDetail.setTitle("LOADING...");
                            viewDetail.setMessage
                                    (
                                            "เลขบัตรประชาชน : " + sMemberID + "\n" + "\n"
                                                    + "เบอร์โทรศัพท์ : " + stelephone + "\n" + "\n"
                                                    + "เพศ : " + sex_content + "\n" + "\n"
                                                    + "วัน-เดือน-ปี เกิด : " + birthdate + "\n" + "\n"
                                                    + "ที่อยู่ปัจจุบัน(ตามทะเบียนบ้าน) : " + address + "\n"
                                                    + "จังหวัดเกิด : " + PROVINCE_NAME + "\n" + "\n"
                                                    + "ภาวะโลกร่วม : " + diagnosis + "\n" + "\n"
                                                    + "ภาวะโลกร่วม อื่นๆ : " + detail_diagnosis + "\n" + "\n"
                                                    + "ชื่อผู้ให้ข้อมูล : " + info_name + "   " + informative_lastname + "\n" + "\n"
                                                    + "เบอร์โทรศัพท์ผู้ให้ข้อมูล : " + informative_tel + "\n" + "\n"
                                    );

                            viewDetail.setNegativeButton("โทรศัพท์ติดต่อ", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    // TODO Auto-generated method stub
                                    // dialog.dismiss();

                                    //startActivities( callphone(informative_tel));

                                    Toast.makeText(MainActivity.this, String.valueOf("เบอร์โทรศัพท์ผู้ให้ข้อมูล : " + informative_tel + " กำลังโทรออก... "), Toast.LENGTH_SHORT).show();

                                   // Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + informative_tel));
                                   //  startActivities(intent);
                                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel" , informative_tel , null ));
                                    startActivity(intent);


                                }
                            });
                            viewDetail.setPositiveButton("ปิดหน้าต่าง",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,
                                                            int which) {
                                            // TODO Auto-generated method stub
                                            dialog.dismiss();
                                        }
                                    });





                            //menu.setHeaderIcon(android.R.drawable.btn_minus);



                            viewDetail.show();


                        }
                    });


                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


            }
        });


    }



    public void autoprovince(List<String> arrList,AutoCompleteTextView autocomplete )
    {
        try {

            JSONArray data = new JSONArray(getJSONUrl(url2));

           // Toast.makeText(MainActivity.this,String.valueOf(  data.length()  ),Toast.LENGTH_SHORT).show();

            for(int i = 0; i < data.length(); i++) {

                JSONObject c = data.getJSONObject(i);

                arrList.add( c.getString("PROVINCE_NAME")  );

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item,
                        arrList);

               //  Toast.makeText(MainActivity.this,String.valueOf( c.getString("PROVINCE_NAME")  ),Toast.LENGTH_SHORT).show();
                autocomplete.setAdapter(adapter);


            }

        }catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public void autoname(List<String> arrList,AutoCompleteTextView autocomplete1 )
    {
        try {

            JSONArray data = new JSONArray(getJSONUrl(url));
            //Toast.makeText(MainActivity.this,String.valueOf(  data.length()  ),Toast.LENGTH_SHORT).show();

            for(int i = 0; i < data.length(); i++) {

                JSONObject c = data.getJSONObject(i);

                arrList.add( c.getString("name")  );

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item,
                        arrList);

                //  Toast.makeText(MainActivity.this,String.valueOf(  c.getString("name") ),Toast.LENGTH_SHORT).show();
                autocomplete1.setAdapter(adapter);


            }

        }catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void startScan() {
        new Thread() {
            public void run() {
                try{
                    Thread.sleep(500);
                    //hRefresh.sendEmptyMessage(REFRESH_SCREEN);
                }catch(Exception e){
                }
            }
        }.start();
    }





    public String getJSONUrl(String url) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) { // Download OK
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    str.append(line);
                }
            } else {
                Log.e("Log", "Failed to download result..");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }


}

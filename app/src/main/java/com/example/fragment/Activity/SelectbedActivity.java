package com.example.fragment.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.Adapter.Adapter_selectbed;
import com.example.fragment.Model.BookbedResponse;
import com.example.fragment.R;
import com.example.fragment.SharedPreferences.UserSessionManager;
import com.example.fragment.api.RetrofitClient;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectbedActivity extends AppCompatActivity {

    ImageView hotelimg,img,txthome;

    //    TextView txthome;
    Spinner spnadults,spnchild;
    TextView hotelname,addr,hdate,addr1;
    Button hotelBook;
    EditText username,userno;
    RadioGroup radioGroup;
    RadioButton radioButton,rbtn1,rbtn2;
    TextView integer_number,Set_date1,totalfare,bedName;

    String emails,UserId,man5,man6,man7,man8;
    UserSessionManager seesion;

    //
    private TextView startPickDate;
    private TextView endPickDate;
    static final int DATE_DIALOG_ID = 0;
    private TextView activeDateDisplay;
    private Calendar activeDate;
    private Calendar currentDate;
    private Calendar fromDate;
    private Calendar startDate;
    private Calendar endDate;
    String strBed;
//    ArrayList<BookbedResponse> nm1=new ArrayList<>();
//    Adapter_selectbed cr1;
//    ArrayList<BookbedResponse> nm4=new ArrayList<>();
//    Adapter_selectbed cr4;

    private java.util.Calendar myCalendar;

    int minteger = 0;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectbed);


        seesion=new UserSessionManager(this);
        HashMap<String,String> profile=seesion.getUserDetails();
        emails=profile.get("email");
        UserId=profile.get("UserId");
        Log.e(UserId, " "+UserId );

        Intent intent=getIntent();
        man5=intent.getStringExtra("id");
        man6=intent.getStringExtra("image");
        man7=intent.getStringExtra("text");
        man8=intent.getStringExtra("address");
        bedName=findViewById(R.id.hotelname);
//        bedAddress=findViewById(R.id.address);
        hotelimg=(ImageView)findViewById(R.id.hotelimg);


        bedName.setText(man7);
//        bedAddress.setText(man8);
        Picasso.get().load(man6).into(hotelimg);

       // Toast.makeText(getApplicationContext(),""+man5+man6+man7,Toast.LENGTH_LONG).show();






        username=findViewById(R.id.husername);
        userno=findViewById(R.id.huserno);
        hotelimg=findViewById(R.id.hotelimg);
        hotelname=findViewById(R.id.hotelname);
        addr=findViewById(R.id.address);
        addr1=findViewById(R.id.totalfare1);
        hdate=findViewById(R.id.hdate);
        spnadults=(Spinner)findViewById(R.id.hsp1);
        spnchild=(Spinner)findViewById(R.id.hsp2);
        hotelBook=(Button)findViewById(R.id.hotelbook);
        radioGroup=(RadioGroup)findViewById(R.id.radiogrp);
 radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
     @Override
     public void onCheckedChanged(RadioGroup radioGroup, int i) {
         radioButton= radioGroup.findViewById(i);
         switch (i){
             case R.id.rbtn1:
                 strBed = radioButton.getText().toString();
                 break;
             case R.id.rbtn2:
                strBed = radioButton.getText().toString();
                 break;
             default:
         }
     }
 });
//        if (radioGroup.getCheckedRadioButtonId() == R.id.rbtn1)
//        {
//
//        }
//        else {}
        addr1.setText(man8);
//        hotelBook=findViewById(R.id.book);

        hotelBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userBooking();
            }
        });

        /*ACTION BAR*/
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action);
        img=(ImageView)findViewById(R.id.back);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),BookActivity.class);
                startActivity(intent);
            }
        });
        /*ACTION to HOME*/
        txthome=(ImageView)findViewById(R.id.acthome);
        txthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });




        ArrayAdapter adapter=  ArrayAdapter.createFromResource(this,R.array.adults,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.spinner_text_color);
        spnadults.setAdapter(adapter);

        spnadults.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ///
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ///
            }
        });


        ArrayAdapter adapter1= ArrayAdapter.createFromResource(this,R.array.child,android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.spinner_text_color);
        spnchild.setAdapter(adapter1);

        spnchild.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ///
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ////
            }
        });

        /*  capture our View elements for the start date function   */
        startPickDate = (TextView) findViewById(R.id.hdate);

        /*get tday date  */

        currentDate=Calendar.getInstance();
        Log.d("currentDate ",""+(currentDate.get(Calendar.DAY_OF_MONTH))+(currentDate.get(Calendar.MONTH)+1)+(currentDate.get(Calendar.YEAR)));

        /* get the current date */
        startDate = Calendar.getInstance();
        Log.d("startdate ",""+(startDate.get(Calendar.DAY_OF_MONTH))+(startDate.get(Calendar.MONTH)+1)+(startDate.get(Calendar.YEAR)));

        /* add a click listener to the button   */
        startPickDate.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                showDateDialog(startPickDate, startDate);
                Log.d("startDate-on click ",""+(startDate.get(Calendar.DAY_OF_MONTH))+(startDate.get(Calendar.MONTH)+1)+(startDate.get(Calendar.YEAR)));

            }
        });


    }

    private void userBooking(){

        String areaname= hotelname.getText().toString().trim();
        String username1=username.getText().toString().trim();
        String phoneno = userno.getText().toString().trim();
        String adult = spnadults.getSelectedItem().toString().trim();
        String child = spnchild.getSelectedItem().toString().trim();
        String date = hdate.getText().toString().trim();
//        String typeofbed=rbtn1.getText().toString();
        String address=addr1.getText().toString().trim();

        if (username1.isEmpty()) {
            Toast.makeText(SelectbedActivity.this,"please enter name",Toast.LENGTH_LONG).show();
        }else if(date.isEmpty()){
            Toast.makeText(SelectbedActivity.this,"Please select Date",Toast.LENGTH_LONG).show();
        }else if (adult.equalsIgnoreCase("Start time")||adult.isEmpty()){
            Toast.makeText(SelectbedActivity.this,"Please select Start time",Toast.LENGTH_LONG).show();
        }else if (child.equalsIgnoreCase("End time")||child.isEmpty()){
            Toast.makeText(SelectbedActivity.this,"Please select End time",Toast.LENGTH_LONG).show();}
//        }else if (radioGroup.getCheckedRadioButtonId() == R.id.rbtn1){
//
//
//        }else if (radioGroup.getCheckedRadioButtonId() == R.id.rbtn2){}


        else {

            Call<BookbedResponse> Call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .Bookbed(areaname,username1,phoneno,adult, child,date,strBed,address, emails,UserId);

            Call.enqueue(new Callback<BookbedResponse>() {
                @Override
                public void onResponse(Call<BookbedResponse> call, Response<BookbedResponse> response) {

                    BookbedResponse defaultResponse = response.body();

                    if ((defaultResponse != null ? defaultResponse.getStatus() : 0) == 1) {
                        String im = defaultResponse.getMessage();
                        Toast.makeText(SelectbedActivity.this, "" + im, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SelectbedActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else if ((defaultResponse != null ? defaultResponse.getStatus() : 0) == 0) {
                        String im = defaultResponse.getMessage();
                        Toast.makeText(SelectbedActivity.this, "" + im, Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<BookbedResponse> call, Throwable t) {


                }
            });
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateDisplay(TextView dateDisplay, Calendar date)
    {
        dateDisplay.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(date.get(Calendar.DAY_OF_MONTH) ).append("-")
                        .append(date.get(Calendar.MONTH)+1).append("-")
                        .append(date.get(Calendar.YEAR)).append(" "));

        Log.d("msg","date:"+(date.get(Calendar.DAY_OF_MONTH))+(date.get(Calendar.MONTH)+1)+(date.get(Calendar.YEAR)));

        fromDate=date;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateDisplay1(TextView dateDisplay, Calendar date)
    {
        dateDisplay.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(date.get(Calendar.DAY_OF_MONTH)+1 ).append("-")
                        .append(date.get(Calendar.MONTH)+1).append("-")
                        .append(date.get(Calendar.YEAR)).append(" "));

        Log.d("msg","date:"+(date.get(Calendar.DAY_OF_MONTH))+(date.get(Calendar.MONTH)+1)+(date.get(Calendar.YEAR)));

        fromDate=date;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void showDateDialog(TextView dateDisplay, Calendar date)
    {
        Log.d("SDD", dateDisplay.getText().toString());
        Log.d("startdate ",""+(currentDate.get(Calendar.DAY_OF_MONTH))+(currentDate.get(Calendar.MONTH)+1)+(currentDate.get(Calendar.YEAR)));
        activeDateDisplay = dateDisplay;
        activeDate = date;
        showDialog(DATE_DIALOG_ID);
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
    {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @SuppressWarnings("deprecation")
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


            activeDate.set(Calendar.YEAR, year);
            activeDate.set(Calendar.MONTH, monthOfYear);
            activeDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);



            Date fromDate,toDate;
            try
            {
                if(currentDate.before(activeDate)|| currentDate.equals(activeDate))
                {
                    if(startPickDate.getText().toString().isEmpty())
                    {
                        updateDisplay(activeDateDisplay, activeDate);
                    }
                    else
                    {
                        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                        fromDate=sdf.parse(startPickDate.getText().toString());
                        Log.d("fromdate",""+fromDate);
                    }
                }

                else
                {
                    Toast toast=new Toast(getBaseContext());
                    toast=Toast.makeText(getApplicationContext(), "Please enter a valid date", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
            catch(Exception e)
            {
                Log.e("excepion",e.getMessage().toString());
            }
            unregisterDateDisplay();
        }
    };
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void unregisterDateDisplay()
    {
        Log.d("startdate ",""+(currentDate.get(Calendar.DAY_OF_MONTH))+(currentDate.get(Calendar.MONTH)+1)+(currentDate.get(Calendar.YEAR)));
        Log.d("from date:","-"+activeDate.DAY_OF_MONTH+activeDate.MONTH+activeDate.YEAR);
        activeDateDisplay = null;
        activeDate = null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {

            case DATE_DIALOG_ID:
                Log.d("fromdate","msg");
                Log.d("id",""+DATE_DIALOG_ID);
                return new DatePickerDialog(this, dateSetListener, activeDate.get(Calendar.YEAR), activeDate.get(Calendar.MONTH), activeDate.get(Calendar.DAY_OF_MONTH));
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
        switch (id) {
            case DATE_DIALOG_ID:
                Log.d("id",""+DATE_DIALOG_ID);
                ((DatePickerDialog) dialog).updateDate(activeDate.get(Calendar.YEAR), activeDate.get(Calendar.MONTH), activeDate.get(Calendar.DAY_OF_MONTH));
                break;
        }
    }


//    Select seats


//    public void increaseInteger(View view) {
//        if (minteger<10) {
//            minteger = minteger + 1;
//            display(minteger);
//        }
//
//    }public void decreaseInteger(View view) {
//        if (minteger>0) {
//            minteger = minteger - 1;
//            display(minteger);
//        }
//    }
//
//    private void display(int number) {
//        TextView displayInteger = (TextView) findViewById(
//                R.id.integer_number);
//        TextView amount = (TextView) findViewById(R.id.totalfare);
//        amount.setText("Rs."+number*100);
//        displayInteger.setText("" + number);
//    }




}

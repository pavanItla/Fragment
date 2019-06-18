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
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.Model.BikeRentalResponse;
import com.example.fragment.Model.CarBookingResponse;
import com.example.fragment.R;
import com.example.fragment.SharedPreferences.UserSessionManager;
import com.example.fragment.api.RetrofitClient;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.Z;

public class BookbikeActivity extends AppCompatActivity {


    ImageView img,Car,txthome;
    TextView carName,bikename;
    EditText name,lno,mbl;
    TextView date;
    Spinner sp1,sp3,sp4;
    String emails,UserId;
    String man3,man4,man5;

    Button book;
    UserSessionManager seesion;


    private TextView startPickDate;
    private TextView endPickDate;
    static final int DATE_DIALOG_ID = 0;
    private TextView activeDateDisplay;
    private Calendar activeDate;
    private Calendar currentDate;
    private Calendar fromDate;
    private Calendar startDate;
    private Calendar endDate;


    private java.util.Calendar myCalendar;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookbike);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        seesion=new UserSessionManager(this);
        HashMap<String,String> profile=seesion.getUserDetails();
        emails=profile.get("email");
        UserId=profile.get("UserId");
        Log.e(UserId, " "+UserId );


        Intent intent=getIntent();
        man3=intent.getStringExtra("id");
        man4=intent.getStringExtra("image");
        man5=intent.getStringExtra("text");
        carName=findViewById(R.id.car);
        Car=(ImageView)findViewById(R.id.carimg);


        carName.setText(man5);
        Picasso.get().load(man4).into(Car);



        // Toast.makeText(getApplicationContext(),""+man3+man4,Toast.LENGTH_LONG).show();


        /*ACTION BAR*//*
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action);
        img=(ImageView)findViewById(R.id.back);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                Intent intent=new Intent(BookbikeActivity.this,BikeActivity.class);
                startActivity(intent);
            }
        });*/

        /*ACTION to HOME*//*
        txthome=(ImageView)findViewById(R.id.acthome);
        txthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });*/
        bikename=(TextView) findViewById(R.id.car);
        name=(EditText)findViewById(R.id.bname);
        lno=(EditText)findViewById(R.id.dno);
        mbl=(EditText)findViewById(R.id.bmblno);
        date=(TextView)findViewById(R.id.bdate);
        sp1=(Spinner)findViewById(R.id.bspn1);
        //sp2=(Spinner)findViewById(R.id.bspn2);
        sp3=(Spinner)findViewById(R.id.bspn3);
        sp4=(Spinner)findViewById(R.id.bspn4);
        book=(Button)findViewById(R.id.book);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookBike();
            }
        });



        ArrayAdapter adapter=  ArrayAdapter.createFromResource(this,R.array.pickup,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.spinner_text_color);
        sp1.setAdapter(adapter);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ///
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ///
            }
        });

//        ArrayAdapter adapter1=  ArrayAdapter.createFromResource(this,R.array.dropoff,android.R.layout.simple_spinner_dropdown_item);
//        adapter.setDropDownViewResource(R.layout.spinner_text_color);
//        sp2.setAdapter(adapter1);
//
//        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                ///
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                ///
//            }
//        });

        ArrayAdapter adapter2=  ArrayAdapter.createFromResource(this,R.array.start,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.spinner_text_color);
        sp3.setAdapter(adapter2);

        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ///
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ///
            }
        });

        ArrayAdapter adapter3=  ArrayAdapter.createFromResource(this,R.array.end,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.spinner_text_color);
        sp4.setAdapter(adapter3);

        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*  capture our View elements for the start date function   */
        startPickDate = (TextView) findViewById(R.id.bdate);

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

    public void bookBike() {
        //validation for license page
        String MobilePattern = "[0-9]{10}";
        String re = "^[A-Z]{2}\\d{14}$";

//        getText()
        String bikename1= bikename.getText().toString().trim();
        String licenseName = name.getText().toString().trim();
        String licenseno = lno.getText().toString().trim();
        String mblno = mbl.getText().toString().trim();
        String dat = date.getText().toString().trim();
        String pickup = sp1.getSelectedItem().toString().trim();
        // String drop = sp2.getSelectedItem().toString().trim();
        String starttime = sp3.getSelectedItem().toString().trim();
        String endtime = sp4.getSelectedItem().toString().trim();

        if (licenseName.isEmpty()) {
            name.setError("Name required");
            name.requestFocus();
        }



        else if (licenseno.isEmpty()) {
            lno.setError("Please Enter License Number");
            lno.requestFocus();
        } else if(lno.getText().toString().length()<16 || lno.length()>16 || licenseno.matches(re)==false ) {

            lno.setError("enter a valid license number");
        }
        else if (mblno.isEmpty()) {
            mbl.setError("Enter Your Number");
            mbl.requestFocus();
        }
        else if(mbl.getText().toString().length()<10 || mblno.length()>13 || mblno.matches(MobilePattern)==false  ) {

            mbl.setError("enter a valid phone number");
        }

       else if(dat.isEmpty()){
            Toast.makeText(BookbikeActivity.this,"Please select Date",Toast.LENGTH_LONG).show();
        }else if (pickup.equalsIgnoreCase("Pick up point")||pickup.isEmpty()){

            Toast.makeText(BookbikeActivity.this,"Please select Pickup point",Toast.LENGTH_LONG).show();

        }else if (starttime.equalsIgnoreCase("Start time")||pickup.isEmpty()){

            Toast.makeText(BookbikeActivity.this,"Please select Start time",Toast.LENGTH_LONG).show();

        }else if (endtime.equalsIgnoreCase("End time")||endtime.isEmpty()){

            Toast.makeText(BookbikeActivity.this,"Please select End time",Toast.LENGTH_LONG).show();

        }


        else {

            Call<BikeRentalResponse> Call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .Carbooking(bikename1,licenseName, licenseno, mblno, dat, pickup, starttime, endtime,emails,UserId);


                    Call.enqueue(new Callback<BikeRentalResponse>() {
                    @Override
                    public void onResponse(Call<BikeRentalResponse> call, Response<BikeRentalResponse> response) {

                    BikeRentalResponse defaultResponse = response.body();

                    if ((defaultResponse != null ? defaultResponse.getStatus() : 0) == 1) {
                        String im = defaultResponse.getMessage();
                        Toast.makeText(BookbikeActivity.this, "" + im, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(BookbikeActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else if ((defaultResponse != null ? defaultResponse.getStatus() : 0) == 0) {
                        String im = defaultResponse.getMessage();
                        Toast.makeText(BookbikeActivity.this, "" + im, Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<BikeRentalResponse> call, Throwable t) {


                    Toast.makeText(BookbikeActivity.this, "Thank You For Booking" , Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(BookbikeActivity.this, MainActivity.class);
                    startActivity(intent);


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


                //checks if the date chosen by the user is greater than the current system date.Doesnt allow to choose past date
                if(currentDate.before(activeDate)|| currentDate.equals(activeDate))
                {

                    //checks if the from date edit text is empty or not
                    if(startPickDate.getText().toString().isEmpty())
                    {

                        updateDisplay(activeDateDisplay, activeDate);

                    }
                    else
                    {


                        //converts the date in the from date edittextbox and active date to dd-mm-yyyy format
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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.fragment.api;

import com.example.fragment.Model.BedImageResponse;
import com.example.fragment.Model.BedResponse;
import com.example.fragment.Model.BikeImageResponse;
import com.example.fragment.Model.BikeRentalResponse;
import com.example.fragment.Model.BikeResponse;
import com.example.fragment.Model.BookbedResponse;
import com.example.fragment.Model.CarBookingResponse;
import com.example.fragment.Model.CarImageResponse;
import com.example.fragment.Model.CarResponse;
import com.example.fragment.Model.CountandpriceResponse;
import com.example.fragment.Model.DefaultResponse;
import com.example.fragment.Model.DeleteCartItemResponse;
import com.example.fragment.Model.DrinkCartImagePostResponse;
import com.example.fragment.Model.DrinkImageResponse;
import com.example.fragment.Model.FinalFoodCartHistoryResponse;
import com.example.fragment.Model.FoodCartFinalResponse;
import com.example.fragment.Model.FoodCartImagesGetResponse;
import com.example.fragment.Model.FoodCartImagesPostResponse;
import com.example.fragment.Model.FoodImageResponse;
import com.example.fragment.Model.LoginResponse;
import com.example.fragment.Model.TotalPriceREsponse;
import com.example.fragment.Model.UpdatePasswordResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface Api {

    @FormUrlEncoded
    @POST("register")
    Call<DefaultResponse> createUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("number") String number

    );
    @GET("login")
    Call<LoginResponse> userLogin(
            @Query("email") String email,
            @Query("password") String password
    );

//    @GET("deleteitem")
//    Call<DeleteCartItemResponse> Delete(
//            @Query("id") String id
//
//    );

    @FormUrlEncoded
    @POST("update")
    Call<UpdatePasswordResponse> updateUser(

            @Field("email") String email,
            @Field("number") String number,
            @Field("password") String password

    );

    @FormUrlEncoded
    @POST("bedbooking")
    Call<BookbedResponse> Bookbed(


            @Field("areaname") String areaname,
            @Field("username") String username1,
            @Field("phoneno") String phoneno,
            @Field("noofadults") String adult,
            @Field("noofchilds") String child,
            @Field("Date") String date,
            @Field("typeofbed") String typeofbed,
            @Field("address") String address,
            @Field("email") String email,
            @Field("UserId") String UserId


    );

    @FormUrlEncoded
    @POST("carbooking")
    Call<CarBookingResponse> Carbooking1(
            @Field("carnameget") String carname,
            @Field("Name") String name,
            @Field("Mobile_no") String number,
            @Field("Pick_up_point") String pickup,
            @Field("Drop_off_point") String drop,
            @Field("start_time") String starttime,
            @Field("no_of_persons") String noofpersons,
            @Field("email") String email

    );

    @FormUrlEncoded
    @POST("Bikerental")
    Call<BikeRentalResponse> Carbooking(
            @Field("bikenameget") String bikename1,
            @Field("Name_On_Driving_License") String licenseName,
            @Field("Driving_License_No") String licenseno,
            @Field("Mobile_No") String mblno,
            @Field("Date") String dat,
            @Field("Pick_Up_Point") String pickup,
            @Field("Start_Time") String starttime,
            @Field("End_Time") String endtime,
            @Field("email") String email,
            @Field("UserId") String UserId


    );

    //    **Getting image,Text from database for ADD TO CART
    @FormUrlEncoded
    @POST("cartimages")
    Call<FoodCartImagesPostResponse> PostFoodCart(
            @Field("id") String id,
            @Field("text") String name,
            @Field("price") String price,
            @Field("email") String email,
            @Field("UserId") String UserId


            );
    //    *****8


    //    **Food Cart History Get Response

    @FormUrlEncoded
    @POST("finalpaymentcart")
    Call<FinalFoodCartHistoryResponse> Finalfoodcart(
            @Field("id") String id,
            @Field("text") String name,
            @Field("price") String price,
            @Field("email") String email,
            @Field("UserId") String UserId,
            @Field("time") String time

    );

//    *****

//    **Getting image,Text from database for bike_Rental

//    @FormUrlEncoded
//    @POST("cartdrinkimages")
//    Call<DrinkCartImagePostResponse> PostDrinkCart(
//
//            @Field("UniqId") String UniqId
//    );

//    *****


//**Food Cart Count,price Update
    @FormUrlEncoded
    @POST("count")
    Call<CountandpriceResponse> countandpr(
        @Field("text") String qwe,
        @Field("price") String exe,
        @Field("count") String number1,
        @Field("email") String email

    );
//    ****


//*** Total Price for Food Cart Response for Payment Gate
    @FormUrlEncoded
    @POST("totalprice")
    Call<TotalPriceREsponse> total(

            @Field("email") String email

    );
//    ****

//*** History get Responses
    @GET("carbooking")
    Call<CarResponse> requestBooking(@Query("email") String emails);

    @GET("Bikerental")
    Call<BikeResponse> bikeBooking(@Query("email") String emails);

    @GET("Bookbed")
    Call<BedResponse> bedBooking(@Query("email") String emails);

    @GET("cartfoodfinalpaymenthistory")
    Call<FoodCartFinalResponse> requestCartBooking(@Query("UserId") String UserId);
    ////****


    ////****car,bike,foodimage,bed response
    @GET("carimages")
    Call<CarImageResponse> requestCar();

    @GET("bikeimages")
    Call<BikeImageResponse> requestBike();

    @GET("foodimages")
    Call<FoodImageResponse> requestFood();

    @GET("drinkimages")
    Call<DrinkImageResponse> requestDrink();

    @GET("bedimages")
    Call<BedImageResponse> requestBed();

    @GET("cartfoodimages")
    Call<FoodCartImagesGetResponse> requestFoodCart( @Query("email") String email);
//***

//    **Delete Items From Cart response
    @GET("deleteitem")
    Call<DeleteCartItemResponse> Delete(
            @Query("text") String text,
            @Query("email") String email
           );
//    *****
}

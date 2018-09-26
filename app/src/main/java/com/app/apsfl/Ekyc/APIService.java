package com.app.apsfl.Ekyc;

/*import com.example.code1.lmho.pojo.SingleUserDetails;
import com.example.code1.lmho.pojo.UploadResponse;*/

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by code1 on 3/7/2018.
 */

public interface APIService {

    @POST("verifyAadhar")
    Call<EkycDetails> getEkycInfo(@Header("Authorization") String headers, @Body RequestBody requestBody, @Query("ano") String aadhar_no);

    @GET("getAadharDetails")
    Call<EkycDetails> getAadharInfo(@Header("Authorization") String headers, @Query("aadharNumber") String aadhar_no);


    //Call<EkycDetails> getEkycInfo(@Header("Authorization") Map<String, String> headers, @Body RequestBody requestBody, @Query("ano") String aadhar_no);


    // Call<EkycDetails> getEkycInfo(@Header("Authorization") Map<String, String> headers, @Body String body, @Query("ano") String aadhar_no);






/*


    @POST("register")
    @FormUrlEncoded
    Call<SingleUserDetails> registration(@Field("EMAIL") String email, @Field("USER_NAME") String username, @Field("PASSWORD") String password, @Field("MOBILE") String mobile);

    @POST("login")
    @FormUrlEncoded
    Call<SingleUserDetails> login(@Field("EMAIL") String email,
                                  @Field("PASSWORD") String password);

    @GET("forgotPassword")
    Call<SingleUserDetails> forgotpassword(@Query("MOBILE") String mobile);

   */
/* @Multipart
    @POST("images/upload")
    Call<UploadResponse> uploadImage(@Part MultipartBody.Part filePart,@Part("file_img") FormDataBodyPart fileDetail);*//*


    @POST("images/upload")
    @FormUrlEncoded
    Call<UploadResponse> uploadImage(@Field("IMAGE") String base64,
                                     @Field("EMAIL") String email);

    @POST("setprofilepic")
    @FormUrlEncoded
    Call<UploadResponse> setImage(@Field("FOR_EMAIL") String base64);

    @POST("getprofilepic")
    @FormUrlEncoded
    Call<UploadResponse> getImage(@Field("FOR_ID") String id);

    @GET("getUserDetails")
    Call<SingleUserDetails> getBasicInfo(@Query("FOR_EMAIL") String email);

    @GET("getAllUserDetails")
    Call<List<SingleUserDetails>> getAllUsersInfo();

    @PUT("updateProfile")
    @FormUrlEncoded
    Call<SingleUserDetails> updateProfile(@Field("NAME") String name,
                                          @Field("ADDRESS") String address,
                                          @Field("MOBILE") String mobile,
                                          @Field("CHKEMAIL") String chkemail);

    @POST("updatePassword")
    @FormUrlEncoded
    Call<SingleUserDetails> updatePassword(@Field("OLD_PASSWORD") String password,
                                           @Field("NEW_PASSWORD") String newpassword,
                                           @Field("MOBILE_NUMBER") String mobile);
*/
}
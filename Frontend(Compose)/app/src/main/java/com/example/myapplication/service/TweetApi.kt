import com.example.myapplication.models.Tweet
import com.example.myapplication.models.TweetResponse
import com.example.myapplication.models.User
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TweetApi {
    @GET("/tweets/all-tweets")
    suspend fun getTweets(): Response<List<TweetResponse>>

    @PUT("/tweets/apply/{id}")
    suspend fun apply(
        @Path("id") objectId: String,
    ): Response<Unit>

    @GET("/tweets/{domain}")
    suspend fun getTweetsByDomain(
        @Path("domain") domain:String
    ):Response<List<TweetResponse>>

    @GET("/tweets/get-tweets/{username}")
    suspend fun getTweetsOfUser(
        @Path("username") username:String
    ):Response<List<TweetResponse>>

    @POST("/tweets/new-tweet")
    suspend fun createTweet(
        @Body tweet:Tweet
    ):Response<ResponseBody>
}
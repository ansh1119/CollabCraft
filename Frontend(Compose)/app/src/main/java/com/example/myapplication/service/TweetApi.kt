import com.example.myapplication.models.Tweet
import com.example.myapplication.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TweetApi {
    @GET("/tweets/all-tweets")
    suspend fun getTweets(): Response<List<Tweet>>

    @POST("/public/create-user")
    suspend fun createUser(@Body user: User): Response<String>
}
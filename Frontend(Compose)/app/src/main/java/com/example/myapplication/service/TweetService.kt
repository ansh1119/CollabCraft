import com.example.myapplication.models.Tweet
import retrofit2.http.GET

interface TweetApiService {
    @GET("/v1/ed6902e2-9f84-4370-be20-3cdde849342a")
    suspend fun getTweets(): List<Tweet>
}
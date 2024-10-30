import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Repository.UserRepository
import com.example.myapplication.models.TweetResponse
import com.example.myapplication.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    // Backing property to hold the user
    private val _user = MutableStateFlow<User?>(null) // Mutable flow for internal use
    val user: StateFlow<User?> get() = _user // Public flow for UI to observe

    val applicants: StateFlow<List<User>> get()=repository.applicants

    // Function to fetch user by username and update the state
    fun getUser(username: String) {
        viewModelScope.launch {
            try {
                val fetchedUser = repository.getUser(username)
                _user.value = fetchedUser // Update the state
            } catch (e: Exception) {
                e.printStackTrace() // Handle exceptions (optional logging)
                _user.value = null // Reset user state in case of error
            }
        }
    }

    fun getApplicants(id:String){
        viewModelScope.launch {
            val response=repository.getApplicants(id)
        }
    }


}

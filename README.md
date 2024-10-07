CollabCraft
CollabCraft is an app designed to help users connect with potential teammates or mentors for any project, hackathon, or collaboration. Users can create posts (similar to tweets) specifying the kind of help or expertise they are looking for, and others can apply for the opportunity directly through the app.

Features
Create Posts: Users can create posts specifying the role they need, such as developers, designers, mentors, etc.
Apply for Opportunities: Other users can view posts and apply for the role directly.
Real-time Interaction: View and interact with open posts in real-time.
Manage Applications: Users can track and manage the applications they receive for their posts.
Tech Stack
Frontend
Jetpack Compose: Modern Android UI toolkit for building native interfaces quickly and efficiently.
Backend
Spring Boot: Robust backend handling data storage, user management, and interaction logic.
REST API: All data communication between the frontend and backend happens via secure RESTful APIs.
Installation & Setup
Backend (Spring Boot)
Clone the repository:
bash
Copy code
git clone https://github.com/your-repo/project-connect.git
Navigate to the backend folder:
bash
Copy code
cd backend
Build the backend:
bash
Copy code
./mvnw clean install
Run the Spring Boot application:
bash
Copy code
./mvnw spring-boot:run
The backend will be available at http://localhost:8080.
Frontend (Jetpack Compose)
Open the project in Android Studio.
Sync the project to download all required dependencies.
Build and run the app on your preferred device or emulator.
API Endpoints
POST /api/posts - Create a new post.
GET /api/posts - Fetch all open posts.
POST /api/apply/{postId} - Apply for a specific post.
You can find a detailed list of all the API endpoints here.

Contribution
Contributions are welcome! Please follow the steps below:

Fork the repository.
Create a new branch (git checkout -b feature-xyz).
Make your changes and commit them (git commit -m 'Add feature xyz').
Push to the branch (git push origin feature-xyz).
Open a Pull Request.

document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from submitting the traditional way

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    console.log('Email:', email); // Debugging log
    console.log('Password:', password); // Debugging log

    // Make a GET request to the backend to check the credentials
    fetch(`http://localhost:8080/v1/students/email/${email}`)
        .then(response => {
        if (!response.ok) {
            throw new Error('Invalid email');
        }
        return response.json();
    })
        .then(student => {
        console.log('Student:', student); // Debugging log
        if (student && student.studentPassword === password) {
            // Redirect to profile.html with the student ID
            alert("Going to profile");
            window.location.href = `profile.html?studentId=${student.studentId}`;
        } else {
            alert('Invalid password');
        }
    })
        .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
        alert('Invalid data');
    });
});

// Redirect to signup page when "Sign Up" link is clicked
document.querySelector('a[href="signUp.html"]').addEventListener('click', function(event) {
    event.preventDefault(); // Prevent default link behavior
    window.location.href = 'signUp.html'; // Redirect to signup page
});
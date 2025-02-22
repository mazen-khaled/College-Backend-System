document.getElementById('signupForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from submitting the traditional way

    // Collect form data
    const studentData = {
        studentName: document.getElementById('studentName').value,
        studentEmail: document.getElementById('studentEmail').value,
        studentPassword: document.getElementById('studentPassword').value,
        studentDOB: document.getElementById('studentDOB').value,
        studentGPA: parseFloat(document.getElementById('studentGPA').value)
    };

    console.log('Student Data:', studentData); // Debugging log

    // Make a POST request to the backend to create a new student
    fetch('http://localhost:8080/v1/students', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(studentData)
    })
        .then(response => {
        if (!response.ok) {
            throw new Error('Failed to create student');
        }
    })
        .then(data => {
        console.log('Student created:', data); // Debugging log
        alert('Signup successful! Redirecting to login page...');
        window.location.href = 'index.html'; // Redirect to login page
    })
        .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
        alert('Failed to sign up. Please try again.');
    });
});
// Get the full URL of the current page
const url = new URL(window.location.href);

// Extract the 'studentId' query parameter
const studentId = url.searchParams.get('studentId');

if (studentId) {
    // Fetch the student's profile data from an API
    fetch(`http://localhost:8080/v1/students/id/${studentId}`)
        .then(response => response.json())
        .then(data => {
        // Display the student's profile data on the page
        displayProfile(data);
        console.log(data);
    })
        .catch(error => {
        console.error('Error fetching student profile:', error);
    });
} else {
    console.error('No studentId found in the URL');
}

// Function to display the profile data
function displayProfile(student) {
    document.getElementById('studentId').textContent = student.studentId;
    document.getElementById('studentName').textContent = student.studentName;
    document.getElementById('studentEmail').textContent = student.studentEmail;
    document.getElementById('studentDOB').textContent = student.studentDOB;
    document.getElementById('studentGPA').textContent = student.studentGPA;
    document.getElementById('studentAge').textContent = student.studentAge;
}

// Add event listener to the Update Button
document.getElementById('updateButton').addEventListener('click', () => {
    // Show the update form container
    const updateFormContainer = document.getElementById('updateFormContainer');
    updateFormContainer.style.display = 'block';

    // Fetch the current student data again to populate the input fields
    fetch(`http://localhost:8080/v1/students/id/${studentId}`)
        .then(response => response.json())
        .then(data => {
        // Populate the input fields with the current student data
        document.getElementById('studentNameInput').value = data.studentName;
        document.getElementById('studentEmailInput').value = data.studentEmail;
        document.getElementById('studentDOBInput').value = data.studentDOB;
        document.getElementById('studentGPAInput').value = data.studentGPA;
        document.getElementById('studentAgeInput').value = data.studentAge;
    })
        .catch(error => {
        console.error('Error fetching student profile:', error);
    });
});

// Add event listener to the form submission
document.getElementById('updateForm').addEventListener('submit', (event) => {
    event.preventDefault(); // Prevent the form from submitting the traditional way

    // Get the updated values from the input fields
    const updatedStudent = {
        studentId: parseInt(studentId), // Ensure studentId is a number
        studentName: document.getElementById('studentNameInput').value,
        studentEmail: document.getElementById('studentEmailInput').value,
        studentDOB: document.getElementById('studentDOBInput').value,
        studentGPA: parseFloat(document.getElementById('studentGPAInput').value), // Ensure GPA is a number
        studentPassword: document.getElementById('studentPasswordInput').value // Get the new password
    };

    // Send a PUT request to update the student's profile
    fetch(`http://localhost:8080/v1/students`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedStudent)
    })
        .then(response => {
        if (response.ok) {
            alert('Profile updated successfully!');
            // Refresh the page to show the updated data
            window.location.reload();
        } else {
            alert('Failed to update profile.');
        }
    })
        .catch(error => {
        console.error('Error updating student profile:', error);
    });
});
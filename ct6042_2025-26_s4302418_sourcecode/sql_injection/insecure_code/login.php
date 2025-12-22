<?php
$conn = mysqli_connect("localhost", "root", "", "mock_sql_injection");

$username = $_POST['username'];
$password = $_POST['password'];

// SQL query vulnerable to SQL injection
$sql_query = "SELECT * FROM users WHERE username = '$username' AND password = '$password'";
$result = mysqli_query($conn, $sql_query);

if (mysqli_num_rows($result) > 0) {
 echo "Login successful.";
} else {
 echo "Invalid credentials!";
}

?>
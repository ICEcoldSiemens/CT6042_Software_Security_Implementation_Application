<?php 

// SQL queries run before data is inputted
$pre_stats = new PDO("mysql:host=localhost;dbname=secure_mock_sql_injection", "root", "", [
    PDO::ATTR_ERRMODE =>
    PDO::ERRMODE_EXCEPTION
]);


// Prepared and treated as solely input using prepared statement
$stmt = $pre_stats->prepare("SELECT * FROM users WHERE username = :username AND password = :password");

// Uses input data to access, not merge input data and query (seperate from one another)
$stmt->execute([
    ':username' => $username,
    ':password' => $password
]);

$result = $stmt->fetch();
?>
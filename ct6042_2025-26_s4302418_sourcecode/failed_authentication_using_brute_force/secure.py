# Run this script + run the brute force attack script - it will demonstrate how secure it is.

from flask import Flask, request, jsonify
import time

app = Flask(__name__)


USERS = {
    "admin": {
        "password": "superduperpassword2025",
        "failed_attempts": 0,
        "lock_until": 0
    }
}

MAX_ATTEMPTS = 3  # Max failed attempts
LOCKOUT_TIME = 30 # Lockout time in seconds

@app.route("/login", methods=["POST"])
def login():
    data = request.json

# Basic validation however no direct credential comparisons
    if not data or "username" not in data or "password" not in data:
        return jsonify({"message": "Invalid request"}), 400

    username = data["username"]
    password = data["password"]

    # No user enumeration
    if username not in USERS:
        return jsonify({"message": "Invalid credentials"}), 401

    user = USERS[username]
    current_time = time.time()

    # Verify whether account is locked
    if current_time < user["lock_until"]:
        return jsonify({
            "message": "Account locked. Try again later."
        }), 403

    # Enables if correct credentials
    if password == user["password"]:
        user["failed_attempts"] = 0
        return jsonify({"message": "Login successful"}), 200

    # Attempt counter with every failed login
    user["failed_attempts"] += 1

    # Account lockdown after 3 attempts
    if user["failed_attempts"] >= MAX_ATTEMPTS:
        user["lock_until"] = current_time + LOCKOUT_TIME
        user["failed_attempts"] = 0
        return jsonify({
            "message": "Account locked due to multiple failed attempts."
        }), 403

    return jsonify({"message": "Invalid credentials"}), 401

if __name__ == "__main__":
    app.run(debug=False)


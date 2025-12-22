# Run this script + run the brute force attack script - it will demonstrate the vulnerability

from flask import Flask, request, jsonify

app = Flask(__name__)

# Insecure to hard code credentials
USERNAME = "admin"
PASSWORD = "superduperpassword2025"

@app.route("/login", methods=["POST"])
def login():
    data = request.json

# Basic validation but not enough against brute force attacks
    if not data or "username" not in data or "password" not in data:
        return jsonify({"message": "Invalid request"}), 400

    if data["username"] == USERNAME and data["password"] == PASSWORD:
        return jsonify({"message": "Login successful"}), 200

# Failed Authentication: lack of rate limiting and account timeout
    else:
        return jsonify({"message": "Invalid credentials"}), 401

if __name__ == "__main__":
        app.run(debug=True)
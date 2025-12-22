from flask import Flask, session, redirect, url_for, request, render_template

app = Flask(__name__)

# Secret key should be introduced through server-side but hard coded for example
app.secret_key = "some_secret_key"

# Database example
users = {
        "Manny": {"password": "password101", "role": "user"},
        "Sully": {"password": "admin101", "role": "admin"}
}

@app.route("/login", methods=["GET", "POST"])
def login():
    if request.method == "POST":
        username = request.form["username"]
        password = request.form["password"]

        # Instead of client-side role authentication, server-side provides better security
        if username in users and users[username]["password"] == password:
            session["username"] = username
            session["role"] = users[username]["role"]
            return redirect(url_for("dashboard"))

        return "Invalid credentials", 401

    # Introduces login page (HTML)
    return render_template("login.html")

@app.route("/")
def dashboard():

    # Validating if user is authenticated + buffed security measures
    if "username" not in session:
        return redirect(url_for("login"))

    role = session.get("role")

# Role is validated through server-side and content accessed
    if role == "admin":
        return "Status - Admin Dashboard: Sensitive Data"
    else:
        return "Status - User Dashboard: Common Data"

# Redirects back to login page
@app.route("/logout")
def logout():
    session.clear()
    return redirect(url_for("login"))

if __name__ == "__main__":
    app.run(debug=False)

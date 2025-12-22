from flask import Flask, request, render_template, session, redirect, url_for

app = Flask(__name__)

# Insecure practice to hard code sensitive credentials
app.secret_key = "sensitive-key"

@app.route("/", methods=["GET"])

# Insecure role validation - taking input blindly from URL query parameter
def dashboard():
    role = request.args.get("role") # Client-controlled

    # Fails to perform verification - blindly trusts client input
    if role == "admin":
        return "Status - Admin Dashboard: Sensitive Data"
    else:
        return "Status - User Dashboard: Common Data"

if __name__ == "__main__":
    app.run(debug=True)
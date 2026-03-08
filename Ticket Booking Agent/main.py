import time

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
driver.maximize_window() # Ensure desktop layout
driver.get("https://www.irctc.co.in/nget/train-search")

wait = WebDriverWait(driver, 20)

try:
    # 1️⃣ Click OK on the initial alert popup
    ok_button = wait.until(
    EC.element_to_be_clickable((By.CSS_SELECTOR, ".btn btn-primary.ng-star-inserted"))
    )
    ok_button.click()

    # 2️⃣ Click Login directly 
    login_button = wait.until(
        EC.element_to_be_clickable((By.CSS_SELECTOR, ".search_btn.loginText.ng-star-inserted"))
    )
    login_button.click()

    # 3️⃣ Credentials
    username_field = driver.find_element(By.CSS_SELECTOR, "input[formcontrolname='userid']")
    username_field.send_keys("YOUR_USERNAME")

    

    time.sleep(1)  # Short pause before entering password

    password_field = driver.find_element(By.CSS_SELECTOR, "input[formcontrolname='password']")
    password_field.send_keys("YOUR_PASSWORD")

    login = wait.until(
        EC.element_to_be_clickable((By.XPATH, "//button[contains(text(),'SIGN IN')]"))
    )
    login.click()

    time.sleep(5)  # Short pause before clicking login
    
    # 4️⃣ Wait for manual login to complete
    # This waits until the 'Logout' button appears, signaling success
    wait.until(EC.presence_of_element_located((By.XPATH, "//a[contains(text(),'LOGOUT')]")))
    print("Login successful!")

except Exception as e:
    print(f"An error occurred: {e}")
# Import browser automation magic
import marionette_driver
from marionette_driver import marionette
#from marionette import Marionette
from marionette_driver.by import By

# Instantiate the Marionette (client) class
client = marionette.Marionette(host='localhost', port=2828)

# Start a session to talk to the server
# (otherwise, nothing will work because the strings aren't connected)
client.start_session()

# Give a command and check that it worked
client.navigate("https://www.mozilla.org")
assert "building a better Internet" in client.title

# Switch to the chrome context for a minute (content is default)
with client.using_context(client.CONTEXT_CHROME):
   urlbar = client.find_element(By.ID, "urlbar")
   urlbar.send_keys("about:robots")
   # try this one out yourself!

# Close the window, which ends the session
client.close()

# USAGE EXAMPLES

Run in local chrome (default browser):
```
gradle clean test
```

Run in local opera:
```
gradle clean test -Dweb.browser=opera
```

Run in remoteWebDriver:
```
gradle clean test -Dselenoid.url=http://host.docker.internal -Dselenoid.port=4444 -Dselenoid.ui.port=8083
```

Applicable parameters:
selenoid.url
selenoid.port
selenoid.ui.port
web.browser
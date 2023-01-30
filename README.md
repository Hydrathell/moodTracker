# SpringBoot with OAuth

* You will need a couple of Auth0 accounts

username: test@test.com
password: testPassw0rd!

username: other@test.com
password: testPassw0rd!

You will need to add your Auth0 CLIENT_ID and CLIENT_SECRET as environmental variables:

```
MOD2_AUTH0_CLIENT_ID=**************************
MOD2_AUTH0_CLIENT_SECRET=**************************
MOD2_AUTH0_ISSUER=**************************
```

```
gradle bootRun
```
_you will need gradle installed on your command line to run that command to start your springboot server_

## Run Jenkins

```
docker-compose up -d
```

```
docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```

### Hello World Pipeline

```ruby
pipeline {
    agent any 
    stages {
        stage('Stage 1') {
            steps {
                echo 'Hello world!' 
            }
        }
    }
}
```
# Hello World

1. http://localhost:8080 would return "Hello!" as plain text. You can use a browser or some REST clients such as Postman to make a request to http://localhost:8080

2. http://localhost:8080/healthz would return health information in JSON format. Sample response is given below. Please note that up-time is shown in UTC when running this image in Docker. It can be converted into appropriate timezone by adding more code. However it is done here as it was out of scope of this coding exercise.
```javascript
{
    "version": "0.0.1",
    "status": "OK",
    "uptime": "up since 2020-08-23 19:46:28"
}
```
3. I would include JVM heap usage information to the health api response. It would provide insight into how JVM is using the heap and how much heap memory is available etc.

4. See the `Dockerfile`. This `Dockerfile` first build the java project and creates a JAR file and then create a docker image.

5. To automate the build/test/deploy process, I would configure a hook in GitHub for triggering a jenkins build job when creating a Pull Request or PR Merge or some other events that you want to automate. This would allow automatic invocation of the Jenkins job when developers creating a PR or merging a PR. Regarding the branching strategy, you can use either of the 2 strategies mentioned below. 
- **Strategy 1:** You can create a git branch exclusively for your development. You can name that branch as "develop" or "feature-branch" or something. Once the developer finish development, then they can raise a Pull Request to merge the development branch with master branch. In this strategy, the master branch is considered as the release branch. You can also maintain a separate Release branch if needed.
- **Strategy 2:** You can fork the repo into your workspace and free to work on any existing or newly created branch in your workspace. Then raise a pull request against the main repo once you're done with development/testing in your workspace.
6. Steps to execute and verify the coding exercise app
    1. Clone or download code from https://github.com/raghukaramel/hello-world
        1. `git clone https://github.com/raghukaramel/hello-world`
    2. Run `docker build . -t hello-world`
    3. Run `docker run -it -p8080:8080 hello-world`
    4. Open a browser and goto http://localhost:8080. You should see `Hello!` printed on the browser
    5. In the browser, goto http://localhost:8080/healthz. You should see a JSON response as mentioned above.
    6. You can also open a REST client such as Postman to test the healhz endpoint. Using postman would allow you to verify the response content-type and other details.


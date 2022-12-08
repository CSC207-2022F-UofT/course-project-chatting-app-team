# K125 group project

## Introduction:

A blog web, communicate with each other through posts.
Mainly serve on mobile end, currently only support Chineses 

This is our web link: [web link](k125.love/k127). (Please use **_mobile_** to enter the web / PC: right click on the web page, select inspect, **_swtich to the mobile mode_**)

Web-link: k125.love/127


## Features:
1) **Login**: click the top right profile picture, to log-in or register.
2) **Reply** the post: click somewhere in the post and a text box will appear, so you can comment on the post.
3) **Like/Unlike** post: you can also like a post.
4) **Delete your own** post: you can also delete if the post is yours.
5) **Send post**: you can also send a post using the test box on the bottom.
6) **Others**: There are some other incidental functions that are not introduced.

## Language for project:
1. **UI**: HTML, CSS
2. **Frontend-controller,presenter**: Javascript, Vue.js
3. **Controller, Presenter, Gateway**: Java servlet
4. **Database**: Java, MangoDB API
5. **Usecase, Entity**: Java

## :briefcase:Directories and files:
Symbol meaning:
- :bangbang: means the this directory(all content)/file is necessary to read
- :x: means not finish (not for marking), but leave for future improvement
- :file_folder:/:memo: indicates file/folder

We will not list all files, files that listed are that we think need further clarification.

## Part1. Project Architecture: 
- :file_folder:[src/webapps](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/webapps): frontend + UI
    1. :file_folder:CSS style: CSS files
    2. :file_folder:demo-files: font-family style (plugin)
    3. :file_folder:fonts: font-family (plugin)
    4. :file_folder:[jsfile](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/webapps/jsfile) (:bangbang:): frontend-classes, include post_list, post and user           class
    5. :file_folder:jsfile_test (:bangbang:): frontend-classes test
    6. :file_folder:WEB-INF: web server settings
    7. :file_folder:images: images used for the website
    8. :memo: index.jsp (:bangbang:): view, main page, user will see this when enter the                   website, the one for UI mark
    9. :memo: jQuery_Version_old_version.jsp: old version, written by jQuery, leave here for                reference
    10. :memo: style.css: font-family (plugin)
    11. :memo: icomoon_fontstyle_display(used_in_project).html: font-family (plugin)
    12. :memo: selection.json: font-family data
    13. :memo: favicon.ico: web logo, show on the top tab when open
    14. :memo: jQuery_HTML_Version_old_version.html: html version of index.jsp
- :file_folder:[src/main/java/database_connection](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/main/java/database_connection) (:bangbang:): Database
    1. :memo: Database.java: database class
    2. :memo: Database(Delete/Insert/Read/Update).java: database use case class
    3. :memo: DatabaseUsageExample: examples for how to write database method
- :file_folder:[src/main/java/interfaceAdaptors](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/main/java/interfaceAdaptors) (:bangbang:): Interface adaptor layer,                        includes controller, gateway and presenter.
    1. :memo: XXXGateway.java: gateway
    2. :memo: XXXResponse.java: presenter
    3. :memo: (XXX with direct function).java: controller
    4. :memo: servletLikeReply(Gateway/Response).java (:x:) give like to replies
    5. :memo: servletPostPost(Gateway/Response).java (:x:) post the posts instead of sending               the post
- :file_folder:[log_in_use_case](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/main/java/log_in_use_case) (:bangbang:): Use case layer, for login function
- :file_folder:[post_post_use_case](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/main/java/post_post_use_case) (:bangbang:): Use case layer, for inquiry history posts function (Post class factory)
- :file_folder:[register_use_case](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/main/java/register_use_case) (:bangbang:): Use case layer, for user register(CommonUser class factory)
- :file_folder:[send_reply_use_case](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/main/java/send_reply_use_case) (:bangbang:): Use case layer, for instantiating reply class (Reply class factory)
- :file_folder:[user_exist_use_case](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/main/java/user_exist_use_case) (:bangbang:): Use case layer, for checking if user exists
- :file_folder: tutorial (:x:): an example folder initallly constructed, no more need
- :file_folder:[post_reply_user](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/main/java/post_reply_user) (:bangbang:): entity layer, classes
    1. :memo: User.java: abstract user class
    2. :memo: CommonUser.java: user class
    3. :memo: Post.java: post class
    4. :memo: Reply.java: reply class
    
## Part2.[Unit Test](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/test/java) (:bangbang:) src/test/java
- :file_folder: [Post_Reply_Tests](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/test/java/Post_Reply_Tests): test post class and reply class, entity class test
- :file_folder: [common_user_test](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/test/java/common_user_test): test CommonUser class, entity class test
- :file_folder: [log_in_use_case](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/test/java/log_in_use_case): test password check(login) use case, database use case test
- :file_folder: [post_post_use_case](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/test/java/post_post_use_case): test Post class factory use case
- :file_folder: [register_use_case](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/test/java/register_use_case): test User class factory (register) use case
- :file_folder: [send_reply_use_case](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/test/java/send_reply_use_case): test Reply class facotry (send reply) use case
- :file_folder: tutorial (:x:): example, no more needed
- :file_folder: [user_exist_use_case](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/test/java/user_exist_use_case): test the function of whether user exists, database use                   case test
- :file_folder: [src/webapps/jsfile_test](https://github.com/CSC207-2022F-UofT/course-project-dating-app-team/tree/main/src/webapps/jsfile_test): test frontend classes, user class and post class
                written in html files
 
## Test that we did not cover: 
-UI(view): Although we use Vue as our front-end framework, we do not use the component method provided by Vue (We write html instead). Vue unit tests need the component method, but it requires nodejs as the backend. Since we use Java as the backend, we do not include the component method. Thus, the Vue unit test is implausible in our project. But since we write the classes (user class, post class) for frontend, we do have tests for those classes, which can be found at src/webapps/jsfile_test.

-Servlet(interface Adaptors): Servlet can not be tested directly because all its input is passed in by UI. The only way to test servlet is to mock objects using spring framework as the coding framework. However, our project is not based on the spring framework. If we want to test, we need to redo everything into spring framework. It’s too hard for us to do. 

Our project used dependency injection in common user class and a simple factory design pattern in our entities.
  
## Wanna run the project on the local computer? 
General work: install the Tomcat server, create package and deploy it.
1. Install the Tomcat server (Recommended 8 version, JDK 1.8 or 18)
2. File-> Project strcture -> Modules -> Add web -> Alter Web Module Descriptor file to web.xml at webapps/WEB-INF -> Alter Web Source Directory to src/webapps -> apply
3. File-> Project strcture -> Artifact -> Click + button to add Web Application: Exploded -> From modules -> Set the package(suggest to learn from online) -> apply
4. Click Edit configuration
5. Deployment: Choose artifact that you just created, Server->Application Server: Tomcat you download, click apply (bottom right)
6. Click build and run

It is not suggest to run on the local computer, because it takes a lot of time to install the Tomcat server, but if you want, Good Luck!.
Reference may help: https://blog.csdn.net/wkh18891843165/article/details/116672710

## Some future idea:
We intend to develop this web application in a deeper level (may input for use). You can follow this project. And we may update during winter break. 

# K125 team

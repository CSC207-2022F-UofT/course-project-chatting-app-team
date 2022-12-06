web link: k125.love/k127 (Please use mobile to enter the web, or right click mouse, select aspect, swtich to the mobile mode on PC)

Introduction:

   A blog web, communicate with each other through posts

Features:
1) click the top right profile picture, to log-in or register.
2) click somewhere in the post and a text box will appear, so you can comment on the post.
3) you can also like a post.
4) you can also delete if the post is yours.
5) you can also post a post using the test box on the bottom. 
6) There are some other incidental functions that are not introduced.

Language for project:
1. UI: HTML, CSS
2. Frontend-controller,presenter: Javascript, Vue.js
3. Controller, Presenter, Gateway: Java servlet
4. Database: Java, MangoDB API
5. Usecase, Entity: Java

Directory and its associated layer: 
###(IMPORTANT!!) means the core of this project ### ###(File) indicates the file### ###(plugin) indicates the plugin ###
1. com.xxx.example (IMPORTANT!!): InterfaceAdaptor layer, includes controller, gateway and presenter.
   1. (File) XXXGateway: gateway 
   2. (File) XXXResponse: presenter
   3. (File) XXX with direct function: controller
2. database_connection (IMPORTANT!!): Database 
   1. (File) Database: database class 
   2. (File) DatabaseXXX: class extend from database class
   3. (File) DatabaseUsageExample: example for how to code database
3. xxx_use_case (IMPORTANT!!): Use case layer
4. webapps: frontend + UI
   1. CSS style: CSS files
   2. demo-files: font-family style (plugin)
   3. fonts: font-family (plugin)
   4. jsfile (IMPORTANT!!): frontend-classes 
   5. jsfile_test (IMPORTANT!!): frontend-classes test 
   6. WEB-INF: web server settings
   7. images: images used for the website
   8. (File) index.jsp (IMPORTANT!!): view, main page, user will see this when enter the website, the one for UI mark
   9. (File) old_version.jsp: old version, written by jQuery
   10. (File) style.css: font-family (plugin)
   11. (File) demo.html: font-family (plugin)
   12. (File) selection.json: font-family data
   13. (File) favicon.ico: web logo, show on the top tab when open
   14. (File) test.html: html version of index.jsp
5.  post_reply_user (IMPORTANT!!): entity layer, classes
    1. (File) User: abstract user class
    2. (File) CommonUser: user class
    3. (File) Post: post class
    4. (File) Reply: reply class

How to run the project on the local computer? -> Idea: install the Tomcat server, create package and deploy it.
1. Install the Tomcat server (Recommended 8 version, JDK 1.8 or 18)
2. File-> Project strcture -> Modules -> Add web -> Alter Web Module Descriptor file to web.xml at webapps/WEB-INF -> Alter Web Source Directory to src/webapps -> apply
3. File-> Project strcture -> Artifact -> Click + button to add Web Application: Exploded -> From modules -> Set the package(suggest to learn from online) -> apply
4. Click Edit configuration
5. Deployment: Choose artifact that you just created, Server->Application Server: Tomcat you download, click apply (bottom right)
6. Click build and run

It is not suggest to run on the local computer, because it takes a lot of time to install the Tomcat server.
Some reference: https://blog.csdn.net/wkh18891843165/article/details/116672710








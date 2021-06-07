# Demo Flowing Soft challenge

# Backend

* Spring Boot 2
* Gradle 6.3
* Java 12
* Netbeans 12

## Download Gradle

```

https://gradle.org/releases/

```

## Configuring Gradle With Netbeans

Please follow nexts steps.

1.	Start NetBeans
2.	Invoke **Tools > Options…**
3.	Invoke **Java > Graddle…**

![gradle](https://user-images.githubusercontent.com/85512533/121068657-9003ef00-c79a-11eb-9ef0-8dddd5769c9e.png)

4. Click on: **Custom**
5. Select downloaded gradle file.
6. Select gradle version, press 'Ok' and 'Apply'

## Run Spring Boot With Netbeans

Please follow nexts steps.

1. Start NetBeans
2. Open the project
3. Right click on the project
4. Click on: **Clean and Build**
5. Wait until a message is displayed: **BUILD SUCCESSFUL**

![build-successful](https://user-images.githubusercontent.com/85512533/121070089-487e6280-c79c-11eb-8f15-b6e014903506.png)

7. Then right click on the project. Click on: **Run**
8. Now the spring application is running on:
```

http://localhost:8080/

```

## The port can be modified
1. Go to **demo > Resources**
2. Open **application.properties**
3. By default it is 8080, but it can be modified

![port](https://user-images.githubusercontent.com/85512533/121071876-841a2c00-c79e-11eb-8e73-36b03c048b20.png)


### Can use the Swagger on:

```
http://localhost:8080/swagger-ui/index.html?url=/v3/api-docs

```

  


# FrontEnd

* Angular 12
* Boostrap 5

## Install Angular

Please follow nexts steps.

1.Install Nodejs

```
https://nodejs.org/es/download/

```
2. Intall Angular with the command:

```
npm install -g @angular/cli

```
3. Check Version with the command:
 
```
ng version

```
 
## Run Angular with VS Code

Please follow nexts steps.

1. Start VS Code.
2. Open the proyect
3. Open New Terminal in VS Code
4. Run the command:

```
npm install

```
5. Run Application with the command:

```
ng serve

```
6. Open your browser on:

```
http://localhost:4200/

```

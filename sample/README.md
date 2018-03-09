1、boot需要web运行环境，启动容器， 需要引入boot-web-start 
配置容器， 同样需要配置web相关运行环境的bean
对于web或者容器环境来说，引入加热后，只需@EnableAutoConfiguration就能初始化web容器环境。
当然也可自己手动配置容器、web环境的bean。
2、对于有些项目在@EnableAutoConfiguration，且项目的相应jar都引入，会自动初始化项目
3、对于有些项目在@EnableAutoConfiguration，且项目的相应jar都引入，还需要@enable相应的项目，如@EnbaleWebMvc


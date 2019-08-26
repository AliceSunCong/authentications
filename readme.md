springboot shiro 权限控制demo
learn from https://mrbird.cc/tags/Shiro/

**shiro简介**

Apache Shiro有三个核心的概念subject，securityManager和Realms

1.subject：主体，代表当前“用户”，这个用户不一定是一个具体的人，
与当前应用交互的任何东西都是Subject，如网络爬虫，机器人等，即一个抽象概念。
所有Subject 都绑定到SecurityManager，与Subject的所有交互都会委托给SecurityManager。
可以把Subject认为是一个门面，SecurityManager才是实际的执行者。

2.securityManager：安全管理器，即所有与安全有关的操作都会与SecurityManager交互，
且它管理着所有Subject，可以看出它是Shiro的核心。它负责与后边介绍的其他组件进行交互，
类似于Spring MVC中的DispatcherServlet前端控制器。

3.realm：域，Shiro从Realm获取安全数据（如用户、角色、权限），就是说SecurityManager要验证用户身份，
那么它需要从Realm获取相应的用户进行比较以确定用户身份是否合法。
 也需要从Realm得到用户相应的角色/权限进行验证用户是否能进行操作。
 
 shiro提供了4大基本安全功能：认证，授权，会话管理&加密
 
 身份验证(Authentication)：也称为登录验证，即验证用户名和密码是否正确；
 
 授权(Authorization)：根据用户的角色和权限来控制用户可访问的资源；
 
 会话管理(Session Management)：即使在非Web或EJB应用程序中，也可以管理用户特定的SESSION会话；
 
 密码学(Cryptography)：使用加密算法保证数据安全，同时易于使用。
 
 除此之外，Shiro也支持以下特性：
 
 Web支持(Web Support)：Shiro提供的web程序API可以帮助轻松保护Web应用程序；
 
 缓存(Caching)：缓存可确保安全验证操作保持快速高效；
 
 并发性(Concurrency)：Apache Shiro支持具有并发功能的多线程应用程序；
 
 测试(Testing)：测试API帮助您编写单元测试和集成测试；
 
 运行方式(Run As)：允许用户以别的用户身份（如果允许）登录；
 
 记住我(Remember Me)：在会话中记住用户的身份，只有在强制登录时才需要登录。
 
 **shiro用户认证**
 
 shiro进行用户认证可以归纳为：
 
 1.定义一个shiroConfig，配置 SecurityManager Bean，SecurityManager是shiro的安全管理器，
 管理着所有subject；
 
 2.在shiroConfig中配置shiroFilterFactoryBean （Shiro过滤器工厂类），依赖 SecurityManager；
 
 3.自定义realm实现，定义用户认证，实现 doGetAuthenticationInfo()方法。
 
 具体实现：
 
 1.pom文件引入依赖（Shiro、MyBatis、数据库和thymeleaf）
 
 2.定义Shiro配置类，shiroConfig--（shiroFilterFactoryBean、securityManager、shiroRealm）
 
 3.配置完shiroConfig后，对realm进行实现，然后注入到 SecurityManager 中
 
 自定义realm，继承AuthorizingRealm类，实现doGetAuthorizationInfo()和doGetAuthenticationInfo()
 
 建数据库，数据交互dao，service，controller
 
 **shiro remember Me**
 
 1.更改shiroConfig，加入remember me功能实现--rememberMeCookie()、rememberMeManager()，接下来将cookie管理对象设置到SecurityManager
 
 修改权限配置，将ShiroFilterFactoryBean的filterChainDefinitionMap.put("/**", "authc");
 更改为filterChainDefinitionMap.put("/**", "user");。
 user指的是用户认证通过或者配置了Remember Me记住用户登录状态后可访问。
 
 **shiro权限控制**

数据库设计：

user用户表、role角色表、permission权限表、user_role用户角色表、role_permission角色权限表



 
 
 
 
 
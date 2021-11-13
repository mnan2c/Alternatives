## 1. Spring Security框架原理

想要对对Web资源进行保护，最好的办法莫过于Filter，要想对方法调用进行保护，最好的办法莫过于AOP。
所以Spring Security在我们进行用户认证以及授予权限的时候，通过各种各样的拦截器来控制权限的访问，从而实现安全。

1. Spring Security 框架的主要过滤器(Filter) :

    WebAsyncManagerIntegrationFilter
    SecurityContextPersistenceFilter
    HeaderWriterFilter
    CorsFilter
    LogoutFilter
    RequestCacheAwareFilter
    SecurityContextHolderAwareRequestFilter
    AnonymousAuthenticationFilter
    SessionManagementFilter
    ExceptionTranslationFilter
    FilterSecurityInterceptor
    UsernamePasswordAuthenticationFilter
    BasicAuthenticationFilter

2. Spring Security框架的核心组件:

    1. SecurityContextHolder：提供对SecurityContext的访问
    1. SecurityContext：持有Authentication对象和其他可能需要的信息
    1. AuthenticationManager：其中可以包含多个AuthenticationProvider
    1. ProviderManager：AuthenticationManager接口的实现类
    1. AuthenticationProvider：主要用来进行认证操作的类，调用其中的authenticate()方法去进行认证操作
    1. Authentication：Spring Security方式的认证主体
    1. GrantedAuthority：对认证主题的应用层面的授权，含当前用户的权限信息，通常使用角色表示
    1. UserDetails：构建Authentication对象必须的信息，可以自定义，也可以访问DB得到
    1. UserDetailsService：通过username构建UserDetails对象，通过loadUserByUsername根据userName获取UserDetail对象 
    （可以在这里基于自身业务进行自定义的实现，如通过数据库、xml、缓存获取等）

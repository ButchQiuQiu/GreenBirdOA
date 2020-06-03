</br>前端ui使用bootstrap,table是用的Jquery的dataTable,每个td都可以单独点击修改.这个东西太繁琐了,就个表格400行js...
</br>通信使用的是ajax和json,后端json用jackson解析封装




# 正在整合Security和JWT，拆分其他模块转移至CloudNetflix
* 微服务的鉴权验证中心，由redis存储用户信息（角色等等）。
* 其他服务处于无状态化，并且security也能自由扩展集群。流量小的项目可以直接丢入zuul或者gateway中，每次请求都会经过security集群鉴权，鉴权/功能鉴权由反射动态分发为同名方法。
* 类似分布式seesion但是架构更为简洁，其他服务无状态化，缺点是payload只放了username或者uuid大流量性能上没有安全性低的纯jwt高。
* 总体上来说就是性能换安全就算私钥被盗也没什么大不了，payload上放的东西越简陋安全性越高，但是最后可能和跨域sessionid没什么区别了。。。
* 鉴权由security集中管理带来的问题是每个boy都得弄明白这套方案，开发效率或多或少有点影响。
* **这么操作SpringSecurity基本就披了层皮性能上可能不如自己写套过滤器。。。**


## 每个角色需求的权限不一样,导致crud会有非常多的鉴权方法.
</br>采取自动分支在AccessDecisionManager层面由反射自动分发对应角色url请求类型的鉴权方法,目前只鉴权增删改.

## security的鉴权太过于繁琐最后还是mybatis暴力鉴权比AccessDecisionManager香一些,鉴权如下:

```xml
<!--不同角色的增删改权限判断 -->
  <sql id="accessDecision">
    <choose>
      <!-- 管理部门 -->
      <when test="myUser.fk_depart.fk_authority.id==1">
          (
            <!-- 可以操作级别小于或者等于自己的非管理角色用户 -->
            (#{targetUser.fk_jurisdiction.id}&lt;=#{myUser.fk_jurisdiction.id} and #{targetUser.fk_depart.fk_authority.id}!=1)
            or
            <!-- 可以操作级别小于自己的管理角色用户 -->
            (#{targetUser.fk_jurisdiction.id}&lt;#{myUser.fk_jurisdiction.id} and #{targetUser.fk_depart.fk_authority.id}=1)
          )
      </when>
      <!-- 人事部门 -->
      <when test="myUser.fk_depart.fk_authority.id==2">
          ( 
            <!-- 可以操作级别小于或者等于自己的普通用户 -->
            (#{targetUser.fk_jurisdiction.id} &lt;=#{myUser.fk_jurisdiction.id} and #{targetUser.fk_depart.fk_authority.id}=3)
            or 
            <!-- 可以操作级别小于自己的人事用户 -->
            (#{targetUser.fk_jurisdiction.id} &lt;#{myUser.fk_jurisdiction.id} and #{targetUser.fk_depart.fk_authority.id}=2)
          )
      </when>
      <!-- 普通部门 -->
      <when test="myUser.fk_depart.fk_authority.id==3">
        (
          <!-- 不允许操作 -->
          1=2
        )
      </when>
      <!-- 未知部门不允许操作 -->
      <otherwise>
          1=2
      </otherwise>
    </choose>
  </sql>
```
鉴权全部集中在一起耦合性可维护性明显比security好多了,当然大型项目还是security好一些.
  

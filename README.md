</br>前端ui使用bootstrap,table是用的Jquery的dataTable,每个td都可以单独点击修改.这个东西太繁琐了,就个表格400行js...
</br>通信使用的是ajax和json,后端json用jackson解析封装



# 正在转移到maven+springboot+mybatis+ajax权限改为SpringSecurity实现 .
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
鉴权全部集中在一起耦合性可维护性明显比security好多了,当然大型项目还是security好一.
  

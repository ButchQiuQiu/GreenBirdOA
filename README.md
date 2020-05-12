</br>前端ui使用bootstrap,table是用的Jquery的dataTable,每个td都可以单独点击修改.这个东西太繁琐了,就个表格400行js...
</br>通信使用的是ajax和json,后端json用jackson解析封装



# 正在转移到maven+springboot+mybatis+ajax权限改为SpringSecurity实现 .
## 每个角色需求的权限不一样,导致crud会有非常多的鉴权方法.
</br>采取自动分支在AccessDecisionManager层面由反射自动分发对应角色url请求类型的鉴权方法,目前只鉴权增删改.....

  
  

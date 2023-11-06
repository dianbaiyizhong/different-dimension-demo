# different-dimension-demo

spring-boot自我约束，以ddd为例

#### 工程名，模块名

小写+中划线组合。原因我觉得，工程名和模块名是作为本地磁盘目录存在，本身git也是不区分大小写，路径有些系统也不支持大小写，所以我想统一都用小写。可以参考spring-boot-starter这类组件，作为全球最多人引用的组件之一，他是什么样的一种规范，我也就照抄

#### package
包名应该全是小写，也不该有中划线，下划线等，但是如果遇到词组的情况，这个要再考虑一下


### 实体类规范
#### query类
介于前端到服务控制层之间，传递前端人员想要查询的条件，里面推荐使用spring校验注解方式完成参数校验
#### vo类
后台展示给前端的对象类，跟query类是反着来的
#### Dto类
1. QueryDto，可以传给repository层给数据库作为查询条件，这里应该跟query有所区分，因为query跟dto之间还有业务处理




### 前端显示
#### 参数错误返回
看见data的json格式吗，使用的是valid框架自带的，到时候前端人员处理提示等操作就好处理了
```json
{
    "code": 400001,
    "message": "参数错误",
    "data": [
        {
            "codes": [
                "NotNull.commonQuery.rows",
                "NotNull.rows",
                "NotNull.java.lang.Integer",
                "NotNull"
            ],
            "arguments": [
                {
                    "codes": [
                        "commonQuery.rows",
                        "rows"
                    ],
                    "arguments": null,
                    "defaultMessage": "rows",
                    "code": "rows"
                }
            ],
            "defaultMessage": "不能为null",
            "objectName": "commonQuery",
            "field": "rows",
            "rejectedValue": null,
            "bindingFailure": false,
            "code": "NotNull"
        }
    ]
}
```
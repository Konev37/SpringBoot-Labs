package cn.iocoder.springboot.lab24.apidoc.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

// 描述一个 Model 的信息
// value ：Model 名字
// description：Model 描述
@ApiModel("用户 VO")
public class UserVO {

    // 声明每个成员变量的信息
    // value：成员变量的简要描述
    // dataType: 和 @ApiImplicitParam 注解的 dataType 属性一致。不过因为 @ApiModelProperty 是添加在成员变量上，可以自动获得成员变量的类型。
    @ApiModelProperty(value = "用户编号", required = true, example = "1024")
    private Integer id;
    @ApiModelProperty(value = "账号", required = true, example = "yudaoyuanma")
    private String username;

    public Integer getId() {
        return id;
    }

    public UserVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserVO setUsername(String username) {
        this.username = username;
        return this;
    }

}

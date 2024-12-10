package cn.iocoder.springboot.lab24.apidoc.controller;

import cn.iocoder.springboot.lab24.apidoc.dto.UserAddDTO;
import cn.iocoder.springboot.lab24.apidoc.dto.UserUpdateDTO;
import cn.iocoder.springboot.lab24.apidoc.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
// @Api 注解，添加在 Controller 类上，标记它作为 Swagger 文档资源
// tags：为当前类提供 Swagger API 文档的标签信息（标签分组）
// 一个 Controller 可以有多个标签，多个 Controller 也可以共享同一个标签。但一般情况下，我们会为每个 Controller 指定一个唯一的标签
@Api(tags = "用户 API 接口")
public class UserController {

    @GetMapping("/list")
    // 添加在 Controller 方法上，标记它是一个 API 操作（用于描述一个具体的操作）
    // value：API 操作名称
    // notes：API 操作描述
    @ApiOperation(value = "查询用户列表", notes = "目前仅仅是作为测试，所以返回用户全列表")
    public List<UserVO> list() {
        // 查询列表
        List<UserVO> result = new ArrayList<>();
        result.add(new UserVO().setId(1).setUsername("yudaoyuanma"));
        result.add(new UserVO().setId(2).setUsername("woshiyutou"));
        result.add(new UserVO().setId(3).setUsername("chifanshuijiao"));
        // 返回列表
        return result;
    }

    @GetMapping("/get")
    @ApiOperation("获得指定用户编号的用户")
    // 添加在 Controller 方法上，声明每个请求参数的信息
    // name：参数名
    // value：参数简要描述
    // required：是否为必传参数，默认为 false
    // dataType ：数据类型，通过字符串 String 定义
    // dataTypeClass：数据类型，通过 dataTypeClass 定义。在设置了 dataTypeClass 属性的情况下，会覆盖 dataType 属性。推荐采用这个方式
    // paramType：参数所在位置的类型，有 path、query、body、header、form 等
    //      path：参数作为 URL 路径的一部分，通常用于 RESTful API 风格的 URL。
    //             必须在 URL 路径中指定，通常用于唯一标识某个资源，例如，/users/{id} 中的 id 参数。
    //      query：参数通过 URL 查询字符串传递，通常用于 GET 请求。
    //              通常位于 URL 的 ? 后面，例如，/users?id=1024 中的 id 参数。
    //      body：参数放在请求体中，通常用于 POST 或 PUT 请求，传递复杂对象。
    //      header：参数通过 HTTP 请求头传递，通常用于认证信息（如 JWT Token）。
    //      form：参数作为表单数据传递，通常用于表单提交。
    // example：参数值的简单示例
    @ApiImplicitParam(name = "id", value = "用户编号", required = true, dataTypeClass = Integer.class, paramType = "query", example = "1024")
    // @RequestParam("id") 用于将 HTTP 请求中的查询参数 id 绑定到 UserVO 方法的参数 id 上
    public UserVO get(@RequestParam("id") Integer id) {
        // 查询并返回用户
        return new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
    }

    @PostMapping("add")
    @ApiOperation("添加用户")
    public Integer add(UserAddDTO addDTO) {
        // 插入用户记录，返回编号
        Integer returnId = UUID.randomUUID().hashCode();
        // 返回用户编号
        return returnId;
    }

    @PostMapping("/update")
    @ApiOperation("更新指定用户编号的用户")
    public Boolean update(UserUpdateDTO updateDTO) {
        // 更新用户记录
        Boolean success = true;
        // 返回更新是否成功
        return success;
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除指定用户编号的用户")
    @ApiImplicitParam(name = "id", value = "用户编号", paramType = "query", dataTypeClass = Integer.class, required = true, example = "1024")
    public Boolean delete(@RequestParam("id") Integer id) {
        // 删除用户记录
        Boolean success = false;
        // 返回是否更新成功
        return success;
    }

}

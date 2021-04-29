## 魔方解不开了怎么办，让程序来帮你。
只需用摄像头把魔方的六个面扫描一遍就能直接给出还原步骤。即使你的魔方不是标准配色或房间的照明情况特殊也可以通过颜色校准模式来识别。这款荷兰小哥发布的3阶魔方解算器“Qbr”已经在GitHub上开源。 https://github.com/kkoomen/qbr.git
遗憾的是这款qdr是python版本的，这里整理出java版本的kociemba库，增加了线程安全的支持和文件缓存，前端图片识别编码魔方，后端通过kkoomen解码，


### 线程安全SearchThreadSafe 的使用方法
```
            // 工具类Tools 用于生成和校验魔方编码序列
            String cubeStr = Tools.randomCube();
            // 调用solution 的方法解码魔方
            String moves = new SearchThreadSafe().solution(cubeStr ,22, 5, false); // solving it
            // 验证解码序列操作后是否还原
            Cube cube = new Cube(cubeStr);
            for(String move : moves.split(" ")) // rotating
                cube.rotate(move);

```

### 如果需要vue版本的的前端 可以转到，该前段自带node版本的kociemba mock使用，也可以通过代理切换到java后端
https://github.com/toger2021/vue-cube.git
```
步骤数: 20
复原教程: B2 U2 F' R U D' L' B' U L F U F2 R2 F2 D' F2 D R2 D2
1. 将魔方的后面旋转180°。
2. 将魔方的顶层旋转180°。
3. 将魔方的前面向左旋转90°。
...
20.将魔方的底层向右旋转90°。
```
## 安装方法
安装方法如下
````
<dependency>
    <groupId>io.github.toger2021</groupId>
    <artifactId>cube-kociemba</artifactId>
    <version>1.0.0</version>
</dependency>

````
## Search solution 的线程安全
在web的场景下，应该使用线程安全的版本SearchThreadSafe，
在单个应用的场景可以使用非线程安全的版本，因为只又一个程序在跑比如桌面应用或者魔方机器人
具体的可以参看test com.weijiekeji.kociemba.twophase.SearchTest
## restfulapi使用
```
package youpackage

import io.swagger.annotations.ApiOperation;
import com.weijiekeji.kociemba.twophase.SearchThreadSafe;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CubeController {
  @GetMapping("/kociemba/solve/{cubeStr}")
  @ApiOperation(value = "解密魔方", notes = "通过输入魔方序列返回解密序列")
  public String CubeStr(@PathVariable String cubeStr) {

    Long starttime = System.currentTimeMillis();
    String cstr = new SearchThreadSafe().solution(cubeStr ,22, 5, false);
    System.out.println(Thread.currentThread().getName()+" solution "+SearchThreadSafe.total+"=>" + (System.currentTimeMillis() - starttime));
    return cstr;
  }

  @PostMapping("/kociemba/solve")
  @ApiOperation(value = "解密魔方", notes = "通过输入魔方序列返回解密序列")
  public JsonResult CubeStrPostString(@RequestParam String cubeStr) {
    Long starttime = System.currentTimeMillis();
    System.out.println("cubeStr=>" + cubeStr);
    String cstr = new SearchThreadSafe().solution(cubeStr ,22, 5, false);
    System.out.println(Thread.currentThread().getName()+" solution "+SearchThreadSafe.total+"=>" + (System.currentTimeMillis() - starttime));
    return new JsonResult<String>(cstr);
  }
}

```

## vue-cube项目地址：
[https://github.com/toger2021/vue-cube.git](https://github.com/toger2021/vue-cube.git)
[https://gitee.com/taoren/vue-cube.git](https://gitee.com/taoren/vue-cube.git)

## cube-java java实现以及JFrame的实现
[https://github.com/toger2021/cube-java](https://github.com/toger2021/cube-java)
[https://gitee.com/taoren/cube-java.git](https://gitee.com/taoren/cube-java.git)

## cube-kociemba 优化后的jar包源文件
[https://github.com/toger2021/demo-cube.git](https://github.com/toger2021/demo-cube.git)]
[https://gitee.com/taoren/demo-cube.git](https://gitee.com/taoren/demo-cube.git)
maven 引用使用
```
<dependency>
            <groupId>io.github.toger2021</groupId>
            <artifactId>cube-kociemba</artifactId>
            <version>1.0.1</version>
 </dependency>
```


## 解码魔方参考链接：
[1rubiks-cube-tracker-using-opencv](http://programmablebrick.blogspot.com/2017/02/rubiks-cube-tracker-using-opencv.html)

[2 youtube](https://www.youtube.com/watch?v=ixTddQQ2Hs4)

[3 色差计算(颜色之间的相似度计算)] (https://blog.csdn.net/qq_16564093/article/details/80698479)

(GUI is inspired from Kociemba's[Java package](http://kociemba.org/download.htm) and org.kociemba.twophase package also belongs to him.)


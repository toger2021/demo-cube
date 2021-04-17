package demo.cube;

import io.swagger.annotations.ApiOperation;
import org.kociemba.twophase.SearchThreadSafe;
import org.springframework.web.bind.annotation.*;

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
//  @PostMapping("/kociemba/solve")
//  @ApiOperation(value = "解密魔方", notes = "通过输入魔方序列返回解密序列 json结构")
//  public String CubeStrPostJson(@RequestBody Map<String, String> body) {
//    String cubeStr = body.get("cubeStr");
//    Long starttime = System.currentTimeMillis();
//    System.out.println("cubeStr=>" + cubeStr);
//    String cstr = new SearchThreadSafe().solution(cubeStr ,22, 5, false);
//    System.out.println(Thread.currentThread().getName()+" solution "+SearchThreadSafe.total+"=>" + (System.currentTimeMillis() - starttime));
//    return cstr;
//  }

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
